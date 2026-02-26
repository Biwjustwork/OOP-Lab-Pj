package com.rpg.lab04;

public class Character implements Destructible{
    protected String name;
    protected int level;
    protected int hp;
    protected int maxHp;
    protected int damage;
    protected int defense;
    protected Weapon weapon;
    protected String role;

    public Character(String name, int level, int hp, int damage, int defense, Weapon weapon, String role) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp;
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.role = role;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void displayCharacterDetails(){
        System.out.println("--- "+name+" ---");
        System.out.println(" Class: "+ role);
        System.out.println(" Level: "+ level);
        System.out.println(" Health Points: "+hp+"/"+maxHp);
        System.out.println(" Damage: "+damage);
        System.out.println(" Defense: "+defense);
        System.out.println(" Weapon: "+weapon.toString());
        System.out.println();
    }

    public void attack(Destructible target){
        if (!isAlive()){
            System.out.println("cannot attack because they dead");
            return;
        }
        int rawDamage = weapon.getDmg() +damage+ (level * 2);
        if (target instanceof Character){
            Character character = (Character) target;
            System.out.println(name+" ("+role+") attacks "+character.getName()+" with "+weapon.getName());
        }
        System.out.println(" ⚔\uFE0F Raw Attack Damage: "+rawDamage);
        target.takeDamage(rawDamage);

    }

    @Override
    public void takeDamage(int amount){
        System.out.println(" \uD83D\uDEE1\uFE0F "+name+"'s Defense: "+defense+" (reduces damage by "+defense+")");
        int totalDamage = amount - defense;
        if ((hp - totalDamage) >= 0) {
            setHp(hp-totalDamage);
        } else {
            setHp(0);
        }

        System.out.println(" \uD83D\uDCA5 Actual Damage Taken: "+totalDamage);
        System.out.println(" ❤\uFE0F "+name+" takes "+totalDamage+" damage! Current HP: "+(hp)+"/"+maxHp);
    }

    public void levelUp(){
        this.level = getLevel() + 1;
        this.maxHp = getMaxHp() + 10;
        this.hp = getMaxHp();
        System.out.println("Arthur leveled up to Level "+level);
        System.out.println("⏫ Max Health increased to "+maxHp+" (full heal applied)");
    }
    public boolean isAlive(){
        return hp > 0;
    }

    @Override
    public boolean isDestroyed() {
        return !isAlive();
    }
}
