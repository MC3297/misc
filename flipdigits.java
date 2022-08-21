import java.io.*;
import java.util.*;
//AtCoder Grand Contest 049 - B - (Flip Digits) MatthewC3297
public class flipdigits {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(r.readLine());
        char[] first = r.readLine().toCharArray();
        char[] second = r.readLine().toCharArray();
        ArrayList<Integer> ones = new ArrayList<>();
        for (int i = n-1; i >= 0; i--) if (first[i] == '1') ones.add(i);
        long totalsum = 0;
        for (int i = 0; i < n; i++) {
            if (first[i] != second[i]) {
                if (ones.size() == 0) {pw.println(-1); pw.close(); return;}
                if (first[i] == '1' && second[i] == '0') {//need 11 to cancel out
                    ones.remove(ones.size()-1);
                    if (ones.size() == 0) {pw.println(-1); pw.close(); return;}
                    first[i] = '0';
                    first[ones.get(ones.size()-1)] = '0';
                    totalsum += ones.get(ones.size()-1)-i;
                    ones.remove(ones.size()-1);
                }
                else if (first[i] == '0' && second[i] == '1') {//shift a 1 to this place
                    totalsum += ones.get(ones.size()-1) - i;
                    first[i] = '1';
                    first[ones.get(ones.size()-1)] = '0';
                    ones.remove(ones.size()-1);
                }
            }
            else if (first[i] == second[i] && first[i] == '1') ones.remove(ones.size()-1);
        }
        pw.println(totalsum);
        pw.close();
    }
}
