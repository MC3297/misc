import java.io.*;
import java.util.*;
//binarysearch.com Longest Alternating Subsequence hard
public class bsearchcom {
    public static int solve(int[] nums) {
        if (nums.length == 0) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 0; i < nums.length-1; i++) {//removes duplicates
            if (nums[i] != nums[i+1]) list.add(nums[i+1]);
        }
        if (list.size() <= 2) return list.size();
        boolean isUp = false;
        if (list.get(1) - list.get(0) > 0) isUp = true;
        boolean[] viable = new boolean[list.size()];
        viable[0] = true; viable[1] = true;
        for (int i=1; i<list.size()-1; i++) {
            int difference = list.get(i+1)-list.get(i);
            //+ means going up, - means going down
            if ((difference > 0 && !isUp) || (difference < 0 && isUp)) {
                viable[i+1] = true;
                isUp = !isUp;
            }
            else {
                viable[i] = false;
                viable[i+1] = true;
            }
        }
        int total = 0;
        for (boolean i: viable) if (i) total++;
        //System.out.println(list);
        //System.out.println(Arrays.toString(viable));
        //System.out.println(total);
        return total;
    }
}
