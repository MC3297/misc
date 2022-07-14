import java.io.*;
import java.util.*;
//AtCoder Beginner Contest 242 - E - (∀x∀) MatthewC3297
public class AxA {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int testcases = Integer.parseInt(r.readLine());
        final int mod = 998244353;
        for (int q = 0; q < testcases; q++) {
            int n = Integer.parseInt(r.readLine());
            String s = r.readLine();
            ArrayList<Integer> storage = new ArrayList<>();
            for (int i = (int)Math.ceil(s.length()/2.0)-1; i >= 0; i--) {
                storage.add(s.charAt(i)-65);
            }
            char[] tempS = new char[n];
            for (int i = 0; i < Math.ceil(n/2.0); i++) {
                tempS[i] = tempS[n-i-1] = s.charAt(i);
            }
            long answer = 0;
            if (new String(tempS).compareTo(s) <= 0) answer++;
            for (int i = 0; i < storage.size(); i++) {
                answer = (answer+bExpo(26, i, mod)*storage.get(i))%mod;
            }
            pw.println(answer);
        }
        pw.close();
    }
    public static long bExpo(long base, long power, long mod) {
        long answer = 1;
        while (power != 0) {
            if (power%2 == 1) answer = (answer*base)%mod;
            base = (base * base)%mod;
            power /= 2;
        }
        return answer;
    }
}