package com.main;

public class JobAverageRunTime {

	private String strJobname;
	private int jobAvgTime;
	private int jobNameKey;
	
	public JobAverageRunTime(String inStrJobname, int inJobAvgTime, int injobNameKey) {
		
		strJobname = inStrJobname;
		jobAvgTime = inJobAvgTime;
		jobNameKey = injobNameKey;
	}
	
	public void setJobname(String inStrJobname)
	{
		strJobname = inStrJobname;
	}
	
	public String getJobname()
	{
	    return strJobname;
	}
	
	
	public void setJobAvgTime(int inJobAvgTime)
	{
		jobAvgTime = inJobAvgTime;
	}
	
	public int getJobAvgTime()
	{
	    return jobAvgTime;
	}
	public void setjobNameKeye(int injobNameKey)
	{
		jobNameKey = injobNameKey;
	}
	
	public int jobNameKey()
	{
	    return jobNameKey;
	}
	
}
