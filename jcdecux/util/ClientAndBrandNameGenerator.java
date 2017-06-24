package com.jcdecux.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ClientAndBrandNameGenerator {
	public static Map<String,String> generate(){
		
		String path = "F:\\JCDecux\\HQ Media Playlist 201309.xlsx";
		Map<String,String> clientMap = new HashMap<String,String>();
		try {
			InputStream str = new FileInputStream(new File(path));
			//reading FileInputStream
			XSSFWorkbook workBook = new XSSFWorkbook(str);
			//get working sheet,has three working sheet, 0,1,2
			//different working sheet relates to different Media type
			XSSFSheet sheet = workBook.getSheetAt(1);
				//get cell from working sheet
			int rows = 2220;
				//int cols;
			for(int r=1;r<=rows;r++){
					//EntryElement entryElement = new EntryElement();
				XSSFRow row = sheet.getRow(r);
					//read content from column "client name"
				XSSFCell chineseNameCell = row.getCell(4);
				if(chineseNameCell == null)
					System.out.println("name cell is null,row is"+r);
				else{
						//chineseName is the key in Map
					String chineseName = chineseNameCell.getStringCellValue().trim();
					if(!("").equals(chineseName) && chineseName != null){						
						if(!clientMap.containsKey(chineseName)){
							String client;
							String brand;
							String industry;
							XSSFCell clientCell = row.getCell(2);
							client = clientCell.getStringCellValue().trim();
							
							XSSFCell brandCell = row.getCell(3);
							if(brandCell == null)
								brand = client;
							else 
								brand = brandCell.getStringCellValue().trim();
							
							XSSFCell industryCell = row.getCell(5);
							if(industryCell == null)
								industry = " ";
							else
								industry = industryCell.getStringCellValue().trim();
							
							clientMap.put(chineseName, client+","+brand+","+industry);
						}
					}
				}
			}
			System.out.println(clientMap.size());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return clientMap;
		}

}
