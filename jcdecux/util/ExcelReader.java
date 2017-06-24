package com.jcdecux.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static List<EntryElement> readExcel(FileObject fileObject,Map<String,String> clientMap ){
		InputStream stream = null;
		List<EntryElement> entryList = new ArrayList<EntryElement>();
		String date = fileObject.getDate();
		String path = fileObject.getPath();
		try {
			InputStream str = new FileInputStream(new File(path));
			//reading FileInputStream
			XSSFWorkbook workBook = new XSSFWorkbook(str);
			//get working sheet,has three working sheet, 0,1,2
			//different working sheet relates to different Media type
			for(int sheetNum=0; sheetNum<3; sheetNum++){
				XSSFSheet sheet = workBook.getSheetAt(sheetNum);
				//get cell from working sheet
				int rows = sheet.getLastRowNum();
				//int cols;
				for(int r=4;r<=rows;r++){
					EntryElement entryElement = new EntryElement();
					XSSFRow row = sheet.getRow(r);
					//read content from column "client name"
					XSSFCell nameCell = row.getCell(1);
					if(nameCell == null)
						System.out.println("name cell is null,row is"+r);
					else{
						String companyName = nameCell.getStringCellValue();
						if(!("").equals(companyName) && companyName != null){
							entryElement.setWeek(fileObject.getDate());
							entryElement.setChineseName(splitBrandName(companyName).trim());
							entryElement.setMedia(getMedia(sheetNum));
							//get Client and Brand
							Object queriedEntry = clientMap.get(entryElement.getChineseName());
							if(queriedEntry!=null){
								String[] clientBrandIndustry = ((String)queriedEntry).split(",");
								String client = clientBrandIndustry[0];
								String brand = clientBrandIndustry[1];
								String industry = clientBrandIndustry[2];
								entryElement.setClient(client);
								entryElement.setBrand(brand);
								entryElement.setIndustry(industry);
							}
							
							//read content from column "Seconds"
							XSSFCell timeCell = row.getCell(3);
							if(timeCell == null)
								System.out.println("time cell is null");
							else{
								Date time = timeCell.getDateCellValue();
								if(time != null){
									String slotDuration = time.toString().split(" ")[3].split(":")[2];
									entryElement.setSlotDuration(slotDuration+" sec.");
									int rateCard = getRateCard(sheetNum,slotDuration);
									entryElement.setRateCard(rateCard);
								}
								//System.out.println(Integer.parseInt(new java.text.DecimalFormat("0").format(time)));
							}
							int duration = Integer.parseInt(entryElement.getSlotDuration().split(" ")[0]);
							if(sheetNum<2 && duration > 12){
								int t = duration / 12;
								entryElement.setSlotDuration("12 sec.");
								for(int i=0;i<t;i++)
									entryList.add(entryElement);
							}
							else if(sheetNum==2 && duration > 10){
								int t = duration / 10;
								entryElement.setSlotDuration("10 sec.");
								for(int i=0;i<t;i++)
									entryList.add(entryElement);
							}
							else{
								entryList.add(entryElement);
							}
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entryList;
	}
	
	private static String splitBrandName(String brandName){
		String name = brandName.split("ÉÏº£")[0];
		String splitedBrandName = name.split("\\£¨|\\(")[0];
		return splitedBrandName;
	}
	
	private static String getMedia(int sheetNum){
		String media="";
		switch(sheetNum){
			case 0:
				media = "HQ T2 - 55 inches";
				break;
			case 1:
				media = "HQ T2 Departure - 70 inches";
				break;
			case 2:
				media = "HQ T2 Arrival - 70 inches";
				break;
		}
		return media;
	}
	
	private static int getRateCard(int sheetNum,String slotDuration){
		int rateCard=0;
		int duration = Integer.parseInt(slotDuration);
		if(sheetNum ==0){
			if (duration == 6)
				rateCard = 75000;
			else
				rateCard = 150000;
		}
		else if(sheetNum == 1){
			if (duration == 6)
				rateCard = 89000;
			else
				rateCard = 178000;
		}
		else if(sheetNum == 2){
			if(duration == 5)
				rateCard = 59000;
			else
				rateCard = 118000;
		}
		return rateCard;
	}
}
