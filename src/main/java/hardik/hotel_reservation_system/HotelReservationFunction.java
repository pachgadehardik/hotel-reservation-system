package hardik.hotel_reservation_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HotelReservationFunction implements HotelReservationInterface {

	Scanner sc = new Scanner(System.in);

	public Hotel getHotelDetails() {
		Hotel hotel = new Hotel();
		// Already Entering the Weekend And WeekDays Prices for both Reward as well as
		// Regular Users
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

	public long getTotalWeekDays(String from_date, String to_date) throws ParseException {
		SimpleDateFormat myFormat = new SimpleDateFormat("ddMMyyyy");
		Date dateBefore = myFormat.parse(from_date);
		Date dateAfter = myFormat.parse(to_date);

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(dateBefore);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(dateAfter);
		int workdays = 0;
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(dateAfter);
			endCal.setTime(dateBefore);
		}

		do {
			// excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workdays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date

		return workdays;
	}

	//Calucalating Best Hotel by Rating for Both Rewarded and Regular Customer
	public void getCheapestHotel(HotelList hotelList, String from_Date, String to_Date) throws ParseException {
		long no_of_days = totalDays(from_Date, to_Date);
		long total_weekDays = getTotalWeekDays(from_Date, to_Date);
		long weekend_Days = no_of_days - total_weekDays;
		System.out.println("1-Regular 2-Rewarded");
		int op = sc.nextInt();
		switch(op) {
			case 1:
				Map<Hotel, Long> priceMap = new HashMap<Hotel, Long>();
				for (int i = 0; i < hotelList.getHotelsList().size(); i++) {
					long cost = hotelList.getHotelsList().get(i).getWeekDayRatesRegular() * total_weekDays
							+ hotelList.getHotelsList().get(i).getWeekendRatesRegular();
					hotelList.getHotelsList().get(i).setTotalPrice(cost);
					priceMap.put(hotelList.getHotelsList().get(i), cost);
				}
				Entry<Hotel, Long> min = Collections.min(priceMap.entrySet(), Comparator.comparingLong(Entry::getValue));

				List<Hotel> cheapHotels = priceMap.keySet().stream().filter(m -> m.getTotalPrice() == min.getValue())
						.collect(Collectors.toList());

				int rating = cheapHotels.stream().max(Comparator.comparing(Hotel::getRating)).get().getRating();

				System.out.println("Best Rated Cheapest Hotel is:");
				System.out.println(cheapHotels.stream().filter(m -> m.getRating() == rating).collect(Collectors.toList()));
				break;
			case 2:
				Map<Hotel, Long> priceMap1 = new HashMap<Hotel, Long>();
				for (int i = 0; i < hotelList.getHotelsList().size(); i++) {
					long cost = hotelList.getHotelsList().get(i).getWeekDayRatesReward() * total_weekDays
							+ hotelList.getHotelsList().get(i).getWeekendRatesReward();
					hotelList.getHotelsList().get(i).setTotalPrice(cost);
					priceMap1.put(hotelList.getHotelsList().get(i), cost);
				}
				
				int bestRating = hotelList.getHotelsList().stream().max(Comparator.comparing(Hotel::getRating)).get().getRating();
				System.out.println(priceMap1.keySet().stream().filter(m -> m.getRating() == bestRating).collect(Collectors.toList()));
				break;
			default:
				break;
		}
		

	}

	public void getBestRatedHotel(HotelList hotelList, String from_Date1, String to_Date1) throws ParseException {
		long no_of_days = totalDays(from_Date1, to_Date1);
		long total_weekDays = getTotalWeekDays(from_Date1, to_Date1);
		long weekend_Days = no_of_days - total_weekDays;
		System.out.println("Overall Best Rated Hotel is :");
		int bestRating = hotelList.getHotelsList().stream().max(Comparator.comparing(Hotel::getRating)).get().getRating();
		System.out.println(hotelList.getHotelsList().stream().filter(m -> m.getRating() == bestRating).collect(Collectors.toList()));
		
	}
}
