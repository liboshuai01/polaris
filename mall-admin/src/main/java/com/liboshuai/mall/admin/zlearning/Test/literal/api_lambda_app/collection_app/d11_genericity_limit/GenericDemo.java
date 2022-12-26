package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.collection_app.d11_genericity_limit;

import java.util.ArrayList;

/**
 * @author:Sun
 * @date2022/12/822:29
 */
public class GenericDemo {
    public static void main(String[] args) {

        ArrayList<BMW> bmws = new ArrayList<>();

        bmws.add(new BMW());
        bmws.add(new BMW());
        bmws.add(new BMW());
        go(bmws);


        ArrayList<Benz> benzs = new ArrayList<>();
        benzs.add(new Benz());
        benzs.add(new Benz());
        benzs.add(new Benz());
        go(benzs);

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());
//        go(dogs);



    }
    public static void go(ArrayList<? extends Car> cars){

    }
}
class Dog{

}
class Benz extends Car{

}
class BMW extends Car{

}
class Car{

}
