package com.javarush.test.level34.lesson02.task03;

/* Разложение на множители с помощью рекурсии
Разложить целое число n > 1 на простые множители.
Вывести в консоль через пробел все множители в порядке возрастания.
Написать рекуррентный метод для вычисления простых множителей.
Не создавайте статические переменные и поля класса.
Пример:
132
Вывод на консоль:
2 2 3 11
*/
public class Solution {
    public static void main(String[] args) {
       new Solution().recursion(132);
    }
    public void recursion(int n) {
        if(n <= 0) return;
        for(int i = 2; i <= n; i++){
            if(n % i == 0){
                n = n / i;
                System.out.print(i + " ");
                recursion(n);

                return;
            }
        }
    }
}
