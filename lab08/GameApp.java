package lab08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;


public class GameApp {

	public static final Scanner input = new Scanner(System.in);
	public static Board [] games;
	public static Point [] scores;
	public static void main(String[] args) {
		
		
		System.out.println("Podaj liczbę gier: ");
		int n = input.nextInt();
		System.out.println("Podaj maksymalną liczbę rund: ");
		int m = input.nextInt();
		games = new Board [n];
		scores = new Point[n];
		for(int i = 0; i<n; i++) {
			scores[i] = new Point();
		}

	
		gameLabel:for(int i = 0; i<n; i++) {
			System.out.println("Gra nr " + (i+1));
			int a, b, c, d;	
			
			for(int j = 0; j<m; j++) {
				System.out.println("RUNDA " + (j+1));
				System.out.println("Podaj współrzędne punktu A: ");
				a = input.nextInt();
				b = input.nextInt();
				System.out.println("Podaj współrzędne punktu B: ");
				c = input.nextInt();
				d = input.nextInt();
			
				try {
					games[i] = new Board();
					games[i].addUserPoints(a,b,c,d);
				}catch(IllegalArgumentException e) {
					System.out.println("Niepoprawne współrzędne");
					j -= 1;
					continue;
				}
				
				Board.Pair<Integer, Board.Point> distAndPoint = games[i].check();
				
				if(distAndPoint.getA() == 0) {
					scores[i].addRound();
					scores[i].calculateWinPoints(scores[i].getNum_rounds());				
					scores[i].gameWonInfo();
					break gameLabel;					
				} else {
					scores[i].addRound();
					scores[i].ad(distAndPoint.getA());
					System.out.println("Blizej jest punkt "+ distAndPoint.getB() + " odleglosc: " + distAndPoint.getA());
				}
				
			}	
			System.out.println("Koniec gry nr " + 1 + " zdobyta liczba punktów " + scores[i].getScore());
			System.out.println("Szukany punkt: " + games[i].getX());
			
		}
		System.out.println(games[0].getX());
		System.out.println("#####  PODSUMOWANIE #####");
		int allPoints = 0;
		for(int i = 0; i<n; i++) {
			System.out.println("Gra nr: " + (i+1) + ", liczba zdobytych punktów: " + scores[i].getScore() + " Liczba rund: " +scores[i].getNum_rounds());
			allPoints += scores[i].getScore();
		}
		System.out.println("Lączna liczba punktów: " + allPoints);
		
		// czytanie z pliku i sprawdzanie czy wynik mniejszy
		// zapis większego wyniku jeśli większy od tego w pliku
		
		File file = new File("best_score.txt");
		List<Board.Pair<Integer, Integer>> pairs = new ArrayList<>(); 
		try {
			Scanner input = new Scanner(file);
			while(input.hasNext()) {
				pairs.add(games[0].new Pair<Integer,Integer>(input.nextInt(), input.nextInt()));
			}
			for(int i = 0; i < pairs.size(); i++) {
				if(pairs.get(m-1).getB()<scores[i].getScore()) {
					saveToFile(i, scores[i].getScore());
				}
			}
			input.close();
			
			
		}catch(FileNotFoundException e) {
			
		}

		

}

	private static void saveToFile(int index, int score) {
		try {
			PrintWriter zapis = new PrintWriter("best_score.txt");
		}catch(FileNotFoundException e) {
			
		}
		
	}
}
