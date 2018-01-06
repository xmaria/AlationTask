package com.test.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class exportDataToExcel {
	
	
	/*
	 * Function Name: writeToExcel
	 * Description: Check First result result is visible
	 * Parameters: Map<String, Object[]> - data to write into excel
	 * Return Value: none
	 */	
	
	public void writeToExcel(Map<String, Object[]> data) throws FileNotFoundException, IOException{
		HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Amazon Data");
     
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();

        int rownum = 0;
        for (String key : keyset) 
        {
            //create a row of excelsheet
            Row row = sheet.createRow(rownum++);

            //get object array of particular key
            Object[] objArr = data.get(key);

            int cellnum = 0;

            for (Object obj : objArr) 
            {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) 
                {
                    cell.setCellValue((String) obj);
                }
                else if (obj instanceof Integer) 
                {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        
         String filename="src/extractedData.xls";
         try{
             FileOutputStream fos = new FileOutputStream(filename);
             workbook.write(fos);
             fos.flush();
         }catch(FileNotFoundException e){
             e.printStackTrace();
             System.out.println("Invalid directory or file not found");
         }catch(IOException e){
             e.printStackTrace();
             System.out.println("Error occurred while writting excel file to directory");
         }
        
    }
	}
	

