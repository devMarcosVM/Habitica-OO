package habiticaPackage;

public class Tag {
	private String tagName;
	private boolean checked;
	
	public Tag () {
		tagName = null;
		checked = false;
	}
	public Tag(String tagName) {
		this.tagName = tagName;
		checked = false;
	}
	
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public String getTagName() {
		return tagName;
	}
	public boolean getChecked() {
		return checked;
	}
}
