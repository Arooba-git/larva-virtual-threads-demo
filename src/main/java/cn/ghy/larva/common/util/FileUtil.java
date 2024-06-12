package cn.ghy.larva.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * @author Ziyang
 */
public class FileUtil {

  public String baseLocalURL = "D:/upload/";
  private String baseVisitURL = "/upload/";


  public String getFileShortName(String fileName) {
    if (fileName != null && fileName.length() > 0 && fileName.lastIndexOf(".") > -1) {
      return fileName.substring(0, fileName.lastIndexOf("."));
    }
    return fileName;
  }

  public String getFileSuffix(String fileName) {
    if (fileName != null && fileName.length() > 0 && fileName.lastIndexOf(".") > -1) {
      return fileName.substring(fileName.lastIndexOf("."));
    }
    return "";
  }

  public void createDir(String dir) {
    File directory = new File(baseLocalURL + dir);
    if (!directory.exists()) {
      directory.mkdirs();
    }
  }

  public void writeExcel(XSSFWorkbook workbook, String excelFilePath) throws IOException {
    try (FileOutputStream fileOutputStream = new FileOutputStream(excelFilePath)) {
      workbook.write(fileOutputStream);
    }
  }

  public XSSFWorkbook readExcel(String excelFilePath) throws IOException {
    try (FileInputStream fileInputStream = new FileInputStream(excelFilePath)) {
      XSSFWorkbook workbook;
      workbook = new XSSFWorkbook(fileInputStream);
      return workbook;
    }
  }
}
