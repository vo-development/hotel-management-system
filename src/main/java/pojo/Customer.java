package pojo;

public class Customer {
	
	private int id;
	
	private String name;
	
	private String password; 

	private String mail;
	
	private String phoneNo;
	
	private String tcNo;
	
	private String adress;
	
	public Customer( int id,String name, String password, String mail, String phoneNo, String tcNo, String adress) {
		super();
		this.id=id;
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.phoneNo = phoneNo;
		this.tcNo = tcNo;
		this.adress = adress;
	}

	public Customer( String name, String password, String mail, String phoneNo, String tcNo, String adress) {
		super();
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.phoneNo = phoneNo;
		this.tcNo = tcNo;
		this.adress = adress;
	}
	public Customer() {
		
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", mail=" + mail + ", phoneNo="
				+ phoneNo + ", tcNo=" + tcNo + ", adress=" + adress + "]";
	}
	
	
	
	
	
	
}
