package GUI;

import Business_Logic.ATM;
import Business_Logic.Account;
import Business_Logic.Customer;
import DataBase.CRUD;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class CreateAccountController {
	@FXML
	private TextField fname;
	
	@FXML
	private TextField lname;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField accountno;
	
	@FXML
	private PasswordField PIN;
	
	@FXML
	private PasswordField confirmPin;
	
	@FXML
	private Label alert;
	
	private Account a = new Account();
	private Customer c = new Customer();
	private CRUD handler = new CRUD();

	
	@FXML
	public void backButtonPressed(ActionEvent event) 
	{
		Main m = new Main();
		m.changeScene("MainPage.fxml");
	}
	
	@FXML
	public void createAccountPressed(ActionEvent event) 
	{
		if(fname.getText().isEmpty() || lname.getText().isEmpty() || email.getText().isEmpty() || accountno.getText().isEmpty() || PIN.getText().isEmpty())
		{
			alert.setText("All Fields are Required ");
		}
		
		else if(PIN.getText().equals(confirmPin.getText()))				// Verify if PIN is equal to CONFIRM PIN
		{
			
			int flag = a.accountDuplication(accountno.getText(), PIN.getText());			// Checks for Account Duplication
			//System.out.println("flag"+flag);
			
			if(flag == 1)
			{
				alert.setText("Account No or PIN already In Use ");
			}
			else
			{
				a.createAccount(c);
				int temp = a.getRegisteredCustomers();
				a.customer[temp-1].setFirstName(fname.getText());
				a.customer[temp-1].setLastName(lname.getText());
				a.customer[temp-1].setEmail(email.getText());
				a.customer[temp-1].setaccountNo(accountno.getText());
				a.customer[temp-1].setPIN(PIN.getText());
				a.customer[temp-1].setBalance(0);
				alert.setText("Account Successfully Created ");
				handler.saveCustomers(c);
				fname.clear();
				lname.clear();
				email.clear();
				accountno.clear();
				PIN.clear();
				confirmPin.clear();	
			}
		}
		
		else												// If PIN's donot match
		{
			alert.setText("PIN's Donot Match");
		}
	}
	
	@FXML
	public void resetButtonPressed(ActionEvent event) 
	{
		Main m = new Main();
		m.changeScene("CreateAccount.fxml");
	}
}
