package Main;

import java.util.List;
import java.util.Scanner;

import Exceptions.AlreadyBookedException;
import Factory.VenueFactory;
import Manager.BookingManager;
import Model.User;
import Model.Venue;
import Exceptions.AlreadyBookedException;
import Exceptions.VenueNotFoundException;

public class Application {
   // private static final int  = 0;
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
        VenueFactory vf = new VenueFactory();
        BookingManager bm = BookingManager.getInstance();
        
       
        
        User user = new User(101, "Tahasim", "tahu@gmail.com");
        User user1=new User(102,"Sabiha","sabi@gmail.com");

        
        Venue ven = vf.createVenue("FunctionHall", 101, "Grand Palace", "Hyderabad", 50000, 500);
        Venue ven1 = vf.createVenue("WorkSpace", 102, "Co-WorkHub", "Bangalore", 500, 20);
        Venue ven2 = vf.createVenue("ToLet", 103, "Tech-Park Office", "Chennai", 100000, 50);

        
        bm.addVenue(ven);
        bm.addVenue(ven1);
        bm.addVenue(ven2);

        
        try {
            bm.addBooking(user, ven, "15-09-2025");
        } catch (AlreadyBookedException | VenueNotFoundException e) {
            //System.out.println(e.getMessage());
        }

        try {
            bm.addBooking(user, ven1, "15-09-2025");
        } catch (AlreadyBookedException | VenueNotFoundException e) {
            //System.out.println(e.getMessage());
        }

        try {
            bm.addBooking(user, ven2, "15-09-2025");
        } catch (AlreadyBookedException | VenueNotFoundException e) {
            //System.out.println(e.getMessage());
        }
        
        try {
            bm.addBooking(user, ven2, "15-09-2025");
        } catch (AlreadyBookedException | VenueNotFoundException e) {
            //System.out.println(e.getMessage());
        }
        
        try {
            bm.addBooking(user1, ven, "25-09-2025");
        } catch (AlreadyBookedException | VenueNotFoundException e) {
            //System.out.println(e.getMessage());
        }

        try {
            bm.addBooking(user1, ven1, "25-09-2025");
        } catch (AlreadyBookedException | VenueNotFoundException e) {
            //System.out.println(e.getMessage());
        }

        try {
            bm.addBooking(user1, ven2, "25-09-2025");
        } catch (AlreadyBookedException | VenueNotFoundException e) {
            //System.out.println(e.getMessage());
        }
        int a;
        
       while(true) { 
        System.out.println("Enter your choice");
        a=sc.nextInt();
        
        
        switch(a) {
        
        case 1:
        	System.out.println("Enter city name:");
        	String city=sc.next();
        	
        switch( city)
        {
        	case "Hyderabad":
        System.out.println("[INFO] Venues in Hyderabad:");
        List<Venue> searchResults = user.search("Hyderabad");
        for (Venue v : searchResults) {
            System.out.println("   " + v);
        }
        break;
        	case "Bangalore":
        System.out.println("[INFO] Venues in Bangalore:");
       List<Venue> searchResults1 = user.search("Bangalore");
       for (Venue v : searchResults1) {
           System.out.println("   " + v);
       }
       break;
        	case "Chennai":
       System.out.println("[INFO] Venues in Chennai:");
       List<Venue> searchResults2 = user.search("Chennai");
        for (Venue v : searchResults2) {
           System.out.println("   " + v);
       }
        break;
        default:
        	System.out.println("No cities found");
        	
        }
       
        break;
        case 2:
        
            System.out.println("Enter Venue ID:");
            int vid = sc.nextInt();
            List<Venue> venuesById = user.search(vid);
            if (venuesById.isEmpty()) {
                System.out.println("[ERROR] No venue found with ID " + vid);
            } else {
                System.out.println("[INFO] Venue found:");
                for (Venue v : venuesById) {
                    System.out.println("   " + v);
                }
            }
            break;

        	
        	
        	
        	case 3:
        		int cancelid;
        		System.out.println("Enter ID for cancelling booking:");
        		cancelid=sc.nextInt();
        		bm.cancelBooking(cancelid);
        		
        		
        		break;
        	case 4:
        		bm.saveToFile();
        		break;
        	case 5:
        		bm.loadFromFile();
        		break;
        	case 6:
        		System.out.println("Than you for use smart booking system");
        		return;
        	default:
        		System.out.println("Can't find ID");
        		
        }
        
        
        
       }
        
        //bm.cancelBooking(101); 
       //bm.loadFromFile();    
    
	}
}
