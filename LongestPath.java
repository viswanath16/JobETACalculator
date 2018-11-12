package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestPath {

   
	public static void main(String[] args) {
		CSVUtils csvUtils = new CSVUtils();
		Map<String, JobAverageRunTime> jobAvgRuntime = new HashMap<String, JobAverageRunTime>(); 
		jobAvgRuntime = csvUtils.GenerateJobAvgRunTime("F:\\JobETAAlgo\\JobAvgRuntime.csv");
		
		ArrayList<JobDependency> lstJobDependency = new ArrayList<JobDependency>(); 
		lstJobDependency = csvUtils.GenerateJobDependency("F:\\JobETAAlgo\\JobDependency.csv");
		
		Graph grp = new Graph(jobAvgRuntime.size());
		
		for (JobDependency jobDep : lstJobDependency){
			grp.addEdge( jobAvgRuntime.get(jobDep.getJobname()).jobNameKey(),  jobAvgRuntime.get(jobDep.getSuccessorJobname()).jobNameKey() , jobAvgRuntime.get(jobDep.getJobname()).getJobAvgTime());
		}
		int s = 0;
	    System.out.println("Following are the ETA's from start job to all dependent jobs " + s + "\n");
	    grp.longestPath(s);
	}
}
