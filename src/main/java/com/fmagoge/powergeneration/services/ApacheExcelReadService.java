package com.fmagoge.powergeneration.services;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fmagoge.powergeneration.model.Plant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ApacheExcelReadService {

	static String SHEET = "sample_data_values";

    public List<Plant> read() {

    	Resource resource = new ClassPathResource("sample_data.xlsx");
    	FileInputStream excelFile = null;
    	
    	
    	 try {
    		 excelFile = new FileInputStream(resource.getFile());
    	      Workbook workbook = new XSSFWorkbook(excelFile);

    	      Sheet sheet = workbook.getSheet(SHEET);
    	      Iterator<Row> rows = sheet.iterator();

    	      List<Plant> plantList = new ArrayList<Plant>();
    	      DataFormatter formatter = new DataFormatter();
    	      
    	      int rowNumber = 0;
    	      while (rows.hasNext()) {
    	        Row currentRow = rows.next();

    	        // skip header
    	        if (rowNumber == 0 || rowNumber == 1) {
    	          rowNumber++;
    	          continue;
    	        }

    	        Iterator<Cell> cellsInRow = currentRow.iterator();

    	        Plant plant = new Plant();

    	        int cellIdx = 0;
    	        while (cellsInRow.hasNext()) {
    	          Cell currentCell = cellsInRow.next();

    	          switch (cellIdx) {
    	          case 0:
    	            plant.setSEQGEN19(formatter.formatCellValue(currentCell));
    	            break;

    	          case 1:
    	            plant.setYEAR(formatter.formatCellValue(currentCell));
    	            break;

    	          case 2:
    	            plant.setPSTATABB(formatter.formatCellValue(currentCell));
    	            break;

    	          case 3:
    	            plant.setPNAME(formatter.formatCellValue(currentCell));
    	            break;
    	          case 4:
    	              plant.setGENID(formatter.formatCellValue(currentCell));
    	              break;
    	          case 5:
    	              plant.setGENSTAT(formatter.formatCellValue(currentCell));
    	              break;
    	          case 6:
    	              plant.setGENNTAN(formatter.formatCellValue(currentCell));
    	              break;

    	          default:
    	            break;
    	          }

    	          cellIdx++;
    	        }

    	        plantList.add(plant);
    	        
    	        rowNumber++;
    	      }

    	      workbook.close();

    	      return plantList;
    	    } catch (IOException e) {
    	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    	    }
    	  }
    
    /*
        try {
        	
            excelFile = new FileInputStream(resource.getFile());
            
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }

                }
                System.out.println();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return excelFile;
	*/
}
   