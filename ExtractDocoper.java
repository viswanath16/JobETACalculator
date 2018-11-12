package com.main;

import java.io.*;

public class ExtractDocoper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // The name of the file to open.
        String strSourceJobList = "C:\\Eclipse-Workspace\\EtaCalculator\\EtaSrcFiles\\JobDependency.csv";
        String strJobDocoperList = "C:\\Eclipse-Workspace\\EtaCalculator\\EtaSrcFiles\\JobsDocoper.txt";

        try {
            // Use this for reading the data.
            byte[] buffer = new byte[1000];

            FileInputStream inputStream = new FileInputStream(strSourceJobList);
            FileOutputStream outputStream = new FileOutputStream(strJobDocoperList);

            // read fills buffer with data and returns
            // the number of bytes read (which of course
            // may be less than the buffer size, but
            // it will never be more).
            int total = 0;
            int nRead = 0;
            while((nRead = inputStream.read(buffer)) != -1) {
                // Convert to String so we can display it.
                // Of course you wouldn't want to do this with
                // a 'real' binary file.
            	outputStream.write(buffer);
            	total += nRead;
            }   

            // Always close files.
            inputStream.close();        
            outputStream.close(); 
            
        }
        catch(FileNotFoundException ex) {
            System.out.println( "Unable to open file '" + strSourceJobList + "'");                
        }
        catch(IOException ex) {
            System.out.println( "Error reading file '" + strSourceJobList + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }

	}

}
