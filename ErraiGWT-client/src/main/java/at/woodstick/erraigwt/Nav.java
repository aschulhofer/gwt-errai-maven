package at.woodstick.erraigwt;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.common.client.dom.Anchor;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.DOM;

@Templated
public class Nav implements IsElement {

	@Inject 
	@DataField("nav-container")
	private Div navContainer;
	
	@PostConstruct
	protected void constructed() {
		
	}
	
	protected void init(List<Pages> pages) {
		
		for(Pages page : pages) {
			Anchor navLink = (Anchor) DOM.createAnchor();
			
			navLink.setTextContent(page.getLinkName());
			navLink.setHref("#" + page.getPath());
			navLink.setClassName("nav-link");
			
			navContainer.appendChild(navLink);
		}
		
	}
}
