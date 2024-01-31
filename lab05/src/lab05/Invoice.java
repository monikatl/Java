package lab05;

public class Invoice {
	private Customer customer;
	private int number;
	private double sum;
	
	
	public Invoice(int customerId, Customer customer) {
		this.customer = customer;	
		sum();
		this.number = customer.getPurchases().size();
	}
	
	public void sum() {
		for(Purchase p : customer.getPurchases()) {
			this.sum += p.getValue();
		}
	}

	@Override
	public String toString() {
		return "Invoice. customerId= " + customer.getId()+ "\n" + customer + "\n number trans. "+ number + " sum amount " + sum +
				"\n------------------------------------------------\n";
	}
	
	
	
	
	
	
	
}
