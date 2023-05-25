package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Utility.DBUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void switchToAdminLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("adminlogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToStudentLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("studentlogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToStudentPage(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("student.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToAdminPage(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void books_available(ActionEvent event) throws IOException {
		Connection con = null;
		try
		{
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select count(bid) from Books");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
                int count = rs.getString("name");

                // Populate the TextField
                book_avail.setText(count);
            }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}