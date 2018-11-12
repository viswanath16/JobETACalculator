package com.main;

public class JobDocOper {

	private String strJobname;
	private String strJobDocOper;
	
	public JobDocOper(String inStrJobname, String inStrJobDocOper) {
		
		strJobname = inStrJobname;
		strJobDocOper = inStrJobDocOper;
	}
	
	public void setJobname(String inStrJobname)
	{
		strJobname = inStrJobname;
	}
	
	public String getJobname()
	{
	    return strJobname;
	}
	
	
	public void setSuccessorJobname(String inJobDocOper)
	{
		strJobDocOper = inJobDocOper;
	}
	
	public String getJobDocOper()
	{
	    return strJobDocOper;
	}
	
}
