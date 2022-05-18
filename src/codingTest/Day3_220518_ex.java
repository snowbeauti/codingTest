package codingTest;
import java.util.Scanner;

public class Day3_220518_ex {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int [] A = new int[num];
		
		for(int i=0; i<num; i++) {
			A[i] = sc.nextInt();
		}
		
		//가장 큰 수 찾기
		//합계 구하기
		long max = 0;
		long sum = 0;
		
		for(int i=0; i<num; i++) {
			if(A[i]>max) max=A[i];
			sum += A[i];
		}


		//모든 점수를 점수/M*100 으로 수정
		System.out.println(sum/max*100/num);
	}

}
