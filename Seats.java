
public class Seats {
	
	int SeatNum;
	String SeatClass;
	Boolean IsWindow;
	Boolean IsAisle;
	Boolean IsTable;
	double SeatPrice;
	String EMail;
	
	Seats(int seatNum, String seatClass, Boolean isWindow, Boolean isAisle, Boolean isTable, double seatPrice, String eMail){
		 SeatNum = seatNum;
		SeatClass = seatClass;
		IsWindow = isWindow;
		IsAisle = isAisle;
	     IsTable = isTable;
		SeatPrice = seatPrice;
		EMail = eMail;
	}

	public int takeSeatNum() {
		return SeatNum;
	}
	public String takeSeatClass() {
		return SeatClass;
	}
	public Boolean ConfirmWindow() {
		return IsWindow;
	}
	public Boolean ConfirmTable() {
		return IsTable;
	}
	public double takePrice() {
		return SeatPrice;
	}
	public String takeEmail() {
		return EMail;
	}
	public void askForEmail(String eMail) {
		EMail = eMail;
	}

}
