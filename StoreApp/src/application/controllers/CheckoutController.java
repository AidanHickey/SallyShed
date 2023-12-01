package application.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

import application.Cart;
import application.CartItem;
import application.CurrencyHelper;
import application.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CheckoutController implements Initializable, PropertyChangeListener {
	
	@FXML private VBox checkoutItemList;
	@FXML private Button purchaseBtn;
	@FXML private Label subtotalValueLabel;
	@FXML private Label taxesValueLabel;
	@FXML private Label shippingValueLabel;
	@FXML private Label totalValueLabel;
	
	public void GoToThankYouPage(ActionEvent event){
		
	}

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		purchaseBtn.setDisable( Cart.getItemCount() == 0);
		Cart.addPropertyChangeListener( this);
		updateCartTotalLabels();
		
		for( CartItem item : Cart.getItems()) {
			Node node = ProductListItemController.createProductListItem( item.getProduct());
			checkoutItemList.getChildren().add(node);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch(evt.getPropertyName()) {
			case "quantity":
				if( (Integer)evt.getNewValue() == 0) {
					Product product = (Product)evt.getSource();
					String lookupClass = ProductListItemController.getProductIdClass( product);
					Node node = checkoutItemList.lookup("."+lookupClass);
					
					if( node != null) {
						checkoutItemList.getChildren().remove(node);
					}
					
				}
				
				updateCartTotalLabels();
				break;
			case "item count":
				if( (Integer)evt.getNewValue() == 0) {
					purchaseBtn.setDisable(true);
				}
				break;
		}
	}

	
	private void updateCartTotalLabels() {
		subtotalValueLabel.setText( CurrencyHelper.formatMoney( Cart.calculateSubtotal()));
		taxesValueLabel.setText( CurrencyHelper.formatMoney( Cart.calculateTaxes()));
		shippingValueLabel.setText( CurrencyHelper.formatMoney( Cart.calculateShipping()));
		totalValueLabel.setText( CurrencyHelper.formatMoney( Cart.calculateTotal()));
	}
}