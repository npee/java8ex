package io.npee.java8.functionalinterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MethodReferenceTestDriveTest {

    @Test
    void reference_to_a_static_method() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> powResult = nums.stream().map(n -> Math.pow(n, 2)).collect(Collectors.toList());
        // powResult.forEach(r -> System.out.println(r));
        powResult.forEach(System.out::println); // Static method
    }

    @Test
    void reference_to_an_instance_method_of_a_particular_object() {

        User user1 = new User("user1", 20);
        User user2 = new User("user2", 10);
        User user3 = new User("user3", 30);

        List<User> userList = Arrays.asList(user1, user2, user3);

        UserAgeComparator userAgeComparator = new UserAgeComparator();
        // List<User> sortedUserList = userList.stream().sorted((u1, u2) -> userAgeComparator.compare(u1, u2)).collect(Collectors.toList());
        List<User> sortedUserList = userList.stream().sorted(userAgeComparator::compare).collect(Collectors.toList());

        Assertions.assertEquals(sortedUserList.get(0).getUsername(), "user2");
        Assertions.assertEquals(sortedUserList.get(1).getUsername(), "user1");
        Assertions.assertEquals(sortedUserList.get(2).getUsername(), "user3");

        sortedUserList.forEach(u -> System.out.println(u.username));
    }

    static class User {

        public User(String username, Integer age) {
            this.username = username;
            this.age = age;
        }

        public User(String username) {
            this.username = username;
            this.age = 0;
        }

        private String username;
        private Integer age;

        public String getUsername() {
            return username;
        }

        public Integer getAge() {
            return age;
        }
    }

    static class UserAgeComparator implements Comparator<User> {
        @Override
        public int compare(User u1, User u2) {
            return u1.getAge().compareTo(u2.getAge());
        }
    }

    @Test
    void reference_to_an_instance_method_of_an_arbitrary_object_of_a_particular_type() {
        List<Integer> nums = Arrays.asList(10, 51, 24, 30, 55, 28, 1, 19);
        // List<Integer> sorted = nums.stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
        List<Integer> sorted = nums.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    @Test
    void reference_to_a_constructor() {
        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");
//        User[] users = langs.stream().sorted(String::compareTo).map(u -> new User(u)).toArray(new IntFunction<User[]>() {
//            @Override
//            public User[] apply(int value) {
//                return new User[value];
//            }
//        });
        User[] users = langs.stream().sorted(String::compareTo).map(User::new).toArray(User[]::new);
        Arrays.stream(users).forEach(u -> System.out.println(u.getUsername()));
    }

    @Test
    void reference_to_a_varargs_method() {
        List<String> usernames = Arrays.asList("user1", "user2");
        User[] users = usernames.stream().map(User::new).toArray(User[]::new);
        Arrays.stream(users).forEach(MethodReferenceTestDriveTest::printAllUsernames);
    }

    private static void printAllUsernames(User... users) {
        Arrays.stream(users).forEach(u -> System.out.println(u.getUsername()));
    }
}