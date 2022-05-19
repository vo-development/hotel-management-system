package dal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import pojo.Room;

public class RoomDAO implements BaseDAO<Room>{
	
	private PreparedStatement statement = null;
	
	private ResultSet result = null;
	

	@Override
	public Room findById(int id) {
		Room room=null;
		
		try {
			 String findByIdQuery="SELECT * FROM oda where id=?";
			 statement=con.prepareStatement(findByIdQuery);
			 statement.setInt(1, id);
			 result=statement.executeQuery();
			 
			 if (result.next()) {
				 room = new Room();
				 int roomId= result.getInt("id");
				 int price= result.getInt("price");
				 int number = result.getInt("numara");
				 int hotelId = result.getInt("otel_id");
				 int reservationId= result.getInt("rezervasyon_id");
				 int bedQuantity = result.getInt("yatak_Sayisi");
					
				 room.setId(roomId);
				 room.setPrice(price);
				 room.setNumber(number);
				 room.setHotelId(hotelId);
				 room.setReservationId(reservationId);
				 room.setBedQuantity(bedQuantity);
				 
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return room;
	}
		
	@Override
	public HashSet<Room> findAll() {
		
		HashSet<Room> rooms = new HashSet<Room>();
		
		try {
			String findAllQuery = "SELECT * from oda";
			statement=con.prepareStatement(findAllQuery);
			result=statement.executeQuery();
			
			Room room;
			
			while(result.next()) {
				room = new Room();
				
				int id= result.getInt("id");
				int price= result.getInt("fiyat");
				int number = result.getInt("numara");
				int hotelId = result.getInt("otel_id");
				int reservationId= result.getInt("rezervasyon_id");
				int bedQuantity= result.getInt("yatak_sayisi");
				
				room.setId(id);
				room.setPrice(price);
				room.setNumber(number);
				room.setHotelId(hotelId);
				room.setReservationId(reservationId);
				room.setBedQuantity(bedQuantity);
				
				rooms.add(room);
				
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return rooms;
	}

	public HashSet<Room> findAllByHotelId(int hotelId) {

		HashSet<Room> rooms = new HashSet<Room>();

		try {
			String findAllQuery = "SELECT * from oda WHERE otel_id=?";
			statement=con.prepareStatement(findAllQuery);
			statement.setInt(1,hotelId);
			result=statement.executeQuery();

			Room room;

			while(result.next()) {
				room = new Room();

				int id= result.getInt("id");
				int price= result.getInt("fiyat");
				int number = result.getInt("numara");
				int reservationId= result.getInt("rezervasyon_id");
				int bedQuantity= result.getInt("yatak_sayisi");

				room.setId(id);
				room.setPrice(price);
				room.setNumber(number);
				room.setHotelId(hotelId);
				room.setReservationId(reservationId);
				room.setBedQuantity(bedQuantity);

				rooms.add(room);


			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return rooms;
	}

	@Override
	public int insert(Room room) {
			
		int generatedKey=0;
		
		try {
			
			String insertQuery="INSERT INTO oda (numara,otel_id,rezervasyon_id,yatak_sayisi,fiyat) VALUES (?,?,?,?,?)";
			
			statement=con.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
			
			statement.setObject(1, room.getNumber());
			statement.setObject(2, room.getHotelId());
			statement.setObject(3, room.getReservationId());
			statement.setObject(4, room.getBedQuantity());
			statement.setObject(5, room.getPrice());

			
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
	public int update(Room room) {
		
		int generatedKey=0;



		try {

			Statement stmt = con.createStatement();
			stmt.execute("SET foreign_key_checks = 0");
			stmt.close();

			String updateQuery="UPDATE oda SET numara=?,otel_id=?,rezervasyon_id=?,yatak_sayisi=?,fiyat=? WHERE id=?";
			statement=con.prepareStatement(updateQuery,Statement.RETURN_GENERATED_KEYS);
			statement.setObject(1, room.getNumber());
			statement.setObject(2, room.getHotelId());

			if(room.getReservationId() != 0)
				statement.setObject(3, room.getReservationId());

			else
				statement.setObject(3,null);

			statement.setObject(4, room.getBedQuantity());
			statement.setObject(5, room.getPrice());
			statement.setObject(6, room.getId());
			
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
			String deleteQuery = "DELETE from oda where id=?";
			
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
