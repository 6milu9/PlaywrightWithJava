package framework.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;

public class ExcelUtils {
    private ExcelUtils() {}

    public static Object[][] read(String file, String sheet) throws Exception {

        Workbook wb = WorkbookFactory.create(new File(file));
        Sheet sh = wb.getSheet(sheet);

        int rows = sh.getPhysicalNumberOfRows();
        int cols = sh.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = sh.getRow(i).getCell(j).toString();
            }
        }
        return data;
    }
}
