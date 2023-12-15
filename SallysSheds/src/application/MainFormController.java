package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class MainFormController implements Initializable {
	
	@FXML
    private Label checkout_total;
	
	@FXML
    private Label checkout_subtotal;

    @FXML
    private Button largeShed_addBtn;

    @FXML
    private Spinner<Integer> largeShed_spinner;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button mf_checkoutBtn;

    @FXML
    private AnchorPane mf_checkoutPage;

    @FXML
    private Button mf_homeBtn;

    @FXML
    private AnchorPane mf_homePage;

    @FXML
    private Button mf_productsBtn;

    @FXML
    private AnchorPane mf_productsPage;

    @FXML
    private Button purchaseBtn;

    @FXML
    private Button rocky_addBtn;

    @FXML
    private Spinner<Integer> rocky_spinner;

    @FXML
    private Button smallShed_addBtn;

    @FXML
    private Spinner<Integer> smallShed_spinner;
	
	private Alert alert;
	
	private SpinnerValueFactory<Integer> spin;
	
	public void logout() {
		try {
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to log out?");
			Optional<ButtonType> option = alert.showAndWait();
			if(option.get().equals(ButtonType.OK)) {
				logout_btn.getScene().getWindow().hide();
				Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(root);
				stage.setTitle("Sally's Sheds");
				stage.setScene(scene);
				stage.show();
			}
		} catch(Exception e) {e.printStackTrace();}
	}
	
	public void switchForm(ActionEvent event) {
		if(event.getSource() == mf_homeBtn) {
			mf_homePage.setVisible(true);
			mf_productsPage.setVisible(false);
			mf_checkoutPage.setVisible(false);
		} else if(event.getSource() == mf_productsBtn) {
			mf_homePage.setVisible(false);
			mf_productsPage.setVisible(true);
			mf_checkoutPage.setVisible(false);
		} else if(event.getSource() == mf_checkoutBtn) {
			mf_homePage.setVisible(false);
			mf_productsPage.setVisible(false);
			mf_checkoutPage.setVisible(true);
		}
	}
	
	public int ls_qty;
	public int ss_qty;
	public int r_qty;
	public double total_price = 0;
	
	public void setLSQuantity() {
		spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100,0);
		largeShed_spinner.setValueFactory(spin);
	}
	
	public void setSSQuantity() {
		spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100,0);
		smallShed_spinner.setValueFactory(spin);
	}
	
	public void setRQuantity() {
		spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100,0);
		rocky_spinner.setValueFactory(spin);
	}
	
	public void addBtn(ActionEvent event) {
		if(event.getSource() == largeShed_addBtn) {
			ls_qty = largeShed_spinner.getValue();
			try {
				if(ls_qty == 0) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please select a quantity.");
					alert.showAndWait();
				} else {
					total_price += 2999.99 * ls_qty;
					updateCheckout();
					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Added!");
					alert.showAndWait();
				}
			} catch(Exception e) {e.printStackTrace();}
		} else if(event.getSource() == smallShed_addBtn) {
			ss_qty = smallShed_spinner.getValue();
			try {
				if(ss_qty == 0) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please select a quantity.");
					alert.showAndWait();
				} else {
					total_price += 1999.99 * ss_qty;
					updateCheckout();
					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Added!");
					alert.showAndWait();
				}
			} catch(Exception e) {e.printStackTrace();}
		} else if(event.getSource() == rocky_addBtn) {
			r_qty = rocky_spinner.getValue();
			try {
				if(r_qty == 0) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please select a quantity.");
					alert.showAndWait();
				} else {
					total_price += 199.99 * r_qty;
					updateCheckout();
					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Added!");
					alert.showAndWait();
				}
			} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	public void updateCheckout() {
		checkout_subtotal.setText("$" + Math.round(total_price * 100.0)/100.0);
		checkout_total.setText("$" + Math.round((total_price + 1000) * 100.0)/100.0);
	}
	
	public void purchaseBtn() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CreditCardForm.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setTitle("Credit Card Authorization");
			stage.setScene(scene);
			stage.showAndWait();
			total_price = 0;
			checkout_subtotal.setText("$" + 0);
			checkout_total.setText("$" + 0);
		} catch(Exception e) {e.printStackTrace();}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setLSQuantity();
		setSSQuantity();
		setRQuantity();
		
	}

}
