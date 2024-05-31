package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.entity.Faculty;
import com.entity.User;

public class FacultyDao extends HttpServlet {

	private Connection conn;

	public FacultyDao(Connection conn) {
		super();
		this.conn = conn;
	}


	
	public boolean addfaculty(Faculty fct) {
		boolean f=false;
		try {
			String sql="insert into faculty (name,Location,Qualification,Branch,email,password,description,role,pdate) values(?,?,?,?,?,?,?,?,?)";
			
			java.util.Date d2 = null;
		      if (d2==null) 
		    	 d2=new java.util.Date();  
				      long ld=d2.getTime();
				      java.sql.Date sqlDate= new java.sql.Date(ld);
				     // System.out.println(sqlDate);
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, fct.getName());
			ps.setString(2, fct.getLocation());
			ps.setString(3, fct.getQualification());
			ps.setString(4, fct.getBranch());
			ps.setString(5, fct.getEmail());
			ps.setString(6, fct.getPassword());
			ps.setString(7, fct.getDescription());
			ps.setString(8, "faculty");
			ps.setDate(9, sqlDate);
			
			int i=ps.executeUpdate();
			if (i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
	public Faculty login(String em,String psw) {
		
		Faculty u= null;
		
	   try {
		 String sql="select * from faculty where email=? and password=?";
		   PreparedStatement ps= conn.prepareStatement(sql);
		   ps.setString(1, em);
		   ps.setString(2, psw);
		   
		   ResultSet rs= ps.executeQuery();
		   while (rs.next()) {
			u=new Faculty();
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
	
	
public boolean updateFaculty(Faculty u) {
		boolean f=false;
		try {
		
		 String sql = "update faculty set name=?,Location=?,Qualification=?,Branch=?,email=? where id=?";
		 
		   PreparedStatement ps= conn.prepareStatement(sql);
		   ps.setString(1, u.getName());
		   ps.setString(2, u.getLocation());
		   ps.setString(3, u.getQualification());
		   ps.setString(4, u.getBranch());
		   ps.setString(5, u.getEmail()); 
		   ps.setInt(6, u.getId());
		  
		      int i=ps.executeUpdate();
		      if (i==1) {	    	 
				f = true;
			}
			   
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return f;
	}


public boolean deleteFacultybyid(int id) {
	boolean f = false;  

try {
	String dql4="delete from faculty where id=?";
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

public boolean changepswd(Faculty u) {
	boolean f=false;
	try {
	
	 String sql ="update faculty set password = ? where email = ?";
		
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

public List<Faculty> getAllfaculty() {
	List<Faculty> list = new ArrayList<>();
	Faculty j = null;

	try {
		String sql1 = "select * from faculty order by id desc";
		PreparedStatement ps = conn.prepareStatement(sql1);
		ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
			j = new Faculty();
			j.setId(rs.getInt(1));
			j.setName(rs.getString(2));
			j.setLocation(rs.getString(3));
			j.setQualification(rs.getString(4));
			j.setBranch(rs.getString(5));
			j.setEmail(rs.getString(6));
			j.setPassword(rs.getString(7));
			j.setDescription(rs.getString(8));
			j.setRole(rs.getString(9));
						
			java.sql.Date d3=rs.getDate(10);
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


public Faculty getFacultyById(int id) {
 	Faculty j = null;

try {
	String sql2 = "select * from faculty where id=?";
	PreparedStatement ps = conn.prepareStatement(sql2);
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	
		while (rs.next()) {
			j = new Faculty();
			j.setId(rs.getInt(1));
			j.setName(rs.getString(2));
			j.setLocation(rs.getString(3));
			j.setQualification(rs.getString(4));
			j.setBranch(rs.getString(5));
			j.setEmail(rs.getString(6));
			j.setPassword(rs.getString(7));
			j.setDescription(rs.getString(8));
			j.setRole(rs.getString(9));
		
       
	}
} catch (SQLException se) {
	se.printStackTrace();
}catch (Exception e) {
	e.printStackTrace();
}
return j;
}



}
