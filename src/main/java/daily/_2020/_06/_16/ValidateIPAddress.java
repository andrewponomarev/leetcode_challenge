package daily._2020._06._16;

import static daily._2020._06._16.ValidateIPAddress.IPvType.IPv4;
import static daily._2020._06._16.ValidateIPAddress.IPvType.IPv6;
import static daily._2020._06._16.ValidateIPAddress.IPvType.Neither;

public class ValidateIPAddress {

    enum IPvType {

        IPv4("^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$"),
        IPv6("^(([0-9a-fA-F]{4}|[0-9a-fA-F]{3}|[0-9a-fA-F]{2}|[0-9a-fA-F]{1}):){7}([0-9a-fA-F]{4}|[0-9a-fA-F]{3}|[0-9a-fA-F]{2}|[0-9a-fA-F]{1})$"),
        Neither(".*");

        String pattern;

        IPvType(String pattern) {
            this.pattern = pattern;
        }

        IPvType() {
        }
    }


    public String validIPAddress(String IP) {

        for (IPvType iPvType : IPvType.values()) {
            if (IP.matches(iPvType.pattern)) {
                return iPvType.name();
            }
        }
        return Neither.name();
    }

    public static void main(String[] args) {
        System.out.println(new ValidateIPAddress().validIPAddress("172.16.254.1"));
        System.out.println(new ValidateIPAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(new ValidateIPAddress().validIPAddress( "256.256.256.256"));
    }

}
