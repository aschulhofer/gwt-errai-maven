package at.woodstick.erraigwt;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.enterprise.client.jaxrs.MarshallingWrapper;
import org.jboss.errai.enterprise.client.jaxrs.api.RestErrorCallback;
import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.nav.client.local.PageShown;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.slf4j.Logger;

import com.google.common.base.Strings;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

import at.woodstick.erraigwt.service.TestRestEndpointService;

@Page(path = "overview")
@Templated
public class OverviewPage extends Composite {

	@Inject
	private Logger log;
	
	@Inject
	@DataField("in1")
	private Label itemField1;
	
	@Inject
	@DataField("in2")
	private Label itemField2;
	
	@Inject
	@DataField("in3")
	private Label itemField3;
	
	@Inject
	@DataField("item-input")
	private TextBox itemInput;
	
	@Inject
	@DataField("refresh-button")
	private Button refreshItemFieldButton;
	
	@Inject
	private Caller<TestRestEndpointService> testEndpoint;
	
	@PostConstruct
	private void constructed() {
		ItemSpec itemSpec1 = new ItemSpec("000.000");
		
		setItemText(itemField1, itemSpec1);
		setItemText(itemField2, itemSpec1);
		setItemText(itemField3, itemSpec1);
		
		refreshItemFieldButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String textInput = itemInput.getText();
				
				if(Strings.isNullOrEmpty(textInput)) {
					return;
				}
				
				setItemField2(textInput);
			}
		});
	}

	private void setItemText(HasText element, ItemSpec item) {
		element.setText(item.getItemNumber());
	}
	
	@PageShowing
	private void preparePage() {
		log.debug("Overview page showing");
	}

	@PageShown
	private void showPage() {
		log.debug("Overview page shown");
		
		
	}
	
	@AfterInitialization
	private void afterInit() {
		setItemField2("020.020");
	}
	
	private void setItemField2(final String itemString) {
		testEndpoint.call(new RemoteCallback<Response>() {
			@Override
			public void callback(Response response) {
				log.debug("Status code: {}", response.getStatusCode());
				log.debug("Response text: {}", response.getText());
				
				final ItemSpec itemSpec = MarshallingWrapper.fromJSON(response.getText(), ItemSpec.class);
				
				setItemText(itemField2, itemSpec);
			}
		}, new RestErrorCallback() {
			@Override
			public boolean error(Request message, Throwable throwable) {
				return false;
			}
		}).getItemSpec(itemString);
	}
}
