package lab10;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;



public class Fishining {

	private static List<Catch> catches = new ArrayList<>();
	public static void main(String[] args) {
		
		
		String name = "Monika";
		
		File file = new File("fishing.txt");
		Scanner input = new Scanner(file);
		
		while(input.hasNext()) {
			int day = input.nextInt();
			int month = input.nextInt();
			int year = input.nextInt();
		 
		}
		
		
		try {
			readFileToList("fishing.txt");
		}catch(FileNotFoundException e) {
			System.err.println("Nie znaleziono pliku!");
		}
		
		
		
		// 1
		catches.forEach(System.out::println);
		
		// 2
		var two = catches
					.stream()
					.sorted(Comparator.comparing(Catch::getFishermanName)
							.thenComparing(Catch::getDate))
					.collect(toList());
		
		two.forEach(System.out::println);
		
		// 3 unikatowe nazwy gatunków ryb
		var unikatoweNazwyGatunkow = catches
										.stream()
										.map(c -> c.getFish().getSpecies())
										.distinct()
										.sorted()
										.collect(toList());
		
		unikatoweNazwyGatunkow.forEach(System.out::println);
		
		
		// 4 dane połowów szczupaków o wadze 1 do 2 kg od najnowszego polowu
		Predicate<Catch> lekkiSzczupak = c->c.getFish().getWeight()>= 1
											&& c.getFish().getWeight()<=2;
		
		var szczupaki = catches
							.stream()
							.filter(lekkiSzczupak)
							.sorted(Comparator.comparing(Catch::date))
							.collect(toList());
		szczupaki.forEach(System.out::println);
		
		
		// 5 które połowy w które dni tygodnia		
		Map<String, List<Catch>> byDays = catches.stream()
								.collect(groupingBy(Catch::getNameOfDay));
		
		byDays.entrySet().forEach(System.out::println);
		
		//catches.forEach(x->System.out.println(x.day()));
		
		// 6. ile ryb o długości powyżej 50 cm złowił dany wędkarz
		// grouping po wędkarzu
		// count
		
		Map<String, Long> poIleRybek = catches.stream()
							.filter(c -> c.getFish().getLength()>50)
							.collect(groupingBy(Catch::getFishermanName, counting()));
		poIleRybek.entrySet().forEach(System.out::println);
		
		// 7. łączna waga złowionych szczupaków i sandaczy
		// filter szczupaki i sandacze
		// suma wag
		
		Predicate<Catch> sandacz = c -> c.getFish().getSpecies().equals("sandacz");
		Predicate<Catch> szczupak = c -> c.getFish().getSpecies().equals("szczupak");
	
		System.out.println("Waga szczupaków i sandaczy: " + catches.stream()
				.filter(sandacz.or(szczupak))
				.map(c -> c.getFish().getWeight())
				.reduce(0.0, (a,b) -> a+b));
		
		//
		// ile złowiono w danym dniu ryb + ile najdłuższa  + ile najkrótsza
		
		var srednie = catches.stream()
				.collect(groupingBy(Catch::getNameOfDay, averagingInt(Catch::getLength)));
		
	
		var najkrotsze = catches.stream()
				.collect(groupingBy(Catch::getNameOfDay, minBy(comparingInt(Catch::getLength))));
		
		var najdluzsze = catches.stream()
				.collect(groupingBy(Catch::getNameOfDay, maxBy(comparingInt(Catch::getLength))));
		
		var ilosc = catches.stream()
				.collect(groupingBy(Catch::getNameOfDay, counting()));
		
	
	
		System.out.println(summary);

		
		
		

	}
	

	private static void readFileToList(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner input = new Scanner(file);
		while(input.hasNext()) {
			catches.add(createCatch(input));
		}
		input.close();
	}
	
	private static Calendar createDate(Scanner input) {
		int day = input.nextInt();
		int month = input.nextInt();
		int year = input.nextInt();
		Calendar date = new GregorianCalendar(year, month-1,day);
		return date;
	}
	
	private static Catch createCatch(Scanner input) {
		Calendar date = createDate(input);
		String species = input.next();
		String fisher = input.next();
		String weight = input.next();
		int length = input.nextInt();
		Fish fish = new Fish(species, Double.parseDouble(weight), length);
		return new Catch(date, createFisherman(fisher), fish);
	}
	
	private static Fisherman createFisherman(String fisher) {
		String name = fisher;
		int id = Character.getNumericValue(fisher.charAt(fisher.length()-2));
		return new Fisherman(name, id);
	}
	


}
