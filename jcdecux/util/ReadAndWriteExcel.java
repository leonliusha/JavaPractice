package com.jcdecux.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadAndWriteExcel {

	public static void main(String args[]) throws IOException{
		final String filepath = "F:\\JCDecux\\2013-9-20";
		//get all source files from a directory
		List<FileObject> fileList = ReadFile.readFile(filepath);
		List<EntryElement> entryList = new ArrayList<EntryElement>();
		//read all client and brand from a source file
		Map<String,String> clientMap = ClientAndBrandNameGenerator.generate();
		System.out.println("Client and Brand reading is done");
		for(int i=0; i < fileList.size();i++){
			String date = fileList.get(i).getDate();
			String path=fileList.get(i).getPath();
			System.out.println(date);
			System.out.println(path);
			//get entryList from excel reader
			entryList = ExcelReader.readExcel(fileList.get(i),clientMap);
			System.out.println("the size is:"+entryList.size());
			
			//put entryList to excel writer
			ExcelWriter.writeExcel(entryList,fileList.get(i));
		}
		/*for(int j=0;j<entryList.size();j++){
			System.out.print(entryList.get(j).getChineseName());
			System.out.print("----------");
			System.out.print(entryList.get(j).getMedia());
			System.out.print("----------");
			System.out.print(entryList.get(j).getSlotDuration());
			System.out.print("----");
			System.out.println(entryList.get(j).getRateCard());
			
		}*/
		System.out.println("done!");
	}
}
