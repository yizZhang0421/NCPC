import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
				boolean lower=false, upper=false;
				ArrayList<Integer> lower_set = new ArrayList<>();
				ArrayList<Integer> upper_set = new ArrayList<>();
				HashMap<ArrayList<Integer>, Integer> set_lcm = new HashMap<>();
				ArrayList<Integer> n_factors = new ArrayList<>();
				for(int i=1;i<=Math.sqrt(n);i++) {
					if(n%i==0) {
						if(n_factors.contains(i)==false)
							n_factors.add(i);
						if(n_factors.contains(n/i)==false)
						n_factors.add(n/i);
					}
				}
				Collections.sort(n_factors);
				for(int i : n_factors) {
					if(i<=3) {
						continue;
					}
					ArrayList<Integer> i_factors = new ArrayList<>();
					for(int j=1;j<=Math.sqrt(i);j++) {
						if(i%j==0) {
							if(i_factors.contains(j)==false)
								i_factors.add(j);
							if(i_factors.contains(i/j)==false)
								i_factors.add(i/j);
						}
					}
					Collections.sort(i_factors);
					if(lower==false) {
						for(int need_part : i_factors) {
							int magnification=need_part-2;
							if(magnification<2) {
								continue;
							}
							int part_quantity=n/i;
							lower_set.add(magnification*part_quantity);
							lower_set.add(part_quantity);
							lower_set.add(part_quantity);
							set_lcm.put(lower_set, Math.max(magnification*part_quantity, part_quantity));
							lower=true;
							break;
						}
					}
					if(upper==false) {
						for(int need_part : i_factors) {
							if((need_part-1)%2!=0) {
								continue;
							}
							int magnification=(need_part-1)/2;
							if(magnification<2) {
								continue;
							}
							int part_quantity=n/i;
							upper_set.add(magnification*part_quantity);
							upper_set.add(magnification*part_quantity);
							upper_set.add(part_quantity);
							set_lcm.put(upper_set, Math.max(magnification*part_quantity, part_quantity));
							upper=true;
							break;
						}
					}
					if(lower && upper) {
						break;
					}
				}
				
				ArrayList<Integer> result_set = null;
				if(set_lcm.size()==1) {
					result_set=lower_set==null?upper_set:lower_set;
				}
				else {
					if(set_lcm.get(lower_set)==set_lcm.get(upper_set)) {
						result_set=lower_set;
					}
					else {
						result_set = set_lcm.get(lower_set)<set_lcm.get(upper_set)?lower_set:upper_set;
					}
				}
				Collections.sort(result_set);
				String tmp = "";
				for(int i : result_set) {
					tmp+=i+" ";
				}
				System.out.println(tmp.trim());
			}
			n = Integer.parseInt(br.readLine().trim());
		}
	}
}