package lab06;

public interface Dietician extends Comparable<Dietician> {
	
	int ALARM = 30;
	
	double getBMI();
	void setBMI();
	int getAge();
	
	default String viewAlarm() {
		if(this.getBMI()>Dietician.ALARM) {
			return "ALARM. Problem nadwaga";
		}
		return "";
	}
	
	@Override
	default int compareTo(Dietician o) {
		return Integer.compare(this.getAge(), o.getAge());
	}
	
}
