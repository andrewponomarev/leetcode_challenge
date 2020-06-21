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

    public int hIndex2(int[] citations) {
        int h = 0;
        int N = citations.length;
        while (h < N && citations[h] < N - h) {
            h++;
        }
        return h;
    }

    public int hIndexLog(int[] citations) {
        int N = citations.length;
        int left = 0;
        int right = N-1;
        int pivot = 0;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (citations[pivot] == N - pivot) {
                return N - pivot;
            }
            else if (citations[pivot] < N - pivot) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return N - left;
    }

}
