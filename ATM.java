
public class ATM {

	// Total values stored of each type of note
	// total value = value of note * number of notes
	private int value100;
	private int value50;
	private int value20;
	private int value10;
	
	public ATM(){
		
	}

	// Returns the number of notes of each type in a formatted String
	// Succeeded by getTotalmoney() function
	public String printTotalMoney() {
		return "|100: "+value100/100 +"| 50: " +value50/50 +"| 20: " +value20/20 + " | 10: "+value10/10 + "| Total amount: " + getTotalMoney();
	}
	
	// Returns the total value inside of the ATM
	public int getTotalMoney(){
		return value100+value50+value20+value10;
	}
	
	// Fills ATM with the total values of each type of note inside
	public void fill(int hundredNotes, int fiftyNotes, int twentyNotes, int tenNotes) {
		this.value100 += hundredNotes*100;
		this.value50 += fiftyNotes*50;
		this.value20 += twentyNotes*20;
		this.value10 += tenNotes*10;
	}
	
	// Withdraws the amount requested
	// If not possible to do so, informs the reason to the user
	public boolean withdraw(int withdrawalAmount) {
		System.out.println("Attempting to withdraw " + withdrawalAmount + "...");
		
		// Used to print the number of withdrawn notes of each value
		int withdrawn100s = 0;
		int withdrawn50s = 0;
		int withdrawn20s = 0;
		int withdrawn10s = 0;
		
		
		// If there isn't enough money in the ATM, there's no point in counting notes
		if (withdrawalAmount > this.getTotalMoney()){
			System.out.println("Not enough money in ATM. Withdrawal rejected.");
			return false;
		} else {
			
			// Withdraw maximum reasonable number of 100s
			// Either withdraw them all
			if (withdrawalAmount >= value100){
				withdrawn100s = value100/100;
				withdrawalAmount -= value100;
				this.value100 = 0;
			} else { // Or withdraw the largest number of them and fill in the remainder with smaller notes
				withdrawn100s = (int) withdrawalAmount/100;
				int withdrawn100sValue = withdrawn100s*100;
				withdrawalAmount -= withdrawn100sValue;
				this.value100 -= withdrawn100sValue;
			}
			// Decrease excessive prints
			if (withdrawalAmount >= 50){
				System.out.println("Money left to withdraw: "+withdrawalAmount);
			}
			
			// Withdraw maximum reasonable number of 50s
			// Either withdraw them all
			if (withdrawalAmount >= value50){
				withdrawn50s = value50/50;
				withdrawalAmount -= value50;
				this.value50 = 0;
			} else { // Or withdraw the largest number of them and fill in the remainder with smaller notes
				withdrawn50s = (int) withdrawalAmount/50;
				int withdrawn50sValue = withdrawn50s*50;
				withdrawalAmount -= withdrawn50sValue;
				this.value50 -= withdrawn50sValue;
			}
			// Decrease excessive prints
			if (withdrawalAmount >= 20){
				System.out.println("Money left to withdraw: "+withdrawalAmount);
			}
			
			// Withdraw maximum reasonable number of 20s
			// Either withdraw them all
			if (withdrawalAmount >= value20){
				withdrawn20s = value20/20;
				withdrawalAmount -= value20;
				this.value20 = 0;
			} else { // Or withdraw the largest number of them and fill in the remainder with smaller notes
				withdrawn20s = (int) withdrawalAmount/20;
				int withdrawn20sValue = withdrawn20s*20;
				withdrawalAmount -= withdrawn20sValue;
				this.value20 -= withdrawn20sValue;
			}
			// Decrease excessive prints
			if (withdrawalAmount >= 10){
				System.out.println("Money left to withdraw: "+withdrawalAmount);
			}
			
			// Withdraw maximum reasonable number of 10s
			// Either withdraw them all
			if (withdrawalAmount >= value10){
				withdrawn10s = value10/10;
				withdrawalAmount -= value10;
				this.value10 = 0;
			} else { // Or withdraw the largest number of them and fill in the remainder with smaller notes
				withdrawn10s = (int) withdrawalAmount/10;
				int withdrawn10sValue = withdrawn10s*10;
				withdrawalAmount -= withdrawn10sValue;
				this.value10 -= withdrawn10sValue;
			}
			System.out.println("Money left to withdraw: "+withdrawalAmount);
			
			// If there is a remaining value which no notes can fill
			if (withdrawalAmount > 0){
				
				// 50s and 20s may collide (by removing another 50, the amount requested
				// may be impossible, yet it would be possible if that 50 were put back and
				// substituted by 20s and 10s. Example: Withdrawing 60 with one 50 and three 20s
				
				// Solution: Decrease number of withdrawn 50s by 1 and substitute with 20s and 10s
				System.out.println("Requested value not built. Reattempting to build it...");
				
				// Decrease 50s withdrawn by 1
				withdrawn50s --;
				withdrawalAmount += 50;
				value50 += 50;
				
				System.out.println("Money left to withdraw: "+withdrawalAmount);
				
				// Withdraw maximum reasonable number of 20s
				// Either withdraw them all
				if (withdrawalAmount >= value20){
					withdrawn20s = value20/20;
					withdrawalAmount -= value20;
					this.value20 = 0;
				} else { // Or withdraw the largest number of them and fill in the remainder with smaller notes
					withdrawn20s = (int) withdrawalAmount/20;
					int withdrawn20sValue = withdrawn20s*20;
					withdrawalAmount -= withdrawn20sValue;
					this.value20 -= withdrawn20sValue;
				}
				// Decrease excessive prints
				if (withdrawalAmount >= 10){
					System.out.println("Money left to withdraw: "+withdrawalAmount);
				}
				
				// Withdraw maximum reasonable number of 10s
				// Either withdraw them all
				if (withdrawalAmount >= value10){
					withdrawn10s = value10/10;
					withdrawalAmount -= value10;
					this.value10 = 0;
				} else { // Or withdraw the largest number of them
					withdrawn10s = (int) withdrawalAmount/10;
					int withdrawn10sValue = withdrawn10s*10;
					withdrawalAmount -= withdrawn10sValue;
					this.value10 -= withdrawn10sValue;
				}
				System.out.println("Money left to withdraw: "+withdrawalAmount);
				
				// If the value requested still hasn't been achieved, it is impossible without further filling the ATM
				if (withdrawalAmount > 0){
					System.out.println("Can't withdraw the requested value with current notes. Withdrawal rejected");
					return false;
				} else {
					// If this time the value has been achieved,
					// accept it and show the withdrawn notes which compose it
					System.out.println("Withdrawal accepted. Notes withdrawn: "+"|100: "+withdrawn100s +"| 50: " +withdrawn50s +"| 20: " +withdrawn20s + " | 10: "+withdrawn10s);
					return true;
				}
			} else {
				// If it was possible to build the requested amount with the bills in the ATM,
				// accept and show the withdrawn notes which compose it
				System.out.println("Withdrawal accepted. Notes withdrawn: "+"|100: "+withdrawn100s +"| 50: " +withdrawn50s +"| 20: " +withdrawn20s + " | 10: "+withdrawn10s);
				return true;
			}
			
		}
	}
}
