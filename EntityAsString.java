package com.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class EntityAsString {
	public static void main(String[] args) {

		ArrayList<JobDocOper> aryJobDocOper = new ArrayList<JobDocOper>();

		try {
			URL obj = new URL("http://sysd/MVSDS/'OJ.MASTER.DOCOPER(FZVBDP10)'");
			URLConnection conn = obj.openConnection();
			String userpass = "co52969" + ":" + "ved18ish";
			String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());

			conn.setRequestProperty ("Authorization", basicAuth);
			InputStream inStream = conn.getInputStream();

			byte[] buffer = new byte[inStream.available()];
			inStream.read(buffer);
			String text = new String(buffer);
			System.out.println(text) ;			
			aryJobDocOper.add(new JobDocOper("FZVBDP10", text));

			inStream.close();
			FileOutputStream fileOut;

			fileOut = new FileOutputStream("C:\\javatemp\\JobDocOper.xls");

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet worksheet = wb.createSheet("Worksheet");

			int i =0;
			for(JobDocOper jobDoc:aryJobDocOper) {
				HSSFRow row = worksheet.createRow(i);
				HSSFCell cellJobName = row.createCell(0);
				HSSFCell cellJobDocoper = row.createCell(1);
				cellJobName.setCellValue(jobDoc.getJobname());
				cellJobDocoper.setCellValue(jobDoc.getJobDocOper());
				i++;
			}
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("File created Successfully!!");
	}
}

