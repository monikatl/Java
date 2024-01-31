package lab05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Application {
	
	public static final List<Customer> customers = new ArrayList<Customer>();
	public static final List<Purchase> purchases = new ArrayList<Purchase>();
	public static final List<Invoice> invoices = new ArrayList<Invoice>();

	public static void main(String[] args) throws FileNotFoundException {
		
		Consumer<Scanner> customersReading = data -> {
			while(data.hasNext()) {
				Customer customer = new Customer(data.nextInt(), data.next(), data.next(), data.nextLine());
				customers.add(customer);
			}
		};
		
		Consumer<Scanner> purchasesReading = data -> {			
			label:
			while(data.hasNext()) {
				Purchase purchase = new Purchase(data.nextInt(), data.next(), data.nextInt(), data.nextDouble());
				for(Customer customer: customers) {
					if(purchase.getClientId()==customer.getId()) {
						purchases.add(purchase);
						continue label;						
					}
				}
				JOptionPane.showMessageDialog(null, "W bazie brak klienta o id: " + purchase.getClientId() + "\nZamówienie "+ purchase +" zostanie pominięte.");				
			}
		};
		
		
		// input file contains data about customers
		importData(customersReading, "klientów");
		
		
		//input file contains data about purchases
		importData(purchasesReading, "z zamówieniami");

		
		//add purchases to customers objects and create invoices objects
		Collections.sort(purchases);
		for(Customer customer : customers) {
			for(Purchase purchase : purchases) {
				if(customer.getId()==purchase.getClientId()) {
					customer.addPurchase(purchase);
				}
			}
			if(customer.getPurchases().size()!=0) {
				invoices.add(new Invoice(customer.getId(), customer));
			}			
		}
		
						
		//input file to save invoices
		String saveFileName = JOptionPane.showInputDialog("Podaj nazwę pliku do zapisu danych faktur:");
		PrintWriter outputFile = new PrintWriter(saveFileName);
		
		for(Invoice invoice : invoices) {
			outputFile.println(invoice.toString());
		}
		
		outputFile.close();
		
		JOptionPane.showMessageDialog(null, "Pomyślnie utworzono plik " + saveFileName);
	}
	
	private static void userInputFile(Consumer<Scanner> action, String type) throws FileNotFoundException {
		String fileName = JOptionPane.showInputDialog("Podaj nazwę pliku zawierającego dane " + type + ":");
		File file = new File(fileName);
		Scanner input = new Scanner(file);
		action.accept(input);
		input.close();
	}
	
	private static void importData(Consumer<Scanner> reading, String type) {
		try {
			userInputFile(reading, type);
		}catch(FileNotFoundException e) {
			int userChoice = JOptionPane.showConfirmDialog(null, "Brak podanego pliku.\nCzy chcesz ponownie wprowadzić nazwę pliku???");
			if(userChoice==0) {
				try {
					userInputFile(reading, type);
				}catch(FileNotFoundException ee) {
					JOptionPane.showMessageDialog(null,Component.ERROR, ee.getMessage(), userChoice);
					System.exit(0);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Koniec programu.");
				System.exit(0);
			}
		}
	}
	
	

}
