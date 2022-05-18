package codingTest;
import java.util.Scanner;

public class Day2_220517_ex{
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String charS = sc.next();
		
		//char > 정수
		//.toCharArray() >> 문자열을 한 글자씩 나눠서 char타입의 배열에 집어넣어줌
		char[] cNum = charS.toCharArray();

		//char형 배열을 합쳐서 하나의 String(문자열)로 만들 수 있음
		  String s2 = new String(cNum);
		  
		int sum = 0;
		
		for(int i=0; i<cNum.length; i++) {
			sum += cNum[i];
		}
		System.out.println(sum);
	}
}