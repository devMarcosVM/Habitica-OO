package habiticaPackage;

public abstract class Task {
	private String title;
	private String note;
	private String difficulty;
	public boolean checked;
	Tag[] tags;
	
	public Task() {
		title = null;
		note = null;
		difficulty = null;
		checked = false;
		tags = new Tag[10];
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public void setTag(Tag tag) {
		for(int i = 0; i < tags.length; i++) {
			if(tags[i] == null) {
				tags[i] = tag;
			}
		}
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getTitle() {
		return title;
	}
	public String getNote() {
		return note;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public Tag[] getTags() {
		return tags;
	}
	public boolean getChecked() {
		return checked;
	}
	
	public void updateTag(Tag tag, int position) {
		if(tags[position] != null && tag.getTagName() != null) {
			tags[position] = tag;
		}
	}
	
	public void deleteTag(int position) {
		if(tags[position] != null) {
			tags[position] = null;
		}
	}
}
