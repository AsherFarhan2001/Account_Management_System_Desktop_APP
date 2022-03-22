package Business_Logic;

import DataBase.CRUD;

public class Account {
	
	public Customer [] customer;
	private int total_Customers;
	private int registered_Customers;
	static int flag = 0;
	static int count;
	static int count1;
	CRUD handler = new CRUD();
	
	public Account()
	{
		
	}
	public Account(int total_Customers)
	{
		this.total_Customers = total_Customers;
		customer = new Customer[total_Customers];
	}
	
	public void createAccount(Customer C)
	{
		handler.loadCustomers(this);
		if(registered_Customers < total_Customers)
		{
			customer[registered_Customers] = C;
			registered_Customers++;
		}
		handler.updateRegisterCustomers(registered_Customers);
		
	}
	
	public int accountDuplication(String accountNo, String PIN)
	{
		int temp = 0;
		retrieveFromDataBase();
		for(int i=0;i<registered_Customers;i++)
		{
			if(accountNo.equals(customer[i].getAccountNo()) || PIN.equals(customer[i].getPIN()))
			{
				temp = 1;
				break;
			}
		}
		
		return temp;
	}
	public int verifyAccount(String accountNo, String PIN)
	{
		flag = 0;				// to return the status of account found
		count = 0;
		retrieveFromDataBase();
		for(int i=0; i<registered_Customers;i++)
		{
			if(accountNo.equals(customer[i].getAccountNo()) && PIN.equals(customer[i].getPIN()))
			{
				flag = 1;
				break;
			}
			count++;				// telling which account is currently opened
		}
		return flag;
			
	}
	
	public int verifyTransferAccount(String accountNo)
	{
		int flag = 0;				// to return the status of transfer account found
		count1 = 0;
		retrieveFromDataBase();
		for(int i=0; i<registered_Customers;i++)
		{
			if(accountNo.equals(customer[i].getAccountNo()))
			{
				flag = 1;
				break;
			}
			count1++;					// telling which account money is being transfered
		}
		return flag;
	}
	
	public void displayCustomer()
	{
		
		for(int i=0;i<registered_Customers;i++)
		{
			
			System.out.println("------------------------- CUSTOMER " + i + "--------------------------------- ");
			System.out.println("First Name : " + customer[i].getFirstName());
			System.out.println("Last Name : " + customer[i].getLastName());
			System.out.println("Email : " + customer[i].getEmail());
			System.out.println("Account No : " + customer[i].getAccountNo());
			System.out.println("PIN : " + customer[i].getPIN());
			System.out.println("Balance : " + customer[i].getBalance());
			
		}
	}
	
	public Customer[] getCustomer()
	{
		return customer;
	}
	
	public void setRegisteredCustomers(int reg)
	{
		this.registered_Customers = reg;
	}
	
	public void setTotalCustomers(int total)
	{
		this.total_Customers = total;
		customer = new Customer[total_Customers];
	}
	
	public int getTotalCustomers()
	{
		return total_Customers;
	}
	
	public int getRegisteredCustomers()
	{
		return registered_Customers;
	}
	
	public int getVerifiedAccount()
	{
		return count;
	}
	
	public void retrieveFromDataBase()
	{
		handler.loadCustomers(this);
		handler.retrieveCustomers(this);
	}
	
	public int getVerifiedTransferAccount()
	{
		return count1;
	}
	
	
	
	

}
