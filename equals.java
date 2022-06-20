import java.io.*;
import java.util.*;
//AtCoder Regular Contest 097 D - Equals MatthewC3297
public class equals {
    static HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    static int currentcomponent = 1;
    static int[] connectedcomponents;
    static boolean[] visited;
    public static void add(int x, int y) {
        if (!adj.containsKey(x)) adj.put(x, new ArrayList<>());
        adj.get(x).add(y);
    }
    public static void dfsComponents(int root) {
        if (visited[root]) return;
        visited[root] = true;
        connectedcomponents[root] = currentcomponent;
        if (adj.containsKey(root)) for (int i: adj.get(root)) dfsComponents(i);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
    
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] storage = new int[n+1];
        connectedcomponents = new int[n+1];
        visited = new boolean[n+1];
        st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= n; i++) {
            storage[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            add(x, y); add(y, x);
        }
        //create some connected components
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfsComponents(i);
                currentcomponent++;
            }
        }
        /*pw.println(adj);
        pw.println(Arrays.toString(visited));
        pw.println(Arrays.toString(connectedcomponents));
        pw.println(Arrays.toString(storage));*/
        int total = 0;
        for (int i = 1; i < storage.length; i++) {
            if (connectedcomponents[i] == connectedcomponents[storage[i]]) total++;
        }
        pw.println(total);
        pw.close();
    }
}
