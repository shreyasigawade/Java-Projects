package daoImpl;

import pojo.Guest;
import pojo.Room;
import roomDao.RoomDao;

public class RoomdaoImpl implements RoomDao{
	Room roomArray[]=new Room[10];
	int index=0;
	@Override
	public boolean addRoom(Room room) {
		if(index<roomArray.length) {
			roomArray[index++]=room;
			return true;//Room added successfully
		}
		return false; //Room array is full, cannot add more rooms
	
		
	}

	@Override
	public Room SearchRoom(int roomNumber) {
		Room room=null;
		for(int i=0;i<index;i++) {
			if(roomArray[i]!=null && roomArray[i].getRoomNumber()==roomNumber) {
				  // Found the room with the specified roomNumber, return it
				room=roomArray[i];
				break;
			}
		}
		// If no room with the specified roomNumber is found, return null or handle the case as needed
		return room;
		
	}

	@Override
	public Room[] getAllRooms() {
		Room[] allRooms = new Room[index]; // Create an array to hold all the rooms

	    // Copy the rooms from roomArray to allRooms
	    for (int i = 0; i < index; i++) {
	        allRooms[i] = roomArray[i];
	    }

	    return allRooms;
	

		
	}


	@Override
	public boolean checkOutGuest(int roomNumber, Guest guest) {
		// TODO Auto-generated method stub
		Room room = SearchRoom(roomNumber);
	    
	    if (room != null && room.isOccupied() && room.getGuest().equals(guest)) {
	        room.checkOut();
	        return true; // Check-out successful
	    }
	    
	    return false;
		
	}

	@Override
	public Guest searchCustomerByName(String name) {
		for (int i = 0; i < index; i++) {
	        Room room = roomArray[i];
	        if (room != null && room.isOccupied() && room.getGuest() != null && room.getGuest().getName().equalsIgnoreCase(name)) {
	            return room.getGuest();
	        }
	    }
	    return null; //
	}

	@Override
	public String getGuestSummaryReport() {
		StringBuilder report = new StringBuilder();

		for (Room room : roomArray) {
		    if (room != null && room.isOccupied() && room.getGuest() != null) {
		        report.append("Room Number: ").append(room.getRoomNumber()).append("\n")
		              .append("Guest Name: ").append(room.getGuest().getName()).append("\n")
		              .append("\n"); // Add a separator
		    }
		}

		if (report.length() == 0) {
		    report.append("No guests have checked in.");
		}

		return report.toString();
		
	}

	public int getIndex() {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public boolean checkIn(int roomNumber, Guest guest) {
		 Room room = SearchRoom(roomNumber);
		    
		    if (room != null && !room.isOccupied()) {
		        room.checkIn(guest);
		        return true; // Check-in successful
		    }
		
		return false;
	}

}
