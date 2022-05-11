package dal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				 int number = result.getInt("numara");
				 int hotelId = result.getInt("otel_id");
				 int reservationId= result.getInt("rezervasyon_id");
					
				 room.setId(roomId);
				 room.setNumber(number);
				 room.setHotel(hotelId);
				 room.setReservationId(reservationId);
				 
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
				int number = result.getInt("numara");
				int hotelId = result.getInt("otel_id");
				int reservationId= result.getInt("rezervasyon_id");
				
				room.setId(id);
				room.setNumber(number);
				room.setHotel(hotelId);
				room.setReservationId(reservationId);
				
				rooms.add(room);
				
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return rooms;
	}

	@Override
	public boolean insert(Room room) {
			
		try {
			
			String insertQuery="INSERT INTO oda (numara,otel_id,rezervasyon_id) VALUES (?,?,?)";
			
			statement=con.prepareStatement(insertQuery);
			
			statement.setObject(1, room.getNumber());
			statement.setObject(2, room.getHotelId());
			statement.setObject(3, room.getReservationId());
			
			
			statement.execute();
			
			
			return true;
		
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Room room) {
		try {
			
			String updateQuery="UPDATE oda SET numara=?,otel_id=?,rezervasyon_id=? WHERE id=?";
			
			statement=con.prepareStatement(updateQuery);
			statement.setObject(1, room.getNumber());
			statement.setObject(2, room.getHotelId());
			statement.setObject(3, room.getReservationId());
			statement.setObject(4, room.getId());
			
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