package GUI;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import Business_Logic.ATM;
import Business_Logic.Account;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

public class LoginAccountController {
	
	@FXML
	private TextField accountno;
	
	@FXML
	private PasswordField pin;
	
	@FXML
	private Label alert;
	
	private Account a = new Account();
	private ATM A = new ATM();

	
	@FXML
	public void signInButtonPressed(ActionEvent event)
	{
		
		if(accountno.getText().isEmpty() || pin.getText().isEmpty())
		{
			alert.setText("Account No and PIN is Required ");
		}
		
		else
		{
			boolean temp = A.autheticateUser(accountno.getText(), pin.getText());
			
			if(temp == true)
			{
				alert.setText("Sign In Successfull ");
				Main m = new Main();
				m.changeScene("SelectionMenu.fxml");
			}
			else
			{
				alert.setText("Invalid Account No or PIN ");
			}
			System.out.println("temp is : " + temp);
			System.out.println("account is : " + a.getVerifiedAccount());
		}
	}
	
	@FXML
	public void BackButtonPressed(ActionEvent event)
	{
		Main m = new Main();
		m.changeScene("MainPage.fxml");
	}
}
