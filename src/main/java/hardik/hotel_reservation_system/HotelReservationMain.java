package hardik.hotel_reservation_system;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class HotelReservationMain {

	public static void displayMenu() {
		System.out.println("1-Add Hotel");
		System.out.println("2-Find Cheapest and Best Rated Hotel");
		System.out.println("3-Find Best Rated by given Date");
		System.out.println("4-Find Cheapest and Best Rated Hotel (Reward Customers): ");
		System.out.println("0-Exit");
	}

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation System!!");

		boolean flag = true;

		HotelList hotelList = new HotelList();
		hotelList.setHotelsList(new ArrayList<Hotel>());

		HotelReservationFunction hotelReservationFunction = new HotelReservationFunction();
		while (flag) {
			displayMenu();
			int option = sc.nextInt();
			switch (option) {
			case 1:
				// Adding Hotel in the Reservation System with ratings and day wised prices
				Hotel hotel = hotelReservationFunction.getHotelDetails();
				hotelReservationFunction.addHotelToList(hotel, hotelList);
				break;
			case 2:
				// Finding Cheapest Hotel based on Weekend and Weekdays Rates along with Rating along with Reward Customer
				System.out.println("Enter the dates:-");
				String from_Date = sc.next();
				String to_Date = sc.next();
				hotelReservationFunction.getCheapestHotel(hotelList, from_Date, to_Date);
				break;
			case 3:
				System.out.println("Enter the dates:-");
				String from_Date1 = sc.next();
				String to_Date1 = sc.next();
				hotelReservationFunction.getBestRatedHotel(hotelList,from_Date1,to_Date1);
				break;
			default:
				flag = false;
				break;
			}
			
			System.out.println("Available Hotels:");
			hotelReservationFunction.displayHotels(hotelList);
		}

	}
}
