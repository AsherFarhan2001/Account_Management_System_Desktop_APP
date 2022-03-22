package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainPageController {
	
	@FXML
	private Button loginButton;
	
	@FXML
	public void loginButtonPressed(ActionEvent event)
	{
		Main m = new Main();
		m.changeScene("LoginAccount.fxml");
	}
	
	@FXML
	public void createAccountButtonPressed(ActionEvent event)
	{
		Main m = new Main();
		m.changeScene("CreateAccount.fxml");
	}

}
