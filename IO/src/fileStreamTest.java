import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class fileStreamTest {
	public static void main(String args[]) throws IOException{
		File file = new File("C:/Users/sliu239/Documents/My Projects/practice/JavaGenericsAndCollection/a.txt");
		OutputStream output = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(output,"UTF-8");
		//writer.append("中文输入");
		//writer.append("\r\n");
		//writer.append("English");
		writer.write("中文输入法");
		writer.write("\r\n");
		writer.write("English");
		writer.close();
		output.close();
		
		InputStream input = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(input,"UTF-8");
		
		StringBuilder sb = new StringBuilder();
		while(reader.ready()){
			sb.append((char)reader.read());
		}
		System.out.println(sb.toString());
		reader.close();
		input.close();
		
		fileStreamTest fileTest = new fileStreamTest();
		fileTest.DirList("C:/Users/sliu239/Documents/My Projects/practice/JavaGenericsAndCollection");
	}
	
	public void DirList(String path){
		File file = new File(path);
		if(file.isDirectory()){
			System.out.println("Direcoty of "+path);
			String[] s = file.list();
			for(int i=0;i<s.length;i++){
				File f = new File(path+"/"+s[i]);
				if(f.isDirectory()){
					System.out.println(s[i]+" is a directory");
				}
				else{
					System.out.println(s[i]+" is a file");
				}
					
			}
		}
		else{
			System.out.println(path + " is not a directory");
		}
	}
}
