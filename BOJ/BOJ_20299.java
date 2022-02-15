import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20299 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		// 입력을 읽어들이기 위한 Reader
		StringTokenizer st;																// 입력을 공백문자 단위로 끊어 읽기 위한 Tokenizer
		StringBuffer sb = new StringBuffer();											// 출력을 위한 Buffer
		st = new StringTokenizer(br.readLine(), " ");									// 읽은 한 줄을 공백문자 단위로 끊는다
		int N = Integer.parseInt(st.nextToken());										// 신청한 동아리의 수 N을 얻는다
		int S = Integer.parseInt(st.nextToken());										// 팀원의 능력 합인 클럽 가입 조건 S를 얻는다 
		int M = Integer.parseInt(st.nextToken());										// 개인 능력치인 클럽 가입 조건 M을 얻는다
		int[] students = new int[3];													// 학생들의 개인 능력치를 저장하기 위한 배열을 생성한다
		int idx, count = 0;																// 학생들의 개인 능력치를 저장한 배열의 인덱스를 가리키기 위한 idx, 스마트 클럽 가입 조건을 통과한 동아리 개수 count를 선언한다
		
		for(int i=0; i<N; i++) {														// 신청한 동아리 수 N번만큼 반복한다
			int sum = 0;																// 학생들의 능력치 합을 구하기 위한 sum을 선언한다
			st = new StringTokenizer(br.readLine(), " ");								// 읽은 한 줄을 공백문자 단위로 끊는다
			for(idx=0; idx<3; idx++) {													// 학생들의 수만큼 반복한다
				int score = Integer.parseInt(st.nextToken());							// 학생 개인의 능력치를 얻는다
				if(score < M) break;													// 그 능력치가 가입 조건 M보다 낮다면 다음 동아리를 확인한다
				students[idx] = score;													// 그 능력치가 가입조건 M보다 높다면 배열에 학생의 능력치를 저장한다
				sum += score;															// 해당 동아리의 능력치 합을 구한다
			}
			if(idx>2 && sum>=S) {														// 모든 학생의 개인 능력치가 M보다 높고 능력치 합이 S보다 높다면
				for(int j=0; j<3; j++) {												// 학생들의 수만큼 반복하여
					sb.append(students[j]).append(" ");									// 학생들의 점수를 버퍼에 담는다
				}
				count++;																// 클럽 가입 조건을 통과한 동아리의 수를 구한다
			}
		}
		sb.insert(0, count+"\n");														// 클럽 가입 조건을 통과한 동아리 수를 버퍼에 맨 앞에 담는다
		System.out.println(sb.toString());												// 버퍼를 출력한다
	}

}
