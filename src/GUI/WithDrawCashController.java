package GUI;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import Business_Logic.ATM;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class WithDrawCashController {
	
	@FXML
	private TextField amount;
	
	@FXML
	private Label alert;

	ATM A = new ATM();
	
	@FXML
	public void withdrawButtonPressed(ActionEvent event) 
	{
		if(amount.getText().isEmpty())
		{
			alert.setText("Please Enter the Amount ");
		}
		
		else
		{
			String str = amount.getText();
			double d = Double.parseDouble(str);
			boolean temp = A.witdrawMoney(d);
			if(temp == true)
			{
				alert.setText("The Amount is Greater than Bank Balance ");
				amount.clear();
			}
			else
			{
				String path = "withdrawCash.mp3"; 
		        Media media = new Media(new File(path).toURI().toString());   
		        MediaPlayer mediaPlayer = new MediaPlayer(media); 
		        mediaPlayer.setAutoPlay(true);  
		        
				alert.setText("The Amount Has Been Successfuly WithDrawn ");
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
