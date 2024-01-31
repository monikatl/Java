package lab06;

public class Dog extends Animal {	
	
	private int factor;
	
	public Dog(String name, double weight, int age, int factor) {
		super(name, weight, age);
		this.factor = factor;
		this.setBMI();
	}

	@Override
	public String toString() {
		return viewAlarm() + " Dog [factor=" + factor + ", name=" + name + ", weight=" + weight + ", age=" + age + ", bmi=" + bmi
				+ "]";
	}

	@Override
	public double getBMI() {
		return this.bmi;
	}

	@Override
	public void setBMI() {
		if(this.factor==1) {
			this.bmi = Math.pow(this.weight, 3);
		}else if(this.factor==2) {
			this.bmi = Math.pow(this.weight, 3);
		}else {
			this.bmi = this.weight+10;
		}	
	}

	@Override
	public int getAge() {
		return this.age;
	}


	
}
