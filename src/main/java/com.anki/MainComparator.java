package com.anki;

import java.util.Comparator;
import java.util.function.Function;

public class MainComparator {

    public static void main(String[] args) {
        Compartor<Person> cmpAge = (p1,p2) -> p1.getAge()-p2.getAge();
        Compartor<Person> cmpFirstname = (p1,p2)->p1.getFirstName().compareTo(p2.getFirstName());
        Compartor<Person> cmpLastname = (p1,p2)->p1.getLastName().compareTo(p2.getLastName());

        /* There is common thing among the compartors above : it takes two Person Object and compare based on the given field .
        * We can generalise above By writing  Function and Passing it to the compoartor.
        * */

        /*Function<Person,Integer> f1 = Person::getAge;
        Function<Person,String> f2 = Person::getFirstName;
        Function<Person,String> f3 = Person::getLastName;*/

        Function<Person,Comparable> f1 = Person::getAge;
        Function<Person,Comparable> f2 = Person::getFirstName;
        Function<Person,Comparable> f3 = Person::getLastName;

        Compartor<Person> personCompartor = Compartor.comparing(f1); //see the comparing method
        Compartor<Person> personLastNameCompartor = Compartor.comparing(f2);
       /*this will not copil;e as the comparing method takes Function<Person,Integer>, but we want Function<Person,String>
       * So will try to make the comparing method more generic;
       * */


       /*Comaparator Chaining
       *
       * Example : If suppose the ages are same,we want to compare based on Firstname and then based on lastname.
       *
       * */

        Compartor<Person> cmp = Compartor.comparing(f1).thenComparing(f2).thenComparing(f3);

    }
}
