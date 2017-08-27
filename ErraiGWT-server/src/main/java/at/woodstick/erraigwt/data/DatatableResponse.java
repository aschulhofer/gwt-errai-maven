package at.woodstick.erraigwt.data;

import java.util.List;

/**
 * <a href="https://datatables.net/manual/server-side">Datatable manual server side processing</a>
 */
public class DatatableResponse<T> {
	
	private int draw;
	
	private int recordsTotal;
	private int recordsFiltered;
	
	private String error;
	
	private List<T> data;

	public DatatableResponse() {
	}

	public DatatableResponse(int draw, int recordsTotal, int recordsFiltered, String error, List<T> data) {
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.error = error;
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
