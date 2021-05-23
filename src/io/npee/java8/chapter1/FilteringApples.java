package io.npee.java8.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println("greenApples = " + greenApples);

        List<Apple> heavyApples = filterHeavyApples(inventory);
        System.out.println("heavyApples = " + heavyApples);

        /**
         * Java 8 Lambda expressions (-> syntax)
         */
        List<Apple> greenApples2 = filterApples(inventory, apple -> "green".equals(apple.getColor()));
        System.out.println("greenApples2 = " + greenApples2);

        List<Apple> heavyApples2 = filterApples(inventory, apple -> apple.getWeight() > 150);
        System.out.println("heavyApples2 = " + heavyApples2);

        List<Apple> weirdApples = filterApples(inventory, apple -> apple.getWeight() < 80 || "brown".equals(apple.getColor()));
        System.out.println("weirdApples = " + weirdApples);

        /**
         * Java 8 Method References (:: syntax)
         */
        List<Apple> greenApplesByPassingMethod = filterApples(inventory, Apple::isGreenApple);
        System.out.println("heavyApples = " + greenApplesByPassingMethod);

        List<Apple> heavyApplesByPassingMethod = filterApples(inventory, Apple::isHeavyApple);
        System.out.println("heavyApples = " + heavyApplesByPassingMethod);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * Predicate Example
     * Predicate is often used in mathematics to mean something function-like that takes a value
     *  for an argument and returns true or false.
     * @param inventory List
     * @param p Predicate
     * @return List
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return this.weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return this.color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
        }

        public static boolean isGreenApple(Apple apple) {
            return "green".equals(apple.getColor());
        }

        public static boolean isHeavyApple(Apple apple) {
            return apple.getWeight() > 150;
        }
    }
}
