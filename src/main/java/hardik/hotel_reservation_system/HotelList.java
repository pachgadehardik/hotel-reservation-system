package hardik.hotel_reservation_system;

import java.util.List;

public class HotelList {

	private List<Hotel> hotelsList;

	public List<Hotel> getHotelsList() {
		return hotelsList;
	}

	public void setHotelsList(List<Hotel> hotelsList) {
		this.hotelsList = hotelsList;
	}

	@Override
	public String toString() {
		return hotelsList.toString();
	}

}
