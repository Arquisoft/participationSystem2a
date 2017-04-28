package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "CITIZEN")
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name = "NAME")
	private String name;
	@Column(name = "SURNAME")
	private String surname;
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(name = "BORN_DATE")
	private Date bornDate;

	private String address;
	private String nationality;
	private String dni;
	private User user;
	private String password;
	private boolean isAdmin;

	// Constructor vacio para JPA
	public Citizen() {
	}

	public Citizen(String name, String surname, String email, Date bornDate, String address,
			String nationality, String dni, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.bornDate = bornDate;
		this.address = address;
		this.nationality = nationality;
		this.dni = dni;
		this.password = password;
	}

	public Citizen(String name, String surname, String email, Date bornDate, String address,
			String nationality, String dni, boolean isAdmin) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.bornDate = bornDate;
		this.address = address;
		this.nationality = nationality;
		this.dni = dni;
		this.isAdmin = isAdmin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public String getAddress() {
		return address;
	}

	public String getNationality() {
		return nationality;
	}

	public String getDni() {
		return dni;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citizen other = (Citizen) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Citizen [name=" + name + ", surname=" + surname + ", email=" + email + ", bornDate="
				+ bornDate + ", address=" + address + ", nationality=" + nationality + ", dni="
				+ dni + "]";
	}
	


	protected void _setUser(User user) {
		this.user = user;
	}

}
