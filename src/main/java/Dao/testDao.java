package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnnection;
import model.test;

public class testDao {

	public static void insertTest(test t) {
		try {
			Connection conn = DBConnnection.CreateConnection();
			String sql = "insert into student (name,contact, gender, dob, address, email, password ) values (?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, t.getName());
			pst.setLong(2, t.getContact());
			pst.setString(3, t.getGender());
			pst.setString(4, t.getDob());
			pst.setString(5, t.getAdddress());
			pst.setString(6, t.getEmail());
			pst.setString(7, t.getPassword());
			pst.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static test testlogin(test t) {
		test t1 = null;
		try {
			Connection conn = DBConnnection.CreateConnection();
			String sql = "select * from student where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, t.getEmail());
			pst.setString(2, t.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				t1 = new test();
				t1.setId(rs.getInt("id"));
				t1.setName(rs.getString("name"));
				t1.setContact(rs.getLong("contact"));
				t1.setGender(rs.getString("gender"));
				t1.setDob(rs.getString("dob"));
				t1.setAdddress(rs.getString("address"));
				t1.setEmail(rs.getString("email"));
				t1.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t1;

	}
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection conn = DBConnnection.CreateConnection();
			String sql = "select * from student where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static List<test> getAllTest() {
		List<test> list = new ArrayList<test>();
		try {
			Connection conn = DBConnnection.CreateConnection();
			String sql = "select * from student";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				test t1 = new test();
				t1.setId(rs.getInt("id"));
				t1.setName(rs.getString("name"));
				t1.setContact(rs.getLong("contact"));
				t1.setGender(rs.getString("gender"));
				t1.setDob(rs.getString("dob"));
				t1.setAdddress(rs.getString("address"));
				t1.setEmail(rs.getString("email"));
				t1.setPassword(rs.getString("password"));
				list.add(t1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public static test getTestByID(int id) {
		test t1 = null;
		try {
			Connection conn = DBConnnection.CreateConnection();
			String sql = "select * from student where id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				t1 = new test();
				t1.setId(rs.getInt("id"));
				t1.setName(rs.getString("name"));
				t1.setContact(rs.getLong("contact"));
				t1.setGender(rs.getString("gender"));
				t1.setDob(rs.getString("dob"));
				t1.setAdddress(rs.getString("address"));
				t1.setEmail(rs.getString("email"));
				t1.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t1;
	}
	
	public static void editTest(test t) {
		try {
			Connection conn = DBConnnection.CreateConnection();
			String sql = "update  student set name=?,contact=?, gender=?, dob=?, address=?, email=?, password=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, t.getName());
			pst.setLong(2, t.getContact());
			pst.setString(3, t.getGender());
			pst.setString(4, t.getDob());
			pst.setString(5, t.getAdddress());
			pst.setString(6, t.getEmail());
			pst.setString(7, t.getPassword());
			pst.setInt(8, t.getId());
			
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void deleteTest(int id) {
		try {
			Connection conn = DBConnnection.CreateConnection();
			String sql = "delete from student where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setInt(1, id);
			pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
