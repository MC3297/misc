import java.io.*;
import java.util.*;
//AtCoder Grand Contest 024 C - Sequence Growing Easy MatthewC3297
public class seqgrowing {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(r.readLine());
        int[] storage = new int[n];
        for (int i = 0; i < n; i++) {
            storage[i] = Integer.parseInt(r.readLine());
        }
        //if interval > 1 or [0] != 0, -1
        if (storage[0] != 0) {pw.println(-1); pw.close(); return;}
        for (int i = 0; i < n-1; i++) {
            if (storage[i+1] - storage[i] > 1) {
                pw.println(-1); pw.close(); return;
            }
        }
        long total = 0;
        for (int i = 1; i < storage.length; i++) {
            if (storage[i] == storage[i-1] + 1) total++;
            else total += storage[i];
        }
        pw.println(total);
        pw.close();
    }
}
