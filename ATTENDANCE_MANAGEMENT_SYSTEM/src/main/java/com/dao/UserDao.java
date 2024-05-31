package com.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.entity.User;



public class UserDao extends HttpServlet {

	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(User u) {
		boolean f=false;
	
		try {
			String sql="insert into user (name,Location,Qualification,Branch,course,semester,email,password,description,role,pdate) values(?,?,?,?,?,?,?,?,?,?,?)";
			
			 java.util.Date d2 = null;
		      if (d2==null) 
		    	 d2=new java.util.Date();  
				      long ld=d2.getTime();
				      java.sql.Date sqlDate= new java.sql.Date(ld);
				     // System.out.println(sqlDate);
			
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getLocation());
			ps.setString(3, u.getQualification());
			ps.setString(4, u.getBranch());
			ps.setString(5, u.getCourse());
			ps.setString(6, u.getSemester());
			ps.setString(7, u.getEmail());
			ps.setString(8, u.getPassword());
			ps.setString(9, u.getDescription());
			ps.setString(10, "user");
			ps.setDate(11, sqlDate);
			
			int i=ps.executeUpdate();
			if (i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean profilleReqUser(User u) {
		boolean f=false;
	
		try {
			String sql="insert into userReq (attendID,name,Location,Qualification,Branch,course,email,description) values(?,?,?,?,?,?,?,?)";
			
		
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getLocation());
			ps.setString(4, u.getQualification());
			ps.setString(5, u.getBranch());
			ps.setString(6, u.getCourse());
			ps.setString(7, u.getEmail());
			ps.setString(8, u.getDescription());
		
			
			int i=ps.executeUpdate();
			if (i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	public boolean addAttendence(User u) {
		boolean f=false;
	
		try {
			String sql="insert into attendence (attendID,name,Attend,AttedenceDate,Branch,course) values(?,?,?,?,?,?)";
			
			 java.util.Date d2 = null;
		      if (d2==null) 
		    	 d2=new java.util.Date();  
				      long ld=d2.getTime();
				      java.sql.Date sqlDate= new java.sql.Date(ld);
				     // System.out.println(sqlDate);
			
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getAttend());
			ps.setDate(4, sqlDate);
			ps.setString(5, u.getBranch());
			ps.setString(6, u.getCourse());
			
			int i=ps.executeUpdate();
			if (i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	public User login(String em,String psw) {
		
		User u= null;
		
	   try {
		 String sql="select * from user where email=? and password=?";
		   PreparedStatement ps= conn.prepareStatement(sql);
		   ps.setString(1, em);
		   ps.setString(2, psw);
		   
		   ResultSet rs= ps.executeQuery();
		   while (rs.next()) {
			u=new User();
			u.setId(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setQualification(rs.getString(3));
			u.setEmail(rs.getString(4));
			u.setPassword(rs.getString(5));
			u.setRole(rs.getString(6));
			
		}
				   
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return u;
	}
	
	
public boolean updateUser(User u) {
		boolean f=false;
		try {
		
		
		 String sql = "update user set name=?,Location=?,qualification=?,Branch=?,course=?,semester=?,email=?,description=? where id=?";
			
		   PreparedStatement ps= conn.prepareStatement(sql);
		   ps.setString(1, u.getName());
		   ps.setString(2, u.getLocation());
		   ps.setString(3, u.getQualification());
		   ps.setString(4, u.getBranch());
		   ps.setString(5, u.getCourse());
		   ps.setString(6, u.getSemester());
		   ps.setString(7, u.getEmail()); 
		   ps.setString(8, u.getDescription()); 
		   ps.setInt(9, u.getId());
		  
		      int i=ps.executeUpdate();
		      if (i==1) {	    	 
				f = true;
			}
			   
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return f;
	}

public boolean deleteUserbyid(int id) {
	boolean f = false;  

try {
	String dql4="delete from user where id=?";
	PreparedStatement ps=conn.prepareStatement(dql4);
	ps.setInt(1, id);
	int i=ps.executeUpdate();
	
	if (i == 1) {
		f = true;
	}

	
} catch (Exception e) {
	e.printStackTrace();
}
return f;

}

public boolean changepswd(User u) {
	boolean f=false;
	try {
	
	 String sql ="update user set password = ? where email = ?";
		
	   PreparedStatement ps= conn.prepareStatement(sql);
	   ps.setString(1, u.getPassword());
	 //  ps.setInt(2, u.getId());
	   ps.setString(2, u.getEmail());
	  
	      int i=ps.executeUpdate();
	      
	      
	     
	      if (i==1) {	
			f = true;
			 
		}
		   
} catch (Exception e) {
	e.printStackTrace();
}	
	return f;
}


public List<User> getAllUser() {
	List<User> list = new ArrayList<>();
	User j = null;

	try {
		String sql1 = "select * from user order by id desc";
		PreparedStatement ps = conn.prepareStatement(sql1);
		ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
			j = new User();
			j.setId(rs.getInt(1));
			j.setName(rs.getString(2));
			j.setLocation(rs.getString(3));
			j.setQualification(rs.getString(4));
			j.setBranch(rs.getString(5));
			j.setCourse(rs.getString(6));
			j.setSemester(rs.getString(7));
			j.setEmail(rs.getString(8));
			j.setPassword(rs.getString(9));
			j.setDescription(rs.getString(10));
			j.setRole(rs.getString(11));
						
			java.sql.Date d3=rs.getDate(12);
			SimpleDateFormat ds1= new SimpleDateFormat("dd-MM-yyyy");
			String st3=ds1.format(d3);	
			
			j.setPdate(st3);
			list.add(j);
           
		}
	} catch (SQLException se) {
		se.printStackTrace();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}

public List<User> getAllUserReqlist() {
	List<User> list = new ArrayList<>();
	User j = null;

	try {
		String sql1 = "select * from userreq order by id desc";
		PreparedStatement ps = conn.prepareStatement(sql1);
		ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
			j = new User();
			j.setId(rs.getInt(1));
			j.setAttendID(rs.getInt(2));
			j.setName(rs.getString(3));
			j.setLocation(rs.getString(4));
			j.setQualification(rs.getString(5));
			j.setBranch(rs.getString(6));
			j.setCourse(rs.getString(7));
			j.setEmail(rs.getString(8));
			j.setDescription(rs.getString(9));
			list.add(j);
		}
	} catch (SQLException se) {
		se.printStackTrace();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}




public List<User> getAllUserAttencence() {
	List<User> list = new ArrayList<>();
	User j = null;

	try {
		String sql1 = "select * from attendence order by id desc";
		PreparedStatement ps = conn.prepareStatement(sql1);
		ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
			j = new User();
			j.setId(rs.getInt(1));
			j.setAttendID(rs.getInt(2));
			j.setName(rs.getString(3));
			j.setAttend(rs.getString(4));
			java.sql.Date d3=rs.getDate(5);
			j.setBranch(rs.getString(6));
			j.setCourse(rs.getString(7));			
			
			SimpleDateFormat ds1= new SimpleDateFormat("dd-MM-yyyy");
			String st3=ds1.format(d3);	
			
			j.setAttedenceDate(st3);
			list.add(j);
           
		}
	} catch (SQLException se) {
		se.printStackTrace();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}



    public User getuserById(int id) {
     	User j = null;

	try {
		String sql2 = "select * from user where id=?";
		PreparedStatement ps = conn.prepareStatement(sql2);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				j = new User();
				j.setId(rs.getInt(1));
				j.setName(rs.getString(2));
				j.setLocation(rs.getString(3));
				j.setQualification(rs.getString(4));
				j.setBranch(rs.getString(5));
				j.setCourse(rs.getString(6));
				j.setSemester(rs.getString(7));
				j.setEmail(rs.getString(8));
				j.setPassword(rs.getString(9));
				j.setDescription(rs.getString(10));
				j.setRole(rs.getString(11));
			
			
           
		}
	} catch (SQLException se) {
		se.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
	return j;
}





}
