package hardik.hotel_reservation_system;

import java.util.List;
import java.util.Scanner;

public class HotelReservationFunction implements HotelReservationInterface {

	Scanner sc = new Scanner(System.in);

	public Hotel getHotelDetails() {
		Hotel hotel = new Hotel();
		System.out.println("Enter the Hotel Name: ");
		hotel.setHotelName(sc.next());
		System.out.println("Enter the Regular WeekDay Rate: ");
		hotel.setWeekDayRatesRegular(sc.nextInt());
		System.out.println("Enter the Regular WeekEnd Rate: ");
		hotel.setWeekendRatesRegular(sc.nextInt());
		System.out.println("Enter the Reward Weekday Rate: ");
		hotel.setWeekDayRatesReward(sc.nextInt());
		System.out.println("Enter the Reward WeekEnd Rate :");
		hotel.setWeekendRatesReward(sc.nextInt());
		System.out.println("Enter the Rating: ");
		hotel.setRating(sc.nextInt());
		return hotel;
	}

	public void addHotelToList(Hotel hotel, HotelList hotelList) {
		List<Hotel> hotelL = hotelList.getHotelsList();
		hotelL.add(hotel);
		hotelList.setHotelsList(hotelL);
	}

	public void displayHotels(HotelList hotelList) {
		System.out.println(hotelList.getHotelsList());
	}
}
