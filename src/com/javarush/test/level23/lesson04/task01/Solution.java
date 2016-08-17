package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution solutions = new Solution();
        solutions.innerClasses[0] = solutions.new InnerClass();
        solutions.innerClasses[1] = solutions.new InnerClass();

        Solution solutions2 = new Solution();
        solutions2.innerClasses[0] = solutions.new InnerClass();
        solutions2.innerClasses[1] = solutions.new InnerClass();

        Solution[] sol = new Solution[2];
        sol[0] = solutions;
        sol[1] = solutions2;


        return sol;
    }
}
