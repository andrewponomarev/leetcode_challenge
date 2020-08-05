package daily._2020._08.week_1._04;

public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }
}
