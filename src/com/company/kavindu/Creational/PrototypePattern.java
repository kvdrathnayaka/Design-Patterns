package com.company.kavindu.Creational;

import java.util.HashMap;
import java.util.Map;

interface Tree extends Cloneable{
    Tree clone() throws CloneNotSupportedException;
}

class PineTree implements Tree{
    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Tree clone() throws CloneNotSupportedException {
        System.out.println("Cloning Pine Tree Obj");
        return (Tree) super.clone();
    }

    @Override
    public String toString() {
        return "PineTree";
    }
}

class CoconutTree implements Tree{
    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Tree clone() throws CloneNotSupportedException {
        System.out.println("Cloning Coconut Tree Obj");
        return (Tree) super.clone();
    }

    @Override
    public String toString() {
        return "CoconutTree";
    }
}

class PrototypeFactory{
    public static class TreeType{
        public static final String pineTree = "PineTree";
        public static final  String coconutTree = "CoconutTree";
    }

    private static final Map<String, Tree> prototypeTreeMap = new HashMap<>();

    static{
        prototypeTreeMap.put(TreeType.pineTree, new PineTree());
        prototypeTreeMap.put(TreeType.coconutTree, new CoconutTree());
    }

    public static Tree getInstance(final String name) throws CloneNotSupportedException{
        return prototypeTreeMap.get(name).clone();
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        try{
            String pineTreePrototype = PrototypeFactory.getInstance(PrototypeFactory.TreeType.pineTree).toString();
            System.out.println(pineTreePrototype);

            String coconutTreePrototype = PrototypeFactory.getInstance(PrototypeFactory.TreeType.coconutTree).toString();
            System.out.println(coconutTreePrototype);
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
