package at.woodstick.erraigwt.ui.layout;

import javax.inject.Inject;

import org.jboss.errai.ui.client.local.api.elemental2.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import elemental2.dom.HTMLDivElement;

@Templated(StandardLayout.TEMPLATE)
public abstract class StandardLayout implements IsElement {

	public static final String TEMPLATE = "/at/woodstick/erraigwt/ui/layout/StandardLayout.html";
	public static final String FIELD_CONTENT = "layout-content";
	
	@Inject
	@DataField("layout-header")
	protected Header header;
	
	@Inject
	@DataField("layout-navigation")
	protected NavBar navBar;
	
	@Inject
	@DataField(FIELD_CONTENT)
	protected HTMLDivElement content;
}
