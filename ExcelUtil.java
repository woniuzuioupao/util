package com.ziytek.taozhu.base.util;


import org.apache.poi.ss.usermodel.Cell;

/**
 * Created by Gongxl on 2017/2/23.
 */
public class ExcelUtil {

    /**
     * 获取EXCEL单元格的值
     *
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        int type = cell.getCellType();
        String result;
        switch (type) {
            case Cell.CELL_TYPE_NUMERIC:
                result = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING:
                result = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                result = "";
                break;
            default:
                result = cell.getCellComment().getString().toString();
                break;
        }
        return result;
    }
}
