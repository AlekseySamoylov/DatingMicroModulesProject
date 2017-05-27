package com.alekseysamoylov.dating.test;


import com.alekseysamoylov.dating.root.model.Customer;
import com.alekseysamoylov.dating.root.model.Gender;
import com.alekseysamoylov.dating.root.model.User;

import java.io.File;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * For test new features!
 */
public class StreamsTest {

    public static void main(String[] args) {
        File[] files = new File("/usr/local/.").listFiles(File::canWrite);
        assert files != null;
        Arrays.stream(files).forEach(file -> {
            System.out.println("Hello " + file);
        });

        String[] names = new String[]{"Hello", "sdfa", "sdfsdaf", "fdssgasfds", "sdadfsa"};

        List<String> sortedNames = Arrays.stream(names).sorted((one, two) -> {
            return Integer.compare(one.length(), two.length());
        }).collect(Collectors.toList());

        System.out.println(sortedNames);
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(() -> {
            System.out.println("Hello world");
        });

        List<String> filteredNames = sortedNames.stream().filter(name -> {
            return name.contains("sd");
        }).collect(Collectors.toList());
        System.out.println(filteredNames);

        List<Customer> customers = Arrays.asList(
                new Customer("Alice", false, Gender.FEMALE),
                new Customer("Pol", true, Gender.MALE),
                new Customer("Sara", true, Gender.FEMALE));

        List<Customer> activeCustomers = customers.parallelStream().filter(Customer::getActive).collect(Collectors.toList());

        Map<Gender, List<Customer>> customerMap = customers.parallelStream().filter(Customer::getActive).collect(Collectors.groupingBy(Customer::getGender));

        List<Customer> nameFilteredCustomers = customers.parallelStream().filter((customer) -> customer.getNikName().contains("l")).collect(Collectors.toList());

        Comparator<User> userComparator = (first, second) -> first.getId().compareTo(second.getId());

        Comparator<User> easyUserComparator = Comparator.comparing(User::getId);

        List<String> customersFunctionExample = map(customers, (customer -> customer.getNikName() + " completed"));

        List<Customer> doubleComparedList = new ArrayList<>(customers);
        doubleComparedList.sort(Comparator.comparing(Customer::getActive)
                .reversed().thenComparing(Customer::getGender)
                .reversed().thenComparing(Customer::getNikName));
        System.out.println(doubleComparedList);

        List<Integer> namesCharNumbers1 = customers.stream().map(Customer::getNikName).map(String::length).collect(Collectors.toList());
        List<Integer> namesCharNumbers2 = customers.stream().map((customer) -> customer.getNikName().length()).collect(Collectors.toList());

        boolean isContainsNonActive = customers.stream().anyMatch((customer -> !customer.getActive()));

        Optional<Customer> activeCustomer = customers
                .stream().filter(Customer::getActive).findAny();
        activeCustomer.ifPresent((customer) -> System.out.println(customer.getNikName()));
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }
}
