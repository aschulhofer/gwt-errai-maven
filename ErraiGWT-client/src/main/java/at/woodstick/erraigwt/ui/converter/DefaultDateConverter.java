package at.woodstick.erraigwt.ui.converter;

import java.util.Date;

import org.jboss.errai.databinding.client.api.Converter;
import org.jboss.errai.databinding.client.api.DefaultConverter;

@DefaultConverter
public class DefaultDateConverter implements Converter<Date, String> {

	@Override
	public Class<Date> getModelType() {
		return Date.class;
	}

	@Override
	public Class<String> getComponentType() {
		return String.class;
	}

	@Override
	public Date toModelValue(String componentValue) {
		return componentValue != null ? new Date(System.currentTimeMillis()) : null;
	}

	@Override
	public String toWidgetValue(Date modelValue) {
		return modelValue != null ? modelValue.toString() : "";
	}

}
