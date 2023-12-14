//Thomas Davis
//Date: 9/29/2023
//version 1.0
//Gringotts bank managing class
public class GWBManager {
	//account item
	private GWBAccount account;
	//transaction array
	private Transaction[] transactions;
	//counter var
	private int counter;
	//Parameterized constructor with starting balance 
	public GWBManager(int galleons, int sickles, int knuts) {
		//counter at 0
		counter=0;
		//initializes account
		account=new GWBAccount(galleons,sickles,knuts);
		//temporary var for amount in string for transaction
		String amount= galleons+" Galleons, "+sickles+" Sickles, "+knuts+" Knuts.";
		//set transaction array length
		transactions=new Transaction[10];
		//transactions array index 0 is new transaction item
		transactions[counter]=new Transaction("NEW",amount,amount);
		//counter increment
		counter++;
		System.out.println("Account created. Your balance is "+amount);
	}
	//method to deposit currency into account
	public void deposit(int galleons, int sickles, int knuts) {
		//if deposit successful
		if(account.deposit(galleons, sickles, knuts)==true) {
		//temporary var for amount in string for transaction
		String amount= galleons+" Galleons, "+sickles+" Sickles, "+knuts+" Knuts.";
		//temp var for current balance
		String currentBal= account.getGalleons()+" Galleons, "+account.getSickles()+" Sickles, "+account.getKnuts()+" Knuts.";
		transactions[counter]=new Transaction("DEPOSIT",amount,currentBal);
		System.out.println("Deposit Successful. Your new balance is "+currentBal);
		counter++;
		}
		//if didn't deposit
		else
		System.out.println("Deposit Failed. Invalid Currency Values");
	}
	//method to withdraw currency from account
	public void withdraw(int galleons, int sickles, int knuts) {
		//if withdraw successful
				if(account.withdraw(galleons, sickles, knuts)==true) {
				//temporary var for amount in string for transaction
				String amount= galleons+" Galleons, "+sickles+" Sickles, "+knuts+" Knuts.";
				//temp var for current balance
				String currentBal= account.getGalleons()+" Galleons, "+account.getSickles()+" Sickles, "+account.getKnuts()+" Knuts.";
				transactions[counter]=new Transaction("WITHDRAW",amount,currentBal);
				System.out.println("Withdraw Successful. Your new balance is "+currentBal);
				counter++;
				grow();
				}
				//if didn't withdraw
				else
				System.out.println("Withdraw Failed. Invalid Amount");
	}
	//method to display table of transactions
	public void viewTransactions(String category) {
		//if want all of it printed
		if (category=="ALL") {
			//header sections
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("ID          Type    Amount                                      Closing Balance                             Transaction Date");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			//iterates through all transaction array
			for(int i=0;i<counter;i++) {
				//prints each important items
				System.out.println("  "+transactions[i].getId()+"       "+transactions[i].getType()+"    "+transactions[i].getAmount()+"              "+transactions[i].getClosingBalance()+"           "+transactions[i].getTransactionDate());
			}
		}
		if (category=="WITHDRAW"||category=="DEPOSIT") {
			//header sections
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("ID          Type    Amount                                      Closing Balance                             Transaction Date");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			//iterates through all transaction array
			for(int i=0;i<counter;i++) {
				//if type matches category
				if(transactions[i].getType()==category) {
				//prints each important items
				System.out.println("  "+transactions[i].getId()+"       "+transactions[i].getType()+"    "+transactions[i].getAmount()+"              "+transactions[i].getClosingBalance()+"           "+transactions[i].getTransactionDate());
				}
			}
		}
	}
	
	//tostring method
	public String toString() {
		return ("Account Balance: "+account.getGalleons()+" Galleons, "+account.getSickles()+" Sickles, "+account.getKnuts()+" Knuts. # of Transactions: "+(counter));
	}
	//analytics method for grading
	public void viewAnalytics() {
		//Header
		System.out.println("-------System Analytics-------");
		//counter is for index so plus 1 for size
		System.out.println("Capacity: "+(counter+1));
		//counter 
		System.out.println("Count: "+counter);
		//array length
		System.out.println("Array Length: "+transactions.length);
		//Footer
		System.out.println("------------------------------");
	}
	//growing an array function
	private void grow() {
		//if max size
		if(transactions.length<=counter) {
			//temp array of double length
			Transaction[] temp=new Transaction[transactions.length*2];
			//iterate through all original and assign it to the temp array
			for (int i=0;i<counter;i++) {
				temp[i]=transactions[i];
			}
			//set the original array to point to the location of the new twice as big array
			transactions=temp;
		}
	}
}
