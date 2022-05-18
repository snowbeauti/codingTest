package codingTest;
import java.util.Scanner;

public class Day3_220518 {

	public static void main(String[] args) {
		//평균 구하기
		//자기 점수 최댓값 > M 
		//모든 점수를 점수/M*100 으로 수정
		
		Scanner sc = new Scanner(System.in);
		//개수
		int A = sc.nextInt();
		int N[] = new int[A];
		for(int i=0; i<A; i++) {
			N[i] = sc.nextInt();
		}

		long sum = 0;
		long max = 0;
		for(int i=0; i<A; i++) {
			if(N[i]>max) max=N[i];
			sum = sum + N[i];
		}
		System.out.println(sum*100/max/A);
	}
}
