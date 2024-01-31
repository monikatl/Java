package lab07;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class EmployeeTest {
	
	public final static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		var eTab = new ArrayList<Employee>();
		eTab.add(new Employee("Nowak Jan", 1.0, 5200.0, 24, "Kierowca"));
		eTab.add(new Employee("Piech Anna", 0.7, 4800.0, 29, "Księgowa"));
		eTab.add(new Employee("Jach Ewa", 1.2, 6000.0, 27, "Księgowa"));
		eTab.add(new Employee("Rak Piotr", 1.25, 4000.0, 21, "Kierowca"));
		eTab.add(new Employee("Maj Jan", 0.5, 7000.0, 52, "Kierownik"));
		eTab.add(new Employee("Bąk Olga", 1.0, 6000.0, 29, "Księgowa"));
		
		
		System.out.println("Na starcie: ");
		eTab.forEach(System.out::println);
		
		System.out.println("Po policzeniu pensji: ");
		eTab.forEach(employee -> employee.setNetSalary(employee.countSalary()));
		eTab.forEach(System.out::println);
		
		System.out.println("Po sortowaniu wg pensji(od najniższej): ");
		Collections.sort(eTab, (e1, e2) -> Double.compare(e1.getNetSalary(), e2.getNetSalary()));
		eTab.forEach(System.out::println);
		

		//multiple conditions
		System.out.println("Po sortowaniu wg position, age then netSalary: ");
		eTab.sort((e1, e2)-> {
			if(e1.getPosition().equals(e2.getPosition())) {
				if(e1.getAge()==e2.getAge()) {
					return Double.compare(e2.getNetSalary(), e1.getNetSalary());
				}else {
					return Integer.compare(e2.getAge(), e1.getAge());
				}
			}else {
				return e1.getPosition().compareTo(e2.getPosition());
			}
		});	
		eTab.forEach(System.out::println);
		
		
		System.out.println("Po sortowaniu referencje comparing: ");
		Collections.sort(eTab, Comparator.comparing(Employee::getAge).reversed()
											.thenComparing(Employee::getPosition)
											.thenComparing(Employee::getNetSalary, (e1, e2) -> e2.compareTo(e1)));
		eTab.forEach(System.out::println);
		
		
		
		String saveFileName = input.nextLine();
		PrintWriter outputFile;
		try {
			outputFile = new PrintWriter(saveFileName);
			for(Employee employee : eTab) {
				outputFile.println(employee.toFile());
			}
			outputFile.close();
			System.out.println("Zapisano w pliku!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
