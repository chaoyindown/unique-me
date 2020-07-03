package com.zhangteng.homestudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhangt
 * @date: 23:29
 */
public class FilterApple {
    @FunctionalInterface
    public interface AppleFilter{
        boolean filter(Apple apple);

        default String findColor() {
            return null;
        }
    }
    public static class Green150Filter implements AppleFilter{

        @Override
        public boolean filter(Apple apple) {
            return "green".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 150;
        }
    }

    public static List<Apple> findAppleByFilter(List<Apple> appleList,AppleFilter filter){
        List<Apple> resultList = new ArrayList<Apple>();
        for(Apple apple : appleList){
            if(filter.filter(apple)){
                resultList.add(apple);
            }
        }
        return resultList;
    }
    public static List<Apple> findYellowApples(List<Apple> appleList,String color){
        List<Apple> resultList = new ArrayList<>();
        appleList.forEach(apple -> {
            if("yellow".equalsIgnoreCase(apple.getColor())){
                resultList.add(apple);
            }
        });

        return resultList;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("yellow",120),
                new Apple("Yellow",139),
                new Apple("pink",160));
//        List<Apple> yellowApples = findYellowApples(apples,"red");
//        List<Apple> yellowApples = findAppleByFilter(apples,new Green150Filter());
       /* List<Apple> yellowApples = findAppleByFilter(apples, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "Yellow".equalsIgnoreCase(apple.getColor()) && apple.getWeight() >= 120;
            }
        });*/
        List<Apple> yellowApples = findAppleByFilter(apples,(Apple apple)->{
            return "yellow".equalsIgnoreCase(apple.getColor());
        });


//        assert yellowApples.size() ==  2;
        System.out.println(yellowApples.toString());
        System.out.println(Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        new Thread(()->{System.out.println(Thread.currentThread().getName());}).start();
    }
}
