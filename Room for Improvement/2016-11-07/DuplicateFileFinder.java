import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateFileFinder {
	
	private static List<File> fileList = new ArrayList<>();
	
	public static Map<Long, Set<File>> collect(File folder){
		Map<Long, Set<File>> result = new HashMap<>();
		//File[] files = folder.listFiles(file -> file.isFile());
		
		collectFiles(folder);
		File[] files = (File[]) fileList.toArray(new File[fileList.size()]);
		
		/*File[] files = folder.listFiles(new FileFilter(){

			@Override
			public boolean accept(File pathname) {
				return pathname.isFile();
			}
		});*/
		for (File file : files) {
			long size = file.length();
			if(!result.containsKey(size)){
				result.put(size, new HashSet<File>());
			}
			Set<File> value = result.get(size);
			value.add(file);
		}
		return result;
	}
	
	public static void collectFiles(File folder){
		File[] files = folder.listFiles();
		for (File file : files) {
			if(file.isFile()){
				fileList.add(file);
			}
			else{
				collectFiles(file);
			}
		}
	}
	
	public static void main(String[] args){
		File folder = new File("C:\\test");
		Map<Long, Set<File>>result = collect(folder);
		for (Long s : result.keySet()) {
			Set<File> value = result.get(s);
			for (File file : value) {
				System.out.println(file.getAbsolutePath() + " ");
			}
			System.out.println();
		}
		//collectFiles(folder);
		//for (File f : fileList) {
		//	System.out.println(f.getAbsolutePath());
			
		//}
	}
}