package lab05;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int id;
	private String name;
	private String surname;
	private String address;
	private List<Purchase> purchases;
	
	
	public List<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Customer(int id, String name, String surname, String address) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.purchases = new ArrayList<Purchase>();
	}
	
	public void addPurchase(Purchase p) {
		purchases.add(p);
	}
	@Override
	public String toString() {
		return this.id + " " + this.name + " " + this.surname + " " + this.address;
	}
	
}
