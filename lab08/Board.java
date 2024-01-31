package lab08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
	
	private Point x;
	private List<Pair<Point, Point>>user_points;
	
	public Board() {
		this.x = randomPoint();
		this.user_points = new ArrayList<>();
	}

	public class Pair<T, R>{	
		private T a;
		private R b;
		
		public Pair(T p1, R p2) {
			this.a = p1;
			this.b = p2;
		}
		public Pair() {}

		public T getA() {
			return a;
		}

		public void setA(T a) {
			this.a = a;
		}

		public R getB() {
			return b;
		}

		public void setB(R b) {
			this.b = b;
		}
	
	}
	
	public class Point{
		private int x;
		private int y;
		
		public Point(int x, int y) {
			if(x<1 || x>8) 
				throw new IllegalArgumentException();
			this.x = x;
			if(y<1 || y>8)
				throw new IllegalArgumentException();
			this.y = y;
		}
		
		public String toString() {
			return "(" + x +", " + y +")";
		}
	}
	
	public Point randomPoint() {
		Random rnd = new Random();
		Point point = new Point(rnd.nextInt(8)+1, rnd.nextInt(8)+1);
		return point;
	}


	public static int countDistance(Point pointX, Point user) {	
		return Math.abs(pointX.x - user.x) + Math.abs(pointX.y - user.y);
	}
	

	//return distance od better point
	public Board.Pair<Integer, Point> check() {
		Board.Pair<Integer, Point> distanceAndPoint = this.new Pair<Integer, Point>();
		int size = user_points.size();
		int distPA = countDistance(this.x, user_points.get(size-1).a);
		int distPB = countDistance(this.x, user_points.get(size-1).b);
		if(distPA==0 || distPB==0) {
			distanceAndPoint.setA(0);
		}else {
			if(distPA<distPB) {
				distanceAndPoint.setA(distPA);
				distanceAndPoint.setB(user_points.get(size-1).a);
			}else {
				distanceAndPoint.setA(distPB);
				distanceAndPoint.setB(user_points.get(size-1).b);
			}
				
		}
		return distanceAndPoint;
	}

	
	public Point getX() {
		return x;
	}


	public void setX(Point x) {
		this.x = x;
	}


	public void addUserPoints(int ax, int ay, int bx, int by) throws IllegalArgumentException {
		this.user_points.add(new Pair<Point, Point>(new Point(ax, ay), new Point(bx, by)));
	}
	

	
	
	
	
}
