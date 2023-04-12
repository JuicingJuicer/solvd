package com.solvd.ta.lab1;

public class Person {
    public static void main(String[] args) {
        String name = args[0];
        int age = Integer.parseInt(args[1]);
        int weight = Integer.parseInt(args[2]);
        System.out.println("Name: " + name + " Age: " + age + " Weight: "+ weight + "lbs");
    }
}
