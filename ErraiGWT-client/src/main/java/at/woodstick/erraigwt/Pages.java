package at.woodstick.erraigwt;

public enum Pages {

	  HOME(Paths.HOME, "Home")
	, OVERVIEW(Paths.OVERVIEW, "Overview")
	, DATATABLE(Paths.DATATABLE, "Datatable")
	, LAYOUT(Paths.LAYOUT, "Layout")
	;
	
	private final String path;
	private final String linkName;

	private Pages(String path, String linkName) {
		this.path = path;
		this.linkName = linkName;
	}

	public String getPath() {
		return path;
	}
	
	public String getLinkName() {
		return linkName;
	}

	public interface Paths {
		String HOME = "home";
		String OVERVIEW = "overview";
		String DATATABLE = "datatable";
		String LAYOUT = "layout";
	}
}
