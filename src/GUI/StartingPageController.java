package GUI;

import Business_Logic.Account;
import Business_Logic.Customer;
import DataBase.CRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartingPageController {
	
	@FXML
	private Button Pbutton;
	
	private Account a = new Account();
	private CRUD db = new CRUD();
	
	@FXML
	public void proceedButtonClicked(ActionEvent event)
	{
		db.loadCustomers(a);
		//db.retrieveCustomers(a);
	//	a.displayCustomer();
		Main m = new Main();
		m.changeScene("MainPage.fxml");
	}
	

}
