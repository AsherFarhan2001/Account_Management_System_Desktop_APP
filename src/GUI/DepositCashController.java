package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import Business_Logic.ATM;
import Business_Logic.Account;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class DepositCashController {
	
	@FXML
	private Label alert;
	
	@FXML
	private TextField amount;

	Account a = new Account();
	ATM A = new ATM();
	
	@FXML
	public void depositButtonPressed(ActionEvent event)
	{
		if(amount.getText().isEmpty())
		{
			alert.setText("Please Enter the Amount ");
		}
		
		else
		{
			String str = amount.getText();
			double d = Double.parseDouble(str);
			A.depositMoney(d);
			alert.setText("Your Amount Has Been Deposited Successfuly ");
			amount.clear();
			
		}
	}
	
	@FXML
	public void backButtonPressed(ActionEvent event) {

		Main m = new Main();
		m.changeScene("SelectionMenu.fxml");
	}
}
