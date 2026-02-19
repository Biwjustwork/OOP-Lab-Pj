package com.rpg.lab03;

public class Warrior extends Character{
    private int armorValue;
    public Warrior(String name, int level, int hp, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, hp, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
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
    public void attack(Character target){
        if (!isAlive()){
            System.out.println("cannot attack because they dead");
            return;
        }
        int rawDamage = (int) (weapon.getDmg() +(damage * 1.5)+ (level * 2));
        System.out.println(name+" ("+role+") attacks "+target.getName()+" with "+weapon.getName());
        System.out.println(" ⚔\uFE0F Raw Attack Damage: "+rawDamage);
        target.receiveDamage(rawDamage);

    }

    @Override
    public void receiveDamage(int damage){
        System.out.println(" \uD83D\uDEE1\uFE0F "+name+"'s Armor Value: "+armorValue+" (reduces damage by "+armorValue+")");
        int Damage = damage - armorValue;
        super.receiveDamage(Damage);
    }
}
