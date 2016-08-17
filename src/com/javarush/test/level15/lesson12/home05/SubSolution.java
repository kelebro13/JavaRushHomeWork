package com.javarush.test.level15.lesson12.home05;

/**
 * Created by DNS on 02.10.2015.
 */
public class SubSolution extends Solution
{
    private SubSolution(short s){}
    private SubSolution(String s){}
    private SubSolution(Object obj){}



    protected SubSolution(int a)
    {
        super(a);
    }

    protected SubSolution(Integer b)
    {
        super(b);
    }

    protected SubSolution(int a, int b)
    {
        super(a, b);
    }

    public SubSolution()
    {
        super();
    }

    public SubSolution(long a)
    {
        super(a);
    }

    public SubSolution(boolean b)
    {
        super(b);
    }

    SubSolution(int a, int b, int c)
    {
        super(a, b, c);
    }

    SubSolution(Integer a, int b, int c)
    {
        super(a, b, c);
    }

    SubSolution(int a, Integer b, int c)
    {
        super(a, b, c);
    }
}
