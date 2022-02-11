import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char before = '0';
		String line = null;
		int count = 0;
		
		for(int i=1; i<=N; i++) {
			line = br.readLine();
			for(int j=0; j<line.length(); j++) {
				if(line.charAt(j) != before) {
					count++;
					before = line.charAt(j);
				}
			}
			System.out.println("#"+i+" "+count);
			count = 0;
			before = '0';
		}
	}

}
