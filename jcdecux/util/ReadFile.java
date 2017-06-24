package com.jcdecux.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFile {
	public ReadFile(){
		
	}
	
	public static List<FileObject> readFile(String filepath){
		//Map<String,String> fileMap = new HashMap<String,String>();
		List<FileObject> fileList = new ArrayList<FileObject>();
		File file = new File(filepath);
		if(!file.isDirectory()){
			//System.out.println("file");
			//System.out.println("path ="+file.getPath());
			//System.out.println("absolute path="+file.getAbsolutePath());
			//System.out.println("name="+file.getName());
		}
		else if(file.isDirectory()){
			//System.out.println("Directory");
			String[] filelist=file.list();
			for(int i=0;i<filelist.length;i++){
				File readfile = new File(filepath+"\\"+filelist[i]);
				if(!readfile.isDirectory()){
					//System.out.println("path ="+readfile.getPath());
					//System.out.println("absolute path="+readfile.getAbsolutePath());
					//System.out.println("name="+readfile.getName());
					FileObject fo = new FileObject();
					fo.setDate(FileNameToDate(readfile.getName()));
					fo.setPath(readfile.getAbsolutePath());
					fileList.add(fo);
				}
				else if(readfile.isDirectory()){
					readFile(filepath+"\\"+filelist[i]);
				}
			}
		}
		return fileList;
		
	}
	
	public static String FileNameToDate(String fileName){
		String[] sa = fileName.split("\\.");
		String date = "2013-";
		char c = sa[0].charAt(sa[0].length()-2);
		int asc2 = c;
		if(asc2 > 48 && asc2 < 57)
			date = date + c;
		date = date+sa[0].charAt(sa[0].length()-1)+"-"+sa[1];
		return date;
	}
}
