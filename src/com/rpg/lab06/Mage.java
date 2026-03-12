package com.rpg.lab06;

public class Mage extends Character {
    private int mana;
    private int maxMana;

    public Mage(String name, int level, int hp, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, hp, damage, defense, weapon, "Mage");
        this.mana = mana;
        this.maxMana = mana;
        setAttack(new MageStyleDecorator(getAttack()));
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    @Override
    public void displayCharacterDetails(){
        System.out.println("--- "+name+" ---");
        System.out.println(" Class: "+ role);
        System.out.println(" Level: "+ level);
        System.out.println(" Health Points: "+hp+"/"+maxHp);
        System.out.println(" Mana: "+ mana+"/"+maxMana);
        System.out.println(" Damage: "+damage);
        System.out.println(" Defense: "+defense);
        System.out.println(" Weapon: "+weapon.toString());
        System.out.println();
    }

}
