package at.woodstick.erraigwt;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class NameSpec {

	private final String name;

	public NameSpec(@MapsTo("name") String name) {
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
