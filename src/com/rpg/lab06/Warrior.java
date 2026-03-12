package com.rpg.lab06;

public class Warrior extends Character {
    private int armorValue;
    public Warrior(String name, int level, int hp, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, hp, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
        setAttack(new WarriorStyleDecorator(getAttack()));
    }

    public int getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(int armorValue) {
        this.armorValue = armorValue;
    }

    @Override
    public void displayCharacterDetails(){
        System.out.println("--- "+name+" ---");
        System.out.println(" Class: "+ role);
        System.out.println(" Level: "+ level);
        System.out.println(" Health Points: "+hp+"/"+maxHp);
        System.out.println(" Damage: "+damage);
        System.out.println(" Defense: "+defense);
        System.out.println(" Armor Value: "+armorValue);
        System.out.println(" Weapon: "+weapon.toString());
        System.out.println();
    }


    @Override
    public void takeDamage(int amount){
        System.out.println(" \uD83D\uDEE1\uFE0F "+name+"'s Armor Value: "+armorValue+" (reduces damage by "+armorValue+")");
        int Damage = amount - armorValue;
        super.takeDamage(Damage);
    }
}
