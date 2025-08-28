package Model;

public class Booking {
	
	private int bookingID;
	
	private Venue venue;
	private User user;
	private String date;
	
	public Booking(int bookingID, Venue venue, User user, String date) {
		super();
		this.bookingID = bookingID;
		this.venue = venue;
		this.user = user;
		this.date = date;
	}
	

	public int getBookingID() {
		return bookingID;
	}


	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}


	public Venue getVenue() {
		return venue;
	}


	public void setVenue(Venue venue) {
		this.venue = venue;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", venue=" + venue + ", user=" + user + ", date=" + date + "]";
	}
	
	

}
