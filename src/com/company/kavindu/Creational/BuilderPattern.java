package com.company.kavindu.Creational;

class House{
    private String base;
    private String wall;
    private String roof;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }
}

abstract class HouseBuilder{
    private final House house = new House();
    public abstract void buildBase();
    public abstract void buildWall();
    public abstract void buildRoof();

    public House buildHouse(){
        return house;
    }
}

class CommonHouse extends HouseBuilder{
    @Override
    public void buildBase() {
        System.out.println("Common House base is 5m");
    }

    @Override
    public void buildWall() {
        System.out.println("Common House wall width is 10cm");
    }

    @Override
    public void buildRoof() {
        System.out.println("Common House roof");
    }
}

class HighHouse extends HouseBuilder{
    @Override
    public void buildBase() {
        System.out.println("Common House base is 100m");
    }

    @Override
    public void buildWall() {
        System.out.println("Common House walls height is 50m");
    }

    @Override
    public void buildRoof() {
        System.out.println("Transparent roof of a tall building");
    }
}

class HouseDirector{
    private HouseBuilder houseBuilder = null;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse(){
        houseBuilder.buildBase();
        houseBuilder.buildWall();
        houseBuilder.buildRoof();
        return houseBuilder.buildHouse();
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        House house = houseDirector.constructHouse();
    }
}
