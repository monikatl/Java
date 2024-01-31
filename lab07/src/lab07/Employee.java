package lab07;

public class Employee implements Accountant {
	
	private String name;
	private int age;
	private double fte;
	private double salaryFTE;
	private double netSalary;
	private String position;

	public Employee(String name, double fte, double salaryFTE, int age, String position) {
		this.name = name;
		this.age = age;
		this.fte = fte;
		this.salaryFTE = salaryFTE;
		this.position = position;	
	}
	
	public String toFile() {
		return "**** zapis lambda ****\n" + this.name + " lat: " + this.age
				+ "  \n" + this.position + " etat: " + this.fte +"\n" 
				+ "  placa_pod="+ this.salaryFTE + "PLN -> pensja=" + this.netSalary + " PLN"
				+ "\n---------------------";
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getFte() {
		return fte;
	}

	public void setFte(double fte) {
		this.fte = fte;
	}

	public double getSalaryFTE() {
		return salaryFTE;
	}

	public void setSalaryFTE(double salaryFTE) {
		this.salaryFTE = salaryFTE;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public double countSalary() {
		double hcc_div = 1-RATE_PIT-HCC;
		if(age<=26) {
			hcc_div = 1 - HCC;
		}
		return this.salaryFTE * this.fte * hcc_div;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", fte=" + fte + ", salaryFTE=" + salaryFTE  + ", position=" + position  + ", netSalary="
				+ netSalary + "]";
	}



}
