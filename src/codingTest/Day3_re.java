package codingTest;
import java.util.Scanner;

public class Day3_re {
	
	public static void main(String[ ] args) {
		//평균 구하기
		//자기 점수 최댓값 > M 
		//모든 점수를 점수/M*100 으로 수정

	Scanner sc = new Scanner(System.in);
	int A = sc.nextInt();
	int score[]  = new int[A];
	for(int i=0; i<A; i++) {
		score[i] = sc.nextInt();
		}
	
	long max = 0;
	long sum = 0;
	for(int i=0; i<A; i++) {
		if(score[i]>max) max = score[i];
		sum += score[i];
	}

	System.out.println(sum*100/max/A);
	
	}
}
