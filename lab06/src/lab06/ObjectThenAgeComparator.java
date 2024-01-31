package lab06;

import java.util.Comparator;

public class ObjectThenAgeComparator implements Comparator<Dietician> {

	@Override
	public int compare(Dietician o1, Dietician o2) {
		if(o1.getClass()==o2.getClass()) return o1.compareTo(o2);		
		else if(o1 instanceof Dog) return -1;
		else return 1;	
	}

}
