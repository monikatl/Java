package lab06;

public abstract class Animal implements Dietician {
	protected String name;
	protected double weight;
	protected int age;
	protected double bmi;
	
	public Animal(String name, double weight, int age) {
		super();
		this.name = name;
		this.weight = weight;
		this.age = age;
	}
	
}
