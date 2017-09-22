package testResources;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL;

public class XlsData {
    public static final String Path_TestData = "C:\\Users\\phild_000\\eclipse-workspace\\";
    public static final String File_TestData = "TestData.xlsx";
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    public static void setExcelFile(String Path, String SheetName) throws Exception {
        try {
            //Open Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);
            //Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
        } catch (Exception e) {
            throw (e);
        }
    }
    public static void setUpTable(String[] namings) throws Exception {
        try {
            int i=0;
            for (String s:namings) {
                setCellData(s,0,i);
                i++;
            }
            } catch (Exception e){
            throw (e);
        }
    }
    public static int findColumn (String category) throws Exception {
        int i;
        try{
            i=0;
            while (!category.matches(getCellData( 0,i))){
                i++;
            }
        } catch (Exception e) {
            throw (e);
        }
        return i;
    }
    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num nad Col num
    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try{
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;
        }catch (Exception e){
            return"";
        }
    }
    //This method is to write in the Excel cell, row num and Col num are the parameters

    public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
        FileOutputStream fileOut = new FileOutputStream(Path_TestData + File_TestData);

        try {
            if (ExcelWSheet.getRow(RowNum)==null) {
                Row =ExcelWSheet.createRow(RowNum);
            } else {Row = ExcelWSheet.getRow(RowNum);}
            Cell = Row.getCell(ColNum, RETURN_BLANK_AS_NULL);

            if (Cell == null){
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
            } else {
                Cell.setCellValue(Result);
            }
            //Constant variables Test Data path and Test Data file name

            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }catch (Exception e){
            throw (e);
        }
    }

}