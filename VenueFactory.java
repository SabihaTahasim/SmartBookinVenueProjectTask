package Factory;
import Model.FunctionHall;
import Model.ToLet;
import Model.Venue;
import Model.Workspace;
import Exceptions.VenueNotFoundException;

public class VenueFactory {
	public Venue createVenue(String type,int id ,String name,String location,double price,int capacity) {
		if (type.equalsIgnoreCase("FunctionHall")) {
            return new FunctionHall(id, name, location, price, capacity); 
        } else if (type.equalsIgnoreCase("Workspace")) {
            return new Workspace(id,name,location,price,capacity);
        } else if (type.equalsIgnoreCase("ToLet")) {
            return new ToLet(id,name,location,price,capacity);
        } else {
            throw new VenueNotFoundException("Unknown venue type: " + type);
        }
	}
	

}
