package com.jcdecux.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelWriter {
	public static void writeExcel(List<EntryElement> entryList,FileObject fileObject) throws IOException{
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet("HQ2013(Public)");
		for(int r=0;r<entryList.size();r++){
			HSSFRow row = sheet.createRow(r);
			//enter values into each cell
			row.createCell(1).setCellValue(entryList.get(r).getWeek());
			row.createCell(2).setCellValue(entryList.get(r).getClient());
			row.createCell(3).setCellValue(entryList.get(r).getBrand());
			row.createCell(4).setCellValue(entryList.get(r).getChineseName());
			row.createCell(5).setCellValue(entryList.get(r).getIndustry());
			row.createCell(6).setCellValue(entryList.get(r).getMedia());
			row.createCell(7).setCellValue(entryList.get(r).getSlotDuration());
			row.createCell(8).setCellValue(entryList.get(r).getRateCard());
		}
		FileOutputStream fileOut = new FileOutputStream("F:\\JCDecux\\processed excel\\HQ Media Playlist "+fileObject.getDate()+".xls");
		workBook.write(fileOut);
		fileOut.close();
	}
}
