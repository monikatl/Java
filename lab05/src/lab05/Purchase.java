package lab05;

public class Purchase implements Comparable<Purchase> {
	
	private int clientId;
	private String productName;
	private int count;
	private double price;
	private double value;
	
	public Purchase(int clientId, String productName, int count, double price) {
		this.clientId = clientId;
		this.productName = productName;
		this.count = count;
		this.price = price;
		this.value = price*count;
	}

	public double getValue() {
		return value;
	}

	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return clientId + " " + productName + " " + count + " " + price;
	}

	@Override
	public int compareTo(Purchase o) {
		if(clientId==o.clientId)
			return 0;
		if(clientId>o.clientId)
			return 1;
		return -1;
	}
	
	
}
