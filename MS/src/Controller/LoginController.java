package Controller;

import javafx.event.ActionEvent;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.getData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Database.DBConnect;
import Database.Database;

import java.net.URL;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class LoginController implements Initializable {

    @FXML
    private Hyperlink signUp_alreadyHaveAccount;

    @FXML
    private Button signUp_btn;

    @FXML
    private Button signUp_close;

    @FXML
    private TextField signUp_email;

    @FXML
    private AnchorPane signUp_form;

    @FXML
    private Button signUp_minimize;

    @FXML
    private PasswordField signUp_password;

    @FXML
    private TextField signUp_username;

    @FXML
    private Button signin_close;

    @FXML
    private Hyperlink signin_createAccount;

    @FXML
    private AnchorPane signin_form;

    @FXML
    private Button signin_loginBtn;

    @FXML
    private Button signin_minimize;

    @FXML
    private PasswordField signin_password;

    @FXML
    private TextField signin_username;
    
    
    // TOols for connection
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
	private double x = 0;
	private double y = 0;
    
    
    
    // validate email
    
    public boolean validateEmail() {
    	Pattern pattern  = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
    	
    	Matcher match = pattern.matcher(signUp_email.getText());
    	
    	Alert alert;
    	
    	if(match.find() && match.group().matches(signUp_email.getText())) {
    		return true;
    	}else {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Email error");
			alert.setHeaderText(null);
			alert.setContentText("Please enter valid email");
			
			alert.showAndWait();
			return false;
    	}
    	
    }
    
    
    
    // signUp function
    
    public void singUp() {
    	
    	String sql = "INSERT INTO auth (email,user_id,password) VALUES (?,?,?)";
    	
    	String checkUsername = "SELECT * FROM auth WHERE user_id = ?";
    	String checkEmail = "SELECT * FROM auth WHERE email = ?";
    	
    	connect = Database.connectDB();
    	
    	try {
    		Alert alert;
    		
    		if(signUp_email.getText().isEmpty() || signUp_username.getText().isEmpty() || signUp_password.getText().isEmpty()) {
    			alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error Message");
    			alert.setHeaderText(null);
    			alert.setContentText("Please fill all the blank fields");
    			
    			alert.showAndWait();
    		}
    		else if(signUp_password.getText().length() < 8) {
    			alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Password error");
    			alert.setHeaderText(null);
    			alert.setContentText("Password must be at least 8 characters long");
    			
    			alert.showAndWait();
    		}else {
    			
    			if(validateEmail()) {
    				
    				// check whether email is unique
    				prepare = connect.prepareStatement(checkEmail);
    				prepare.setString(1, signUp_email.getText());
    				result = prepare.executeQuery();
    				
    				if(result.next()) {
    					
            			alert = new Alert(AlertType.ERROR);
            			alert.setTitle("Error");
            			alert.setHeaderText(null);
            			alert.setContentText("Given email " + signUp_email.getText() +" already exists");
            			
            			alert.showAndWait();
    					
    				}else {
    					// check whether username is unique
    					
        				prepare = connect.prepareStatement(checkUsername);
        				prepare.setString(1, signUp_username.getText());
        				result = prepare.executeQuery();
        				if(result.next()) {
                			alert = new Alert(AlertType.ERROR);
                			alert.setTitle("Error");
                			alert.setHeaderText(null);
                			alert.setContentText("Given username " + signUp_username.getText() +" already exists");
                			
                			alert.showAndWait();
        				}
        				else {
                			//execute account creation if all fields are valid
        					
        		    		prepare = connect.prepareStatement(sql);
        		    		prepare.setString(1, signUp_email.getText());
        		    		prepare.setString(2, signUp_username.getText());
        		    		prepare.setString(3, signUp_password.getText());
                			prepare.execute();
                			
                			System.out.println("creationn!!!");
                			
                			alert = new Alert(AlertType.INFORMATION);
                			alert.setTitle("Success");
                			alert.setHeaderText(null);
                			alert.setContentText("Successfully created account!!");
                			
                			alert.showAndWait();
                			
                			
                			signUp_email.setText("");
                			signUp_password.setText("");
                			signUp_username.setText("");
        				}
    				}     			
        		}
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    
    public void signin() {
    	System.out.println("signging in");
    	DBConnect conn = null;
    	String sql = "SELECT * FROM auth WHERE user_id = ? and password = ?";
    	
    	connect = Database.connectDB();
    			
    	try {
    		prepare = connect.prepareStatement(sql);
    		prepare.setString(1, signin_username.getText());
    		prepare.setString(2, signin_password.getText());
    		
    		result = prepare.executeQuery();
    		
    		Alert alert;
    		
    		if(signin_username.getText().isEmpty() || signin_password.getText().isEmpty()) {
    			alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error Message");
    			alert.setHeaderText(null);
    			alert.setContentText("Please fill all the blank fields");
    			
    			alert.showAndWait();
    		} else {
    			if(result.next()) {
    				
    				
    				// if success, get username
    				getData.username = signin_username.getText();
    				
    				
    				// Hide the login form
    				signin_loginBtn.getScene().getWindow().hide();
    				
    				Parent root = FXMLLoader.load(getClass().getResource("/Views/Dashboard.fxml"));
    				Stage stage = new Stage();
    				Scene scene = new Scene(root);
    				
    				
    		        root.setOnMousePressed((MouseEvent event) -> {
    		        	x = event.getSceneX();
    		        	y = event.getSceneY();
    		        });
    		        
    		        root.setOnMouseDragged((MouseEvent event) -> {
    		        	stage.setX(event.getScreenX() - x);
    		        	stage.setY(event.getScreenY() - y);
    		        });
    				
    				
    				stage.initStyle(StageStyle.TRANSPARENT);
    				stage.setScene(scene);
    				stage.show();
    				
    				alert = new Alert(AlertType.INFORMATION);
    				alert.setTitle("Information Message");
    				alert.setHeaderText(null);
    				alert.setContentText("Successfully login");
    				alert.showAndWait();
    			}else {
        			alert = new Alert(AlertType.ERROR);
        			alert.setTitle("Error Message");
        			alert.setHeaderText(null);
        			alert.setContentText("Wrong Username/Passwords");
        			alert.showAndWait();
    			}
    		}
    		
    		
    	}catch(Exception e) {
    		
    	}
    }
    
    
    
    public void switchForm(ActionEvent event) {
    	if(event.getSource() == signin_createAccount) {
    		signin_form.setVisible(false);
    		signUp_form.setVisible(true);
    		
    	}else if(event.getSource() == signUp_alreadyHaveAccount) {
    		signin_form.setVisible(true);
    		signUp_form.setVisible(false);
    	}
    }
    
    public void signIn_close() {
    	System.out.println("YYYYYY");
    	System.exit(0);
    }
    
    public void sigIn_minimize() {
    	Stage stage = (Stage)signin_form.getScene().getWindow();
    	stage.setIconified(true);
    }
    
    
    public void signUp_close() {
    	System.out.println("YYYYYY");
    	System.exit(0);
    }
    
    public void sigUp_minimize() {
    	Stage stage = (Stage)signin_form.getScene().getWindow();
    	stage.setIconified(true);
    }
    
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
}

