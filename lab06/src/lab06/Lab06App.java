package lab06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lab06App {

	public static void main(String[] args) {
		
		Dietician [] tabP = new Dietician[] {
				new Person("Kowalski Jan", 45, 178, 83),
				new Dog("Yeti", 6.0, 4, 2),
				new Dog("Sonia", 5.1, 7, 2),
				new Person("Mucha Joanna", 24, 169, 61),
				new Dog("Azor", 11.3, 5, 3),
				new Person("Gala Piotr", 34, 184, 91),
				new Person("Piech Anna", 56, 163, 88),
				new Dog("Meps", 16.9, 8, 3),
				new Person("Adamus Jacek", 21, 176, 94),
				new Dog("Rex", 2.8, 3, 1)
		};		
		show(tabP, "Lista w pierwotnej kolejności.");
		Comparator<Dietician> myComparator = new  Comparator<Dietician>() {

			@Override
			public int compare(Dietician o1, Dietician o2) {
				// TODO Auto-generated method stub
				return 0;
			}};
			
			
		Collections.sort( Arrays.asList(tabP), myComparator);
			

		
		
		Arrays.sort(tabP, (o1, o2) -> Double.compare(o1.getBMI(), o2.getBMI()));	
		
		show(tabP, "Lista uporządkowana wg wartości BMI.");
		
		
		Arrays.sort(tabP, new ObjectThenAgeComparator());	
		show(tabP, "Lista uporządkowana kolejno wg gatunków i wieku.");
		

	}
	
	private static void show(Dietician []tab, String text) {
		System.out.println(text);		
		for(Dietician d : tab) {
			System.out.println(d);
		}
		System.out.println("--------------------------------------------------------------------");	
	}

}
