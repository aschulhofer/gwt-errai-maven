package at.woodstick.erraigwt.element;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.client.widget.HasModel;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.ForEvent;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.TextBox;

import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;

@Templated
public class DataForm implements IsElement, HasModel<DataFormModel> {
	
	@Inject
	@AutoBound
	private DataBinder<DataFormModel> binder;
	
	@Inject
	@DataField("prop1")
	@Bound(property = "stringProperty")
	private HTMLDivElement prop1;
	
	@Inject
	@DataField("prop2")
	@Bound(property = "dateProperty")
	private HTMLDivElement prop2;
	
	@Inject
	@DataField("prop3")
	@Bound(property = "bigdecimalProperty")
	private HTMLDivElement prop3;
	
	@Inject
	@Named("inputtext")
	@DataField("prop4")
	@Bound(property = "stringProperty")
	private HTMLInputElement prop4;
	
	@Inject 
	@Named("inputtext")
	@DataField("prop5")
	@Bound(property = "dateProperty")
	private HTMLInputElement prop5;
	
	@Inject
	@DataField("prop6")
	@Bound(property = "bigdecimalProperty")
	private TextBox prop6;
	
	@Inject
	@Named("inputtext")
	@DataField("prop7")
	@Bound(property = "counterProperty.button")
	private HTMLInputElement prop7;
	
	@Inject
	@DataField("data-form-log")
	private HTMLDivElement dataFormLog;

	@PostConstruct
	private void constructed() {
		binder.addPropertyChangeHandler(e -> {
			appendLog(e.getPropertyName() + " changed to " + e.getNewValue());
		});
		
		prop6.addValueChangeHandler(e -> {
			appendLog("prop6 changed to " + e.getValue());
		});
	}
	
	@EventHandler("prop4")
	public void onProp4Change(@ForEvent("change") Event e) {
		appendLog("prop4 changed");
	}
	
	@EventHandler("prop6")
	public void onProp6Change(@ForEvent("change") Event e) {
		appendLog("prop6 changed");
	}
	
	protected void appendLog(final String msg) {
		HTMLDivElement newDiv = (HTMLDivElement) DomGlobal.document.createElement("div");
		newDiv.textContent = msg + " (elemental2)";
		dataFormLog.appendChild(newDiv);
	}
	
	@Override
	public DataFormModel getModel() {
		return binder.getModel();
	}

	@Override
	public void setModel(DataFormModel model) {
		binder.setModel(model);
	}
}
