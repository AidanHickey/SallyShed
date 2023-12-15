package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CreditCardFormController implements Initializable {
	
	@FXML
    private TextField cc_address1;

    @FXML
    private TextField cc_address2;

    @FXML
    private TextField cc_cNum;

    @FXML
    private TextField cc_cvc;

    @FXML
    private TextField cc_email;

    @FXML
    private TextField cc_firstName;

    @FXML
    private AnchorPane cc_infoForm;

    @FXML
    private TextField cc_lastName;

    @FXML
    private TextField cc_mmyy;

    @FXML
    private Button cc_purchaseBtn;
    
    private Alert alert;
	
	public void finalPurchase() {
		if(cc_firstName.getText().isEmpty() || cc_lastName.getText().isEmpty() || cc_email.getText().isEmpty() || cc_cNum.getText().isEmpty() || cc_mmyy.getText().isEmpty() || cc_cvc.getText().isEmpty() || cc_address1.getText().isEmpty() || cc_address2.getText().isEmpty()) {
    		alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error Message");
    		alert.setHeaderText(null);
    		alert.setContentText("Please Fill In All Information.");
    		alert.showAndWait();
    	} else {
    		try {
    			alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Information Message");
    			alert.setHeaderText(null);
    			alert.setContentText("Purchased!");
    			alert.showAndWait();
    			cc_purchaseBtn.getScene().getWindow().hide();
    		} catch(Exception e) {e.printStackTrace();}
    	}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
