package Business_Logic;

import DataBase.CRUD;

public class ATM {
	
	public Account accounts;
	CRUD handler = new CRUD();
	
	public ATM()
	{
		accounts = new Account();
	}
	
	public ATM(Account accounts)
	{
		this.accounts = accounts;
	}
	
	public boolean autheticateUser(String accountNo, String PIN)
	{
		
		int temp = 0;
		temp = accounts.verifyAccount(accountNo, PIN);
		if(temp == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public boolean witdrawMoney(double amount)
	{
		retrieveFromDataBase();
		int no = accounts.getVerifiedAccount();
		double amo = accounts.getCustomer()[no].getBalance();
		if(amo < amount)		
		{
			System.out.println("The Bank Balance is Insufficient ");
			return true;
		}
		else
		{
			double rem_bal = amo - amount;
			accounts.getCustomer()[no].setBalance(rem_bal);
			handler.updateBalance(accounts, no, rem_bal);
			return false;
		}
		
	}
	
	public void depositMoney(double amount)
	{
		retrieveFromDataBase();
		int no = accounts.getVerifiedAccount();
		double amo = accounts.getCustomer()[no].getBalance();
		double rem_bal = amo + amount;
		accounts.getCustomer()[no].setBalance(rem_bal);
		handler.updateBalance(accounts, no, rem_bal);
	}

	public double viewBalance()
	{
		retrieveFromDataBase();
		int no = accounts.getVerifiedAccount();
		return accounts.getCustomer()[no].getBalance(); 
	}
	
	public int transferAmount(String account, double amount)
	{
		int temp = 0;
		int flag;
		temp = accounts.verifyTransferAccount(account);
		if(temp == 1)
		{
			flag = accounts.getVerifiedAccount();
			int no = accounts.getVerifiedTransferAccount();
			if(amount > accounts.getCustomer()[flag].getBalance())
			{
				return 2;
			}
			else
			{
				double user_acc = accounts.getCustomer()[flag].getBalance() - amount;
				double amo = accounts.getCustomer()[no].getBalance();
				double total_amo = amo + amount;
				accounts.getCustomer()[no].setBalance(total_amo);
				handler.updateBalance(accounts, no, total_amo);
				handler.updateBalance(accounts, flag, user_acc);
				return 1; 
			}
			
		}
		else
		{
			System.out.println("Invalid Account No or Pin ");
			return 0;
		}
	}
	
	public void retrieveFromDataBase()
	{
		handler.loadCustomers(accounts);
		handler.retrieveCustomers(accounts);
	}
}
