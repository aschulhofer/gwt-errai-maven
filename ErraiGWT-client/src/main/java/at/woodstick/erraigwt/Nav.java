package at.woodstick.erraigwt;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;

@Templated
public class Nav implements IsElement {

	@Inject 
	@DataField("nav-container")
	private HTMLDivElement navContainer;
	
	@PostConstruct
	protected void constructed() {
		
	}
	
	protected void init(List<Pages> pages) {
		
		for(Pages page : pages) {
			HTMLAnchorElement navLink = (HTMLAnchorElement) DomGlobal.document.createElement("a");
			
			navLink.textContent = page.getLinkName();
			navLink.href = "#" + page.getPath();
			navLink.className = "nav-link";
			
			navContainer.appendChild(navLink);
		}
		
	}
}
