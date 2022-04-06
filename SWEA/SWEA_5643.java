import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class SWEA_5643
{
    static int N;
    static int[][] adjMatrix;
    static final int MAX_VALUE = 500;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            adjMatrix = new int[N+1][N+1];
            for(int i=1; i<=N; i++) {
                Arrays.fill(adjMatrix[i], MAX_VALUE);
            }
 
            int M = Integer.parseInt(br.readLine());
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjMatrix[a][b] = 1;
            }
            floydWarshall();
            int count = getCount();
 
            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
 
    }
     
    public static void floydWarshall() {
        for(int k=1; k<=N; k++) {            // 경유 
            for(int i=1; i<=N; i++) {        // 출발 
                if(i == k) continue;
                for(int j=1; j<=N; j++) {    // 도착 
                    if(i == j || j == k) continue;
                    if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j]) {
                        adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                    }
                }
            }
             
        }
    }
 
    public static int getCount() {
        int[] known = new int[N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(adjMatrix[i][j] != MAX_VALUE) {
                    known[i]++;
                    known[j]++;
                }
            }
        }
         
        int count = 0;
        for(int i=1; i<=N; i++) {
            if(known[i] == N-1) count++;
        }
         
        return count;
    }
 
 
}