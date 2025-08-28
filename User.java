package Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Interfaces.Searchable;
import Manager.BookingManager;

public class User implements Searchable{
	
   @Override
	public int hashCode() {
		return Objects.hash(email, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name);
	}

private int id;
   private String name;
   private String email;
   
    
	public User(int id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
    public void bookVenue(Venue venue,String date) {
    	
    }
    

    @Override
    public List<Venue> search(String keyword) {
        List<Venue> results = new ArrayList<>();

        
        List<Venue> allVenues = BookingManager.getInstance().getVenues();

        for (Venue venue : allVenues) {
            if (venue.getLocation().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(venue);
            }
        }
        return results;
    }
    @Override
    public List<Venue> search(int id) {
        List<Venue> results = new ArrayList<>();

        
        List<Venue> allVenues = BookingManager.getInstance().getVenues();

        for (Venue venue : allVenues) {
        	 if (venue.getId() == id) {
                 results.add(venue);
             } 
        }
        return results;
    }


		
	


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	 
	

}
