package at.woodstick.erraigwt.element;

import java.math.BigDecimal;
import java.util.Date;

import org.jboss.errai.databinding.client.api.Bindable;

@Bindable
public class DataFormModel {

	private String stringProperty;
	private Date dateProperty;
	private BigDecimal bigdecimalProperty;
	
	private Counter counterProperty;
	
	public DataFormModel() {
	
	}

	public String getStringProperty() {
		return stringProperty;
	}

	public void setStringProperty(String stringProperty) {
		this.stringProperty = stringProperty;
	}

	public Date getDateProperty() {
		return dateProperty;
	}

	public void setDateProperty(Date dateProperty) {
		this.dateProperty = dateProperty;
	}

	public BigDecimal getBigdecimalProperty() {
		return bigdecimalProperty;
	}

	public void setBigdecimalProperty(BigDecimal bigdecimalProperty) {
		this.bigdecimalProperty = bigdecimalProperty;
	}

	public Counter getCounterProperty() {
		return counterProperty;
	}

	public void setCounterProperty(Counter counterProperty) {
		this.counterProperty = counterProperty;
	}
}
