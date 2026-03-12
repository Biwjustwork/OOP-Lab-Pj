package com.rpg.lab06;

public class Archer extends Character {
    private final boolean hasRangeAdvantage;
    private double accuracy;
    public Archer(String name, int level, int hp, int damage, int defense, double accuracy, Weapon weapon) {
        super(name, level, hp, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
        this.hasRangeAdvantage = true;
        setAttack(new ArcherStyleDecorator(getAttack()));
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public void displayCharacterDetails(){
        System.out.println("--- "+name+" ---");
        System.out.println(" Class: "+ role);
        System.out.println(" Level: "+ level);
        System.out.println(" Health Points: "+hp+"/"+maxHp);
        System.out.println(" Accuracy: "+ accuracy+"%");
        System.out.println(" Damage: "+damage);
        System.out.println(" Defense: "+defense);
        System.out.println(" Weapon: "+weapon.toString());
        System.out.println();
    }



    public boolean hasRangeAdvantage() {
        return hasRangeAdvantage;
    }
}
