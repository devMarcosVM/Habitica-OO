package habiticaPackage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Habit extends Task {
	private boolean isActive;
	private int positiveStatus;
	private int negativeStatus;
	private boolean positiveSelected;
	private boolean negativeSelected;
	LocalDate updatedAt;
	
	public Habit() {
		super();
		isActive = false;
		positiveStatus = 0;
		negativeStatus = 0;
		positiveSelected = false;
		negativeSelected = false;
	}
	
	public boolean getIsActive() {
		return isActive;
	}
	public boolean getPositiveSelected() {
		return positiveSelected;
	}
	public boolean getNegativeSelected() {
		return negativeSelected;
	}
	public int getPositiveStatus() {
		return positiveStatus;
	}
	public int getNegativeStatus() {
		return negativeStatus;
	}
	
	public void setPositiveSelected(boolean change) {
		positiveSelected = change;
	}
	public void setNegativeSelected(boolean change) {
		negativeSelected = change;
	}
	
	public void setPositiveStatus(int value) {
		positiveStatus = value;
		
	}
	public void setNegativeStatus(int value) {
		negativeStatus = value * -1;
	}
	public int finishHabit(int value) {
		if(isActive == false) {
			updatedAt = LocalDate.now();
			isActive = true;
			setChecked(true);
			return value;
		}
		return 0;
		
	}
	
	public void checkActiveHabit(String range) {
		long daysDifference = ChronoUnit.DAYS.between(updatedAt, LocalDate.now());
		if(range == "daily" && daysDifference >= 1) isActive = false;
		else if(range == "weekly" && daysDifference >= 7) isActive = false;
		else if(range == "monthly" && daysDifference >=30) isActive = false;
	}
	
}
