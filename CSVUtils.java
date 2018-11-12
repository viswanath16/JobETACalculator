package com.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CSVUtils {
	
public Map<String, JobAverageRunTime> GenerateJobAvgRunTime(String csvFileLocationJobAvgRuntime){
	
	//String csvJobAvgRuntimeFile = "C:\\javatemp\\JobAvgRuntime.csv";
	BufferedReader brJobAvgRuntimeFile = null;
    String line = "";
    String cvsSplitBy = ",";
    HashMap<String, JobAverageRunTime> mapJobAvgRuntime = new HashMap<>();
    
    try {
    	
    	brJobAvgRuntimeFile = new BufferedReader(new FileReader(csvFileLocationJobAvgRuntime));
        //ignoring header
        brJobAvgRuntimeFile.readLine();    
        
        ArrayList<String> strReadLine = new ArrayList<String>();
        while ((line = brJobAvgRuntimeFile.readLine()) != null) {
         	strReadLine.add(line);
        }
        
        for (int i=0;i<strReadLine.size() ;i++) {
        	String[] strTmpJobRuntime = strReadLine.get(i).split(cvsSplitBy);
        	JobAverageRunTime  jobAvgRunTime = new JobAverageRunTime(strTmpJobRuntime[0], Integer.parseInt(strTmpJobRuntime[1]), i); 
        	mapJobAvgRuntime.put(strTmpJobRuntime[0], jobAvgRunTime);
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }     
	
    return mapJobAvgRuntime;
}

public ArrayList<JobDependency> GenerateJobDependency(String csvFileLocationJobDependency){
	//String csvJobDependencyFile = "C:\\javatemp\\JobDependency.csv";
	BufferedReader brJobDependencyFile = null;
	String line = "";
	String cvsSplitBy = ",";
	
	ArrayList<JobDependency> lstJobDependency = new ArrayList<JobDependency>();
	
	try {
    	brJobDependencyFile = new BufferedReader(new FileReader(csvFileLocationJobDependency));
        //ignoring header
    	brJobDependencyFile.readLine();        
        while ((line = brJobDependencyFile.readLine()) != null) {
            // use comma as separator
            String[] strSuccesorJobs = line.split(cvsSplitBy);
            JobDependency jobDep = new JobDependency(strSuccesorJobs[0],strSuccesorJobs[1]); 
            lstJobDependency.add(jobDep);            
        }
	} catch (Exception e) {
        e.printStackTrace();
    } 
	
	return lstJobDependency;
}

}