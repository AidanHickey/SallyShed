package application;

public class Product {
	private int id;
	private String title;
	private double price;
	private String thumbnail;
	
	public Product( int id, String title, double price, String thumbnail) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.thumbnail = thumbnail;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public String getThumbnail() {
		return thumbnail;
	}
}
