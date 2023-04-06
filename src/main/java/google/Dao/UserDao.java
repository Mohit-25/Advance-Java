package google.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import google.Bean.UserBean;
import google.util.UserConnection;

public class UserDao {
	
	public void addUser(UserBean bean)
	{
		Connection con=null;
	
		try {
			//store into database 
			con = UserConnection.getConnection();
			//sql 
			//Statement
			//PreparedStatement
			//CallableStatement 
			PreparedStatement pstm = con.prepareStatement("insert into users(firstName,lastName,emailId,password,city,gender,h1,h2,h3) values (?,?,?,?,?,?,?,?,?) ");
			pstm.setString(1,bean.getFirstName());
			pstm.setString(2, bean.getLastName());
			pstm.setString(3, bean.getEmailId());
			pstm.setString(4, bean.getPassword());
			pstm.setString(5, bean.getCity());
			pstm.setString(6, bean.getGender());
			pstm.setString(7, bean.getH1());
			pstm.setString(8, bean.getH2());
			pstm.setString(9, bean.getH3());

			pstm.executeUpdate(); //db -> 	1 -> inserted , updated , deleted 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		

	}		
				
	

	public UserBean Authenticate(String email, String password) 
   {
		UserBean user=null;
		ResultSet rs =null;
		Connection con=null;
	   try
	  {
		
		
		// TODO Auto-generated method stub
		con = UserConnection.getConnection();
		PreparedStatement pstm = con.prepareStatement("select * from users where emailId= ? and password= ?");
		pstm.setString(1,email);
		pstm.setString(2,password );
		
		rs=pstm.executeQuery();
		
		if(rs.next())
		{
			user=new UserBean();
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setEmailId(rs.getString("emailId"));
			user.setPassword(rs.getString("password"));
			user.setCity(rs.getString("city"));
			user.setGender(rs.getString("gender"));
			user.setH1(rs.getString("h1"));
			user.setH2(rs.getString("h2"));
			user.setH3(rs.getString("h3"));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	   finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	return user;
   }



	public static ArrayList<UserBean> getAllrecords() {
		
		UserBean user=null;
		ResultSet rs =null;
		ArrayList<UserBean> list=new ArrayList();
		Connection con=null;
	   try
	  {
		
		
		// TODO Auto-generated method stub
		con = UserConnection.getConnection();
		PreparedStatement pstm = con.prepareStatement("select * from users");
		
		
		rs=pstm.executeQuery();
		
		while(rs.next())
		{
			user=new UserBean();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setEmailId(rs.getString("emailId"));
			user.setPassword(rs.getString("password"));
			user.setCity(rs.getString("city"));
			user.setGender(rs.getString("gender"));
			user.setH1(rs.getString("h1"));
			user.setH2(rs.getString("h2"));
			user.setH3(rs.getString("h3"));
			
			list.add(user);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return list;
	}



	public void deleteuser(Integer userId) {
		
		
		Connection con=null;
	   try
	  {
		
		
		// TODO Auto-generated method stub
		con = UserConnection.getConnection();
		PreparedStatement pstm = con.prepareStatement("delete from users where id=?");
		
		pstm.setInt(1,userId);
		pstm.executeUpdate();
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}



	public UserBean getUserById(Integer userId) {
		
		UserBean user=null;
		ResultSet rs =null;
	
		Connection con=null;
	   try
	  {
		
		
		// TODO Auto-generated method stub
		con = UserConnection.getConnection();
		PreparedStatement pstm = con.prepareStatement("select * from users where id=?");
		
		pstm.setInt(1,userId);
		rs=pstm.executeQuery();
		
		if(rs.next())
		{
			user=new UserBean();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setEmailId(rs.getString("emailId"));
			user.setPassword(rs.getString("password"));
			user.setCity(rs.getString("city"));
			user.setGender(rs.getString("gender"));
			user.setH1(rs.getString("h1"));
			user.setH2(rs.getString("h2"));
			user.setH3(rs.getString("h3"));
			
		
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		return user;
	}



	public void UpdateUser(UserBean user) {
		
		
	  Connection con=null;
	   try
	  {
		
		
		// TODO Auto-generated method stub
		con = UserConnection.getConnection();
		PreparedStatement pstm = con.prepareStatement("update users set firstName=?,lastName=?,city=?,gender=?,h1=?,h2=?,h3=? where id=?");
		
		pstm.setString(1,user.getFirstName());
		pstm.setString(2,user.getLastName());
		pstm.setString(3,user.getCity());
		pstm.setString(4,user.getGender());
		pstm.setString(5,user.getH1());
		pstm.setString(6,user.getH2());
		pstm.setString(7,user.getH3());
		pstm.setInt(8,user.getId());
		
		
		pstm.executeUpdate();
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	}



	public ArrayList<UserBean> SearchUser(String firstName) {
		
		  ResultSet rs=null;
		  ArrayList<UserBean> list=new ArrayList<>();
		  UserBean user=null;
		  Connection con=null;
		   try
		  {
			
			
			// TODO Auto-generated method stub
			con = UserConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from users where firstName like ?");
			
			pstm.setString(1,firstName+"%");
			
			
			
			rs=pstm.executeQuery();
			
			while(rs.next())
			{
				user=new UserBean();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmailId(rs.getString("emailId"));
				user.setPassword(rs.getString("password"));
				user.setCity(rs.getString("city"));
				user.setGender(rs.getString("gender"));
				user.setH1(rs.getString("h1"));
				user.setH2(rs.getString("h2"));
				user.setH3(rs.getString("h3"));
				
				list.add(user);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		   return list;
		
	}

		
}

	
