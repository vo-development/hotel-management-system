package dal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			
			user.setId(userid);
			user.setUsername(name);
			user.setPassword(password);
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
				String name = result.getNString("isim");
				String password = result.getNString("sifre");
				
				user.setId(id);
				user.setUsername(name);
				user.setPassword(password);
				
				users.add(user);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return users;
	}


	@Override
	public boolean insert(User user) {
		
		
		try {
			String insertQuery="INSERT INTO kullanici (id,isim,sifre) values (?,?,?)";
					
					
			
			statement=con.prepareStatement(insertQuery);
			statement.setObject(1, ((pojo.User) user).getId());
			statement.setObject(2, ((pojo.User) user).getUsername());
			statement.setObject(3, ((pojo.User) user).getPassword() );
			
			statement.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public boolean update(User user) {
			try {
			String updateQuery="UPDATE kullanici SET isim=?,sifre=? WHERE id=? ";
			
			statement=con.prepareStatement(updateQuery);
			
			statement.setObject(1, ((pojo.User) user).getUsername());
			statement.setObject(2, ((pojo.User) user).getPassword() );
			statement.setObject(3, ((pojo.User) user).getId());
			statement.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
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
