import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17478 {

	static String[] sentence = new String[]{"어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n", 
			"\"재귀함수가 뭔가요?\"\n", 
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n", 
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n", 
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n", 
			"라고 답변하였지.\n"};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.print(sentence[0]);
		print(N, 0);
	}
	
	public static void print(int N, int n) {
		StringBuilder sb = new StringBuilder();
		if(n+1 > N) {
			for(int j=0; j<n; j++) {
				sb.append("____");
			}
			sb.append(sentence[1]);
			for(int j=0; j<n; j++) {
				sb.append("____");
			}
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			for(int j=0; j<n; j++) {
				sb.append("____");
			}
			sb.append(sentence[5]);
			System.out.print(sb);
			return;
		}
		for(int i=1; i<=4; i++) {
			for(int j=0; j<n; j++) {
				sb.append("____");
			}
			sb.append(sentence[i]);
		}
		System.out.print(sb);
		print(N, n+1);
		sb.setLength(0);
		for(int i=0; i<n; i++) {
			sb.append("____");
		}
		sb.append(sentence[5]);
		System.out.print(sb);
	}

}
