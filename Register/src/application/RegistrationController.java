package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField confirmPasswordField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button registerButton;

    @FXML
    private Button goBackButton;

    @FXML
    private void initialize() {
    	// initialize every text field to null
        firstNameField = null;
        lastNameField = null;
        usernameField = null;
        passwordField = null;
        confirmPasswordField = null;
        phoneNumberField = null;
    }

    @FXML
    private void handleRegisterButtonAction() {
        // Get user input from text fields
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String phoneNumber = phoneNumberField.getText();
        
        
        
        if(password == confirmPassword)
        {
        	// if they are the same
        	
        	// check the phone number
        	saveUserInfoToFile(firstName,lastName,username,password, phoneNumber);
        }
        
        /*
         * // check if the password and confirmPassword are the same
// check if the email is valid
// check if the date of birth is valid and make sure format is correct MM/DD/YYYY
// make sure that the phone number is valid
         * 
         * */

    }

    @FXML
    private void handleGoBackButtonAction() {
    	// link with the home page or the products page
        // go back to the home page
    	
    }

    private void saveUserInfoToFile(String firstName, String lastName, String username, String password, String phoneNumber) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt", true))) {
            // Append user information to the text file
            writer.write("First Name: " + firstName + "\n");
            writer.write("Last Name: " + lastName + "\n");
            writer.write("Username: " + username + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("Phone Number: " + phoneNumber + "\n");
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
}
