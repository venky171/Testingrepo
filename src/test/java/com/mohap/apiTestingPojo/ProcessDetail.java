package com.mohap.apiTestingPojo;

public class ProcessDetail {
	
	private int ProcessId;
	private String ProcessName;
	private boolean IsFavourite;
	private int PendingActionCount;
	private String IconUrl;
	private String MobileIconUrl;
	 
	 
	
	public int getProcessId() {
		return ProcessId;
	}
	public void setProcessId(int processId) {
		ProcessId = processId;
	}
	public String getProcessName() {
		return ProcessName;
	}
	public void setProcessName(String processName) {
		ProcessName = processName;
	}
	public boolean isIsFavourite() {
		return IsFavourite;
	}
	public void setIsFavourite(boolean isFavourite) { 
		IsFavourite = isFavourite;
	}
	public int getPendingActionCount() {
		return PendingActionCount;
	}
	public void setPendingActionCount(int pendingActionCount) {
		PendingActionCount = pendingActionCount;
	}
	public String getIconUrl() {
		return IconUrl;
	}
	public void setIconUrl(String iconUrl) {
		IconUrl = iconUrl;
	}
	public String getMobileIconUrl() {
		return MobileIconUrl;
	}
	public void setMobileIconUrl(String mobileIconUrl) {
		MobileIconUrl = mobileIconUrl;
	}
	
	
		
	
}
