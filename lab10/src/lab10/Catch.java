package lab10;

import java.util.Calendar;

public class Catch {
	@Override
	public String toString() {
		return "Catch [date=" + date.get(Calendar.DAY_OF_MONTH)+ " " + date.get(Calendar.MONTH)+ " " + date.get(Calendar.YEAR)+", " + fisherman + ", fish=" + fish + "]";
	}

	Calendar date;
	Fisherman fisherman;
	Fish fish;
	
	
	public Catch(Calendar date, Fisherman fisherman, Fish fish) {
		this.date = date;
		this.fisherman = fisherman;
		this.fish = fish;
	}
	
	public int getLength() {
		return fish.getLength();
	}
	
	public String getFishermanName(){
		return fisherman.getName();
	}
	
	public Fisherman getFisherman(){
		return fisherman;
	}
	
	public String getDate(){
		return date.toString();
	}
	
	public Calendar date() {
		return date;
	}
	
	public int day() {	
		return this.date.get(Calendar.DAY_OF_WEEK);
	}
	
	public String getNameOfDay() {
		switch(this.day()) {
			case 1: return WeekDay.SUNDAY.nameOfDay;
			case 2: return WeekDay.MONDAY.nameOfDay;
			case 3: return WeekDay.TUESDAY.nameOfDay;
			case 4: return WeekDay.WEDNESDAY.nameOfDay;
			case 5: return WeekDay.THURSDAY.nameOfDay;
			case 6: return WeekDay.FRIDAY.nameOfDay;
			case 7: return WeekDay.SATURDAY.nameOfDay;
			default:
				return "";
		}
	}

	public Fish getFish() {
		return this.fish;
	}

}
