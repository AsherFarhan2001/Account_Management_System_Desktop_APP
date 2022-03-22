package DataBase;

import Business_Logic.Driver;
import Business_Logic.Account;
import Business_Logic.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	
	
	public void loadCustomers(Account a)
	{
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","tiger12345");
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from account");
            
            while(rs.next())
            {
            	a.setTotalCustomers(rs.getInt(2));
            	a.setRegisteredCustomers(rs.getInt(3));
            
            }
            
            con.close();
           
        }
		
		catch(ClassNotFoundException e)
        {
            System.out.println("Driver Not Loaded ");
        }

        catch(SQLException e)
        {
            System.out.println("Connection not Established ");
            e.printStackTrace();
        }
	}
	
	public void retrieveCustomers(Account a)
	{
	
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","tiger12345");
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from customer");
            int count=0;
            for(int i=0;i<a.getRegisteredCustomers();i++)
        	{
        		a.customer[i] = new Customer();
        	}
            
            while(rs.next())
            {
            	
            	a.customer[count].setFirstName(rs.getString(1));
        		a.customer[count].setLastName(rs.getString(2));
        		a.customer[count].setEmail(rs.getString(3));
        		a.customer[count].setaccountNo(rs.getString(4));
        		a.customer[count].setPIN(rs.getString(5));
        		a.customer[count].setBalance(rs.getDouble(6));
        
        		count++;
            }
            
            con.close();
           
        }
		
		catch(ClassNotFoundException e)
        {
            System.out.println("Driver Not Loaded ");
        }

        catch(SQLException e)
        {
            System.out.println("Connection not Established ");
            e.printStackTrace();
        }
	}
	public void saveCustomers(Customer C)
	{
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","tiger12345");
            Statement stmt = con.createStatement();
            stmt.execute("use atm");
            String sql = "INSERT INTO customer (first_name, last_name, email, accountNo, PIN, balance ) VALUES (?,?,?,?,?,?) ";

            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, C.getFirstName());
            statement.setString(2, C.getLastName());
            statement.setString(3, C.getEmail());
            statement.setString(4, C.getAccountNo());
            statement.setString(5, C.getPIN());
            statement.setDouble(6, 0);
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
            {
                System.out.println("The Account has been Successfully Created");
            }
            con.close();

        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Driver Not Loaded ");
        }

        catch(SQLException e)
        {
            System.out.println("Connection not Established ");
            e.printStackTrace();
        }
	}
	
	public void updateRegisterCustomers(int reg_customers)
	{
		
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","tiger12345");
            Statement stmt = con.createStatement();
           
            int temp = 1;
            String sql="UPDATE account SET registered_customers = ? WHERE total_customers = ? ";
            System.out.println(reg_customers);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, reg_customers);
            statement.setInt(2, 10);
			statement.executeUpdate();
            con.close();
        
        }
		
		catch(ClassNotFoundException e)
        {
            System.out.println("Driver Not Loaded ");
        }

        catch(SQLException e)
        {
            System.out.println("Connection not Established ");
            e.printStackTrace();
        }
	}
	
	public void updateBalance(Account a, int no, double amo)
	{
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","tiger12345");
            Statement stmt = con.createStatement();
           
            String sql="UPDATE customer SET balance = ? WHERE accountNo = ? ";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDouble(1, amo);
            statement.setString(2, a.getCustomer()[no].getAccountNo());
			statement.executeUpdate();
            con.close();
        
        }
		
		catch(ClassNotFoundException e)
        {
            System.out.println("Driver Not Loaded ");
        }

        catch(SQLException e)
        {
            System.out.println("Connection not Established ");
            e.printStackTrace();
        }
	}
		
            

            
	
}
