package lab08;

public class Point implements GameScoring {
	private int score;
	private int num_rounds;
	
	
	@Override
	public String toString() {
		return "Point [score=" + score + ", num_rounds=" + num_rounds + "]";
	}

	public int getScore() {
		return score;
	}

	public int getNum_rounds() {
		return num_rounds;
	}

	public Point() {
		this.score = 0;
		this.num_rounds = 0;
	}

	public void addScore(int increase) {
		this.score += increase;
	}
	
	public void addRound() {
		this.num_rounds++;
	}
	
	public void calculateWinPoints(int round) {
		switch(round){
			case 1: this.score+=p_1;
			case 2: this.score+=p_2;
			case 3: this.score+=p_3;
			case 4: this.score+=p_4;
			case 5: this.score+=p_5;
			default:this.score += 0;
		}
	}

	@Override
	public void ad(int distance) {
		int temp = 10-distance;
		if(temp<0) 
			this.score+=0;
		else
		    this.score+=temp;
	}
	
	public void gameWonInfo() {
		System.out.println("Gratulacje! Cel trafiony w rundzie: " + getNum_rounds() + ", liczba zdobytych punktów: " + getScore());
	}
	
}
