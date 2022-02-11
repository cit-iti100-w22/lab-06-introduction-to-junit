package lab6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AccountTest {

	@Test
	public void shouldBeValidIfDepositIsPositive() {

		Account acc = new Account();

		assertEquals(true, acc.deposit(200));
	}

	@Test
	public void shouldBeInvalidIfDepositIsZero() {

		Account acc = new Account();

		assertEquals(false, acc.deposit(0));
	}

	@Test
	public void shouldBeInvalidIfDepositIsNegative() {

		Account acc = new Account();

		assertEquals(false, acc.deposit(-200));
	}

	@Test
	public void shouldBeValidIfDepositIsVeryLowPositiveNumber() {

		Account acc = new Account();

		assertEquals(true, acc.deposit(0.00001));
	}

	@Test
	public void shouldBeInvalidIfDepositIsVeryLowNegativeNumber() {

		Account acc = new Account();

		assertEquals(false, acc.deposit(-0.00001));
	}
	
	@Test
	public void shouldChangeTheBalanceWhenDepositAValidNumber() {

		Account acc = new Account();
		
		acc.deposit(200);

		assertEquals(200, acc.getBalance());
	}
	
	@Test
	public void shouldNotChangeTheBalanceWhenDepositIsNegativeNumber() {

		Account acc = new Account();
		
		acc.deposit(-200);

		assertEquals(0, acc.getBalance());
	}
	
	@Test
	public void shouldNotChangeTheBalanceWhenDepositIsZero() {

		Account acc = new Account();
		
		acc.deposit(0);

		assertEquals(0, acc.getBalance());
	}
	
	@Test
	public void shouldAddInterestOnce() {

		Account acc = new Account();
		
		acc.deposit(100);
		
		acc.addInterest();
		
		assertEquals(110, acc.getBalance());
	}
	
	@Test
	public void shouldAddInterestTwice() {

		Account acc = new Account();
		
		acc.deposit(100);
		
		acc.addInterest();
		acc.addInterest();
		
		assertEquals(121, acc.getBalance());
	}
	
	@Test
	public void shouldReturnZeroOnToStringMethodWhenNoDeposit() {

		Account acc = new Account();
		
		assertEquals("$0.00", acc.toString());
	}
	
	@Test
	public void shouldReturn100OnToStringMethodWhenDeposit100() {

		Account acc = new Account();
		
		acc.deposit(100);
		
		assertEquals("$100.00", acc.toString());
	}
	
	@Test
	public void shouldNotWithdrawWithNevativeValues() {

		Account acc = new Account();
		
		assertEquals(false, acc.withdraw(-100));
	}
	
	@Test
	public void shouldNotWithdrawWithZeroValue() {

		Account acc = new Account();
		
		assertEquals(false, acc.withdraw(0));
	}
	
	@Test
	public void shouldNotWithdrawIfBalanceIsZero() {

		Account acc = new Account();
		
		assertEquals(false, acc.withdraw(100));
	}
}
