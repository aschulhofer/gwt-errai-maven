package at.woodstick.erraigwt;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;

@Portable
@Bindable
public class NameSpec {

	private String name;

	public NameSpec() {
	}

	public NameSpec(@MapsTo("name") String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getExtName() {
		return name + ".ext";
	}
	
	public String getConst() {
		return "const";
	}
}
