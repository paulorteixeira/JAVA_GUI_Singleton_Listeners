/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mutlithread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Paulo
 */
public class Thread1 extends Thread {

    public void run() {
        if (!"".equals(Observado.getInstance().getPathExcel())) {
            InputStream inp = null;
            
            List<List<Object>> tabela = new ArrayList<List<Object>>();
            List<Object> linha = new ArrayList<Object>();
            
            try {
                System.out.println("Antes");
                inp = new FileInputStream(Observado.getInstance().getPathExcel());
                Workbook wb = WorkbookFactory.create(inp);
                Sheet sheet = wb.getSheetAt(0);

                int rowsCount = sheet.getLastRowNum();
                //System.out.println("Total Number of Rows: " + (rowsCount + 1));
                for (int i = 0; i <= rowsCount; i++) {
                    Row row = sheet.getRow(i);
                    int colCounts = row.getLastCellNum();
                    //System.out.println("Total Number of Cols: " + colCounts);
                    
                    for (int j = 0; j < colCounts; j++) {
                        Cell cell = row.getCell(j);
                        //System.out.println(cell);
                        linha.add(cell);
                        
                    }
                    tabela.add(linha);
                    linha = new ArrayList<Object>();
                }
                //System.out.println(tabela.get(0).get(0).toString());
                Observado.getInstance().setTabela(tabela);
                

            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    inp.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }

//            XSSFWorkbook workbook;
//
//            //Criar excel-file;
//            File file = new File(Observado.getInstance().getPathExcel());
//            if (file.exists() == false) {
//
//                workbook = new XSSFWorkbook();
//                XSSFSheet exampleSheet = workbook.createSheet("1");
//                XSSFRow firstRow = exampleSheet.createRow(1);
//                XSSFCell cell = firstRow.createCell(0);
//                cell.setCellValue("value");
//
//                try (
//                        //Write the workbook in file system
//                        FileOutputStream out = new FileOutputStream(file)) {
//                    workbook.write(out);
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(mainGUI.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(mainGUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } else {
//                // Sheet already exists
//                System.out.println("File already exist");
//            }
        }

//        for (int i = 0; i <= 200; i++) {
//            try {
//                Thread.sleep(500);
//                System.out.println("This code is running in a thread");
//                Observado.getInstance().setTexto("taxa: " + i);
//
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Observado.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        System.out.println("cabo");
    }
}
