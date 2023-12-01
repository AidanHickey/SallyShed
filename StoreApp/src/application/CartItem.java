package application;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem( Product product, int quantity) {
    	this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }
    
    public int updateQuantityBy( int amount ) {
    	return quantity += amount;
    }

    public double getTotalPrice() {
        return product.getPrice()* quantity;
    }

	public Product getProduct() {
		return product;
	}
}







/*


public class ProductsController {
	
	public ProductsController() {
		
	}
	public void removeOneLargeShed(MouseEvent event) {
		
		
	}
	
	public void addOneLargeShed(MouseEvent event) {
		
	}
	
	public void removeOneSmallShed(MouseEvent event) {
		
	}
	
	public void addOneSmallShed(MouseEvent event) {
		
	}
	
	public void removeOneRocky(MouseEvent event) {
		
	}
	
	public void addOneRocky(MouseEvent event) {
		
	}
	
	public void backToHome(MouseEvent event) {
	}
	
	public void goToCheckOut(MouseEvent event) {
	}
	
}*/