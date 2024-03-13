package edu.kh.model.dto;

public class Review {
	
	private String deprId;
	private String deptTitle;
	private String locationId;
	
	public Review() {}

	public Review(String deprId, String deptTitle, String locationId) {
		super();
		this.deprId = deprId;
		this.deptTitle = deptTitle;
		this.locationId = locationId;
	}

	public String getDeprId() {
		return deprId;
	}

	public void setDeprId(String deprId) {
		this.deprId = deprId;
	}

	public String getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Reivew [deprId=" + deprId + ", deptTitle=" + deptTitle + ", locationId=" + locationId + "]";
	}
	
	

}
