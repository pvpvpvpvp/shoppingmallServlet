package com.conan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.conan.vo.ProductsVO;


public class ProductDAO {
	private static ProductDAO dao = new ProductDAO();
	private ProductDAO() {}
	public static ProductDAO getInstance() {return dao;}
	
	public Connection getConnection() throws NamingException, SQLException {
		InitialContext ic = new InitialContext();
		DataSource ds =(DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
		Connection conn = ds.getConnection();
		return conn;}
	public void close(Connection conn,PreparedStatement pstmt, ResultSet rs) throws SQLException{conn.close(); pstmt.close(); rs.close();}
	public void close(Connection conn,PreparedStatement pstmt)throws SQLException{conn.close(); pstmt.close();}
	
	public ArrayList<ProductsVO> selectProductAll(){
		try {
			Connection conn = getConnection();
			ArrayList<ProductsVO> vos = new ArrayList<>();
			ProductsVO	vo;
			String selectAll = "SELECT * FROM products";
			PreparedStatement pstmt = conn.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo = new ProductsVO();
				vo.setProId(rs.getString(1));
				vo.setProName(rs.getString(2));
				vo.setUnitPrice(rs.getInt(3));
				vo.setDescription(rs.getString(4));
				vo.setManufacturer(rs.getString(5));
				vo.setCategory(rs.getString(6));
				vo.setNoOfStock(rs.getInt(7));
				vo.setFileName(rs.getString(8));
				vos.add(vo);
			}
			close(conn,pstmt,rs);
			return vos;
		}catch (Exception e) {
			System.err.println(e);
			// TODO: handle exception
		}
		return null;
	}
	
	public ProductsVO selectProduct(String proId) throws NamingException, SQLException{
		Connection conn = getConnection();
		ProductsVO	vo = new ProductsVO();
		String selectAll = "SELECT * FROM products WHERE pro_id=?";
		PreparedStatement pstmt = conn.prepareStatement(selectAll);
		pstmt.setString(1, proId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {		
			vo.setProId(rs.getString(1));
			vo.setProName(rs.getString(2));
			vo.setUnitPrice(rs.getInt(3));
			vo.setDescription(rs.getString(4));
			vo.setManufacturer(rs.getString(5));
			vo.setCategory(rs.getString(6));
			vo.setNoOfStock(rs.getInt(7));
			vo.setFileName(rs.getString(8));
		}
		close(conn,pstmt,rs);
		return vo;
	}

	public int insertProduct(ProductsVO vo) throws NamingException, SQLException{
		Connection conn = getConnection();
		String strInsert = "INSERT INTO Products(pro_id, pro_name, unit_price, description, manufacturer, category, no_of_stock, file_name)\r\n" +
                " VALUES(?,?,?,?,?,?,?,?)";
	    PreparedStatement pstmt = conn.prepareStatement(strInsert);
	    pstmt.setString(1, vo.getProId());
	    pstmt.setString(2, vo.getProName());
	    pstmt.setInt(3, vo.getUnitPrice());
	    pstmt.setString(4, vo.getDescription());
	    pstmt.setString(5, vo.getManufacturer());
	    pstmt.setString(6, vo.getCategory());
	    pstmt.setInt(7, vo.getNoOfStock());
	    pstmt.setString(8, vo.getFileName());
	    int cnt = pstmt.executeUpdate();
	    close(conn,pstmt);
		return cnt;
	}
	
	public int updateMember(ProductsVO vo) throws NamingException, SQLException{
		Connection conn = getConnection();
		String strUpdate = "UPDATE MEMBER SET "+
			    	" user_id =?, user_pwd=?, user_name=?, phone=?,"+
			    	" address=?, email=?"+
			    	" WHERE user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(strUpdate);
		    
//	    pstmt.setString(1, vo.getUserId());
//	    pstmt.setString(2, vo.getUserPwd());
//	    pstmt.setString(3, vo.getAddress());
//	    pstmt.setString(4, vo.getEmail());
//	    pstmt.setString(5, vo.getPhone());
//	    pstmt.setString(6, vo.getUserName());
//	    pstmt.setString(7, vo.getUserId());
	    int cnt = pstmt.executeUpdate();
	    close(conn,pstmt);
		return cnt;
	}
	public int deleteMember(String userId) throws NamingException, SQLException{
		Connection conn = getConnection();
		String strDelete = "DELETE FROM member WHERE user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(strDelete);
		pstmt.setString(1, userId);
		int cnt = pstmt.executeUpdate();
		close(conn,pstmt);
		return cnt;
	}
}
