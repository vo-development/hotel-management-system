package dal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import pojo.Roles;

public class RolesDAO implements BaseDAO<Roles>{
	
	private PreparedStatement statement = null;
	
	private ResultSet result = null;
	

	@Override
	public Roles findById(int id) {
			
			Roles role= null;
		try {
			 String findByIdQuery="SELECT * FROM roller where id=?";
			 statement=con.prepareStatement(findByIdQuery);
			 statement.setInt(1, id);
			 result =statement.executeQuery();
			 
			 if(result.next()) {
					role = new Roles();
					int roleId = result.getInt("id");
					String roleName = result.getString("rol_isim");
					
					role.setId(roleId);
					role.setRoleName(roleName);
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return role;
	}
		
	@Override
	public HashSet<Roles> findAll() {
			
			HashSet<Roles> roles = new HashSet<Roles>();
			
		try {
			
			String findAllQuery = "SELECT * from roller";
			statement=con.prepareStatement(findAllQuery);
			result= statement.executeQuery();
			
			Roles role;
			
			
			while(result.next()) {
				role = new Roles();
				int id = result.getInt("id");
				String roleName = result.getString("rol_isim");
				
				role.setId(id);
				role.setRoleName(roleName);
				
				roles.add(role);
				
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return roles;
	}

	@Override
	public int insert(Roles roles) {
			
			int generatedKey=0;
		
		try {
			
			String insertQuery="INSERT INTO roller (rol_isim) VALUES (?)";
			
			statement=con.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
			
			statement.setObject(1,roles.getRoleName());
			
			statement.execute();
			
			result =statement.getGeneratedKeys();
			
			if(result.next()) 
				generatedKey=result.getInt("id");
			
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		}
			return generatedKey;
	}

	@Override
	public int update(Roles roles) {
		
		int generatedKey=0;
		
		try {
			
			String updateQuery="UPDATE  roller SET rol_ismi=? WHERE id=? ";
			
			statement=con.prepareStatement(updateQuery,Statement.RETURN_GENERATED_KEYS);
			statement.setObject(1, roles.getRoleName());
			statement.setObject(2, roles.getId());
			
			statement.execute();
			
			result =statement.getGeneratedKeys();
			
			
			if(result.next()) 
				generatedKey=result.getInt("id");
			
				} catch (SQLException e) {
					e.printStackTrace();
		}
			return generatedKey;
	}

	@Override
	public boolean delete(int id) {
		
		try {
			String deleteQuery = "DELETE from roller where id=?";
			
			statement=con.prepareStatement(deleteQuery);
			statement.setInt(1, id);
			statement.execute();
			
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

}
