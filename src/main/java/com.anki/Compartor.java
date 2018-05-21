package com.anki;

import java.util.function.Function;

@FunctionalInterface
public interface Compartor<T> {

    public int compare (T a, T b);


   /* static Compartor<Person> comparing(Function<Person, Integer> f1) {

        return (p1,p2)->f1.apply(p1)- f1.apply(p2);

    }
*/

    static <U> Compartor<U> comparing(Function<U, Comparable> f1) {

        return (p1,p2)->f1.apply(p1).compareTo(f1.apply(p2));

    }

    public default Compartor<T>  thenComparing( Compartor cmp){


        return (p1,p2)-> compare(p1,p2)==0? cmp.compare(p1,p2): compare(p1,p2);
    }

    public default Compartor<T>  thenComparing(Function<T, Comparable> f1){

        Compartor cmp = comparing(f1);
        return (p1,p2)-> compare(p1,p2)==0? cmp.compare(p1,p2): compare(p1,p2);
    }

}
