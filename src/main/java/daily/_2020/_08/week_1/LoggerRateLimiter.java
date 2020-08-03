package daily._2020._08.week_1;

import java.util.*;
import java.util.stream.Collectors;

public class LoggerRateLimiter {

    private SortedMap<Integer, Set<String>> timeMap;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        timeMap = new TreeMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Map<Integer, Set<String>> lastTenSecs = timeMap.subMap(timestamp - 9, timestamp + 1);
        Set<String> lastMessages = lastTenSecs.entrySet().stream()
                .map(Map.Entry::getValue)
                .flatMap(set -> set.stream())
                .collect(Collectors.toSet());
        boolean contains = lastMessages.contains(message);
        if (!contains) {
            if (!timeMap.containsKey(timestamp)) {
                timeMap.put(timestamp, new HashSet<>());
            }
            timeMap.get(timestamp).add(message);
        }
        return !contains;
    }

    /**
     * Your Logger object will be instantiated and called as such:
     * Logger obj = new Logger();
     * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
     */
    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();

        System.out.println(logger.shouldPrintMessage(12,"bag"));
        // returns true;

        System.out.println(logger.shouldPrintMessage(12,"bag"));
        // returns true;

        // logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        //returns true;

        // logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2,"bar"));
        //returns true;

        // logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3,"foo"));
        //returns false;

        // logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8,"bar"));
        // returns false;

        // logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10,"foo"));
        // returns false;

        // logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11,"foo"));
        // returns true;
    }
}

