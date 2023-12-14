//Thomas Davis
//Date: 9/29/2023
//version 1.0
import java.util.Date;
//transaction method
public class Transaction {
	//id variable
	private int id;
	//transaction type
	private String type;
	//amount of currency
	private String amount;
	//ending balance
	private String closingBalance;
	//overall counter
	private static int ID_CTR=0;
	//date of transaction
	private Date transactionDate;
	
	//Parameterized constructor
	public Transaction(String type, String amount, String closingBalance) {
		//sets vars to passed in values
		this.type=type;
		this.amount=amount;
		this.closingBalance=closingBalance;
		//id = current id 
		id=ID_CTR;
		//add 1 to id counter
		ID_CTR++;
		//sets to current date and time
		transactionDate=new Date();
	}
	
	public String toString() {
		return ("ID: "+id+" | Type: "+type+" | Amount: "+amount+" | Closing Balance: "+closingBalance+" | Date"+transactionDate);
	}
	
	//all of the following are getter methods
	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getAmount() {
		return amount;
	}

	public String getClosingBalance() {
		return closingBalance;
	}

	public static int getID_CTR() {
		return ID_CTR;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}
}
