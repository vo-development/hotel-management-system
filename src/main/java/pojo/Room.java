package pojo;

public class Room {
	
	private int id;

	private int price;


	private int number;
	
	private int hotelId;
	
	private int reservationId;

	private String reservationStatus = "";

	private int bedQuantity;

	public Room(int price, int number, int hotelId, int reservationId, int bedQuantity) {
		this.price = price;
		this.number = number;
		this.hotelId = hotelId;
		setReservationId(reservationId);
		this.bedQuantity = bedQuantity;
	}

	public Room(int id, int price, int number, int hotelId, int reservationId,
				int bedQuantity) {
		this.id = id;
		this.price = price;
		this.number = number;
		this.hotelId = hotelId;
		setReservationId(reservationId);
		this.bedQuantity = bedQuantity;
	}
	public Room() {
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;

		if(reservationId != 0)
			this.reservationStatus = "Rezerve Edildi";
	}
	public int getBedQuantity() {
		return bedQuantity;
	}
	public void setBedQuantity(int bedQuantity) {
		this.bedQuantity = bedQuantity;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", hotelId=" + hotelId + ", reservationId=" + reservationId
				+ ", bedQuantity=" + bedQuantity + "]";
	}

	
	
	
	
	

}
