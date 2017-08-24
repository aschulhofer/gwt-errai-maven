package at.woodstick.erraigwt.element;

import javax.inject.Inject;

import org.jboss.errai.common.client.ui.HasValue;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
public class ParanthesesLabel implements IsElement, HasValue<String> {

	@Inject
	@DataField("value")
	private ParanthesesTextLabel valueLabel;

	@Override
	public String getValue() {
		return valueLabel.getValue();
	}

	@Override
	public void setValue(String value) {
		valueLabel.setValue(value);
	}
}
