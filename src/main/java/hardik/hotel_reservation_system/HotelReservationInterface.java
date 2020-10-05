package hardik.hotel_reservation_system;

public interface HotelReservationInterface {

	public Hotel getHotelDetails();

	public void addHotelToList(Hotel hotel, HotelList hotelList);

	public void displayHotels(HotelList hotelList);
}
