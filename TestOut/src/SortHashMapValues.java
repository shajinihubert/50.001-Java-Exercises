
import java.util.*;

public class SortHashMapValues{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String []args){
		Map<String, Integer> map=new HashMap();
		map.put("one",1);
		map.put("ten",10);
		map.put("three",3);
		map.put("two",2);
		
		List list=new ArrayList(map.entrySet());
	
		Collections.sort(list,new Comparator(){
			public int compare(Object obj1, Object obj2){
				return ((Comparable)((Map.Entry)(obj1)).getValue()).compareTo(((Map.Entry)(obj2)).getValue());
				}
			});
		System.out.println(list);
	}
}