package com.bridgelaze.in;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import com.opencsv.CSVReader;

public class StateCensusCSVRead {
private static final String CustomException = null;
	

	public void readcsv() throws IOException {
      
      CSVReader reader = new CSVReader(new FileReader("E:\\IndianStatesCensusReport.csv"));
     
      StringBuffer buffer = new StringBuffer();
      String line[];
    
      Iterator it = reader.iterator();
      while (it.hasNext()) {
         line = (String[]) it.next();
         System.out.println(Arrays.toString(line));
         System.out.println(" ");
      }
   }

	public int readNoOfRecords(String fileName) throws IOException {
	
		BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Nrupsh mhatre\\eclipse-workspace\\IndianStatesCensusReport.csv"));
		String line;
	     int count = 0;
	     while((line = bufferedReader.readLine()) != null)
	     {
	         count++;
	     }

	     System.out.print("      Total No of Records or Count :  ");
	     return count;
		   
		}

	public boolean readDelimiter(String filePathRead, String delimiter) throws IOException,CustomException {
		CustomException ce = new CustomException(filePathRead, null);
		Scanner input = new Scanner(Paths.get(filePathRead));
        boolean flag = true;
        try {
            input.useDelimiter(",");
            Pattern result = input.delimiter();

            if (result.pattern().equals(delimiter))
                flag = true;
            else {
                flag = false;
                throw new CustomException("invalid Entry!, Please enter a correct delimiter!", ce.message.IMPROPER_DELIMITER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
		

	public boolean readHeader(String filePathRead, List<String> listName) throws IOException , CustomException {
		 CustomException ce = new CustomException(filePathRead, null);
		 BufferedReader br = new BufferedReader(new FileReader(filePathRead));
		
	     
	        String line = br.readLine();
	        String[] header = line.split(",");
	        boolean flag = true;
	        for (int i = 0; i < header.length && i < listName.size(); i++) {
	            if(listName.get(i).equals(header[i]))
	                flag = true;
	            else {
	                flag = false;
	                throw new CustomException("Invalid Entry! Please Enter the correct Header!", ce.message.IMPROPER_HEADER);
	            }
	        }
	        return flag;
	    }
}