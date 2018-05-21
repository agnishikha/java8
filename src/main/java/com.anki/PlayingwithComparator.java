package com.anki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlayingwithComparator {

    public static void main(String[] args) {

        Comparator cmp = Comparator.comparing(Person::getAge).thenComparing(Person::getFirstName);

        Person p1= new Person(10,"Cnki","chou");
        Person p2= new Person(10,"Bnki","chou");
        Person p3= new Person(12,"Anki","chou");

        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(p1);
        personArrayList.add(p2);
        personArrayList.add(p3);
        Collections.sort(personArrayList,cmp);
        for(Person p : personArrayList){
            System.out.println(p.toString());
        }
    }
}
