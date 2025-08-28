package Model;

public class ToLet extends Venue{

	public ToLet(int id, String name, String location, double price, int capacity) {
		super(id, name, location, price, capacity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void book(String date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelBooking(String date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	double calculateFinalPrice() {   //per month
		// TODO Auto-generated method stub
		return super.getPrice();
	}

}
