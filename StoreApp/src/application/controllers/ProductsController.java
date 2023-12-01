package application.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;


public class ProductsController implements Initializable{
    
	//Placeholder for products, product list can be pulled in from other sources.
	private static ArrayList<Product> products = new ArrayList<Product>() {
		private static final long serialVersionUID = 1950012214330204663L; //Ignore this.

		{
			add( new Product(0, "Large Shed", 2999.99, "Large Shed.jpg"));
			add( new Product(1, "Small Shed", 1999.99, "small shed.jpg"));
			add( new Product(2, "Rocky", 200.0, "Rocky.png"));
		}
	};
	
    @FXML private VBox productList;
    
    public ProductsController() {
    }

    @Override
    public void initialize( URL location, ResourceBundle resources) {
    	
    	for( Product product: products) {
    		productList.getChildren().add( ProductListItemController.createProductListItem( product));
    	}
    }
	

	
}


