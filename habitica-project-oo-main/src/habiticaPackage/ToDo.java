package habiticaPackage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;

public class ToDo extends Task {
	Checklist[] checklists;
	LocalDate upTo;
	private boolean timeLimitReached;
	
	public ToDo(){
		super();
		checklists = new Checklist[1000];
		timeLimitReached = false;
	}
	
	public Checklist[] getChecklists() {
		return checklists;
	}
	public LocalDate getUpTo() {
		return upTo;
	}
	public boolean getTimeLimitReached() {
		return timeLimitReached;
	}
	public void setChecklist(Checklist checklist) {
		for(int i = 0; i < checklists.length; i++) {
			if(checklists[i].getTitle() == null) {
				checklists[i] = checklist;
				break;
			}
		}
	}
	public void setUpTo(LocalDate upTo) {
		this.upTo = upTo;
	}
	
	public void scheduling() {
		long daysDifference = ChronoUnit.DAYS.between(LocalDate.now(), upTo);
		if(daysDifference == 0) {
			timeLimitReached = true;
		}
	}
	public void updateChecklist(Checklist checklist, int position) {
		if(checklists[position] != null) {
			if(checklist.getTitle() != null) checklists[position] = checklist;
		}else {
			System.out.println("\nNao foi possivel encontrar a checklist desejada.");
		}
	}
	public void deleteChecklist(int position) {
		if(checklists[position] != null) {
			checklists[position] = null;
		}
		else System.out.println("\nNao foi possivel deletar a checklist desejada.");
	}
}
