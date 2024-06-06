package habiticaPackage;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private int hp;
	private int xp;
	private int level;
	private int xpLimit;
	Task[][] tasks;
	Tag[] tags;
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		hp = 100;
		xp = 0;
		level = 0;
		tasks = new Task[2][1000];
	}
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public int getHp() {
		return hp;
	}
	public int getXp() {
		return xp;
	}
	public int getLevel() {
		return level;
	}
	public int getXpLimit() {
		return xpLimit;
	}
	public Task[][] getTasks(){
		return tasks;
	}
	public Task getTask(String taskType, int position){
		
		if(taskType == "habit") {
			if(tasks[0][position] != null) return tasks[0][position];
		}
		else if(taskType == "todo") {
			if(tasks[1][position] != null) return tasks[1][position];
		}
		else {
			System.out.println("\nNao foi possivel encontrar a tarefa desejada.");
		}
		return null;
	}
	public Tag[] getTags() {
		return tags;
	}
	public void setTag(Tag tag) {
		for(int i = 0; i < tags.length; i++) {
			if(tags[i] == null) {
				tags[i] = tag;
			}
		}
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setXpLimit() {
		if(level == 0) xpLimit = 25;
		else xpLimit = level * 25;
	}
	public void setTasks(Task task) {
		if(task instanceof Habit) {
			for(int i = 0; i < tasks[0].length; i++) {
				if(tasks[0][i] == null) {
					tasks[0][i] = task;
					break;
				}
			}
		}else if(task instanceof ToDo) {
			for(int i = 0; i < tasks[1].length; i++) {
				if(tasks[1][i] == null) {
					tasks[1][i] = task;
					break;
				}
			}
		}
	}
	
	public void setTags(Tag tag) {
		for(int i = 0; i < tags.length; i++) {
			if(tags[i] == null) {
				tags[i] = tag;
				break;
			}
		}
	}
	
	public void updateHp(Habit task, int status) {
		if(task.getChecked() == true) {
        	if(hp <= 100 && hp >= 0) hp += status;
        	else if(hp + status > 100) setHp(100);
        	else if(hp + status < 0) setHp(0);
        }
	}
	
	public void updateXp(Task task, int position) {
		int gainedXp = 0;
		if(task.getDifficulty() == "easy") {
			gainedXp = level;
		}
		else if(task.getDifficulty() == "medium") {
			gainedXp = level * 2;
		}
		else if(task.getDifficulty() == "hard") {
			gainedXp = level * 3;
		}
		if(task.getChecked() == true) xp += gainedXp;
		
		if(xp >= xpLimit) {
			level += 1;
			setXpLimit();
			xp = 0;
		}
	}
	
	public void updateTask(Task task, int position) {
		if(task instanceof Habit) {
			if(tasks[0][position] != null) {
				tasks[0][position] = task;
			}
		}
		else if(task instanceof ToDo) {
			if(tasks[1][position] != null) {
				tasks[1][position] = task;
			}
		}
	}
	public void updateTag(Tag tag, int position) {
		if(tags[position] != null) tags[position] = tag;
		else System.out.print("\nNão foi possivel encontrar essa tag\n");
	}
	
	public void deleteTask(String taskType, int position) {
		if(taskType == "habit") {
			if(tasks[0][position] != null) tasks[0][position] = null;
			
		}
		else if(taskType == "todo") {
			if(tasks[1][position] != null) tasks[1][position] = null;
		}
		else System.out.print("\nNao foi possivel encontrar esse habito.\n");
	}
	
	public void deleteTag(int position) {
		if(tags[position] != null) tags[position] = null;
		else System.out.print("\nNao foi possivel encontrar essa tag\n");
	}
}
