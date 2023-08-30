package sec01.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class StudentAllDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public StudentAllDAO () {

		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory =(DataSource) envContext.lookup("jdbc/my_student");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listMembers() {
		List membersList = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = " select * from my_student order by id";
			System.out.println("preparedStatement : " + query);
			
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String username = rs.getString("username");
				String univ = rs.getString("univ");
				String birth = rs.getString("birth");
				String email = rs.getString("email");
				
				StudentAllVO memberVO = new StudentAllVO(id,username, univ, birth, email);
				 
				membersList.add(memberVO);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return membersList;
		
	}
	
	public StudentAllVO findMember(String _id) {
		StudentAllVO memInfo = null;
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member where id=?";
			pstmt =con.prepareStatement(query);
			pstmt.setString(1,_id);
			System.out.println(query);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String username = rs.getString("username");
			String univ = rs.getString("univ");
			String birth = rs.getString("birth");
			String email = rs.getString("email");
			memInfo = new StudentAllVO(username, univ, birth, email);
			pstmt.close();
			con.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return memInfo;
}
	
	public void addMember (StudentAllVO m) {
		try {
			con = dataFactory.getConnection();
			String username = m.getUsername();
			String univ = m.getUniv();
			String birth = m.getBirth();
			String email = m.getEmail();
			String query = "insert into my_student(username, univ, birth, email)" + " values(?,?,?,?)";
			System.out.println("preparedStatement : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, univ);
			pstmt.setString(3, birth);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void modMember(StudentAllVO studentAllVO) {
		String username = studentAllVO.getUsername();
		String univ = studentAllVO.getUniv();
		String birth = studentAllVO.getBirth();
		String email = studentAllVO.getEmail();
		try {
			con = dataFactory.getConnection();
			String query = "update my_student set univ=?, birth=?, email=? where username=? ";
			System.out.println(query);
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, univ);
			pstmt.setString(2, birth);
			pstmt.setString(3, email);
			pstmt.setString(4, username);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	
	public void delMember(String id) {
		try {
			con=dataFactory.getConnection();
			String query = "delete from my_student where id=?";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
