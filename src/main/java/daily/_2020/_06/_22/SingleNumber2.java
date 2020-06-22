package daily._2020._06._22;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        int all = 0;
        Set<Integer> set = new HashSet<>();
        for (int a : nums) {
            all += a;
            set.add(a);
        }
        int s_x = 0;
        for (int s : set) {
            s_x += s;
        }
        int s = (all - s_x)/2;
        return all - 3*s;
    }

}
