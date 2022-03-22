	package Business_Logic;

public class Customer {
	
	private String f_name;
	private String l_name;
	private String email;
	private String accountNo;
	private String PIN;
	private double balance;
	
	public Customer()
	{
		
	}
	public Customer(String fname, String lname, String email, String accountNo, String PIN, double balance)
	{
		this.f_name = fname;
		this.l_name = lname;
		this.email = email;
		this.accountNo = accountNo;
		this.PIN = PIN;
		this.balance = balance;
	}
	public void setFirstName(String fname)
	{
		this.f_name = fname;
	}
	
	public void setLastName(String lname)
	{
		this.l_name = lname;
	}
	public void setaccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setPIN(String PIN)
	{
		this.PIN = PIN;
	}
	public void setBalance(double Balance)
	{
		this.balance = Balance;
	}
	
	public double getBalance()
	{
		return balance;
	}
	public String getFirstName()
	{
		return f_name;
	}
	public String getLastName()
	{
		return l_name;
	}
	public String getAccountNo()
	{
		return accountNo;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPIN()
	{
		return PIN;
	}
	
	
}
