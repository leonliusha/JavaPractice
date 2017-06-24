package WildcardPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

public class MultiBounds {
	
	public static <S extends Readable & Closeable, T extends Appendable & Closeable>  void copy(S src, T trg, int size) throws IOException{
		try{
			CharBuffer buf = CharBuffer.allocate(size);
			int i = src.read(buf);
			while(i >= 0){
				buf.flip(); // prepare buffer for writing
				trg.append(buf);
				buf.clear();//prepare buffer for reading
				i = src.read(buf);
			}
		}finally{
			src.close();
			trg.close();
		}

	}
	
	
	//since almost all classes that implement both Readable and Closeable are subclasses of Reader, and
	//almost all classes that implement both Appendable and Closeable are subclasses of Writer,
	//so you might wonder why we don't simplify the method signature like following:
	//This admit most of the same classes, but not all fo them. PrintStream implements Appendable and Closeable
	//but it is not a subclass of Writer.
	public static void copy(Reader src, Writer trg, int size) throws IOException{
		try{
			CharBuffer buf = CharBuffer.allocate(size);
			int i = src.read(buf);
			while(i >= 0){
				buf.flip(); // prepare buffer for writing
				trg.append(buf);
				buf.clear();//prepare buffer for reading
				i = src.read(buf);
			}
		}finally{
			src.close();
			trg.close();
		}

	}
	
	
	public static void main(String args[]){
		MultiBounds mBounds = new MultiBounds();
		int size = 32;
		FileReader r;
		FileWriter w;
		try {
			r = new FileReader("file.in");
			w = new FileWriter("file.out");
			mBounds.copy(r,w,size);
			BufferedReader br = new BufferedReader(r);
			BufferedWriter bw = new BufferedWriter(w);
			mBounds.copy(br, bw, size);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}