package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Utility.DBUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	Connection con = null;
	
	@FXML
	private Label book_avail,book_lent,bk_info,bk_owned,bk_avail,bk_lent;
	
	@FXML
	private TextField bk_name,bookID,studReg,bk_id,st_stid,st_bkid,return_stid,return_bkid,info_bookID;
	
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
		try
		{
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select count(bid) as num from Books");
			ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	book_avail.setText(rs.getString("num"));
            }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void books_lent(ActionEvent event) throws IOException {
		try
		{
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select count(bid) as num from Books_lent");
			ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	book_lent.setText(rs.getString("num"));
            }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void issue_book(ActionEvent event) throws IOException{
		try {
			con=DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into books_lent values(?,?)");
			ps.setString(1, bookID.getText());
			ps.setString(2, studReg.getText());
			ps.executeUpdate();
			bookID.clear();
			studReg.clear();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void add_stock(ActionEvent event) throws IOException{
		try {
			con=DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into books values(?,?)");
			ps.setString(1, bk_id.getText());
			ps.setString(2, bk_name.getText());
			ps.executeUpdate();
			bk_id.clear();
			bk_name.clear();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void books_owned(ActionEvent event) throws IOException {
		try
		{
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select count(bid) as num from Books_lent group by sid having sid=?");
			ps.setString(1, st_stid.getText());
			ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	bk_owned.setText(rs.getString("num"));
            }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void part_book_avail(ActionEvent event) throws IOException {
		try
		{
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select count(bid) as num from Books where bid=?");
			ps.setString(1, st_bkid.getText());
			ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	bk_avail.setText(rs.getString("num"));
            }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void book_information(ActionEvent event) throws IOException {
		try
		{
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select bname from Books where bid=?");
			ps.setString(1, info_bookID.getText());
			ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	bk_info.setText(rs.getString("bname"));
            }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void book_return(ActionEvent event) throws IOException {
		try
		{
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from books_lent where bid=? and sid=?");
			ps.setString(1, return_bkid.getText());
			ps.setString(2, return_stid.getText());
			ps.executeUpdate();
			return_bkid.clear();
			return_stid.clear();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}