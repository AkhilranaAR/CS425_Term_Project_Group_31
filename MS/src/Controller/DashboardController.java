package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import Models.borrowBook;
import Models.customerData;
import Models.getData;
import Models.itemData;
import Models.search;
import Models.transaction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Database.DBConnect;
import Database.Database;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
//import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



public class DashboardController implements Initializable {
	

    @FXML
    private DatePicker addBooks_Date;

    @FXML
    private TextField addBooks_aisleNumber;

    @FXML
    private TextField addBooks_docType;


    @FXML
    private TextField addBooks_id;
    
    @FXML
    private TextField addBooks_numCopies;

    @FXML
    private TextField addBooks_title;
	
    @FXML
    private AnchorPane topForm;
	
	
    @FXML
    private TextField adMovies_duration;

    @FXML
    private Button search_btn;

    @FXML
    private ImageView adMovies_imageView;

    @FXML
    private TableColumn<itemData, String> addMovie_col_genre;

    @FXML
    private TableColumn<itemData, String> addMovie_col_genre1;

    @FXML
    private Button addMovies_btn;

    @FXML
    private Button addMovies_clearBtn;

    @FXML
    private TableColumn<itemData, String> addMovies_col_date;

    @FXML
    private TableColumn<itemData, String> addMovies_col_duration;

    @FXML
    private TableColumn<itemData, String> addMovies_col_movieTitle;

    @FXML
    private DatePicker addMovies_date;

    @FXML
    private Button addMovies_deleteBtn;

    @FXML
    private AnchorPane addMovies_form;

    @FXML
    private TextField addMovies_genre;

    @FXML
    private Button addMovies_import;

    @FXML
    private Button addMovies_insertBtn;

    @FXML
    private TextField addMovies_movieTitle;

    @FXML
    private TextField addMovies_search;

    @FXML
    private TableView<itemData> addMovies_tableView;

    @FXML
    private Button addMovies_updateBtn;

    @FXML
    private Button availableMovies_btn;

    @FXML
    private Button availableMovies_buyBtn;

    @FXML
    private Button availableMovies_clearBtn;

    @FXML
    private TableColumn<itemData, String> availableMovies_col_genre;

    @FXML
    private TableColumn<itemData, String> availableMovies_col_movieTitle;

    @FXML
    private TableColumn<itemData, String> availableMovies_col_showingDate;

    @FXML
    private Label availableMovies_date;
    
    @FXML
    private TableColumn<borrowBook, String> borrowBookTable_col_documentID;

    @FXML
    private TableColumn<borrowBook, String> borrowBookTable_col_title;

    @FXML
    private TableView<borrowBook> borrowBook_table;

    @FXML
    private AnchorPane availableMovies_form;

    @FXML
    private Label availableMovies_genre;

    @FXML
    private ImageView availableMovies_imageView;

    @FXML
    private Label availableMovies_movieTitle;

    @FXML
    private Label availableMovies_normalClass_price;

    @FXML
    private Spinner<Integer> availableMovies_normalClass_quantity;

    @FXML
    private Button availableMovies_receiptBtn;

    @FXML
    private Button availableMovies_selectMovie;

    @FXML
    private Label availableMovies_specialClass_price;

    @FXML
    private Spinner<Integer> availableMovies_specialClass_quantity;

    @FXML
    private TableView<itemData> availableMovies_tableView;

    @FXML
    private Label availableMovies_title;
    
    @FXML
    private Label selectBook_BookId;

    @FXML
    private Label availableMovies_total;
    
    @FXML
    private Label additems_title;
    
    @FXML
    private Label additems_category;
    
    @FXML
    private Label additems_aisle_num;

    @FXML
    private Button customers_btn;

    @FXML
    private Button customers_clearBtn;

    @FXML
    private TableColumn<customerData, String> customers_col_dateChecked;

    @FXML
    private TableColumn<customerData, String> customers_col_movieTitle;

    @FXML
    private TableColumn<customerData, String> customers_col_ticketNumber;

    @FXML
    private TableColumn<customerData, String> customers_col_timeChecked;

    @FXML
    private Label customers_dateChecked;

    @FXML
    private Button customers_deleteBtn;

    @FXML
    private AnchorPane customers_form;

    @FXML
    private Label customers_genre;

    @FXML
    private Label customers_movieTitle;

    @FXML
    private TextField customers_search;

    @FXML
    private TableView<customerData> customers_tableView;

    @FXML
    private Label customers_ticketNumber;

    @FXML
    private Label customers_timeChecked;

    @FXML
    private Label dashboard_availableMovies;
    
    @FXML
    private Label dashboard_totalJournals;
    
    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_total;

    @FXML
    private Label dashboard_totalEarnToday;

    @FXML
    private Button editScreening_btn;

    @FXML
    private TableColumn<itemData, String> editScreening_col_current;

    @FXML
    private TableColumn<itemData, String> editScreening_col_duration;

    @FXML
    private TableColumn<itemData, String> editScreening_col_genre;

    @FXML
    private TableColumn<itemData, String> editScreening_col_movieTitle;

    @FXML
    private ComboBox<?> editScreening_current;

    @FXML
    private Button editScreening_deleteBtn;

    @FXML
    private AnchorPane editScreening_form;

    @FXML
    private ImageView editScreening_imageView;

    @FXML
    private TextField editScreening_search;

    @FXML
    private TableView<itemData> editScreening_tableView;

    @FXML
    private Label editScreening_title;

    @FXML
    private Button editScreening_updateBtn;

    @FXML
    private Button minimize;
    
    
    @FXML
    private Button searchBook_btn;

    @FXML
    private TextField searchBook_search;

    @FXML
    private TableView<search> searchBook_table;

    @FXML
    private TableColumn<search, String> searchBook_table_col_docType;

    @FXML
    private TableColumn<search, String> searchBook_table_col_sno;

    @FXML
    private TableColumn<search, String> searchBook_table_col_title;

    @FXML
    private AnchorPane search_form;

    @FXML
    private Button signout;
    
    @FXML
    private Button transaction_btn;

    @FXML
    private AnchorPane transaction_form;

    @FXML
    private TextField transaction_search;

    @FXML
    private TableView<transaction> transaction_table;

    @FXML
    private TableColumn<transaction, String> transaction_table_col_borrowDate;

    @FXML
    private TableColumn<transaction, String> transaction_table_col_documentId;

    @FXML
    private TableColumn<transaction, String> transaction_table_col_returnDate;

    @FXML
    private TableColumn<transaction, String> transaction_table_col_title;

    @FXML
    private TableColumn<transaction, String> transaction_table_col_transactionId;

    @FXML
    private TableColumn<transaction, String> transaction_table_col_transactionType;

    @FXML
    private Label username;
    
	private double x = 0;
	private double y = 0;
	
    // TOols for connection
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;
    
    
    private SpinnerValueFactory<Integer> spinner1;
    private SpinnerValueFactory<Integer> spinner2;
    
    private float price1 = 0;
    private float price2 = 0;
    private float total = 0;
    
    
    
    private int qty1 = 0;
    private int qty2 = 0;
    
    private int ticketSold;
    private double revenueToday;
    private int totalAvmovies;
    private int totalBooks;
    private int totalMagazines; 
    private int totalThesis;
    
    private int totalJournals;
    private String bookTitle;
    private Integer docID;
    private Date borrowDate;
    
    
    public void selectAvailableBook() {
    	
		borrowBook BD = borrowBook_table.getSelectionModel().getSelectedItem();
		int index = borrowBook_table.getSelectionModel().getSelectedIndex();
		
		if((index - 1) < -1) {
			return;
		}
		bookTitle = BD.getTitle();
		docID = BD.getDocId();
		availableMovies_movieTitle.setText(BD.getTitle());
		availableMovies_date.setText(String.valueOf(BD.getDocId()));
    	
    }
    
    public void selectBook() {
		Alert alert;
		
			availableMovies_title.setText(bookTitle);
			selectBook_BookId.setText(String.valueOf(docID));
			
			// after selecting movie clear text
			
			availableMovies_movieTitle.setText("");
			availableMovies_date.setText("");
    }
    
    
    public void borrowBook() {   	
    	String transactionID = "SELECT count(*) FROM transactional_details";
    	
    	connect = Database.connectDB();
    	Integer ID = 0;
    	try {
    		prepare = connect.prepareStatement(transactionID);
		    result=prepare.executeQuery();
    		
		    if(result.next()) {
		    	ID = result.getInt("count");
		    	
		    	
		    	Date date = new Date();
		    	
		    	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		    	
		    	
		    	int randomNum = ThreadLocalRandom.current().nextInt(10, 1000 + 1);
		    	
		    	String sql = "Insert into transactional_details (transactionid,user_id,doc_id,title,transactions_type,borrow_date,return_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
		    	try {
		    		prepare = connect.prepareStatement(sql);
		    		
		    		prepare.setInt(1,  ID + randomNum);
		    		prepare.setString(2, getData.username);
		    		prepare.setInt(3, docID);
		    		prepare.setString(4, bookTitle);
		    		prepare.setString(5,  "Borrow");
		    		prepare.setDate(6, sqlDate);
		    		prepare.setDate(7, sqlDate);
				    prepare.execute();
				    
				    Alert alert;
				    
	    			alert = new Alert(AlertType.INFORMATION);
	    			alert.setTitle("Success");
	    			alert.setHeaderText(null);
	    			alert.setContentText("Data successfully borrowed successfully");
	    			alert.showAndWait();
		    		
		    		
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	
		    }
		    else {
		    	System.out.println("No data found");
		    }
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
 
    }
    
    
    
    public void returnBook() {   	
    	String transactionID = "SELECT count(*) FROM transactional_details";
    	
    	connect = Database.connectDB();
    	Integer ID = 0;
    	try {
    		prepare = connect.prepareStatement(transactionID);
		    result=prepare.executeQuery();
    		
		    if(result.next()) {
		    	ID = result.getInt("count");
		    	
		    	
		    	String BD = "SELECT * FROM transactional_details WHERE doc_id='" + docID + "'";
		    	prepare = connect.prepareStatement(BD);
		    	
		    	try {
		    		result = prepare.executeQuery();
		    		
		    		while(result.next()) {
		    			borrowDate = result.getDate("borrow_date");
		    		}
		    		System.out.println(String.valueOf(borrowDate) + "wdjhbdjha");
		    	}catch(Exception e){
		    		e.printStackTrace();
		    	}
		    	
		    	Date date = new Date();
		    	
		    	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		    	
		    	int randomNum = ThreadLocalRandom.current().nextInt(10, 1000 + 1);
		    	
		    	String sql = "Insert into transactional_details (transactionid,user_id,doc_id,title,transactions_type,borrow_date,return_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
		    	try {
		    		prepare = connect.prepareStatement(sql);
		    		
		    		prepare.setInt(1,  ID + randomNum);
		    		prepare.setString(2, getData.username);
		    		prepare.setInt(3, docID);
		    		prepare.setString(4, bookTitle);
		    		prepare.setString(5,  "Return");
		    		prepare.setDate(6, (java.sql.Date) borrowDate);
		    		prepare.setDate(7, sqlDate);
				    prepare.execute();
				    
				    Alert alert;
				    
	    			alert = new Alert(AlertType.INFORMATION);
	    			alert.setTitle("Success");
	    			alert.setHeaderText(null);
	    			alert.setContentText("Data successfully returned successfully");
	    			alert.showAndWait();
		    		
		    		
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		    	
		    }
		    else {
		    	System.out.println("No data found");
		    }
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
 
    }
    
    
    
    public void initialiseBorrowBooktable() {
    	
		ObservableList<borrowBook> bookL = FXCollections.observableArrayList();
		borrowBook BB;
		String sql = "SELECT * FROM keywords";
		connect = Database.connectDB();
		try {
			prepare = connect.prepareStatement(sql);
			//prepare.setString(1, searchBook_search.getText());
			result=prepare.executeQuery();
			
			while(result.next()) {
    			BB = new borrowBook(result.getInt("doc_id"), result.getString("keyword"));
    			bookL.add(BB);
    		}
			borrowBookTable_col_documentID.setCellValueFactory(new PropertyValueFactory<>("docId"));
			borrowBookTable_col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
			
			borrowBook_table.setItems(bookL);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void modifyData() {
    	Alert alert;
    	String username= getData.username;
    	String user_type="";
    	
    	String sql1="select user_type from users where user_id='"+username+"'";
    	connect = Database.connectDB();
    	try {
    		prepare = connect.prepareStatement(sql1);
		    result=prepare.executeQuery();
		    if(result.next()) {
		    	System.out.println("tesss");
		    	user_type= result.getString("user_type");
		    }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	if(user_type.equalsIgnoreCase("Librarian")){
    		int num_cp= Integer.parseInt(addBooks_numCopies.getText());
    		int docId= Integer.parseInt(addBooks_id.getText());
    		//System.out.println(docId);
    		
    		//String sql2 = "delete from documents where doc_id="+docId;
    		
    		connect = Database.connectDB();
    		
    		
        	
        	
        	try {
        		
//        		prepare = connect.prepareStatement(sql2);
//        		//prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
//        		prepare.execute();
        		String category = addBooks_docType.getText();
        		if(category.equalsIgnoreCase("Book")) {
        			String sql3 = "update Books set copies_available =(?) where doc_id="+docId;
        			//String sql4 = "delete from Keywords where doc_id="+docId;
        			
        			prepare = connect.prepareStatement(sql3);
            		prepare.setInt(1,num_cp);
            		prepare.execute();
            		
            		
            		
            		
        		}else if(category.equalsIgnoreCase("Journal Article")) {
        			String sql3 = "update Journal_Article set copies_available =(?) where doc_id="+docId;
        			
        			prepare = connect.prepareStatement(sql3);
        			prepare.setInt(1,num_cp);
            		prepare.execute();
            		
            		
        		}else if(category.equalsIgnoreCase("Thesis")) {
        			String sql3 = "update Thesis set copies_available =(?) where doc_id="+docId;
        			
        			prepare = connect.prepareStatement(sql3);
        			prepare.setInt(1,num_cp);
            		prepare.execute();
        		}else {
        			System.out.println("Magazine");
        			String sql3 = "update Magazines set copies_available =(?) where doc_id="+docId;
        			
        			prepare = connect.prepareStatement(sql3);
        			prepare.setInt(1,num_cp);
            		prepare.execute();
        		}
        		
        		
        		
        		
        		
    			alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Success");
    			alert.setHeaderText(null);
    			alert.setContentText("Data successfully Modified");
    			alert.showAndWait();
        		
        		
        	}catch(Exception e) {
        		e.printStackTrace();
        	}

    	}else {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText(null);
			alert.setContentText("You dont have proper authorization");
			alert.showAndWait();
    	}

    	
    }
    
    public void deleteAddBooks() throws SQLException {
    	Alert alert;
    	String username= getData.username;
    	String user_type="";
    	
    	String sql1="select user_type from users where user_id='"+username+"'";
    	connect = Database.connectDB();
    	try {
    		prepare = connect.prepareStatement(sql1);
		    result=prepare.executeQuery();
		    if(result.next()) {
		    	System.out.println("tesss");
		    	user_type= result.getString("user_type");
		    }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	if(user_type.equalsIgnoreCase("Librarian")){
    		int docId= Integer.parseInt(addBooks_id.getText());
    		System.out.println(docId);
    		
    		String sql2 = "delete from documents where doc_id="+docId;
    		
    		connect = Database.connectDB();
    		
    		
    		
        	
        	
        	
        	try {
        		
//        		prepare = connect.prepareStatement(sql2);
//        		//prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
//        		prepare.execute();
        		String category = addBooks_docType.getText();
        		if(category.equalsIgnoreCase("Book")) {
        			String sql3 = "delete from Books where doc_id="+docId;
        			String sql4 = "delete from Keywords where doc_id="+docId;
        			
        			prepare = connect.prepareStatement(sql3);
            		//prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.execute();
            		
            		prepare = connect.prepareStatement(sql4);
            		//prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.execute();
            		String sql5 = "delete from Authors where doc_id="+docId;
            		prepare = connect.prepareStatement(sql5);
            		//prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.execute();
            		
            		
            		
        		}else if(category.equalsIgnoreCase("Journal Article")) {
        			String sql3 = "delete from Journal_Article where doc_id="+docId;
        			String sql4 = "delete from Keywords where doc_id="+docId;
        			prepare = connect.prepareStatement(sql3);
            		//prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.execute();
            		
            		prepare = connect.prepareStatement(sql4);
            		//prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.execute();
            		
        		}else if(category.equalsIgnoreCase("Thesis")) {
        			String sql3 = "delete from Thesis where doc_id="+docId;
        			String sql4 = "delete from Keywords where doc_id="+docId;
        			prepare = connect.prepareStatement(sql3);
            		
            		prepare.execute();
            		
            		prepare = connect.prepareStatement(sql4);
            		//prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.execute();
        		}else {
        			System.out.println("Magazine");
        			String sql3 = "delete from Magazines where doc_id="+docId;
        			String sql4 = "delete from Keywords where doc_id="+docId;
        			prepare = connect.prepareStatement(sql3);
            		prepare.execute();
            		
            		prepare = connect.prepareStatement(sql4);
            		prepare.execute();
        		}
        		
        		prepare = connect.prepareStatement(sql2);
//        		//prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
        		prepare.execute();
        		
        		
        		
    			alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Success");
    			alert.setHeaderText(null);
    			alert.setContentText("Data successfully Deleted");
    			alert.showAndWait();
        		
        		
        	}catch(Exception e) {
        		e.printStackTrace();
        	}

    	}else {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText(null);
			alert.setContentText("You dont have proper authorization");
			alert.showAndWait();
    	}

    	
    }
    
    
    
    
    public void insertAddBooks() {
    	
    	Alert alert;
    	String username= getData.username;
    	String user_type="";
    	
    	String sql1="select user_type from users where user_id='"+username+"'";
    	connect = Database.connectDB();
    	try {
    		prepare = connect.prepareStatement(sql1);
		    result=prepare.executeQuery();
		    if(result.next()) {
		    	System.out.println("tesss");
		    	user_type= result.getString("user_type");
		    }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	if(user_type.equalsIgnoreCase("Librarian")){
    		String sql2 = "INSERT INTO documents (doc_id,doc_type,aisle_num) values (?,?,?)";
        	
        	connect = Database.connectDB();
        	
        	try {
        		
        		prepare = connect.prepareStatement(sql2);
        		prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
        		prepare.setString(2, addBooks_docType.getText());
        		prepare.setString(3, addBooks_aisleNumber.getText());
        		prepare.execute();
        		String category = addBooks_docType.getText();
        		if(category.equalsIgnoreCase("Book")) {
        			String sql3 = "INSERT INTO books (doc_id,title,Copies_available) values (?,?,?)";
        			String sql4 = "INSERT INTO keywords (doc_id,keyword) values (?,?)";
        			prepare = connect.prepareStatement(sql3);
            		prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.setString(2, addBooks_title.getText());
            		prepare.setInt(3, Integer.parseInt(addBooks_numCopies.getText()));
            		prepare.execute();
            		
            		prepare = connect.prepareStatement(sql4);
            		prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.setString(2, addBooks_title.getText());
            		prepare.execute();
            		
        		}else if(category.equalsIgnoreCase("Journal Article")) {
        			String sql3 = "INSERT INTO journal_articles (doc_id,title,Copies_available) values (?,?,?)";
        			String sql4 = "INSERT INTO keywords (doc_id,keyword) values (?,?)";
        			prepare = connect.prepareStatement(sql3);
            		prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.setString(2, addBooks_title.getText());
            		prepare.setInt(3, Integer.parseInt(addBooks_numCopies.getText()));
            		prepare.execute();
            		
            		prepare = connect.prepareStatement(sql4);
            		prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.setString(2, addBooks_title.getText());
            		prepare.execute();
            		
        		}else if(category.equalsIgnoreCase("Thesis")) {
        			String sql3 = "INSERT INTO thesis (doc_id,thesis_name) values (?,?)";
        			String sql4 = "INSERT INTO keywords (doc_id,keyword) values (?,?)";
        			prepare = connect.prepareStatement(sql3);
            		prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.setString(2, addBooks_title.getText());
            		prepare.execute();
            		
            		prepare = connect.prepareStatement(sql4);
            		prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.setString(2, addBooks_title.getText());
            		prepare.execute();
        		}else {
        			String sql3 = "INSERT INTO Magazines (doc_id,title,Copies_available) values (?,?,?)";
        			String sql4 = "INSERT INTO keywords (doc_id,keyword) values (?,?)";
        			prepare = connect.prepareStatement(sql3);
            		prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.setString(2, addBooks_title.getText());
            		prepare.setInt(3, Integer.parseInt(addBooks_numCopies.getText()));
            		prepare.execute();
            		
            		prepare = connect.prepareStatement(sql4);
            		prepare.setInt(1, Integer.parseInt(addBooks_id.getText()));
            		prepare.setString(2, addBooks_title.getText());
            		prepare.execute();
        		}
        		
    			alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Success");
    			alert.setHeaderText(null);
    			alert.setContentText("Data successfully inserted");
    			alert.showAndWait();
        		
        		
        	}catch(Exception e) {
        		e.printStackTrace();
        	}

    	}else {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText(null);
			alert.setContentText("You dont have proper authorization");
			alert.showAndWait();
    	}
    	
    	    	
    }
    
    
    public void getTotalJournals() {
    	
    	String sql = "SELECT count(*) FROM JOURNAL_ARTICLES";
    	
    	connect = Database.connectDB();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		if(result.next()) {
    			totalJournals = result.getInt("count");
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }
    
    public void showTotalJournalsDashboard() {
    	getTotalJournals();
    	
    	dashboard_totalJournals.setText(String.valueOf(totalJournals));
    }
    
    
    public void getTotalThesis() {
    	
    	String sql = "SELECT count(*) FROM THESIS";
    	
    	connect = Database.connectDB();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		if(result.next()) {
    			totalThesis = result.getInt("count");
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }
    
    public void showTotalThesisDashboard() {
    	getTotalThesis();
    	
    	dashboard_availableMovies.setText(String.valueOf(totalThesis));
    }
    
    
    public void getTotalMagazines() {
    	
    	String sql = "SELECT count(*) FROM MAGAZINES";
    	
    	connect = Database.connectDB();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		if(result.next()) {
    			totalMagazines = result.getInt("count");
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }
    
    public void showTotalMagazinesDashboard() {
    	getTotalMagazines();
    	
    	dashboard_totalEarnToday.setText(String.valueOf(totalMagazines));
    }
    
    
    public void getTotalBooks() {
    	
    	String sql = "SELECT count(*) FROM BOOKS";
    	
    	connect = Database.connectDB();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		if(result.next()) {
    			totalBooks = result.getInt("count");
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public void showTotalBooksDashboard() {
    	getTotalBooks();
    	
    	dashboard_total.setText(String.valueOf(totalBooks));
    }
    
    public void totalAvMovies() {
    	
    	String sql = "SELECT count(id) FROM itemData WHERE current = 'Available'";
    	
    	connect = Database.connectDB();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		if(result.next()) {
    			totalAvmovies = result.getInt("COUNT(id)");
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    	
    }
    
    public void displayTotalAvaMovies() {
    	totalAvMovies();
    	dashboard_availableMovies.setText(String.valueOf(totalAvmovies));
    }
    
    public void totalalRevenue() {
    	Date date = new Date();
    	
    	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    	
    	String sql = "SELECT sum(total) FROM customer where date = '" + String.valueOf(sqlDate) + "' ";
    	
    	connect = Database.connectDB();
    	
    	try{
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		if(result.next()) {
    			revenueToday = result.getDouble("SUM(total)");
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public void displayTodayRevenue() {
    	totalalRevenue();
    	dashboard_totalEarnToday.setText(String.valueOf(revenueToday));
    }
    
    
    
    public void countTicket() {
    	
    	String sql = "SELECT count(id) FROM customer";
    	
    	connect = Database.connectDB();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		if(result.next()) {
    			System.out.println("resultt");
    			getData.ticket = result.getInt("count(id)");
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    
    public void displayTotalTickets() {
    	countTicket();
    	dashboard_total.setText(String.valueOf(getData.ticket));
    }
   
    
    
    public void selectCustomerList() {
    	
		customerData CD = customers_tableView.getSelectionModel().getSelectedItem();
		int index = customers_tableView.getSelectionModel().getSelectedIndex();
		
		if((index - 1) < -1) {
			return;
		}
		
		customers_ticketNumber.setText(String.valueOf(CD.getId()));
		customers_movieTitle.setText(CD.getTitle());
		customers_dateChecked.setText(String.valueOf(CD.getDate()));
		customers_timeChecked.setText(String.valueOf(CD.getTime()));
    	
    }
    
    public ObservableList<customerData> customerList(){
    	
    	ObservableList<customerData> customerL = FXCollections.observableArrayList();
    	
    	String sql = "SELECT * FROM customer";
    	connect = Database.connectDB();
    	
    	try {
    		
    		customerData CD;
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		while(result.next()) {
    			CD = new customerData(result.getInt("id"), result.getString("type"), result.getString("title"), result.getInt("quantity"), result.getDouble("total"),
    					result.getDate("date"), result.getTime("time"));
    			
    			customerL.add(CD);
    		}
    		
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return customerL;
    }
    
    
    private ObservableList<customerData> cList;
    
    public void showCustomerList() {
    	cList = customerList();
    	
    	
    	customers_col_ticketNumber.setCellValueFactory(new PropertyValueFactory<>("id"));
    	customers_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    	customers_col_dateChecked.setCellValueFactory(new PropertyValueFactory<>("date"));
    	customers_col_timeChecked.setCellValueFactory(new PropertyValueFactory<>("time"));
    	
    	customers_tableView.setItems(cList);
    	
    	
    }
    
    public void clearCustomerSelection() {
    	customers_ticketNumber.setText("");
    	customers_movieTitle.setText("");
    	customers_dateChecked.setText("");
    	customers_timeChecked.setText("");
    }
    
    public void refundCustomerTicker() {
    	
    	Alert alert;
    	
    	if(customers_ticketNumber.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select item first");
			alert.showAndWait();
    	}
    	else {
    		String sql = "DELETE FROM customer where id = '" + customers_ticketNumber.getText() + "'";
    		
    		connect = Database.connectDB();
    		
    		try {
    			
				alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message!!");
				
				alert.setHeaderText(null);
				alert.setContentText("Do you really want to refund item for '" + customers_movieTitle.getText() + "' ? ");
    			
    			Optional<ButtonType> option = alert.showAndWait();
    			
    			if(ButtonType.OK.equals(option.get())) {
    				
        			statement = connect.createStatement();
        			statement.executeUpdate(sql);
        			
					alert = new Alert(AlertType.INFORMATION);
	    			alert.setTitle("Success");
	    			alert.setHeaderText(null);
	    			alert.setContentText("Item successfully refunded");
	    			
	    			alert.showAndWait();
	    			
	    			showCustomerList();
	    			clearCustomerSelection();
    				
    			} else {
    				return;
    			}
    			
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    }
    
    
   
    
    
    
    
    public void buy() {
    	
    	String sql = "INSERT INTO customer (type,title,quantity,total,date,time) VALUES (?,?,?,?,?,?)";
    	
    	connect = Database.connectDB();
    	String type = "";
    	if(price1>0 && price2 == 0) {
    		type = "Special Packing";
    	}else if(price1==0 && price2>0) {
    		type="Normal Packing";
    	}else if(price1>0 && price2>0) {
    		type="Special & Normal Packing";
    	}
    	
    	Date date = new Date();
    	java.sql.Date setDate = new java.sql.Date(date.getTime());
    	
    	LocalTime lt = LocalTime.now();
    	
    	Time time = Time.valueOf(lt);
    	
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		prepare.setString(1, type);
    		prepare.setString(2, availableMovies_title.getText());
    		prepare.setString(3,  String.valueOf(qty1 + qty2));
    		prepare.setString(4, String.valueOf(total));
    		prepare.setString(5, String.valueOf(setDate));
    		prepare.setString(6, String.valueOf(time));
    		
    		
    		Alert alert;
    		
    		if(availableMovies_imageView.getImage() == null || availableMovies_title.getText().isEmpty()) {
    			
    			alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error Message");
    			alert.setHeaderText(null);
    			alert.setContentText("Please select item first");
    			alert.showAndWait();
    			
    		}
    		else if(price1 == 0 && price2 == 0) {
    			alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error Message");
    			alert.setHeaderText(null);
    			alert.setContentText("Please select quantity of item first");
    			alert.showAndWait();
    		}else {
    			prepare.executeUpdate();
    			
    			alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Success");
    			alert.setHeaderText(null);
    			alert.setContentText("Your item has been purchased");
    			alert.showAndWait();
    			
    			
    			String sql1 = "SELECT * FROM customer";
    			prepare = connect.prepareStatement(sql1);
    			result = prepare.executeQuery();
    			int num = 0;
    			while(result.next()) {
    				num = result.getInt("id");
    			}
    			System.out.println(num + "this isss");
    			String sql2 = "INSERT INTO customer_info (customer_id,type,total,itemTitle) VALUES (?,?,?,?)";
    			
    			prepare = connect.prepareStatement(sql2);
    			
    			prepare.setString(1, String.valueOf(num));
    			prepare.setString(2, type);
    			prepare.setString(3,  String.valueOf(total));
    			prepare.setString(4, availableMovies_title.getText());
    			
    			prepare.execute();
    			
    			clearPurchaseInfo();
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public void clearPurchaseInfo() {
    
    	spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
    	spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
    	
    	
    	availableMovies_specialClass_quantity.setValueFactory(spinner1);
    	availableMovies_normalClass_quantity.setValueFactory(spinner2);
    	
    	availableMovies_specialClass_price.setText("$0.0");
    	availableMovies_normalClass_price.setText("$0.0");
    	
    	availableMovies_imageView.setImage(null);
    	
    	availableMovies_total.setText("$0.0");
    	
    	
    	
    }
    
    
    public void showSpinnerValue() {
    	spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
    	spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
    	
    	availableMovies_specialClass_quantity.setValueFactory(spinner1);
    	availableMovies_normalClass_quantity.setValueFactory(spinner2);
    }
    
    public void getSpinnerValue() {
    	qty1 = availableMovies_specialClass_quantity.getValue();
    	qty2 = availableMovies_normalClass_quantity.getValue();
    	
    	
    	price1 = qty1 * 20;
    	price2 = qty2 * 10;
    	
    	total = price1 + price2;
    	
    	availableMovies_specialClass_price.setText("$" + String.valueOf(price1));
    	availableMovies_normalClass_price.setText("$" + String.valueOf(price2));
    	
    	availableMovies_total.setText("$" + String.valueOf(total));
    }
    
    
    
    // Available movies form
    
    public ObservableList<itemData> availableMovieList(){
    	ObservableList<itemData> listAvMovie = FXCollections.observableArrayList();
    	
    	String sql = "SELECT * FROM itemData WHERE current = 'Available'";
    	
    	connect = Database.connectDB();
    	
    	try {
    		
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		itemData movD;
    		
    		while(result.next()) {
    			movD = new itemData(result.getInt("id"), result.getString("itemTitle"), result.getString("category"), result.getString("image"), result.getString("price"), result.getDate("date"), result.getString("current"));
    			listAvMovie.add(movD);
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return listAvMovie;
    }
    
    
    private ObservableList<itemData> availableMovieList;
    
    public void showAvailableMovies() {
    	availableMovieList = availableMovieList();
    	
    	availableMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    	availableMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("category"));
    	availableMovies_col_showingDate.setCellValueFactory(new PropertyValueFactory<>("price"));
    	
    	availableMovies_tableView.setItems(availableMovieList);
    }
    
    
	public void selectAvailableMovie() {
		itemData movD = availableMovies_tableView.getSelectionModel().getSelectedItem();
		int index = availableMovies_tableView.getSelectionModel().getSelectedIndex();
		
		if((index - 1) < -1) {
			return;
		}
		
		
		getData.path = movD.getImage();
		getData.movieId = movD.getId();
		
		availableMovies_movieTitle.setText(movD.getTitle());
		availableMovies_genre.setText(movD.getCategory());
		availableMovies_date.setText(String.valueOf(movD.getPrice()));
		
		getData.path = movD.getImage();
		getData.title = movD.getTitle();
		
	}
	
	
	public void selectMovie() {
		
		Alert alert;
		
		if(availableMovies_movieTitle.getText().isEmpty() || availableMovies_date.getText().isEmpty() || availableMovies_genre.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select item first");
			alert.showAndWait();
		} else {
			String filePath = "file://" + getData.path;
			
			image = new Image(filePath, 150, 168, false, true);
			availableMovies_imageView.setImage(image);			
			availableMovies_title.setText(getData.title);
			
			// after selecting movie clear text
			
			availableMovies_movieTitle.setText("");
			availableMovies_genre.setText("");
			availableMovies_date.setText("");
		}
		
	}
    
    // current list
    
    private String[] currentList = {"Available", "Not Available"};
    
    public void comboBox() {
    	List<String> listCurrent = new ArrayList<>();
    	
    	for(String data:currentList) {
    		listCurrent.add(data);
    	}
    	
    	ObservableList listC = FXCollections.observableArrayList(listCurrent);
    	
    	editScreening_current.setItems(listC);
    }
    
    // screening
    
    public ObservableList<itemData> editScreeningList(){
    	ObservableList<itemData> editSList = FXCollections.observableArrayList();
    	
    	
    	connect = Database.connectDB();
    	String sql = "SELECT * FROM itemData";
    	try {
    		prepare = connect.prepareStatement(sql);
    		result = prepare.executeQuery();
    		
    		
    		itemData movD;
    		while(result.next()) {
    			movD = new itemData(result.getInt("id"), result.getString("itemTitle"), result.getString("category"), result.getString("image"), result.getString("price"), result.getDate("date"), result.getString("current"));
    			
    			editSList.add(movD);
    		}
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return editSList;
    }
    
    
    private ObservableList<itemData> editScreeningL;
    
    public void showEditScreening() {
    	editScreeningL = editScreeningList();
    	
    	editScreening_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    	editScreening_col_genre.setCellValueFactory(new PropertyValueFactory<>("category"));
    	editScreening_col_duration.setCellValueFactory(new PropertyValueFactory<>("price"));
    	editScreening_col_current.setCellValueFactory(new PropertyValueFactory<>("current"));
    	
    	editScreening_tableView.setItems(editScreeningL);
    }
    
    
    public void updateEditScreening() {
    	
    	String sql = "UPDATE itemData SET current ='" + editScreening_current.getSelectionModel().getSelectedItem() + "' WHERE itemTitle = '" + editScreening_title.getText() + "'";
    	
    	connect = Database.connectDB();
    	
    	try {
    		statement = connect.createStatement();
    		
    		
    		Alert alert;
    		if(editScreening_title.getText().isEmpty() || editScreening_imageView.getImage() == null || editScreening_current.getSelectionModel().isEmpty()) {
    			
				alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error");
    			alert.setHeaderText(null);
    			alert.setContentText("Please fill all blank fields/Select item");
    			
    			alert.showAndWait();
    			
    		}else {
    			statement.executeUpdate(sql);
    			
    			
				alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Success");
    			alert.setHeaderText(null);
    			alert.setContentText("Item Availability updated");
    			
    			alert.showAndWait();
    			showEditScreening();
    			clearEditScreening();
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    }
    
    
    public void clearEditScreening() {
    	editScreening_imageView.setImage(null);
    	editScreening_title.setText("");
//    	editScreening_current.setSelectionModel(null);
    	
    }
    
    public void selectEditScreening() {
    	itemData movD = editScreening_tableView.getSelectionModel().getSelectedItem();
    	
		int index = editScreening_tableView.getSelectionModel().getSelectedIndex();
		
		if((index - 1) < -1) {
			return;
		}
		
		editScreening_title.setText(movD.getTitle());
		
		String filePath = "file://" + movD.getImage();
		
		image = new Image(filePath, 141, 178, false, true);
		editScreening_imageView.setImage(image);		
    }
    
    
	// movie list
	
	public ObservableList<itemData> addMovieList(){
		ObservableList<itemData> listData = FXCollections.observableArrayList();
		
		String sql = "SELECT * FROM itemData";
		connect = Database.connectDB();
		
		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			itemData movD;
			while(result.next()) {
				movD = new itemData(result.getInt("id"), result.getString("itemTitle"), result.getString("category"), result.getString("image"), result.getString("price"), result.getDate("date"), result.getString("current"));
				listData.add(movD);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listData;
		
	}
	
	// display movies in DB on table
	public void showAddmoviesList() {
		listAddMovies = addMovieList();
		
		addMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
		addMovie_col_genre.setCellValueFactory(new PropertyValueFactory<>("category"));
		addMovies_col_duration.setCellValueFactory(new PropertyValueFactory<>("price"));
		addMovies_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));		
		addMovies_tableView.setItems(listAddMovies);
		
	}
    
	
	
	private ObservableList<itemData> listAddMovies;
	
	
	
	// Search movie
	
	public void searchAddMovie() {
		
		FilteredList<itemData> filter = new FilteredList<>(listAddMovies, e->true);
		
		addMovies_search.textProperty().addListener((observable, oldValue, newValue) -> {
			filter.setPredicate(predicateMoviesData -> {
				if(newValue.isEmpty() || newValue == null) {
					return true;
				}
								
				String keySearch = newValue.toLowerCase();
				
				System.out.println(keySearch + "wdkmflwfmk");
				
				if(predicateMoviesData.getTitle().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getCategory().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getPrice().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getDate().toString().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getCurrent().toString().contains(keySearch)) {
					return true;
				}
				
				return false;
			});
			
			SortedList<itemData> sortData = new SortedList<>(filter);
			sortData.comparatorProperty().bind(addMovies_tableView.comparatorProperty());
			System.out.println(sortData);
			addMovies_tableView.setItems(sortData);
		});
		
	}
	
	
	
	// search screening
	public void searchEditScreening() {
		FilteredList<itemData> filter = new FilteredList<>(editScreeningL, e->true);
		
		editScreening_search.textProperty().addListener((observable, oldValue, newValue) -> {
			filter.setPredicate(predicateMoviesData -> {
				if(newValue.isEmpty() || newValue == null) {
					return true;
				}
				
				String keySearch = newValue.toLowerCase();
				
				if(predicateMoviesData.getTitle().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getCategory().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getPrice().toLowerCase().contains(keySearch)) {
					return true;
				}else if(predicateMoviesData.getCurrent().toString().contains(keySearch)) {
					return true;
				}
				
				return false;
			});
			
			SortedList<itemData> sortData = new SortedList<>(filter);
			sortData.comparatorProperty().bind(editScreening_tableView.comparatorProperty());
			
			editScreening_tableView.setItems(sortData);
			
		});
	}
	

	
	public void selectAddMoviesList() {
		itemData movD = addMovies_tableView.getSelectionModel().getSelectedItem();
		int index = addMovies_tableView.getSelectionModel().getSelectedIndex();
		
		if((index - 1) < -1) {
			return;
		}
		
		
		getData.path = movD.getImage();
		getData.movieId = movD.getId();
		
		addMovies_movieTitle.setText(movD.getTitle());
		addMovies_genre.setText(movD.getCategory());
		adMovies_duration.setText(movD.getPrice());
		
		String movDate = String.valueOf(movD.getDate());
		
//		addMovies_date.setValue(movD.getDate());
		
		String filePath = "file://" + movD.getImage();
		
		image = new Image(filePath, 141, 178, false, true);
		adMovies_imageView.setImage(image);
		
		addMovies_date.setValue(movD.getDate().toLocalDate());
		
	}
	
	
	public void importImage() {
		
		
		FileChooser open = new FileChooser();
		open.setTitle("Open movie cover image file");
//		open.getExtensionFilters().add(new ExtensionFilter("Image File", "png", "jpg"));
		
		Stage stage = (Stage)addMovies_form.getScene().getWindow();
		
		File file = open.showOpenDialog(stage);
		
		if(file != null) {
			image = new Image(file.toURI().toString(), 141, 178, false, true);
			adMovies_imageView.setImage(image);
			
			getData.path = file.getAbsolutePath();
		}
		
		
	}
	
	
	
	public void movieId() {
		
		String sql = "SELECT count(id) FROM itemData";
		
		connect = Database.connectDB();
		
		try {
			
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			
			if(result.next()) {
				getData.movieId = result.getInt("count(id)");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void insertAddMovies() {
		
		
		
		String movieTitle = "SELECT * FROM itemData WHERE itemTitle = '" + addMovies_movieTitle.getText() + "'";
		connect = Database.connectDB();
		
		Alert alert;
		
		try {
			
			statement = connect.createStatement();
			result = statement.executeQuery(movieTitle);
			
			if(result.next()) {
				alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error");
    			alert.setHeaderText(null);
    			alert.setContentText(addMovies_movieTitle.getText() + " was already in database");
    			
    			alert.showAndWait();
			}else {
				
				if(addMovies_movieTitle.getText().isEmpty() || addMovies_genre.getText().isEmpty() || adMovies_duration.getText().isEmpty()
						|| adMovies_imageView.getImage() == null || addMovies_date.getValue() == null) {
					alert = new Alert(AlertType.ERROR);
	    			alert.setTitle("Error");
	    			alert.setHeaderText(null);
	    			alert.setContentText("Please fill in the blank fields...");
	    			
	    			alert.showAndWait();
				}else {
					String sql = "INSERT INTO itemData (id,itemTitle,category,price,image,date,current) VALUES (?,?,?,?,?,?,?)";
					
					
					// get image path if all fields are valid
					String imagePath = getData.path;
					
					movieId();
					
					String mId = String.valueOf(getData.movieId + 1);
					
					// prepare sql statement
					prepare = connect.prepareStatement(sql);
					prepare.setString(1, mId);
					prepare.setString(2, addMovies_movieTitle.getText());
					prepare.setString(3, addMovies_genre.getText());
					prepare.setString(4, adMovies_duration.getText());
					prepare.setString(5, imagePath);
					prepare.setString(6, String.valueOf(addMovies_date.getValue()));
					prepare.setString(7,  "Available");
					
					// insert data in table
					
					prepare.execute();
					
					alert = new Alert(AlertType.INFORMATION);
	    			alert.setTitle("Success");
	    			alert.setHeaderText(null);
	    			alert.setContentText("Item successfully added in database");
	    			
	    			alert.showAndWait();
	    			
	    			clearAddMoviesList();
	    			showAddmoviesList();
	    			
				}
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addItems() {
		String sql = "INSERT INTO Documents (doc_id,doc_type,Aisle_num) VALUES (?,?,?)";
		String category= additems_category.getText();
		connect = Database.connectDB();
		
		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, additems_title.getText());
			prepare.setString(2, additems_category.getText());
			prepare.setString(3, additems_aisle_num.getText());
			prepare.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void searchItems() {
		ObservableList<search> searchL = FXCollections.observableArrayList();
		search search;
		String keyword=searchBook_search.getText();
		String sql = "select documents.doc_id, doc_type, keyword from documents join keywords using (doc_id) where keyword like '%"+keyword+"%'";
		connect = Database.connectDB();
//		System.out.println(searchBook_search.getText() + "asjhdbajshdbckajs");
		try {
			prepare = connect.prepareStatement(sql);
			//prepare.setString(1, searchBook_search.getText());
			result=prepare.executeQuery();
			
			while(result.next()) {
    			search = new search(result.getInt("doc_id"), result.getString("doc_type"), result.getString("keyword"));
    			searchL.add(search);
    		}
			searchBook_table_col_sno.setCellValueFactory(new PropertyValueFactory<>("doc_id"));
			searchBook_table_col_title.setCellValueFactory(new PropertyValueFactory<>("docType"));
			searchBook_table_col_docType.setCellValueFactory(new PropertyValueFactory<>("docTitle"));
			
			searchBook_table.setItems(searchL);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void searchTransaction() {
		ObservableList<transaction> transactionL = FXCollections.observableArrayList();
		String id=transaction_search.getText();
		String sql = "select * from transactional_details where user_id = '"+id+"'";
		connect = Database.connectDB();
//		System.out.println(searchBook_search.getText() + "asjhdbajshdbckajs");
		try {
			prepare = connect.prepareStatement(sql);
			//prepare.setString(1, searchBook_search.getText());
			result=prepare.executeQuery();
			
			transaction transactionItem;
			while(result.next()) {
				transactionItem = new transaction(result.getInt("transactionid"), result.getInt("doc_id"), result.getString("title"),
						result.getString("transactions_type"), result.getDate("borrow_date"), result.getDate("return_date"));
				transactionL.add(transactionItem);
    		}
			transaction_table_col_transactionId.setCellValueFactory(new PropertyValueFactory<>("transaction_id"));
			transaction_table_col_documentId.setCellValueFactory(new PropertyValueFactory<>("doc_id"));
			transaction_table_col_title.setCellValueFactory(new PropertyValueFactory<>("docTitle"));
			transaction_table_col_transactionType.setCellValueFactory(new PropertyValueFactory<>("transactionType"));
			transaction_table_col_borrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
			transaction_table_col_returnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
			
			transaction_table.setItems(transactionL);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void updateMovies() {
		String url = getData.path;
		
		String updateSql = "UPDATE itemData SET itemTitle = '" + addMovies_movieTitle.getText() + "', category = '" + addMovies_genre.getText() + "', price = '" + adMovies_duration.getText() + "', image = '" + url + "', date = '" + addMovies_date.getValue() + "' WHERE id = '" + String.valueOf(getData.movieId) + "' ";
		
		connect = Database.connectDB();
		
		try {
			
			statement = connect.createStatement();
			
			Alert alert;
			
			if(addMovies_movieTitle.getText().isEmpty() || addMovies_genre.getText().isEmpty() || adMovies_duration.getText().isEmpty()
					|| adMovies_imageView.getImage() == null || addMovies_date.getValue() == null) {
				
				alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error");
    			alert.setHeaderText(null);
    			alert.setContentText("Please select the item to update");
    			
    			alert.showAndWait();
				
			}else {
				
				statement.executeUpdate(updateSql);
				
				alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Success");
    			alert.setHeaderText(null);
    			alert.setContentText("Data successfully updated data for '" + addMovies_movieTitle.getText() + "'");
    			
    			alert.showAndWait();
    			showAddmoviesList();
    			clearAddMoviesList();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	public void deleteMovie() {
		String sql = "DELETE FROM itemData WHERE itemTitle = '" + addMovies_movieTitle.getText()  + "'";
		
		connect = Database.connectDB();
		
		try {
			
			Alert alert;
			
			statement = connect.createStatement();
			
			if(addMovies_movieTitle.getText().isEmpty() || addMovies_genre.getText().isEmpty() || adMovies_duration.getText().isEmpty()
					|| adMovies_imageView.getImage() == null || addMovies_date.getValue() == null) {
				alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Error");
    			alert.setHeaderText(null);
    			alert.setContentText("Please fill in the blank fields...");
    			
    			alert.showAndWait();
			} else {
				
				alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message!!");
				
				alert.setHeaderText(null);
				alert.setContentText("Do you really want to delete item '" + addMovies_movieTitle.getText() + "' from database? ");
    			
    			Optional<ButtonType> option = alert.showAndWait();
    			
    			if(ButtonType.OK.equals(option.get())) {
    				
					
    				statement.executeUpdate(sql);
					alert = new Alert(AlertType.INFORMATION);
	    			alert.setTitle("Success");
	    			alert.setHeaderText(null);
	    			alert.setContentText("Item successfully DELETED from Database");
	    			
	    			alert.showAndWait();
	    			
	    			showAddmoviesList();
	    			clearAddMoviesList();
    				
    			} else {
    				return;
    			}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void clearAddMoviesList() {
		
		addMovies_movieTitle.setText("");
		addMovies_genre.setText("");
		adMovies_duration.setText("");
		adMovies_imageView.setImage(null);
		addMovies_date.setValue(null);
		
	}
    
    
    //log out
    public void logOut() {
    	signout.getScene().getWindow().hide();
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
			
			
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
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    // switch between different forms
    
    public void switchForm(ActionEvent event) {
    	
    
    	// switch to dashboatd
    	if(event.getSource()== dashboard_btn) {
    		dashboard_form.setVisible(true);
    		addMovies_form.setVisible(false);
    		availableMovies_form.setVisible(false);
    		editScreening_form.setVisible(false);
    		search_form.setVisible(false);
    		transaction_form.setVisible(false);
    		
    		dashboard_btn.setStyle("-fx-background-color:#ae2d3c");
    		addMovies_btn.setStyle("-fx-background-color:transparent");
    		availableMovies_btn.setStyle("-fx-background-color:transparent");
    		searchBook_btn.setStyle("-fx-background-color:transparent");
    		transaction_btn.setStyle("-fx-background-color:transparent");
    		
    		showTotalBooksDashboard();
    		showTotalMagazinesDashboard();
    		showTotalThesisDashboard();
    		showTotalJournalsDashboard();
    		
    	}else if(event.getSource()==addMovies_btn) {
    		dashboard_form.setVisible(false);
    		addMovies_form.setVisible(true);
    		availableMovies_form.setVisible(false);
    		editScreening_form.setVisible(false);
    		search_form.setVisible(false);
    		transaction_form.setVisible(false);
    		
    		dashboard_btn.setStyle("-fx-background-color:transparent");
    		addMovies_btn.setStyle("-fx-background-color: #ae2d3c");
    		availableMovies_btn.setStyle("-fx-background-color:transparent");
    		searchBook_btn.setStyle("-fx-background-color:transparent");
    		transaction_btn.setStyle("-fx-background-color:transparent");
    		
//    		showAddmoviesList();
    		
    		
    	}else if(event.getSource()==availableMovies_btn) {
    		dashboard_form.setVisible(false);
    		addMovies_form.setVisible(false);
    		availableMovies_form.setVisible(true);
    		editScreening_form.setVisible(false);
    		search_form.setVisible(false);
    		transaction_form.setVisible(false);
    		
    		dashboard_btn.setStyle("-fx-background-color:transparent");
    		addMovies_btn.setStyle("-fx-background-color: transparent");
    		availableMovies_btn.setStyle("-fx-background-color: #ae2d3c");
    		searchBook_btn.setStyle("-fx-background-color:transparent");
    		transaction_btn.setStyle("-fx-background-color:transparent");
    		
//    		showAvailableMovies();
    		initialiseBorrowBooktable();
    		
    	}else if(event.getSource()==searchBook_btn) {
    		dashboard_form.setVisible(false);
    		addMovies_form.setVisible(false);
    		availableMovies_form.setVisible(false);
    		editScreening_form.setVisible(false);
    		search_form.setVisible(true);
    		transaction_form.setVisible(false);
    		
    		
    		dashboard_btn.setStyle("-fx-background-color:transparent");
    		addMovies_btn.setStyle("-fx-background-color: transparent");
    		availableMovies_btn.setStyle("-fx-background-color: transparent");
    		searchBook_btn.setStyle("-fx-background-color: #ae2d3c");
    		transaction_btn.setStyle("-fx-background-color:transparent");

    	}
    	else if(event.getSource()==transaction_btn) {
    		dashboard_form.setVisible(false);
    		addMovies_form.setVisible(false);
    		availableMovies_form.setVisible(false);
    		editScreening_form.setVisible(false);
    		search_form.setVisible(false);
    		transaction_form.setVisible(true);
    		
    		
    		dashboard_btn.setStyle("-fx-background-color:transparent");
    		addMovies_btn.setStyle("-fx-background-color: transparent");
    		availableMovies_btn.setStyle("-fx-background-color: transparent");
    		searchBook_btn.setStyle("-fx-background-color: transparent");
    		transaction_btn.setStyle("-fx-background-color: #ae2d3c");

    	}
    	
    }
 
    
    // Display username in side panel
    public void displayUsername() {
    	username.setText(getData.username);
    }
    
    
    public void close() {
    	System.out.println("closing dadboard");
    	System.exit(0);
    }
    
    
    
    public void minimize() {
    	Stage stage = (Stage)topForm.getScene().getWindow();
    	stage.setIconified(true);
    }

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		//display the username on dashboard
		
//		showAddmoviesList(); // pull data from database
//		showEditScreening(); // pull edit screening data from DB
//		comboBox(); // add combobox options
//		showAvailableMovies(); // show available movies in available movies form
//		showSpinnerValue();
//		
//		showCustomerList(); // show customer data on dashboard
//		
		
		displayUsername();
		showTotalBooksDashboard();
		showTotalMagazinesDashboard();
		showTotalThesisDashboard();
		showTotalJournalsDashboard();
		initialiseBorrowBooktable();
		//AddItems(); 
		
	}
}
