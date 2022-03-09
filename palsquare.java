/*
ID: ashleyd1
LANG: JAVA
TASK: palsquare
*/
//usaco training page
import java.util.*;
import java.io.*;
public class palsquare {
    public static char translate(int n) {
        if (n >= 0 && n < 10) {
            return (char)(n+48);
        }
        else {
            return (char)(n+55);
        }
    }
    public static String changeBase(int num, int base, String returnstr) {
        if (num == 0) {
            return returnstr;
        }
        return changeBase(num/base, base, translate(num%base)+returnstr);
    }
    public static boolean isPalindromicString(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int base = Integer.parseInt(file.readLine());
        for (int i = 1; i <= 300; i++) {
            if (isPalindromicString(changeBase(i*i, base, ""))) {
                outfile.print(changeBase(i, base, "")); outfile.print(" "); outfile.println(changeBase(i*i, base, ""));
            }
        }
        file.close();
        outfile.close();
    }
}