package roomDao;

import pojo.Guest;
import pojo.Room;

public interface RoomDao {
	 boolean addRoom(Room room);
	 Room SearchRoom(int roomNumber);

	    Room[] getAllRooms();
	    boolean checkIn(int roomNumber,Guest guest);
	    boolean checkOutGuest(int roomNumber, Guest guest);
	    Guest searchCustomerByName(String name);
	    String getGuestSummaryReport(); 
}
