package dataIndexOf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataIndexOf {
	public static long indexOf(File file, char character, long startByte){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			long count = 0;
			int readReturn;
			while((readReturn = fis.read()) != -1){
				if(count >= startByte) {
					char c = (char) readReturn;
					if(c == character){
						return count;
					}
				}
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
}
