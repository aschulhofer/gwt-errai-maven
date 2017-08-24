package at.woodstick.erraigwt;

public enum Pages {

	  HOME(Paths.HOME)
	, OVERVIEW(Paths.OVERVIEW)
	;
	
	private String path;

	private Pages(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
	public interface Paths {
		String HOME = "home";
		String OVERVIEW = "overview";
	}
}
