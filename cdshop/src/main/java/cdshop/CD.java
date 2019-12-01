package cdshop;

public class CD {

	private int id;
    private String title;
    private String artist;
    private int stock;
    private float price;
 
    protected CD() {
    }
 
    protected CD(String title, String artist, int stock, float price) {
        this.title = title;
        this.artist = artist;
        this.stock = stock;
        this.price = price;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", title=" + title + ", artist=" + artist + ", stock=" + stock + ", price=" + price
				+ "]";
	}
    
}
