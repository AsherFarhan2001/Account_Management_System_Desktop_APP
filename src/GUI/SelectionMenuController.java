package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import Business_Logic.ATM;
import Business_Logic.Account;
import javafx.event.ActionEvent;

public class SelectionMenuController implements Initializable{

	
	@FXML
	private Label user;
	private ATM A = new ATM();
	private Account a = new Account();
	
	@Override
	public void initialize(URL url, ResourceBundle rb) 
	{
		a.retrieveFromDataBase();
		String str = a.getCustomer()[a.getVerifiedAccount()].getFirstName();
		String a = str.toUpperCase();
		user.setText("WELCOME  " + a);
	}
	@FXML
	public void viewBalanceButtonPressed(ActionEvent event) {
		
		double temp = A.viewBalance();
		System.out.println("bal " + temp);
		Main m = new Main();
		m.changeScene("ViewBalance.fxml");
		
	}
	
	@FXML
	public void withDrawCashButtonPressed(ActionEvent event)
	{
		
		Main m = new Main();
		m.changeScene("WithDrawCash.fxml");
	}
	
	@FXML
	public void DepositCashButtonPressed(ActionEvent event)
	{
		Main m = new Main();
		m.changeScene("DepositCash.fxml");
	}
	
	@FXML
	public void transferAmountButtonPressed(ActionEvent event)
	{
		Main m = new Main();
		m.changeScene("TransferAmount.fxml");
	}
	
	@FXML
	public void backButtonPressed(ActionEvent event)
	{
		Main m = new Main();
		m.changeScene("LoginAccount.fxml");
	}
}
