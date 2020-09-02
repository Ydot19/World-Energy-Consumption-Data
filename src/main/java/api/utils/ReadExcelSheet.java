package api.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ReadExcelSheet {

    private InputStream getFileInputStream(String excelFileName){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResourceAsStream(excelFileName);
    }

    @Cacheable("countries")
    public HashMap<String, String> getCountries(String excelFileName) {
        try{
            InputStream excelFile = getFileInputStream(excelFileName);
            Workbook wbs = new XSSFWorkbook(excelFile);
            Sheet dataSheet = wbs.getSheetAt(3);

            Iterator<Row> iterator = dataSheet.iterator();
            HashMap<String, String> allCountries = new HashMap<>();
            while(iterator.hasNext()){
                Row nextRow = iterator.next();
                Cell cell = nextRow.getCell(0);
                if(cell.getRowIndex() > 1){
                    allCountries.put(cell.getStringCellValue(), "country");
                }
            }
            wbs.close();
            excelFile.close();
            return allCountries;

        } catch (IOException e) {
            System.out.println("File Not Found Exception Occurred");
            return null;
        }

    }
}
