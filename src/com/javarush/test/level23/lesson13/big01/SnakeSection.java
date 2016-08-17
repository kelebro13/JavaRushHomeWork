package com.javarush.test.level23.lesson13.big01;

public class SnakeSection
{
    private int x;
    private int y;


    public SnakeSection(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public int hashCode()
    {
        return 31 * ((x == 0 ? 0 : x) + (y == 0 ? 0 : y));
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        SnakeSection snakeSection = (SnakeSection) obj;

        if(x != snakeSection.getX()){
            return false;
        }
        if(y != snakeSection.getY()){
            return false;
        }
        return true;
    }
}
