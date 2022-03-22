package GUI;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import Business_Logic.ATM;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class TransferAmountController {
	
	@FXML
	private TextField accountno;
	
	@FXML
	private TextField amount;
	
	@FXML
	private Label alert;

	ATM A = new ATM();
	
	@FXML
	public void transferButtonPressed(ActionEvent event)
	{
		if(accountno.getText().isEmpty() || amount.getText().isEmpty())
		{
			alert.setText("Please Provide the Required Information ");
		}
		
		else
		{
			String str = amount.getText();
			double d = Double.parseDouble(str);
			int temp = A.transferAmount(accountno.getText(), d);
			if(temp == 1)
			{
				alert.setText("The Amount Has Been Successfuly Transferred ");
				accountno.clear();
				amount.clear();
			}
			
			else if(temp == 2)
			{
				alert.setText("The Amount is Greater than Bank Balance ");
			}
			
			else
			{
				alert.setText("Invalid Account No ");
				accountno.clear();
				amount.clear();
			}
		}
	}
	
	@FXML
	public void backButtonPressed(ActionEvent event) 
	{
		Main m = new Main();
		m.changeScene("SelectionMenu.fxml");
	}
}
