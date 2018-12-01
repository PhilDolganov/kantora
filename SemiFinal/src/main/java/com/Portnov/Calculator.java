package com.Portnov;

public class Calculator {
    private int result;

    public void switchOn(){
        result = 0;
    }

    public void add(int a){
        result += a;
    }

    public int getResult(){
        return result;
    }

    public void subtract(int a){
        result -= a;
    }

}
