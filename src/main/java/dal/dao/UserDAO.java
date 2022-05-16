package dal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import pojo.User;

public class UserDAO implements BaseDAO<User> {
	
	
	private PreparedStatement statement = null;
	
	private ResultSet result= null;
	
	
	public User findById(int id) {
		
	
		String findByIdQuery = ("SELECT * from kullanici where id=?");
		
		User user = null;
		try {
		
			
			
			statement=con.prepareStatement(findByIdQuery);
			statement.setInt(1, id);
			result= statement.executeQuery();
			
			if(result.next()) {
			user = new User();
			
			int userid= result.getInt("id");
			String name = result.getString("isim");
			String password = result.getString("sifre");
			String mail =result.getString("email");
			
			user.setId(userid);
			user.setUsername(name);
			user.setPassword(password);
			user.setMail(mail);
			}
			
	
		}	catch(SQLException e ){
			e.printStackTrace();
		}
		
		
		return user;
		
	}
	
	
	public HashSet<User> findAll() {
			
		HashSet<User> users = new HashSet<User>();
		
		try {
			String findAllQuery = "SELECT * from kullanici";
			
			statement=con.prepareStatement(findAllQuery);
			result = statement.executeQuery();
			
			User user;
			
			while (result.next()) {
				user = new User();
				int id = result.getInt("id");
				String name = result.getString("isim");
				String password = result.getString("sifre");
				String mail = result.getString("email");
				
				user.setId(id);
				user.setUsername(name);
				user.setPassword(password);
				user.setMail(mail);
				
				
				users.add(user);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return users;
	}


	@Override
	public int insert(User user) {
			
		int generatedKey=0;
		
		try {
			String insertQuery="INSERT INTO kullanici (isim,sifre,email) values (?,?,?)";
					
					
			
			statement=con.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
			statement.setObject(1, user.getUsername());
			statement.setObject(2, user.getPassword());
			statement.setObject(3, user.getMail());
			
			statement.execute();
			
			result =statement.getGeneratedKeys();
			
			
			if(result.next()) 
				generatedKey=result.getInt(1);
			
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return generatedKey;
		
	}


	@Override
	public int update(User user) {
			
		int generatedKey=0;
		
		try {
			String updateQuery="UPDATE kullanici SET isim=?,sifre=?,email=? WHERE id=? ";
			
			statement=con.prepareStatement(updateQuery);
			
			statement.setObject(1, user.getUsername());
			statement.setObject(2, user.getPassword() );
			statement.setObject(3, user.getMail());
			statement.setObject(4, user.getId());
			
			statement.execute();
			
			result =statement.getGeneratedKeys();
			
			
			if(result.next()) 
				generatedKey=result.getInt(1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return generatedKey;
			
	}


	@Override
	public boolean delete(int id) {
		try {
			String deleteQuery="DELETE from kullanici where id=?";
			
			statement=con.prepareStatement(deleteQuery);
			statement.setInt(1, id);
			statement.execute();
			
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
	}


}
