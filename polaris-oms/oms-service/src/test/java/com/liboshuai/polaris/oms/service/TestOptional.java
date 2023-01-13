package com.liboshuai.polaris.oms.service;

import org.junit.Test;

import java.util.Optional;

/**
 * @Author: liboshuai
 * @Date: 2023-01-13 10:47
 * @Description: Optional类测试方法
 */
public class TestOptional {

    /**
     * 实际使用场景
     * 1. 我们要将一个对象的名称全部统一为大写，防止空指针. 但是实际使用来看还是遇到了不少的问题
     */
    @Test
    public void actualUse() {
        //Optional.of(T t) : 创建一个 Optional 实例
        Optional<Employee> employee = Optional.of(new Employee());
        System.out.println(employee.get());//LambdaP.Employee{name='null', age=0, salary=0}
        //of方法是不能构建一个null对象的，否则会报错 NullPointerException 虽然报空指针，但是这时候我们就不需要一个个的Debug了，直接就能锁定出错行

        //Optional.empty() : 创建一个空的 Optional 实例
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.get());
        //empty方法是构建一个新的空Optional对象，Optional中的内容是空的但是Optional对象不是空的，这时候调用get方法获取内容会出错
        //NoSuchElementException: No value present

        //Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.get());
        //ofNullable是允许构建一个空对象的，但是同上面一个一样，是无法获取里面的值的，因为没值
        //报错java.util.NoSuchElementException: No value present

        //isPresent() : 判断是否包含值
        Optional<Employee> employees = Optional.ofNullable(null);
        if (employees.isPresent()) {
            System.out.println("不为空");
        } else {
            System.out.println("为空");
        }
        //为空  由此就可以看出，如果Optional中包含内容的话那么他会返回true，否则返回false

        //orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
        Optional<Object> objectOptional = Optional.ofNullable(null);
        Object orElse = objectOptional.orElse(new Employee("orElse", 11, 1555));
        System.out.println(orElse);
        //LambdaP.Employee{name='orElse', age=11, salary=1555}  可以看出orElse作用了，如果是空就返回后面指定创建的，否则就返回ofNullable后封装的对象


        //orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
        Optional<Object> o2 = Optional.ofNullable(null);
        Object o1 = o2.orElseGet(() -> 1);
        System.out.println(o1);
        // 1 orElseGet 里面是要求的是一个供给型接口Supplier  ，所以就可以根据我们的需求随意的处理和返回任何东西

        //map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
        Optional<Employee> o3 = Optional.ofNullable(new Employee("orElse", 11, 1555));
        Optional<Integer> integer = o3.map((e) -> e.getSalary() + 100000);
        System.out.println(integer);
        //Optional[101555]     现在就对封装的对象中的工资进行了操作

        //flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
        Optional<Employee> orElse4 = Optional.ofNullable(new Employee("orElse", 11, 1555));
        Optional<Integer> integer4 = orElse4.flatMap((e) -> Optional.ofNullable(e.getSalary() + 100000));
        System.out.println(integer4);
        //Optional[101555]
        //这里需要注意的是返回值必须是一个封装以后的Optional对象
    }

    @Test
    public void one() {
        //Optional.of(T t) : 创建一个 Optional 实例
        Optional<Employee> employee = Optional.of(new Employee());
        System.out.println(employee.get());//LambdaP.Employee{name='null', age=0, salary=0}
        //of方法是不能构建一个null对象的，否则会报错 NullPointerException 虽然报空指针，但是这时候我们就不需要一个个的Debug了，直接就能锁定出错行
    }

    @Test
    public void two() {
        //Optional.empty() : 创建一个空的 Optional 实例
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.get());
        //empty方法是构建一个新的空Optional对象，Optional中的内容是空的但是Optional对象不是空的，这时候调用get方法获取内容会出错
        //NoSuchElementException: No value present
    }

    @Test
    public void three() {
        //Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.get());
        //ofNullable是允许构建一个空对象的，但是同上面一个一样，是无法获取里面的值的，因为没值
        //报错java.util.NoSuchElementException: No value present
    }

    @Test
    public void four() {
        //isPresent() : 判断是否包含值
        Optional<Employee> employees = Optional.ofNullable(null);
        if (employees.isPresent()) {
            System.out.println("不为空");
        } else {
            System.out.println("为空");
        }
        //为空  由此就可以看出，如果Optional中包含内容的话那么他会返回true，否则返回false
    }

    @Test
    public void five() {
        //orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
        Optional<Object> objectOptional = Optional.ofNullable(null);
        Object orElse = objectOptional.orElse(new Employee("orElse", 11, 1555));
        System.out.println(orElse);
        //LambdaP.Employee{name='orElse', age=11, salary=1555}  可以看出orElse作用了，如果是空就返回后面指定创建的，否则就返回ofNullable后封装的对象
    }

    @Test
    public void six() {
        //orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
        Optional<Object> o2 = Optional.ofNullable(null);
        Object o1 = o2.orElseGet(() -> 1);
        System.out.println(o1);
        // 1 orElseGet 里面是要求的是一个供给型接口Supplier  ，所以就可以根据我们的需求随意的处理和返回任何东西
    }

    @Test
    public void seven() {
        //map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
        Optional<Employee> o3 = Optional.ofNullable(new Employee("orElse", 11, 1555));
        Optional<Integer> integer = o3.map((e) -> e.getSalary() + 100000);
        System.out.println(integer);
        //Optional[101555]     现在就对封装的对象中的工资进行了操作
    }

    @Test
    public void eight() {
        //flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
        Optional<Employee> orElse4 = Optional.ofNullable(new Employee("orElse", 11, 1555));
        Optional<Integer> integer4 = orElse4.flatMap((e) -> Optional.ofNullable(e.getSalary() + 100000));
        System.out.println(integer4);
        //Optional[101555]
        //这里需要注意的是返回值必须是一个封装以后的Optional对象
    }
}
