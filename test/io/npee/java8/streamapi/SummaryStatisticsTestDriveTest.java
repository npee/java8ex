package io.npee.java8.streamapi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
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

    @Test
    void acceptTest() {
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");
        IntSummaryStatistics stats = langs.stream()
                                          .mapToInt((lang) -> (lang.length()))
                                          .summaryStatistics();
        stats.accept(20); // 추가

        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Count: " + stats.getCount());
    }

    @Test
    void combineTest() {
        List<String> langs =
            Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");
        IntSummaryStatistics stats = langs.stream()
                                          .mapToInt((lang) -> (lang.length()))
                                          .summaryStatistics();

        List<String> companies =
            Arrays.asList("google", "apple", "google", "apple", "samsung");
        IntSummaryStatistics stats2 = companies.stream()
                                               .mapToInt((lang) -> (lang.length()))
                                               .summaryStatistics();

        stats.combine(stats2); // 통계 스트림 합치기 (각 통계의 결과끼리 다시 계산)

        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Count: " + stats.getCount());
    }

    @Test
    void summarizingIntTest() {
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");
        IntSummaryStatistics stats =
            langs.stream()
                 // mapToInt() 와 summaryStatistics()를 합친 형태
                 .collect(Collectors.summarizingInt(String::length));

        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Count: " + stats.getCount());
    }

}