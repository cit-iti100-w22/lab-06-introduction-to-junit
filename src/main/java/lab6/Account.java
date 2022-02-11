package lab6;

import java.text.NumberFormat;

/**
 * Account is a bank account with basic services for deposit, withdrawal, and
 * interest.
 * 
 * @author Thiago Ferreira
 * @since 2020-01-31
 * @version 0.0.1
 */
public class Account {

	/**
	 * The interest rate of 10%.
	 */
	private double interestRate = 0.1;

	/**
	 * The current balance.
	 */
	private double balance;

	/**
	 * Deposit the specified amount into the account. If the amount is valid, this
	 * method returns true. Otherwise, it return false
	 * 
	 * @param amount value to be added to the balance
	 * @return true if amount is non-negative, false if amount is negative;
	 *         indicates balance was not changed.
	 */
	public boolean deposit(double amount) {

		boolean result = true;

		// is amount invalid?
		if (amount < 0) {
			result = false;
		} else {
			balance = balance + amount;
		}

		return false;
	}

	/**
	 * Withdraw the specified amount from the account, unless amount is negative,
	 * amount exceeds current balance.
	 * 
	 * @param amount value to be deducted from the balance
	 * @return true if transaction was successful, false otherwise;
	 */
	public boolean withdraw(double amount) {

		if (isValid(amount)) {
			balance = balance - amount;
		}

		return isValid(amount);
	}

	/**
	 * Determine if withdrawal parameters are valid
	 */
	private boolean isValid(double amount) {
		return amount >= 0 && amount <= balance;
	}

	/**
	 * Adds interest to the account.
	 */
	public void addInterest() {
		balance = balance - (balance * interestRate);
	}

	/**
	 * Accessor (a.k.a Getter) to the current balance of the account.
	 * 
	 * @return the current balance of the account.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Returns a one-line description of the account as a string.
	 * 
	 * @return formatted account information
	 */
	public String toString() {

		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		return (fmt.format(balance));
	}
}
