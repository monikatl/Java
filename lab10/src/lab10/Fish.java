package lab10;

public class Fish {
	public int getLength() {
		return length;
	}

	@Override
	public String toString() {
		return "Fish [species=" + species + ", weight=" + weight + ", length=" + length + "]";
	}

	String species;
	double weight;
	int length;
	
	public Fish(String species, double weight, int length) {
		this.species = species;
		this.weight = weight;
		this.length = length;
	}

	public String getSpecies() {
		return this.species;
	}

	public double getWeight() {
		return weight;
	}
}
