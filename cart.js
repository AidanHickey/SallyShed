// cart.js

const cart = {
  items: [],
  cartLimit: 3,
  taxRate: 0.0725, // 7.25% tax rate
  shippingCost: 10000,
};

// Function to add a product to the cart
function addToCart(product) {
  if (cart.items.length < cart.cartLimit) {
    cart.items.push(product);
    return true; // Product added successfully
  } else {
    return false; // Cart limit reached
  }
}

// Function to calculate the subtotal of the items in the cart
function calculateSubtotal() {
  return cart.items.reduce((total, item) => total + item.price, 0);
}

// Function to calculate the total price, including taxes and shipping
function calculateTotal() {
  const subtotal = calculateSubtotal();
  const tax = subtotal * cart.taxRate;
  const total = subtotal + tax + cart.shippingCost;
  return total.toFixed(2);
}

// Function to get the quantity of each item in the cart
function getItemQuantities() {
  const itemQuantities = {};
  for (const item of cart.items) {
    if (item.name in itemQuantities) {
      itemQuantities[item.name]++;
    } else {
      itemQuantities[item.name] = 1;
    }
  }
  return itemQuantities;
}
