package hardik.hotel_reservation_system;

public class Hotel {

	private String hotelName;
	private int weekDayRatesRegular;
	private int weekendRatesRegular;
	private int weekDayRatesReward;
	private int weekendRatesReward;
	private int rating;

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekDayRatesRegular() {
		return weekDayRatesRegular;
	}

	public void setWeekDayRatesRegular(int weekDayRatesRegular) {
		this.weekDayRatesRegular = weekDayRatesRegular;
	}

	public int getWeekendRatesRegular() {
		return weekendRatesRegular;
	}

	public void setWeekendRatesRegular(int weekendRatesRegular) {
		this.weekendRatesRegular = weekendRatesRegular;
	}

	public int getWeekDayRatesReward() {
		return weekDayRatesReward;
	}

	public void setWeekDayRatesReward(int weekDayRatesReward) {
		this.weekDayRatesReward = weekDayRatesReward;
	}

	public int getWeekendRatesReward() {
		return weekendRatesReward;
	}

	public void setWeekendRatesReward(int weekendRatesReward) {
		this.weekendRatesReward = weekendRatesReward;
	}

	@Override
	public String toString() {
		return "Hotel " + this.getHotelName() + " Regular Weekend rates " + this.getWeekendRatesRegular()
				+ " Reawards Weekend Rates : " + this.getWeekendRatesReward() + " Regular Weekdays Rates "
				+ this.getWeekDayRatesRegular() + " Rewards WeekDay Rates" + this.getWeekDayRatesReward() + " Rating "
				+ this.getRating();
	}

}
