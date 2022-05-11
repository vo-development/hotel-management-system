package pojo;

public class Room {
	
	private int id;
	
	private int number;
	
	private int hotelId;
	
	private int reservationId;

	public Room(int id, int number, int hotelId, int reservationId) {
		super();
		this.id = id;
		this.number = number;
		this.hotelId=hotelId;
		this.reservationId = reservationId;
	}
/*	public Room(int number, int hotelId, int reservationId) {
		super();
		this.number = number;
		this.hotelId=hotelId;
		this.reservationId = reservationId;
	}
	*/
	public Room(int id,int number,int hotelId) {
		super();
		this.id=id;
		this.number = number;
		this.hotelId=hotelId;
	}
	public Room() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotel(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", hotelId=" + hotelId + ", reservationId=" + reservationId
				+ "]";
	}

	
	
	
	
	

}
