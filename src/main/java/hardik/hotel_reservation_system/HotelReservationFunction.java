package hardik.hotel_reservation_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

	public long totalDays(String from_date, String to_date) {
		SimpleDateFormat myFormat = new SimpleDateFormat("ddMMyyyy");

		try {
			Date dateBefore = myFormat.parse(from_date);
			Date dateAfter = myFormat.parse(to_date);
			long difference = dateAfter.getTime() - dateBefore.getTime();
			long daysBetween = (difference / (1000 * 60 * 60 * 24));
			return daysBetween;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public void getCheapestHotel(HotelList hotelList, String from_Date, String to_Date) {
		long no_of_days = totalDays(from_Date, to_Date);

		Optional<Hotel> hotel = hotelList.getHotelsList().stream()
				.min(Comparator.comparing(Hotel::getWeekDayRatesRegular));
		if (hotel.isPresent()) {
			System.out.println("Hotel :" + hotel.get().getHotelName() + " TotalExpense: "
					+ (hotel.get().getWeekDayRatesRegular() * no_of_days) + " ");
		} else {
			System.out.println("No Hotels Present in the System");
		}
	}
}
