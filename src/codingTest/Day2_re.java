package codingTest;
import java.util.Scanner;
public class Day2_re {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String sChar = sc.next();
		char[] cArr = sChar.toCharArray();
		
		int sum = 0;
		for(int i=0; i<cArr.length; i++) {
			
			sum += cArr[i];
		}
		
		System.out.println(sum);
	}
}
