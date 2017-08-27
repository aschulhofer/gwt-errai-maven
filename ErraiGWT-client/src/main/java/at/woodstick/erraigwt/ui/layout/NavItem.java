package at.woodstick.erraigwt.ui.layout;

public class NavItem {
	
	public static final Path EMPTY_PATH = new NavItem.Path("");
	
	private Path linkPath = EMPTY_PATH;
	private String displayTextKey = "navitem.key.not.set";

	public NavItem() {
	}

	public NavItem(Path linkPath, String displayTextKey) {
		this.linkPath = linkPath;
		this.displayTextKey = displayTextKey;
	}

	public Path getLinkPath() {
		return linkPath;
	}

	public String getDisplayTextKey() {
		return displayTextKey;
	}

	public NavItem withPath(String path) {
		return withPath(new Path(path));
	}
	
	public NavItem withPath(Path path) {
		this.linkPath = path;
		return this;
	}
	
	public NavItem withDisplayTextKey(String displayTextKey) {
		this.displayTextKey = displayTextKey;
		return this;
	}
	
	public static NavItem item() {
		return new NavItem();
	}
	
	public static class Path {
		private String path;

		public Path(String path) {
			this.path = path;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
	}
}
