package com.company.kavindu.Creational;

class SingletonClass{
    private final SingletonClass instance = new SingletonClass();
    private SingletonClass(){}

    public SingletonClass getInstance() {
        return instance;
    }
}

public class SingletonPattern {

}
