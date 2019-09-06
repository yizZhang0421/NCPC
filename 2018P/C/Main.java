import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		while(n!=0) {
			if(n%3==0) {
				int result=n/3;
				System.out.println(result+" "+result+" "+result);
			}
			else {
				TreeMap<Integer, ArrayList<Integer>> max_array = new TreeMap<>();
				int base = n/3;
				for(int d=base;d<=(n-1)/2;d++) {
					if(d%(n-(d*2))==0 || (n-(d*2))%d==0) {
						ArrayList<Integer> result = new ArrayList<>();
						result.add(d);
						result.add(d);
						result.add((n-(d*2)));
						max_array.put(Math.max(d, (n-(d*2))), result);
						break;
					}
				}
				for(int d=base;d>=1;d--) {
					if(d%(n-(d*2))==0 || (n-(d*2))%d==0) {
						ArrayList<Integer> result = new ArrayList<>();
						result.add(d);
						result.add(d);
						result.add((n-(d*2)));
						max_array.put(Math.max(d, (n-(d*2))), result);
						break;
					}
				}
				ArrayList<Integer> result = max_array.get(max_array.firstKey());
				Collections.sort(result);
				String tmp = "";
				for(int i : result) {
					tmp+=i+" ";
				}
				System.out.println(tmp.trim());
			}
			n = Integer.parseInt(br.readLine().trim());
		}
	}
}