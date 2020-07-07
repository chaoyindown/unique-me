package com.zhangteng.homestudy.java8;

import com.zhangteng.homestudy.Apple;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * @author: zhangt
 * @date: 20:42
 */
public class LambdaUsage {
    private static List<Apple> APPLES;
    public static void main(String[] args) {
        init();
        doBussness();
    }
    static void init(){
        APPLES = Arrays.asList(new Apple("苹果4",20),new Apple("苹果1",20),new Apple("苹果2",50),new Apple("苹果3",100));
    }
    static void getCurrentThreadName(){
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * 实际逻辑代码
     */
    static void doBussness(){
//        System.out.println(APPLES);
//        List<Apple> over80Apples = testLong(APPLES,(a,b)->a.contains("苹果1") && b > 50);
//        System.out.println(over80Apples);
        /*System.out.println(testFunction(new Apple("苹果4",20),(a)->"颜色:"+a.getColor()+
                "然后重量是:"+a.getWeight()));*/
       /* Supplier<String> supplier = String::new;
        System.out.println(testSupplier(supplier).getClass());*/
        /*testIterator();*/
       /* testReference();
        System.out.println(APPLES.iterator().next().getColor());*/
//        testArray();
        testGenerate();

    }
    private static void doRunable(){
            Runnable run = ()-> System.out.println("hello");
            run.run();

    }
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(currentThread().getName());
        }
    }
    private static List<Apple> getWeightOver80(List<Apple> apples, Predicate<Apple> predicate){
        List<Apple> results = new ArrayList<Apple>();
        for(Apple apple : apples){
            if(predicate.test(apple)){
                results.add(apple);
            }
        }
        return results;
    }
    private static List<Apple> testLong(List<Apple> apples, LongPredicate longPredicate){
        List<Apple> results = new ArrayList<Apple>();
        for(Apple apple : apples){
            if(longPredicate.test(apple.getWeight())){
                results.add(apple);
            }
        }
        return results;
    }
    private static List<Apple> testLong(List<Apple> apples, BiPredicate<String,Long> biPredicate){
        List<Apple> results = new ArrayList<Apple>();
        for(Apple apple : apples){
            if(biPredicate.test(apple.getColor(),apple.getWeight())){
                results.add(apple);
            }
        }
        return results;
    }
    private static String testFunction(Apple apple, Function<Apple,String> function){
        return function.apply(apple);
    }
    private static <T> T testSupplier(Supplier<T> supplier){
        return supplier.get();
    }
    private static void testIterator(){
        Iterator<Apple> iterator = APPLES.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getColor());
        }
    }
    private static void testReference(){
        APPLES.sort((a,b)->a.getColor().compareTo(b.getColor()));
        System.out.println(APPLES);
        String str = "123";
        Function<Integer, Character> integerCharacterFunction = str::charAt;
        System.out.println(integerCharacterFunction.apply(2));
    }
    private static void testGenerate(){
        /*Apple[] Apples = new Apple[2];
//        int ints[] = new int[]{1,2,3};
        String strings[] = new String[3];
        strings[0] = "0";
        Arrays.stream(strings).forEach(System.out::println);*/
        Stream<Integer> stream = Stream.iterate(0, a->a+1);
        stream.forEach(System.out::println);
//        System.out.println(ints.toString());
    }
}
