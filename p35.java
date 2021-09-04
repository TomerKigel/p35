import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class p35 {
	public static void main(String[] args) {
		Vector<Long> primes = new Vector<Long>();
		populate_primes(primes);
		int counter = 0;
		for (long i : primes) {
			counter += prime_rotation_num(i,primes);	
		}
		System.out.println(counter);
	}
	public static int prime_rotation_num(long num,Vector<Long> primes)
	{
		boolean rotation_num = true;
		int num_of_rotations = 0;
		if(num > 9)
			num_of_rotations++;
		if(num > 99)
			num_of_rotations++;
		if(num > 999)
			num_of_rotations++;
		if(num > 9999)
			num_of_rotations++;
		if(num > 99999)
			num_of_rotations++;
		
		for (int i = 0; i < num_of_rotations; i++) {
			num = rotation(num);
			if(!primes.contains(num))
					rotation_num = false;
		}
		if(!rotation_num)
			return 0;
		System.out.println(num);
		return 1;
	}
	
	public static long rotation(long num)
	{
		long t = num%10;
		long t_num = num;
		int c = 0;
		while(t_num/10 > 0) {
			c++;
			t_num/=10;
		}
		num /= 10;
		return t * (long)Math.pow(10, c) + num;
	}
	
	public static void populate_primes(Vector<Long> primes)
	{
		for (long i = 2; i < 1000000; i++) {
			boolean prime = true;
			for (long j = 2; j <= Math.sqrt(i); j++) {
				if(i%j == 0)
					prime = false;
			}
			if(prime)
				primes.add(i);
		}
	}
		
}