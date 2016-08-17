package com.javarush.test.level25.lesson11.task02;

/* Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
Обеспечьте переуступку кванта времени (переход хода для текущей нити) для последовательных выводов текста в консоль
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args){
        YieldRunnable yieldRunnable = new YieldRunnable(10);
        YieldRunnable yieldRunnable2 = new YieldRunnable(3);
        Thread thread = new Thread(yieldRunnable);
        Thread thread2 = new Thread(yieldRunnable2);
        thread.start();
        thread2.start();
    }
}
