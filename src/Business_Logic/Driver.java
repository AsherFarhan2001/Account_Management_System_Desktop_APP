	package Business_Logic;

import DataBase.CRUD;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CRUD c = new CRUD();
		Account A = new Account();
		
		boolean verify;
		
		Customer C1 = new Customer("asher","farhan","a@gmail.com","12345","123",234);
		Customer C2 = new Customer("rameen","farhan","r@gmail.com","45678","321",500);
		Customer C3 = new Customer("rameen","farhan","r@gmail.com","45678","424",500);
		
		ATM atm = new ATM(A);
		
		//atm.accounts.createAccount(C1);
		//atm.accounts.createAccount(C2);
		//atm.accounts.createAccount(C3);
		
		atm.accounts.accountDuplication("43434", "424");
		verify = atm.autheticateUser("12345", "123");
		if(verify == true)
		{
			atm.witdrawMoney(120);
			atm.depositMoney(1000);
			double bal = atm.viewBalance();
			System.out.println("The Balance is : " + bal);
			int flag = atm.transferAmount("45678", 235);
		}
		
		verify = atm.autheticateUser("45678", "321");
		if(verify == true)
		{
			System.out.println(atm.viewBalance());
		}
		
		atm.accounts.displayCustomer();
		

	}

}
