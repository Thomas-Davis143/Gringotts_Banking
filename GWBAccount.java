//Thomas Davis
//Date: 9/29/2023
//version 1.0

//Account at Gringotts Bank
public class GWBAccount {
	//integer for amount of different currency values
	private int galleons;
	private int sickles;
	private int knuts;
	
	//parameterized constructor to input starting values
	public GWBAccount(int galleons, int sickles, int knuts) {
		//sets values
		this.galleons=galleons;
		this.sickles=sickles;
		this.knuts=knuts;
	}
	//to string method to return a value to easily print
	public String toString() {
		return (galleons+" Galleons, "+ sickles+" Sickles, "+ knuts+ " Knuts");
	}
	//method to deposit money
	public boolean deposit(int galleons, int sickles, int knuts) {
		//if any value is negative return false and do nothing bc can't deposit negative value
		if(galleons<0||sickles<0||knuts<0)
			return false;
		//if all values are non-negative
		else {
			//add the deposited amount
			this.galleons+=galleons;
			this.knuts+=knuts;
			this.sickles+=sickles;
			//call conversion method
			convert();
			return true;
		}
	}
	//method to withdraw amounts
	public boolean withdraw(int galleons, int sickles, int knuts) {
		sickles+=galleons*17;
		knuts+=sickles*29;
		
		//if any value is negative return false and do nothing bc can't withdraw negative value
				if(knuts<0)
					return false;
				//if insufficient funds return false
				if((this.knuts+(this.sickles*29)+(this.galleons*46))<=knuts)
					return false;
				//if all values are non-negative
				else {
					//call method to make this objects all into knuts
					convertKnuts();
					this.knuts-=knuts;
					//convert back
					convert();
					return true;
				}
	}
	
	//converting the currency types (29 knuts = 1 sickle and 17 sickles = 1 galleon)
	private void convert() {
		//convert them to the higher currency type if enough are in the account
		if(this.knuts>=29) {
			//add the amount it can be converted to
			this.sickles+=(this.knuts/29);
			//set it to the amount left
			this.knuts=this.knuts%29;
		}
		if(this.sickles>=17) {
			//add the amount it can be converted to
			this.galleons+=(sickles/17);
			//set it to the amount left
			this.sickles=sickles%17;
		}
	}
	//convert all to knuts
	private void convertKnuts() {
		//converts galleons to sickles
		this.sickles+=this.galleons*17;
		//converts sickles to knuts
		this.knuts+=this.sickles*29;
		//set galleons and sickles to 0
		this.galleons=0;
		this.sickles=0;
	}
	//getters for all variable
	public int getGalleons() {
		return galleons;
	}
	public int getSickles() {
		return sickles;
	}
	public int getKnuts() {
		return knuts;
	}
}
