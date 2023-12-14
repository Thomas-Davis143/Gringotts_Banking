
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GWBManager manager = new GWBManager(200,100,50);
        System.out.println(manager);
        manager.withdraw(20, 0, 5);
        manager.viewTransactions("ALL");
	}

}
