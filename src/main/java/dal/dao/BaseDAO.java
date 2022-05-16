package dal.dao;

import dal.DBConnection;

import java.sql.Connection;
import java.util.HashSet;


public interface BaseDAO<T>  {
	
	
	
	public Connection con = DBConnection.getConnection();
	
	public T findById(int id );
	
	public HashSet<T> findAll();
	
	public int insert(T t);
	
	public int update(T t);
	
	public boolean delete(int id );
	
	

}
