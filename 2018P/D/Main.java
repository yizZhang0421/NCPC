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
		int N = Integer.parseInt(br.readLine().trim());
		while(N-->0) {
			String[] arP = br.readLine().trim().split(" +");
			BigInteger a = new BigInteger(arP[0]);
			BigInteger r = new BigInteger(arP[1]);
			BigInteger P = new BigInteger(arP[2]);
			BigInteger x = get_divisiable(P, r, a);
			System.out.println(x);
		}
	}

	private static BigInteger get_divisiable(BigInteger p, BigInteger r, BigInteger a) {
		if(a.compareTo(BigInteger.ONE)==0) {
			int n=(int) Math.ceil(r.floatValue()*-1/p.floatValue());
			return p.multiply(new BigInteger(n+"")).add(r);
		}
		BigInteger n = get_divisiable(a, r.multiply(new BigInteger("-1")), p.mod(a));
		BigInteger Q =p.multiply(n).add(r).divide(a);
		return Q;
	}
}