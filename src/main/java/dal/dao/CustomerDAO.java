package dal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import pojo.Customer;

public class CustomerDAO implements BaseDAO<Customer>{
	
	private PreparedStatement statement = null;
	
	
	private ResultSet result = null;
	

	@Override
	public Customer findById(int id) {
		
		Customer customer = null;
		
		try {
			 String findByIdQuery="SELECT * FROM musteri where id=?";
			 
			statement=con.prepareStatement(findByIdQuery);
			statement.setInt(1, id);
			result = statement.executeQuery();
			
			if(result.next()) {
				customer= new Customer();
				int customerId = result.getInt("id");
				String name= result.getString("isim");
				String password = result.getString("sifre");
				String mail = result.getString("mail");
				String phoneNo= result.getString("telefon_no");
				String identityNo= result.getString("kimlik_no");
				String adress= result.getString("adres");
				
				customer.setId(customerId);
				customer.setName(name);
				customer.setPassword(password);
				customer.setMail(mail);
				customer.setPhoneNo(phoneNo);
				customer.setTcNo(identityNo);
				customer.setAdress(adress);
				
			}
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return customer;
	}

	public Customer findByMail(String mail) {

		Customer customer = null;

		try {
			 String findByIdQuery="SELECT * FROM musteri where mail=?";

			statement=con.prepareStatement(findByIdQuery);
			statement.setString(1, mail);
			result = statement.executeQuery();

			if(result.next()) {
				customer= new Customer();
				int customerId = result.getInt("id");
				String name= result.getString("isim");
				String password = result.getString("sifre");
				String phoneNo= result.getString("telefon_no");
				String identityNo= result.getString("kimlik_no");
				String adress= result.getString("adres");

				customer.setId(customerId);
				customer.setName(name);
				customer.setPassword(password);
				customer.setMail(mail);
				customer.setPhoneNo(phoneNo);
				customer.setTcNo(identityNo);
				customer.setAdress(adress);

			}



		} catch (SQLException e) {
			e.printStackTrace();
		}


		return customer;
	}



		
	@Override
	public HashSet<Customer> findAll() {
			HashSet<Customer> customers = new HashSet<Customer>();
		try {
			Customer customer;
			
			String findAllQuery = "SELECT * from musteri";
			statement=con.prepareStatement(findAllQuery);
			result=statement.executeQuery();
			
			while(result.next()) {
				customer = new Customer();
				 
				int id = result.getInt("id");
				String name= result.getString("isim");
				String password = result.getString("sifre");
				String mail = result.getString("mail");
				String phoneNo= result.getString("telefon_no");
				String identityNo= result.getString("kimlik_no");
				String adress= result.getString("adres");
				
				customer.setId(id);
				customer.setName(name);
				customer.setPassword(password);
				customer.setMail(mail);
				customer.setPhoneNo(phoneNo);
				customer.setTcNo(identityNo);
				customer.setAdress(adress);
				
				customers.add(customer);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		
		
		
		return customers;
	}

	@Override
	public int insert(Customer customer) {
		int generatedKey=0;
		try {
			
			String insertQuery = "INSERT INTO musteri (isim,sifre,mail,telefon_no,kimlik_no,adres) values (?,?,?,?,?,?)";
			
			statement = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			statement.setObject(1, customer.getName());
			statement.setObject(2, customer.getPassword());
			statement.setObject(3, customer.getMail());
			statement.setObject(4, customer.getPhoneNo());
			statement.setObject(5, customer.getTcNo());
			statement.setObject(6, customer.getAdress());
			
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
	public int update(Customer customer) {
		int generatedKey=0;
		try {
			
			String updateQuery="UPDATE  musteri  SET isim = ? , sifre= ?, mail = ?, telefon_no= ?,kimlik_no= ?, adres= ? WHERE id=?";
			statement = con.prepareStatement(updateQuery,Statement.RETURN_GENERATED_KEYS);
			
			statement.setObject(1, customer.getName());
			statement.setObject(2, customer.getPassword());
			statement.setObject(3, customer.getMail());
			statement.setObject(4, customer.getPhoneNo());
			statement.setObject(5, customer.getTcNo());
			statement.setObject(6, customer.getAdress());
			statement.setObject(7, customer.getId());
			
			
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
			String deleteQuery = "DELETE from musteri where id=?";
			
			statement= con.prepareStatement(deleteQuery);
			statement.setInt(1, id);
			statement.execute();
			
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

	
	
}
