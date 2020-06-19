package daily._2020._06._18;

public class H_Index_2 {

    public int hIndex(int[] citations) {
        int N = citations.length;
        int h = 1;
        while ( N - h >= 0 && citations[N - h] >= h) {
            h++;
        }
        return h-1;
    }
}
