package com.company.kavindu.Creational;

interface AnimalGroups{
    boolean isHavingLegs();
    boolean isHavingFeathers();
}

class Fish implements AnimalGroups{
    @Override
    public boolean isHavingLegs() {
        return false;
    }

    @Override
    public boolean isHavingFeathers() {
        return false;
    }
}

class Mammal implements AnimalGroups{
    @Override
    public boolean isHavingLegs() {
        return true;
    }

    @Override
    public boolean isHavingFeathers() {
        return false;
    }
}

class Bird implements AnimalGroups{
    @Override
    public boolean isHavingLegs() {
        return true;
    }

    @Override
    public boolean isHavingFeathers() {
        return true;
    }
}

class FactoryMethod {
    public AnimalGroups getAnimalGroup(String group){
        if(group.equalsIgnoreCase("FISH")) return  new Fish();
        else if(group.equalsIgnoreCase("MAMMAL")) return new Mammal();
        else if(group.equalsIgnoreCase("BIRD")) return new Bird();
        return null;
    }
}

public class FactoryMethodPattern{
    public static void main(String[] args) {
        final FactoryMethod factoryMethod = new FactoryMethod();
        String group = "bird";
        AnimalGroups animalGroup = factoryMethod.getAnimalGroup(group);
        System.out.println("Animal group " + group + " has legs ? " + animalGroup.isHavingLegs());
        System.out.println("Animal group " + group + " has feathers ? " + animalGroup.isHavingFeathers());
    }
}