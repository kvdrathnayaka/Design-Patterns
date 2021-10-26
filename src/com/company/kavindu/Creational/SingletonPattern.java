package com.company.kavindu.Creational;

class SingletonClass{
    private static final SingletonClass instance = new SingletonClass();
    private SingletonClass(){}

    public static SingletonClass getInstance() {
        return instance;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {

    }
}
