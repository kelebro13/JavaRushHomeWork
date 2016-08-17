package com.javarush.test.level30.lesson06.task01;

import java.util.ArrayList;
import java.util.List;

/* Такие хитрые исключения!
Исправьте реализацию метода checkAFlag, чтобы во всех случаях он не приводил к бросанию исключений.
Сохраните логику вывода данных.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        checkAFlag(new D());
    }

    public static void checkAFlag(D d) {
        if(d != null){
            if(d.cs != null){
                if(!d.cs.isEmpty()){
                    C c = d.cs.get(0);
                    if(c.bs != null){
                       if(!c.bs.isEmpty()){
                           B b = c.bs.get(0);
                           if(b.as != null){
                               if(!b.as.isEmpty()){
                                   A a = b.as.get(0);
                                   if(a.flag != false){
                                       System.out.println("A's flag is true");
                                   }else{
                                       System.out.println("Oops!");
                                   }
                               }else{
                                   System.out.println("Oops!");
                               }
                           }else{
                               System.out.println("Oops!");
                           }
                       }else{
                           System.out.println("Oops!");
                       }
                    }else{
                        System.out.println("Oops!");
                    }
                }else{
                    System.out.println("Oops!");
                }
            }else{
                System.out.println("Oops!");
            }
        }else{
            System.out.println("Oops!");
        }




    }

    static class A {
        boolean flag = true;
    }

    static class B {
        List<A> as = new ArrayList<>();
        {
            as.add(new A());
        }
    }

    static class C {
        List<B> bs = new ArrayList<>();
        {
            bs.add(new B());
        }
    }

    static class D {
        List<C> cs = new ArrayList<>();
        {
            cs.add(new C());
        }
    }
}
