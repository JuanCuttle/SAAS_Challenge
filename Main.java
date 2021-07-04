
public class Main {

	public static void main(String[] args) {
		
		// Starting up ATM
		ATM atm = new ATM();
		
		System.out.println("Total money in ATM before filling: " + atm.printTotalMoney());
		
		// Filling up ATM with money
		// requires 4 integer values: number of 100 notes, number of 50 notes,
		// number of 20 notes and number of 10 notes
		atm.fill(1, 1, 3, 0);
		
		System.out.println("Total money in ATM after filling: " + atm.printTotalMoney());
		
		// Withdrawing from ATM
		// requires 1 integer value: total value to withdraw from ATM
		atm.withdraw(60);
		
		System.out.println("Total money in ATM after withdrawing: " + atm.printTotalMoney());
	}

}
