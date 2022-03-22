package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import Business_Logic.ATM;
import Business_Logic.Account;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class ViewBalanceController implements Initializable {
	
	@FXML
	private Label balance;

	
	@Override
	public void initialize(URL url, ResourceBundle rb) 
	{
		Account a = new Account();
		ATM A = new ATM();
		a.retrieveFromDataBase();
		double bal = A.viewBalance();
		String str = Double.toString(bal);
		balance.setText(str);
	}
	
	@FXML
	public void backButtonPressed(ActionEvent event)
	{
		Main m = new Main();
		m.changeScene("SelectionMenu.fxml");
	}
}
