package com.rpg.lab04;

public class Warrior extends Character {
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
    public void attack(Destructible target){
        if (!isAlive()){
            System.out.println("cannot attack because they dead");
            return;
        }

        int rawDamage = (weapon.getDmg() + (level * 2));
        if (target instanceof Character){
            Character character = (Character) target;
            System.out.println("\uD83D\uDDE1 "+name+" ("+role+") attacks "+character.getName()+" with "+weapon.getName());
        }else {
            System.out.println("\uD83D\uDDE1 "+name+" ("+role+") performs a POWERFUL STRIKE on Target!");
        }
        int powDamage = (int)(rawDamage * 1.5);
        System.out.println(" ⚔\uFE0F Raw Attack Damage: "+rawDamage+" -> Enhanced: "+powDamage+" (1.5x multiplier)");

        target.takeDamage(powDamage);

    }

    @Override
    public void takeDamage(int amount){
        System.out.println(" \uD83D\uDEE1\uFE0F "+name+"'s Armor Value: "+armorValue+" (reduces damage by "+armorValue+")");
        int Damage = amount - armorValue;
        super.takeDamage(Damage);
    }
}
