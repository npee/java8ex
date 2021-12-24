package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import org.junit.jupiter.api.Test;

class SummaryStatisticsTestDriveTest {

    @Test
    void intSummaryStatisticsTest() {
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");
        IntSummaryStatistics stats = langs.stream()
                                          .mapToInt((lang) -> (lang.length()))
                                          .summaryStatistics();

        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Count: " + stats.getCount());
    }

}