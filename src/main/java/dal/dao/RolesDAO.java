package dal.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;

import pojo.Roles;

public class RolesDAO implements BaseDAO<Roles>{
	
	private PreparedStatement statement = null;
	
	private ResultSet rs = null;
	

	@Override
	public Roles findById(int id) {
			
			Roles role= null;
		try {
			 String findByIdQuery="SELECT * FROM roller where id=?";
			 statement=con.prepareStatement(findByIdQuery);
			 statement.setInt(1, id);
			 rs =statement.executeQuery();
			 
			 if(rs.next()) {
					role = new Roles();
					int roleId = rs.getInt("id");
					String roleName = rs.getString("rol_isim");
					
					role.setId(roleId);
					role.setRoleName(roleName);
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return role;
	}


	public ArrayList<Roles> findByUser(int  userId) {


			var roles = new ArrayList<Roles>();
		try {


			 String query="SELECT id,rol_isim FROM roller r LEFT JOIN  kullanicirol kc ON r.id = kc.rol_id WHERE kullanici_id =?";
			 statement=con.prepareStatement(query);
			 statement.setInt(1, userId);
			 rs =statement.executeQuery();

			Roles role;
			 if(rs.next()) {
				 role = new Roles();

				 role.setId(rs.getInt("id"));
				 role.setRoleName(rs.getString("rol_isim"));

				 roles.add(role);
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return roles;
	}
		
	@Override
	public HashSet<Roles> findAll() {
			
			HashSet<Roles> roles = new HashSet<Roles>();
			
		try {
			
			String findAllQuery = "SELECT * from roller";
			statement=con.prepareStatement(findAllQuery);
			rs = statement.executeQuery();
			
			Roles role;
			
			
			while(rs.next()) {
				role = new Roles();
				int id = rs.getInt("id");
				String roleName = rs.getString("rol_isim");
				
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
			
			rs =statement.getGeneratedKeys();
			
			if(rs.next())
				generatedKey= rs.getInt(1);
			
		
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
			
			rs =statement.getGeneratedKeys();
			
			
			if(rs.next())
				generatedKey= rs.getInt(1);
			
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
