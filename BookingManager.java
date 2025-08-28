package Manager;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;

import Model.Booking;
import Model.Venue;
import Model.Booking;
import Model.User;
import Exceptions.AlreadyBookedException;

public class BookingManager {
	private static BookingManager instance;
	private List<Booking> b=new ArrayList<>();
	private static int bookingIdCounter = 100;

	private List<Venue> venues = new ArrayList<>();
	
	public static BookingManager getInstance() {
		 if (instance == null) {
		        instance = new BookingManager(); // create object when first time called
		    }
		return instance;
	}
	public static void setInstance(BookingManager instance) {
		BookingManager.instance = instance;
	}
	public List<Booking> getB() {
		return b;
	}
	public void setB(List<Booking> b) {
		this.b = b;
	}
	public void addBooking(User user, Venue venue, String date) {
	    
	    for (Booking booking : b) {
	        if (booking.getVenue().equals(venue) && booking.getDate().equals(date)) {
	        	
	            throw new AlreadyBookedException("Venue has been booked on " + date);
	        }
	    }

	    
	    int bookingId = ++bookingIdCounter;
	    Booking newBooking = new Booking(bookingId, venue, user, date);
	    b.add(newBooking);

	    saveToFile();
	    //System.out.println("[BOOKING SUCCESS]\n" + newBooking);
	}

		
	
	public void cancelBooking(int BookingID) {
		Booking bookingToRemove=null;
		for(Booking booking:b) {
			if(booking.getBookingID()==BookingID) {
				bookingToRemove=booking;
				break;
				
				
			}
			
		}
		if(bookingToRemove!=null) {
			b.remove(bookingToRemove);
			bookingToRemove.getVenue().cancelBooking(bookingToRemove.getDate());
			saveToFile();
			System.out.println("booking cancelled Successfully");
		}
		
		
	}
	public void saveToFile() {
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\sabih\\OneDrive\\Desktop\\Hello.txt"))){
			//System.out.println("Saving " + b.size() + " bookings...");

			for(Booking booking:b) {
				bw.write("BK"+booking.getBookingID()+","+booking.getVenue().getName()+","+booking.getDate());
				bw.newLine();
				
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void loadFromFile() {
		try(FileReader fr=new FileReader("C:\\Users\\sabih\\OneDrive\\Desktop\\Hello.txt")){
			char ch;
			 while ((ch = (char) fr.read()) != -1) {
            System.out.print((char) ch);
        }
	        
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
	 public void addVenue(Venue v) {
	        venues.add(v);
	    }

	    public List<Venue> getVenues() {
	        return venues;
	    }
	
	 

}
