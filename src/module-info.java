module SDA_Assignment {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.sql;
	requires javafx.media;
	
	opens GUI to javafx.graphics, javafx.fxml;
}
