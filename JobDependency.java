package com.main;

public class JobDependency {

	private String strJobname;
	private String strSuccessorJobname;
	
	public JobDependency(String inStrJobname, String inStrSuccessorJobname) {
		
		strJobname = inStrJobname;
		strSuccessorJobname = inStrSuccessorJobname;
	}
	
	public void setJobname(String inStrJobname)
	{
		strJobname = inStrJobname;
	}
	
	public String getJobname()
	{
	    return strJobname;
	}
	
	
	public void setSuccessorJobname(String inSuccessorJobname)
	{
		strSuccessorJobname = inSuccessorJobname;
	}
	
	public String getSuccessorJobname()
	{
	    return strSuccessorJobname;
	}
	
}
