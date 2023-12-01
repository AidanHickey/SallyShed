package application;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class Cart {
	
	private static HashMap< Integer, CartItem> itemMap = new HashMap<>();
	private static ArrayList<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();

	public static void updateCartItemQuantityBy( Product product, int amount) {
		CartItem ci = itemMap.get( product.getId());
		
		//Add new cart item if it does not already exist, as long as amount would not result in lack of quantity.
		if( ci == null && amount > 0) {
			ci = new CartItem( product, amount);
			itemMap.put( product.getId(), ci);
			
			informListenersQuantityUpdated( product, 0, amount);
			
			int itemCount = itemMap.size();
			informListenersItemCountUpdated( itemCount-1, itemCount);
		} else if( ci != null) {
			int oldAmount = ci.getQuantity();
			
			//If the item does exist, just update it and return the new amount.
			int newAmount = ci.updateQuantityBy(amount);
			
			//Remove from cart when quantity lacking.
			if( newAmount <= 0) {
				itemMap.remove( product.getId());
				informListenersQuantityUpdated( product, oldAmount, 0);
				
				int itemCount = itemMap.size();
				informListenersItemCountUpdated( itemCount+1, itemCount);
			} else {
				informListenersQuantityUpdated( product, oldAmount, newAmount);	
			}
		}
	}
	
	public static Collection<CartItem> getItems() {
		return itemMap.values();
	}
	
	public static CartItem getProductCartItem( Product product) {
		return itemMap.get( product.getId());
	}
	
	public static int getProductQuantity( Product product) {
		CartItem cartItem = getProductCartItem( product);
		if( cartItem == null) {
			return 0;
		} else {
			return cartItem.getQuantity();
		}
	}
	
	public static int getItemCount() {
		return itemMap.size();
	}
	
	public static double calculateSubtotal() {
		double sum = 0.0;
		for( CartItem ci :itemMap.values()) {
			sum += ci.getTotalPrice();
		}
		return sum;
	}

	public static double calculateTaxes() {
		return calculateSubtotal() * 0.0725;
	}

	public static double calculateShipping() {
		return 10000;
	}

	public static double calculateTotal() {
		return calculateSubtotal() + calculateTaxes() + calculateShipping();
	}
	
	private static void informListeners( Object source, String propertyName, Object oldValue, Object newValue) {
		for( PropertyChangeListener cl: listeners) {
			PropertyChangeEvent event = new PropertyChangeEvent( source, propertyName, oldValue, newValue);
			cl.propertyChange(event);
		}
	}
	
	private static void informListenersQuantityUpdated( Product product, int oldAmount, int newAmount) {
		informListeners( product, "quantity", oldAmount, newAmount);
	}
	
	private static void informListenersItemCountUpdated( int oldAmount, int newAmount) {
		informListeners( Cart.class, "item count", oldAmount, newAmount);
	}
	
	public static void addPropertyChangeListener(PropertyChangeListener cl) {
		listeners.add(cl);
	}

}
