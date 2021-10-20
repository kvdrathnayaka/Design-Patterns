package com.company.kavindu.Creational;

abstract class AbstractFactory{
    abstract AnimalGroups getAnimalGroup(String group);
}

class AnimalsLivedInWater extends AbstractFactory{
    @Override
    public AnimalGroups getAnimalGroup(String group) {
        if(group.equalsIgnoreCase("FISH")) return new Fish();
        return null;
    }
}

class AnimalsLivedInLand extends AbstractFactory{
    @Override
    public AnimalGroups getAnimalGroup(String group) {
        if(group.equalsIgnoreCase("BIRD")) return new Bird();
        else if(group.equalsIgnoreCase("MAMMAL")) return new Mammal();
        return null;
    }
}

class FactoryProducer{
    public static AbstractFactory getAnimalFactory(String group){
        if(group.equalsIgnoreCase("BIRD") || group.equalsIgnoreCase("MAMMAL"))
            return new AnimalsLivedInLand();
        if(group.equalsIgnoreCase("FISH"))
            return new AnimalsLivedInWater();
        return null;
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        String animalType = "mammal";
        AbstractFactory abstractFactory = FactoryProducer.getAnimalFactory(animalType);
        AnimalGroups animalGroups = abstractFactory.getAnimalGroup(animalType);
        System.out.println("Animal group " + animalType + " has legs ? " + animalGroups.isHavingLegs());
        System.out.println("Animal group " + animalType + " has feathers ? " + animalGroups.isHavingFeathers());
    }
}
