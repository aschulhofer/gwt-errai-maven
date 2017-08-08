package at.woodstick.erraigwt;

public class NameSpec {

	private final String name;

	public NameSpec(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String getExtName() {
		return name + ".ext";
	}
	
	public String getConst() {
		return "const";
	}
}
