import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class HiddenMessage {
	
	public void encryptMessage(File inputFile, String inputString){
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(inputFile));
			
			String line = br.readLine();
			while (line != null) {
		        sb.append(line);
		        line = br.readLine();
		    }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String[] splitted = sb.toString().split(" ");
		String binary = new BigInteger(inputString.getBytes()).toString(2);
		String binaryFinal = "0" + binary;
		
		for (int i = 0; i < binaryFinal.length(); i++) {
			if(i*2+1 >= splitted.length){
				break;
			}
			if(binaryFinal.charAt(i)=='1'){
				String temp = splitted[i*2];
				splitted[i*2] = splitted[i*2+1];
				splitted[i*2+1] = temp;
			}
		}
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < splitted.length; i++) {
			output.append(splitted[i]+" ");
		}
		String outputString = output.toString();
		try {
			PrintWriter out = new PrintWriter(inputFile);
			out.append(outputString);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		File file = new File("C:/Users/Zsori Lukacs Peter/Desktop/input.txt");
		HiddenMessage hm = new HiddenMessage();
		hm.encryptMessage(file, "hi");
	}
}
