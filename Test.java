

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) throws Exception {

//		EncryptionHelper helper = new EncryptionHelper();
		//String encrypted = helper.encrypt("SUM2015!",
				//"f9j3i2lnkfb6934ojnv-2qpx", "DESede");
		///String original = helper.decrypt(encrypted, "f9j3i2lnkfb6934ojnv-2qpx",
				//"DESede");
		//System.out.println("original password" + original);
		
		
		
		List<Long> list = new ArrayList<Long>();
		list.add(3l);
		list.add(4l);
		list.add(5l);
		list.add(6l);
		list.add(7l);
		list.add(8l);
		Set<Object> set = new HashSet<Object>();
		set.add(null);
		set.add(null);
		Object obj = new Object();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(null, obj);
		map.put(null, obj);
		
		
		Map<Long, Integer> idNumMap = new HashMap<Long, Integer>();
		Map<Integer, Long> numIdMap = new HashMap<Integer, Long>();
		
		Long srcId =38011l;
		
		idNumMap.put(38011l, 1);
		idNumMap.put(38012l, 2);
		
		numIdMap.put(1,38003l);
		numIdMap.put(2,38004l);
		Long destid = getLocationOrBuilId(idNumMap, numIdMap, srcId);
		System.out.println("LocationId:"+destid );
		
		if(findDuplicates(list)){
			System.out.println("Duplicate");
		}else{
			System.out.println("No duplicates");
		}
		
		/*if(checkDuplicates(list)){
			System.out.println("Duplicate");
		}else{
			System.out.println("Not Duplicate");
		}*/
	}
	
	private static Long getLocationOrBuilId(Map<Long, Integer> idNumMap,
			Map<Integer, Long> numIdMap, Long srcId) {

		Long destId = null;
		int num = 0 ;
		
		if(idNumMap != null){
			
			num = idNumMap.get(srcId) == null ? 0 : idNumMap.get(srcId);
		}
		if(numIdMap != null){
			
			destId = numIdMap.get(num);
			
//			destId = numIdMap.get((long)num) == null ? null : Long.valueOf(numIdMap.get((long)num));
		}
		return destId;

	}

	private Test() {
//		super();
		// TODO Auto-generated constructor stub
	}

	/*public static File TempFile() throws IOException {
		File tempFile = File.createTempFile("des", ".tmp");
		return tempFile;
	}

	static void writeToFile(String filename, String text) throws IOException {
		FileResourceHelper fileHelper = new FileResourceHelper();
		OutputStream out = fileHelper.getOutputStream(filename);
		out.write(text.getBytes());
		out.close();
	}

	private static SimplestCipher newCipher(String keyPath, Mode mode) {
		return new SimplestCipher.Factory(new ResourceKeyProvider("DESede",
				keyPath, StorageFormats.raw())).create(mode);
	}*/
	
	private static <T> boolean findDuplicates(Collection<T> list) {
        Set<T> uniques = new HashSet<T>();
        return list.stream().filter(e -> !uniques.add(e)).collect(Collectors.toSet()).size() > 0 ? true:false;
    }
	
	private static Boolean checkDuplicates(List<Long> list){
		Set<Long> set = new HashSet<Long>();
		boolean flag = false;
		
		for(int i =0; i<list.size(); i++){
			
			if(!set.contains(list.get(i))){
				set.add(list.get(i));
				
			}else{
				return true;
			}
		}
		return flag;
		
	}
}
