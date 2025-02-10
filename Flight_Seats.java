//imports
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileReader;


public class Flight_Seats {

	//ArrayList
	public static ArrayList<Seats> displayAllSeats = new ArrayList<>();
	
	
	public static void main(String[] args)throws IOException {
		
		
		Flight_Seats classObject = new Flight_Seats();
		
		String filename;
		FileReader Room_File_Reading= new FileReader("seats.txt");
		
		Scanner file_Read = new Scanner(Room_File_Reading);
		

		//whileLOOP
		while (file_Read.hasNextInt()) {
			int SeatNum = file_Read.nextInt();
			String SeatClass = file_Read.next();
			Boolean IsWindow = file_Read.hasNext();
			Boolean IsAisle = file_Read.hasNext();
			Boolean IsTable = file_Read.hasNext();
			double SeatPrice = file_Read.nextDouble();
			String EMail = file_Read.next();
			
			Seats Seats_ToAdd = new Seats(SeatNum,  SeatClass,  IsWindow,  IsAisle, IsTable,  SeatPrice,  EMail);
		displayAllSeats.add(Seats_ToAdd);
		
		}
	
		classObject.menu_For_Client();
	}
		
	private void menu_For_Client() throws IOException {

		Scanner Scanned = new Scanner(System.in);
		
		 System.out.println("- - Seat Booking System - -");
	        System.out.println("");
	        System.out.println("");
	        System.out.println("- - MAIN MENU - -");
	        System.out.println("1 - Reserve Seat");
	        System.out.println("2 - Cancel Seat");
	        System.out.println("3 - View Seat Reservations.");
	        System.out.println("Q - Quit");
         System.out.println("Pick :");
         
         String Client_Input_Menu = Scanned.next();
		   /* Switch used to changed between methods based on the input from menu input scanner.
         * before exiting it will call the SaveSeats method to save updated data to file*/
        switch (Client_Input_Menu) {
            case "1":
            	client_Seat_Reservation();
                break;
            case "2":
            	 Cancel_Seat();
                break;
            case "3":
            	viewClientSeatReservation();
                break;
            case "Q":
            	System.out.println("Hope to see you soon");
            	Saved_Seats();
                System.exit(0);
                break;
            default:
                System.out.println("\nError please try again and enter only the number for one of the options!\n");
                menu_For_Client();
                break;
        }
	}


	    private void  client_Seat_Reservation() throws IOException {

	        int P;
	        int Q;
	        int R;


	        Scanner Scan = new Scanner(System.in);

	        System.out.println("--Please select a seat Type from the options-- \n1-First class\n2-Standard class");

	        String ReserveIntput = Scan.next();

	        //switch takes the user input and prints the seats that match their choice, unless the seats are booked then they wont print.
	        switch (ReserveIntput) {
	            case "1":
	                System.out.println("--Here is  the list of our available seats-- \n");

	                //for loop to iterate each line in the appendix A file
	                for (P= 0; P < 18; P++) {
	                    //finds the lines that contain the word single and don't contain an @ because if they have an @ they are booked
	                    if (displayAllSeats.get(P).takeSeatClass().equalsIgnoreCase("First Class") && !displayAllSeats.get(P).takeEmail().contains("@")) {

	                        System.out.println("Seat Number:" + (displayAllSeats.get(P).takeSeatNum() + ", Seat class:"
	                                + (displayAllSeats.get(P).takeSeatClass()     + ", Seat has Window:" + (displayAllSeats.get(P).ConfirmWindow() + ", Has Lounge:" + (displayAllSeats.get(P).ConfirmTable() + ", Seat Price:" + (displayAllSeats.get(P).takePrice()))))));
	                    }
	                }

	                // after the user gets a list of the type of seat they wanted it asks them to enter the number of that seat.
	                System.out.println("\n--Please enter seat number you would like to book--");
	                int no_Of_Input1 = Scan.nextInt();

	                // after they choose the room number they enter their email address.
	                System.out.println("\nPlease Enter your email address to complete booking");
	                String Client_Email_1 = Scan.next();

	                /* set's the email from "free" to the users email to show the room is booked.
	                 * for the room number they chose. the for loop indexes each line same as above to find
	                 * the room number*/
	                for (P = 0; P < 18; P++) {
	                    if (displayAllSeats.get(P).takeSeatNum() == no_Of_Input1) {

	                    	displayAllSeats.get(P).askForEmail(Client_Email_1);

	                    }

	                }

	                Saved_Seats();

	                break;
	            case "2":
	                //each case works the same way as explained in case 1 comments.
	                System.out.println("--Here is  the list of our available Double rooms-- \n");

					//iteration
	                for (	Q = 0; Q < 18; Q++) {
	                    if (displayAllSeats.get(Q).takeSeatClass().equalsIgnoreCase("Standard Class") && !displayAllSeats.get(Q).takeEmail().contains("@")) {

	                        

	                        System.out.println("Seat Number:" + (displayAllSeats.get(Q).takeSeatNum() + ", Seat class:"
	                                + (displayAllSeats.get(Q).takeSeatClass()     + ", Seat has Window:" + (displayAllSeats.get(Q).ConfirmWindow() + ", Has Lounge:" + (displayAllSeats.get(Q).ConfirmTable() + ", Seat Price:" + (displayAllSeats.get(Q).takePrice()))))));
	                        
	                        
	                    }
	                }

	                System.out.println("\n--Please enter seat number you would like to book--");
	                int no_Of_Input2 = Scan.nextInt();

	                System.out.println("\nPlease Enter your email address to complete booking");
	                String Client_Email_2 = Scan.next();

					//iteration
	                for (Q = 0; Q < 17; Q++) {
	                    if (displayAllSeats.get(Q).takeSeatNum() == no_Of_Input2) {

	                    	displayAllSeats.get(Q).askForEmail(Client_Email_2);

	                    }

	                }

	                Saved_Seats();

	                break;

	            case "3":
	                System.out.println("--Here is  the list of our available  seats-- \n");

	                for (R = 0; R < 17; R++) {
	                    if (displayAllSeats.get(R).takeSeatClass().equalsIgnoreCase("Seats") && !displayAllSeats.get(R).takeEmail().contains("@")) {

	                    	 System.out.println("Seat Number:" + (displayAllSeats.get(R).takeSeatNum() + ", Seat class:"
		                                + (displayAllSeats.get(R).takeSeatClass()     + ", Seat has Window:" + (displayAllSeats.get(R).ConfirmWindow() + ", Has Lounge:" + (displayAllSeats.get(R).ConfirmTable() + ", Seat Price:" + (displayAllSeats.get(R).takePrice()))))));
		                        
	                    }
	                }

	                System.out.println("\n--Please enter seat number you would like to book--");
	                int no_Of_Input3    = Scan.nextInt();

	                System.out.println("\nPlease Enter your email address to complete booking");
	                String UserEmail3 = Scan.next();

	                for (Q = 0; Q < 17; Q++) {
	                    if (displayAllSeats.get(Q).takeSeatNum() == no_Of_Input3) {

	                    	displayAllSeats.get(Q).askForEmail(UserEmail3);

	                    }

	                }

	                Saved_Seats();

	                break;

	            // default to start user main menu again if no matches are found.
	            default:
	                System.out.println("\nSorry you either entered the number wrong or no available rooms found." +
	                        "\nplease try again. only enter the number of your option or try a different seat Type.\n");
	                menu_For_Client();
	                break;
	        }

	        //confirms seat booking to the user
	        System.out.println("\nThanks your seat is now booked\n");

	        //call the User menu method to give recurring options menu
	        menu_For_Client();

	    }
        
	    
	    private void Cancel_Seat () throws IOException {

	        boolean cancelled = false;

	        Scanner Scanned = new Scanner(System.in);

	        System.out.println("\n--To cancel Please enter the seat number you booked--");

	        int No_Cancellation = Scanned.nextInt();

	        System.out.println("\n--Now please enter the email address you booked with--");

	        /* user can enter the email address they booked with and the system will look for their email
	         * so it can cancel their booking*/
	        String Input_Cancellation = Scanned.next();

	        /* if anything matches the users input of their email address then it will remove there email
	        address and replace it with free */
	        for (int v= 0; v < 18; v++) {
	            if (displayAllSeats.get(v).takeEmail().equalsIgnoreCase(Input_Cancellation) && displayAllSeats.get(v).takeSeatNum() == No_Cancellation) {

	            	displayAllSeats.get(v).askForEmail("Free");

	                //confirms the seat is cancelled
	                System.out.println("\nThanks. Your Seat has now been canceled");

	                cancelled = true;

	                //if the users input doesn't match anything it will give the error below and the user can try again
	            }

	        }

	        if (!cancelled) {
	            System.out.println("\nSorry we couldn't find your booking please try again and make sure you have entered the correct details.");
	        }

	        
	        Saved_Seats();
	        menu_For_Client();

	    }
        
	    private void viewClientSeatReservation() throws IOException {

	        FileReader Room_File_Reading = new FileReader("seats.txt");

	        Scanner file_Read = new Scanner(Room_File_Reading);

	        System.out.println("\n-- Seat Reservation Info -- ");

	        //while loop reads appendix A file and prints each line to show all the info in the file
	        while (file_Read.hasNextInt()) {

	        	int SeatNum = file_Read.nextInt();
				String SeatClass = file_Read.next();
				Boolean IsWindow = file_Read.hasNext();
				Boolean IsAisle = file_Read.hasNext();
				Boolean IsTable = file_Read.hasNext();
				double SeatPrice = file_Read.nextDouble();
				String EMail = file_Read.next();
				
				
				Seats Seats_ToAdd = new Seats(SeatNum,  SeatClass,  IsWindow,  IsAisle, IsTable,  SeatPrice,  EMail);


	            displayAllSeats.add(Seats_ToAdd);

	          /* if Statement so the system prints out "booked" if the seat is booked as booked rooms would contain
	           an email address and therefore contain a @ symbol  */
	            if (EMail.contains("@"))
	                EMail = "Booked";


	            System.out.println("Seat number " + SeatNum + ", Class:" + SeatClass + ", Has Window:" + IsWindow + " ,Has Table:" + IsTable + " is " + EMail);

	        }

	        //recurring option menu
	        menu_For_Client();

	    }
	    
	    private void Saved_Seats() throws IOException {

		       
	        PrintWriter FileWrite = new PrintWriter("seats.txt");
	       //file writer to write the data in the array to the appendix A file
	        
	        for (int Z = 0; Z < 18; Z++) {
	        	// The Shown above for loop so that it index each line of the file of rooms
	           
	            FileWrite.println(displayAllSeats.get(Z).takeSeatNum() + " " + displayAllSeats.get(Z).takeSeatClass()
	                    +   " " + displayAllSeats.get(Z).ConfirmWindow() +
	                    " " + displayAllSeats.get(Z).ConfirmTable() + " " + displayAllSeats.get(Z).takePrice()+ " " + displayAllSeats.get(Z).takeEmail() );
	            //above writes data from array to each line of the file of rooms.01111
	        }

	       
	        FileWrite.close();
	    }
	    
	    
	    
	    
	    
    }
		

	


