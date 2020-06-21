package daily._2020._06._19;

public class LongestDuplicateSubstring {
    //todo

    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1;
        int right = n;
        int pivot = 1;
        String result = "";
        while (left <= right) {
            pivot = left + (right - left) / 2;
            String cur = dupSubstringOfLengthK(s, pivot);
            if (exists(cur)) {
                result = cur;
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return result;
    }

    private String dupSubstringOfLengthK(String s, int k) {
        return "";
    }

    private boolean exists(String s) {
        return !s.equals("");
    }

}
