package com.rpg.lab04;

public class Archer extends Character {
    private double accuracy;
    public Archer(String name, int level, int hp, int damage, int defense, double accuracy, Weapon weapon) {
        super(name, level, hp, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
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

    @Override
    public void attack(Destructible target){
        if (!isAlive()){
            System.out.println("cannot attack because they dead");
            return;
        }
        boolean hitSuccessful = (Math.random()*100) < accuracy;

        if (!hitSuccessful){
            System.out.println(" Accuracy: Missed");
            if (target instanceof Character){
                Character character = (Character) target;
                System.out.println(name+" ("+role+") attack missed "+character.getName());
            }else {
                System.out.println(name+"("+role+") attack missed target");
            }

            return;
        }

        int rawDamage = weapon.getDmg() +damage+ (level * 2);
        if (target instanceof Character){
            Character character = (Character) target;
            System.out.println("\uD83C\uDFF9 "+name+" ("+role+") attacks "+character.getName()+" with "+weapon.getName());
        }else {
            System.out.println("\uD83C\uDFF9 "+name+" ("+role+") shoots a precise arrow at Target! ");
        }
        System.out.println(" ⚔\uFE0F Raw Attack Damage: "+rawDamage);
        System.out.println(" Accuracy: Hit");
        target.takeDamage(rawDamage);
    }
}
