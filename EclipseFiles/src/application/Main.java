package application;
	
import javafx.scene.image.Image;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
 
	public void start(Stage primaryStage){
		try {		
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("pages/fxmlFiles/AdminLogin.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Library Management System");
			primaryStage.getIcons().add(new Image("D:\\College\\sem4\\dbms-mini-project\\AdminLoginPage\\login-page-design.png"));
			
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
