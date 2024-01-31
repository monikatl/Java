package lab10;

public class Fisherman {
	String name;
	int id;
	
	public Fisherman(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nazwisko) {
		this.name = nazwisko;
	}

	@Override
	public String toString() {
		return "Fisherman [name=" + name + ", id=" + id + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
