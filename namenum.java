/*
LANG: JAVA
TASK: namenum
*/
import java.util.*;
import java.io.*;
public class namenum {
    public static void setUp(HashMap<Integer, HashSet<Character>> storage) {
        for (int i = 2; i < 10; i++) {
            HashSet<Character> temp = new HashSet<>();
            storage.put(i, temp);
        }
        storage.get(2).add('A');storage.get(2).add('B');storage.get(2).add('C');
        storage.get(3).add('D');storage.get(3).add('E');storage.get(3).add('F');
        storage.get(4).add('G');storage.get(4).add('H');storage.get(4).add('I');
        storage.get(5).add('J');storage.get(5).add('K');storage.get(5).add('L');
        storage.get(6).add('M');storage.get(6).add('N');storage.get(6).add('O');
        storage.get(7).add('P');storage.get(7).add('R');storage.get(7).add('S');
        storage.get(8).add('T');storage.get(8).add('U');storage.get(8).add('V');
        storage.get(9).add('W');storage.get(9).add('X');storage.get(9).add('Y');
    }
    public static boolean isValid(String num, String name, HashMap<Integer, HashSet<Character>> storage) {
        if (num.length() == name.length()) {
            for (int i = 0; i < num.length(); i++) {
                int intval = Character.getNumericValue(num.charAt(i));
                if (!storage.get(intval).contains(name.charAt(i))) return false;
            }
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new FileReader("namenum.in"));
        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
        PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        String num = file.readLine();
        String line;
        boolean returned = false;
        HashMap<Integer, HashSet<Character>> storage = new HashMap<>();
        setUp(storage);
        while ((line = dict.readLine()) != null) {
            if (isValid(num, line, storage)){outfile.println(line); returned = true;}
        }
        if (!returned) outfile.println("NONE");
        dict.close();
        file.close();
        outfile.close();
    }
}