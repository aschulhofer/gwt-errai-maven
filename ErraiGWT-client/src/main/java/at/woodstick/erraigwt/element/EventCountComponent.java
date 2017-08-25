package at.woodstick.erraigwt.element;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.Event;
import org.jboss.errai.common.client.dom.Span;
import org.jboss.errai.databinding.client.BindableProxy;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.client.widget.HasModel;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.ForEvent;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.ButtonElement;

@Templated
public class EventCountComponent implements IsElement, HasModel<Counter> {

	@Inject
	@AutoBound
	private DataBinder<Counter> binder;
	
	@Inject
	@DataField("root")
	private Div rootElement;
	
	@Inject
	@DataField("element-count")
	@Bound(property = "element")
	private Span elementCountDisplay;

	@Inject
	@DataField("button-count")
	@Bound(property = "button")
	private Span buttonCountDisplay;
	
	@Inject
	@DataField("count-button")
	private ButtonElement countButton;
	
	private Counter counterInstance = new Counter(0, 0);
	
	@PostConstruct
	protected void constructed() { 
		countButton.setInnerHTML("Click me!");
	}
	
	@AfterInitialization
	protected void afterInit() {
		setModel(counterInstance);
	}
	
	@EventHandler("root")
	public void handleRootClick(@ForEvent("click") Event e) {
		getModel().incElementCount();
	}
	
	@EventHandler("count-button")
	public void handleButtonClick(@ForEvent("click") Event e) {
		getModel().incButtonCount();
	}
	
	public Counter getCounterInstance() {
		return counterInstance;
	}
	
	@SuppressWarnings("unchecked")
	public Counter getModelRef() {
		return (Counter) ((BindableProxy<Counter>) binder.getModel()).unwrap();
	}
	
	@Override
	public Counter getModel() {
		return binder.getModel();
	}

	@Override
	public void setModel(Counter model) {
		binder.setModel(model);
	}
}
