import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Hash {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<Integer,HashSet<String>> map = new HashMap<Integer,HashSet<String>>();
		
		while(scanner.hasNext())
		{
			String str = scanner.next();
			if(!map.containsKey(str.hashCode()))
			{
				map.put(str.hashCode(), new HashSet<String>());
			}
			map.get(str.hashCode()).add(str);
		}
		scanner.close();
		
		Integer [] hashCodes = map.keySet().toArray(new Integer[]{});
		Arrays.sort(hashCodes);
		for(int hashCode :hashCodes)
		{
			String [] words = map.get(hashCode).toArray(new String[]{});
			if(words.length==1)continue;
			Arrays.sort(words);
			System.out.print(hashCode+":");
			for(int i=0;i<words.length;i++)
			{
				String str = words[i];
				if(i != words.length-1)
					System.out.print(" "+str+",");
				else
					System.out.print(" "+str);
			}
			System.out.println();
		}

	}

}
