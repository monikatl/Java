package lab06;

public class Person implements Dietician {
	private String personalData;
	private int age;
	private double height;
	private double weight;
	private double bmi;
	
	public Person(String personalData, int age, double height, double weight) {
		super();
		this.personalData = personalData;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.setBMI();
		if(this.getBMI()>Dietician.ALARM) {
			System.out.println(viewAlarm());
		}
	}

	@Override
	public String toString() {
		return viewAlarm() + " Person [personalData=" + personalData + ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", bmi=" + bmi + "]";
	}

	@Override
	public double getBMI() {
		return this.bmi;
	}

	@Override
	public void setBMI() {
		this.bmi = weight/Math.pow(height*0.01, 2);
		
	}

	@Override
	public int getAge() {
		return this.age;
	}
	
	
}
