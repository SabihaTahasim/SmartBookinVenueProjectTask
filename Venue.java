package Model;
import java.util.Objects;
import java.util.Scanner;

import Interfaces.Bookable;

public abstract class Venue implements Bookable {
	
	 private int id;
	 
	 private String name;
	 private String location;
	 private double price;
	 private int capacity;
	 abstract double calculateFinalPrice();
	@Override
	public int hashCode() {
		return Objects.hash(capacity, id, location, name, price);
	}
	
	public Venue(int id, String name, String location, double price, int capacity) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.price = price;
		this.capacity = capacity;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venue other = (Venue) obj;
		return capacity == other.capacity && id == other.id && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	@Override
	public String toString() {
		return "Id="+id +"\n"+"Name=" + name + "\n" +"Location=" + location +"\n"+ "Price=" + price +"\n"+ "Capacity="+ capacity  ;
	}
	 
	 

}
