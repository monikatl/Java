package lab10;

public enum WeekDay {
	SUNDAY("Niedziela"), 
	MONDAY("Poniedziałek"), 
	TUESDAY("Wtorek"), 
	WEDNESDAY("Środa"),
	THURSDAY("Czwartek"),
	FRIDAY("Piątek"),
	SATURDAY("Sobota");
	
	String nameOfDay;
	
	WeekDay(String nD){
		this.nameOfDay = nD;
	}
	
}
