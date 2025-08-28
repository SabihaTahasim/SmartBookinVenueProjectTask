package Model;

public class FunctionHall extends Venue {

	

	public FunctionHall(int id, String name, String location, double price, int capacity) {
		super(id, name, location, price, capacity);
		// TODO Auto-generated constructor stub
	}



	@Override
	double calculateFinalPrice() { //seasonal
		// TODO Auto-generated method stub
		return super.getPrice();
	}

	

	@Override
	public void cancelBooking(String date) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void book(String date) {
		// TODO Auto-generated method stub
		
	}
	

}
