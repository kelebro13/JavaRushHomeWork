package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {



    private Solution(short s){}
    private Solution(String s){}
    private Solution(Object obj){}

    protected Solution(int a){}
    protected Solution(Integer b){}
    protected Solution (int a, int b){}

    public Solution(){}
    public Solution(long a){}
    public Solution(boolean b){}

    Solution (int a, int b, int c){}
    Solution (Integer a, int b, int c){}
    Solution (int a, Integer b, int c){}
}

