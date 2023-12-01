package application.controllers;


public class CartControllerOld {
	/*
    private List<CartItem> items;

    public void Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(String itemName, double price) {
        // Check if the item is already in the cart
    	
        for (CartItem item : items) {
            if (item.getName().equals(itemName)) {
                item.incrementQuantity();
                return;
            }
        }

        // If the item is not in the cart, add a new item
        //items.add(new CartItem(itemName, price));
    }

    public void removeItem(String itemName, double price) {
        // Check if the item is in the cart
    	
        for (CartItem item : items) {
            if (item.getName().equals(itemName)) {
                item.decrementQuantity();

                // If the quantity becomes zero, remove the item from the cart
                if (item.getQuantity() == 0) {
                    items.remove(item);
                }
                return;
            }
        }
        
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    } 

    public double calculateTax() {
        // Implement tax calculation logic here
        // For example, return 7.25% of the subtotal
        return calculateSubtotal() * 0.0725;
    }

    public double calculateShipping() {
        // Implement shipping calculation logic here
        // For example, return a flat shipping fee
        return 10000;
    }

    public double calculateTotal() {
        // Total is the sum of subtotal, tax, and shipping
        return calculateSubtotal() + calculateTax() + calculateShipping();
    }
    */
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