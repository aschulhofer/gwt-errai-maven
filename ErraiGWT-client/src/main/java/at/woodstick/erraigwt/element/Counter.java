package at.woodstick.erraigwt.element;

import org.jboss.errai.databinding.client.api.Bindable;

@Bindable
public class Counter {
	private int element;
	private int button;

	public Counter() {
	
	}

	public Counter(int element, int button) {
		this.element = element;
		this.button = button;
	}

	public void incElementCount() {
		element++;
	}
	
	public void incButtonCount() {
		button++;
	}
	
	public int getElement() {
		return element;
	}

	public int getButton() {
		return button;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public void setButton(int button) {
		this.button = button;
	}
}
