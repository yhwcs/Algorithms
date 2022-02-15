import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20361 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		// 입력을 읽어들이기 위한 Reader
		StringTokenizer st;																// 입력을 공백문자 단위로 끊어 읽기 위한 Tokenizer											// 출력을 위한 Buffer													// 테스트 케이스 수만큼 반복한다
		st = new StringTokenizer(br.readLine(), " ");								// 읽은 한 줄을 공백문자 단위로 끊는다
		int N = Integer.parseInt(st.nextToken());									// 종이컵 수 N을 얻는다
		int X = Integer.parseInt(st.nextToken());									// 간식이 들어있는 종이컵 인덱스 X를 얻는다
		int K = Integer.parseInt(st.nextToken());									// 컵의 위치를 맞바꾸는 횟수 K를 얻는다
		for(int i=0; i<K; i++) {													// 컵의 위치를 맞바꾸는 K번만큼 반복한다
			st = new StringTokenizer(br.readLine(), " ");							// 읽은 한 줄을 공백문자 단위로 끊는다
			int A = Integer.parseInt(st.nextToken());								// 바꿀 컵의 위치 A를 얻는다
			int B = Integer.parseInt(st.nextToken());								// 바꿀 컵으 위치 B를 얻는다
			if(A == X) X = B;														// A가 간식이 있는 종이컵의 인덱스 X와 같다면 이제 간식이 B에 있으므로 X의 값을 B로 바꾼다
			else if(B == X) X = A;													// B가 간식이 있는 종이컵의 인덱스 X와 같다면 이제 간식이 A에 있으므로 X의 값을 A로 바꾼다
		}
		System.out.println(X);			
	}
}
