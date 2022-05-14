package pojo;

import java.util.*;

public class Hotel {
	
	private int id;
	
	private String name;
	
	private HashSet<Room> room;
	
	private HashSet<User> employee;
	
	
	public Hotel(int id, String name, HashSet<Room> room, HashSet<User> employee) {
		this.id=id;
		this.name=name;
		this.room=room;
		this.employee=employee;
		
	}
	public Hotel (String name) {
		this.name=name;
	}
	
	public Hotel(int id, String name) {
		this.id=id;
		
		this.name=name;
	}
	public Hotel () {
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public HashSet<Room> getRoom() {
		return room;
	}


	public void setRoom(HashSet<Room> room) {
		this.room = room;
	}


	public HashSet<User> getEmployee() {
		return employee;
	}


	public void setEmployee(HashSet<User> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
