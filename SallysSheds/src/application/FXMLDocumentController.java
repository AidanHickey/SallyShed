package application;

import java.util.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXMLDocumentController implements Initializable {
	
	@FXML
    private Hyperlink si_forgotPass;

    @FXML
    private Button si_loginBtn;

    @FXML
    private AnchorPane si_loginForm;

    @FXML
    private PasswordField si_password;

    @FXML
    private TextField si_username;

    @FXML
    private Button side_CreateBtn;

    @FXML
    private AnchorPane side_form;

    @FXML
    private TextField su_answer;

    @FXML
    private PasswordField su_password;

    @FXML
    private ComboBox<?> su_question;

    @FXML
    private Button su_signupBtn;

    @FXML
    private AnchorPane su_signupForm;

    @FXML
    private TextField su_username;
    
    @FXML
    private Button side_alreadyHave;
    
    @FXML
    private Button fp_back;

    @FXML
    private Button fp_changePassBtn;

    @FXML
    private PasswordField fp_confirmPass;

    @FXML
    private PasswordField fp_newPass;

    @FXML
    private AnchorPane fp_questionForm;
    
    private Alert alert;
    
    public void loginBtn() {
    	if(si_username.getText().isEmpty() || si_password.getText().isEmpty()) {
    		alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error Message");
    		alert.setHeaderText(null);
    		alert.setContentText("Incorrect Username/Password.");
    		alert.showAndWait();
    	} else {
    		try {
    			alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Information Message");
    			alert.setHeaderText(null);
    			alert.setContentText("Logged In!");
    			alert.showAndWait();
    			Parent root = FXMLLoader.load(getClass().getResource("MainForm.fxml"));
    			Stage stage = new Stage();
    			Scene scene = new Scene(root);
    			stage.setTitle("Sally's Sheds");
    			stage.setMinWidth(1100);
    			stage.setMinHeight(600);
    			stage.setScene(scene);
    			stage.show();
    			si_loginBtn.getScene().getWindow().hide();
    		} catch(Exception e) {e.printStackTrace();}
    	}
    }
    
    public void regBtn() {
    	if(su_username.getText().isEmpty() || su_password.getText().isEmpty() || su_question.getSelectionModel().getSelectedItem() == null || su_answer.getText().isEmpty()) {
    		alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error Message");
    		alert.setHeaderText(null);
    		alert.setContentText("Please fill all blank fields.");
    		alert.showAndWait();
    	} else {
    		try {
    			alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Information Message");
    			alert.setHeaderText(null);
    			alert.setContentText("Successfully Registered Account!");
    			alert.showAndWait();
    			su_username.setText("");
    			su_password.setText("");
    			su_question.getSelectionModel().clearSelection();
    			su_answer.setText("");
    			TranslateTransition slider = new TranslateTransition();
    			slider.setNode(side_form);
        		slider.setToX(0);
        		slider.setDuration(Duration.seconds(.4));
        		
        		slider.setOnFinished((ActionEvent e) -> {
        			side_alreadyHave.setVisible(false);
        			side_CreateBtn.setVisible(true);
        		});        		
        		slider.play();
    		} catch(Exception e) {e.printStackTrace();}
    	}
    }
    
    private String[] questionList = {"What is your favorite color?", "What is your favorite food?", "What is your birthday?"};
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void regQuestionList() {
    	List<String> listQ = new ArrayList<>();
    	for(String data:questionList) {
    		listQ.add(data);
    	}
    	ObservableList listData = FXCollections.observableArrayList(listQ);
    	su_question.setItems(listData);
    }
    
    public void switchForgotPass() {
    	fp_questionForm.setVisible(true);
    	si_loginForm.setVisible(false);
    }
    
    public void changePassBtn() {
    	if(fp_newPass.getText().isEmpty() || fp_confirmPass.getText().isEmpty()) {
    		alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error Message");
    		alert.setHeaderText(null);
    		alert.setContentText("Please fill all blank fields.");
    		alert.showAndWait();
    	} else {
    		if (fp_newPass.getText().equals(fp_confirmPass.getText())) {
    			try {
    				alert = new Alert(AlertType.INFORMATION);
    	    		alert.setTitle("Information Message");
    	    		alert.setHeaderText(null);
    	    		alert.setContentText("Successfuly Changed Password!");
    	    		alert.showAndWait();
    	    		si_loginForm.setVisible(true);
    	    		fp_questionForm.setVisible(false);
    	    		fp_confirmPass.setText("");
    	    		fp_newPass.setText("");
        		} catch(Exception e) {e.printStackTrace();}
    		} else {
    			alert = new Alert(AlertType.ERROR);
        		alert.setTitle("Error Message");
        		alert.setHeaderText(null);
        		alert.setContentText("Not matching.");
        		alert.showAndWait();
    		}
    	}
    }
    
    public void backToLoginForm() {
    	si_loginForm.setVisible(true);
    	fp_questionForm.setVisible(false);
    }
    
    public void switchForm(ActionEvent event) {
    	
    	TranslateTransition slider = new TranslateTransition();
    	
    	if(event.getSource() == side_CreateBtn) {
    		slider.setNode(side_form);
    		slider.setToX(300);
    		slider.setDuration(Duration.seconds(.4));
    		
    		slider.setOnFinished((ActionEvent e) -> {
    			side_alreadyHave.setVisible(true);
    			side_CreateBtn.setVisible(false);
    			fp_questionForm.setVisible(false);
    			si_loginForm.setVisible(true);
    			regQuestionList();
    		});
    		
    		slider.play();
    	} else if(event.getSource() == side_alreadyHave) {
    		slider.setNode(side_form);
    		slider.setToX(0);
    		slider.setDuration(Duration.seconds(.4));
    		
    		slider.setOnFinished((ActionEvent e) -> {
    			side_alreadyHave.setVisible(false);
    			side_CreateBtn.setVisible(true);
    			fp_questionForm.setVisible(false);
    			si_loginForm.setVisible(true);
    		});
    		
    		slider.play();
    	}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
