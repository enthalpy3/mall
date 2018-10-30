package item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import item.ItemInfo;

public class DataManager {
	 Connection con = null;
	    //String url = "jdbc:mysql://localhost:3306/my_site?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	    String url = "jdbc:mysql://localhost:3306/my_site";
	    String user = "jsp_user";
	    String pass = "zxcv1234";

	    private Connection openConnection() {
	        try {
	            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	            Class.forName("org.mariadb.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, pass);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	    }

	    private void closeConnection() {
	        try {
	            if (con != null)
	                con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            con = null;
	        }
	    }

	    /*
	    상품등록
	     */
	    public int insertItem(ItemInfo item) {
	        PreparedStatement pstmt = null;
	        String query = "INSERT INTO board VALUES(?,?,?,?,?)";
	        int res = 0;
	        openConnection();
	        try {
	            pstmt = con.prepareStatement(query);
	            pstmt.setString(1, item.getKind());
	            pstmt.setString(2, item.getName());
	            pstmt.setString(3, item.getPrice());
	            pstmt.setString(4, item.getSize());
	            pstmt.setInt(5, item.getEm());
	            //Timestamp ts = new Timestamp(System.currentTimeMillis());
	            //pstmt.setTimestamp(4, ts);
	            res = pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeConnection();
	        }
	        return res;
	    }
	    
	    /*
	     * 상품 삭제
	     */
	    public int removeItem(String name) {
	        PreparedStatement pstmt = null;
	        String query = "DELETE FROM item WHERE name=?";
	        int res = 0;
	        openConnection();
	        try {
	        	pstmt = con.prepareStatement(query);
	        	//pstmt = con.prepareCall(query);
	            pstmt.setString(1, name);
	            res = pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeConnection();
	        }
	        return res;
	    }
	    
	    /*
	     * 상품정보 수정 이름,가격,사이즈
	     */
	    public int updateItem(ItemInfo item) {
	        PreparedStatement pstmt = null;
	        String query = "UPDATE item SET name=?, price=?, size=? WHERE name=?";
	        int res = 0;
	        openConnection();
	        try {
	            pstmt = con.prepareStatement(query);
	            pstmt.setString(1, item.getName());
	            pstmt.setString(2, item.getPrice());
	            pstmt.setString(3, item.getSize());
	            res = pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeConnection();
	        }
	        return res;
	    }
	    
	    /*
	     * 상품확인
	     */
	    public boolean isItem(String name, String kind) {
	        PreparedStatement pstmt = null;
	        String query = "SELECT * FROM item WHERE name=? and kind=?";
	        boolean res = false;
	        openConnection();
	        try {
	            pstmt = con.prepareStatement(query);
	            pstmt.setString(1, name);
	            pstmt.setString(2, kind);
	            ResultSet rs = pstmt.executeQuery();
	            res = rs.next();
	            rs.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeConnection();
	        }
	        return res;
	    }
	    
	    /*
	     * 자세히 보기
	     */
	    public ItemInfo getItem(String name) {
	        PreparedStatement pstmt = null;
	        ItemInfo item = new ItemInfo();
	        String query = "SELECT * FROM item WHERE name=?";
	        openConnection();
	        try {
	            pstmt = con.prepareStatement(query);
	            pstmt.setString(1, name);
	            ResultSet rs = pstmt.executeQuery();
	            rs.next();
	            item.setKind(rs.getString("kind"));
	            item.setName(rs.getString("name"));
	            item.setPrice(rs.getString("price"));
	            item.setSize(rs.getString("size"));
	            //item.setReg_date(rs.getTimestamp("reg_date"));
	            rs.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeConnection();
	        }
	        return item;
	    }
}
