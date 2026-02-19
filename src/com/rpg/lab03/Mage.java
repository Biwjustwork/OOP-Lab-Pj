package com.rpg.lab03;

public class Mage extends Character{
    private int mana;
    private int maxMana;

    public Mage(String name, int level, int hp, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, hp, damage, defense, weapon, "Mage");
        this.mana = mana;
        this.maxMana = mana;
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

    @Override
    public void attack(Character target){
        if (!isAlive()){
            System.out.println("cannot attack because they dead");
            return;
        }
        if (mana - 30 > 0){
            this.mana = mana - 30;

        } else {
            System.out.println(name+" ("+role+") has not enough mana for the magic missile.");
            return;
        }
        int rawDamage = (int) (weapon.getDmg() +damage+ (level * 2));
        System.out.println(name+" ("+role+") use \"Magic Missile\" spell to attacks "+target.getName()+" with "+weapon.getName());
        System.out.println(" ⚔\uFE0F Raw Attack Damage: "+rawDamage);
        target.receiveDamage(rawDamage);

    }
}
