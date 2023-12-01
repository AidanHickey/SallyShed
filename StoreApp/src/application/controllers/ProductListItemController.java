package application.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import application.Cart;
import application.CurrencyHelper;
import application.Main;
import application.Product;
import application.SceneController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProductListItemController implements PropertyChangeListener {
	
	public Product product;
	public int quantity = 0;
	@FXML private Label titleLabel;
	@FXML private ImageView thumbnailImageView;
	@FXML private Label quantityLabel;
	@FXML private Label priceLabel;
	
	public ProductListItemController() {
		Cart.addPropertyChangeListener(this);
	}
	
	public void setup( Product product) {
		this.product = product;
		
		titleLabel.setText( product.getTitle());
		
		URL thumbnailURL = Main.class.getResource("/images/" + product.getThumbnail());
		try {
			thumbnailImageView.setImage( new Image( thumbnailURL.toURI().toString()));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		updateQuantity( Cart.getProductQuantity( product));
		
		priceLabel.setText("Price: " + CurrencyHelper.formatMoney( product.getPrice()));
	}
	
	public void addQuantityToCart(MouseEvent e) {
		Cart.updateCartItemQuantityBy(product, 1);
	}
	
	public void subtractQuantityFromCart(MouseEvent e) {
		Cart.updateCartItemQuantityBy(product, -1);
	}
	
	public void updateQuantity( int quantity) {
		this.quantity = Math.max(0, quantity);
		quantityLabel.setText( "Quantity: " + quantity);
	}
	
	public static String getProductIdClass( Product product) {
		return "product-" + product.getId();
	}
	
	public static Node createProductListItem( Product product) {
		URL url = Main.class.getResource( SceneController.baseScenePath + "partials/ProductListItemTemplate.fxml");
		FXMLLoader loader = new FXMLLoader( url);
		try {
			Node node = loader.load();
			if( node != null) {
				ProductListItemController controller = (ProductListItemController)loader.getController();
				controller.setup( product);
				node.getStyleClass().add( getProductIdClass( product));
				
				return node;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch(evt.getPropertyName()){
			case "quantity":
				Product product = (Product)evt.getSource();
				if( product == this.product ) {
					updateQuantity( (Integer)evt.getNewValue());
				}
				break;
		}
	}
}
