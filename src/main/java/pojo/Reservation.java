package pojo;

import java.util.*;

public class Reservation {
	
	private int id;
	
	private int price;
	
	private Date startDate;
	
	private Date endDate;
	
	private int customerId;

	public Reservation(int price, Date startDate, Date endDate, int customerId) {
		super();
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customerId= customerId;
	}
	public Reservation(int id,int price, Date startDate, Date endDate, int customerId) {
		super();
		this.id=id;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customerId= customerId;
	}
	public Reservation() {
		
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", price=" + price + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", customerId=" + customerId + "]";
	}
	

	
	
	
	

}

