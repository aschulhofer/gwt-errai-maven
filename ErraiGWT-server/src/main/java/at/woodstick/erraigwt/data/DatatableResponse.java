package at.woodstick.erraigwt.data;

import java.util.List;

public class DatatableResponse<T> {
	private List<T> data;

	public DatatableResponse() {
	}

	public DatatableResponse(List<T> data) {
		this.data = data;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
