package test;

import java.util.Scanner;

import daoImpl.RoomdaoImpl;
import pojo.Guest;
import pojo.Room;



public class HotelManagementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int roomNumber;
		  String roomType;
		    double price;
		    int capacity;
		    boolean isOccupied;
		    int choice;
		    String  name;
		    double contactNo;
		    
		    int index=0;
			  Scanner sc =new Scanner(System.in);
			 Room room;
			  RoomdaoImpl impl =new  RoomdaoImpl();
			  do {
				  System.out.println("1. Manage Rooms \n2.Get available Rooms  \n3.Search room by room number \n4.Check in   \n5.Check out room "
				  		+ " \n6.Search by customer name \n7.Get Guest summary report");
				  System.out.println("Enter your choice: ");
					choice=Integer.parseInt(sc.nextLine());
					switch(choice) {
					case 1:
						 System.out.print("Enter Room Number: ");
						 roomNumber= Integer.parseInt(sc.nextLine());
						 
						 System.out.print("Enter Room Type: ");
						 roomType=sc.nextLine();
						 
						 System.out.print("Enter RooM price: ");
						 price=Double.parseDouble(sc.nextLine());
						 
						 System.out.print("Enter Room capacity: ");
		                 capacity = Integer.parseInt(sc.nextLine());
						
						 System.out.print("Is the Room occupied? (true/false): ");
		                 isOccupied = Boolean.parseBoolean(sc.nextLine());
		                  
		                 room = new Room(roomNumber, roomType, price, capacity, isOccupied);
		                 boolean roomAdded = impl.addRoom(room);

		                 if (roomAdded) {
		                        System.out.println("Room added successfully.");
		                    } else {
		                        System.out.println("Failed to add room. The room list is full.");
		                    }
		                 System.out.println("***********************************************************");
		                    break;
		                   
						
					case 2:
						System.out.println("Here are room lists given below");
						Room[] roomlist=impl.getAllRooms();
						for(int i=0;i<impl.getIndex();i++) {
							System.out.println(roomlist[i]);
						}
						 System.out.println("***********************************************************");
						 break;
						
					case 3:
						 System.out.print("Enter Room Number to search: ");
		                   roomNumber = Integer.parseInt(sc.nextLine());
		                    Room searchedRoom = impl.SearchRoom(roomNumber);
		                    if (searchedRoom == null) {
		                        System.out.println("No room found with the specified room number.");
		                    } else {
		                        System.out.println("Details of room found:\n" + searchedRoom);
		                    }
		                    System.out.println("***********************************************************");  
					    break;
					case 4:
						 System.out.print("Enter Room Number to check-in: ");
						     roomNumber = Integer.parseInt(sc.nextLine());

						    System.out.print("Enter Guest Name: ");
						    name = sc.nextLine();
						    
						    System.out.print("Enter Guest contactNo: ");
						    contactNo=Double.parseDouble(sc.nextLine());
						    
						    Guest newGuest = new Guest(name,contactNo );
						    boolean checkedIn = impl.checkIn(roomNumber, newGuest);
						    if (checkedIn) {
						        System.out.println("Checked-in successfully.");
						    } else {
						        System.out.println("Failed to check-in. Room not found or already occupied.");
						    }
						    System.out.println("***********************************************************");
						    break;

					case 5:
						 System.out.print("Enter Room Number to check-out: ");
						 roomNumber = Integer.parseInt(sc.nextLine());
						 Room roomToCheckOut = impl.SearchRoom(roomNumber);


						 if (roomToCheckOut != null && roomToCheckOut.isOccupied()) {
						        System.out.println("Room found: " + roomToCheckOut);
						        System.out.print("Do you really want to check out room? (y/n): ");
						        char c = sc.nextLine().charAt(0);

						        if (c == 'y' || c == 'Y') {
						            Guest guestToCheckOut = roomToCheckOut.getGuest();
						            boolean checkedOut = impl.checkOutGuest(roomNumber, guestToCheckOut);

						            if (checkedOut) {
						                System.out.println("Checked-out successfully.");
						            } else {
						                System.out.println("Failed to check-out. Room not found or not occupied.");
						            }
						        } else {
						            System.out.println("Check-out canceled.");
						        }
						    } else {
						        System.out.println("Failed to check-out. Room not found or not occupied.");
						    }
						 System.out.println("***********************************************************");
						
						break;
					case 6:
						 System.out.print("Enter the name of the customer to search: ");
						    String customerName = sc.nextLine();

						    Guest searchedCustomer = impl.searchCustomerByName(customerName);

						    if (searchedCustomer != null) {
						        System.out.println("Customer found: " + searchedCustomer.getName()+","+searchedCustomer.getContactNo());
						      
						    } else {
						        System.out.println("Customer not found.");
						    }
						    System.out.println("***********************************************************");
						    break;
					case 7:
						String guestReport = impl.getGuestSummaryReport();
					    System.out.println("Guest Summary Report:\n" + guestReport);
					    System.out.println("***********************************************************");
					    break;
					case 8:
						 System.out.println("Exit!!");
					}
					}while(choice!=6);
					  sc.close();

			

			  
	}

}
