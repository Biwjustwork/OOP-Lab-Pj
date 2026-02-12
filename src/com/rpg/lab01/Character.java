package com.rpg.lab01;

public class Character {
    protected String name;
    protected int level;
    protected int hp;
    protected int maxHp;
    protected Weapon weapon;
    protected String role;

    public Character(String name, int level, int hp, Weapon weapon, String role) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp;
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

    public void displayCharacterDetails(){
        System.out.println("--- "+name+" ---");
        System.out.println(" Class: "+ role);
        System.out.println(" Level: "+ level);
        System.out.println(" Health Points: "+hp+"/"+maxHp);
        System.out.println(" Weapon: "+weapon.toString());
        System.out.println();
    }

    public int attack(){
        int damage = weapon.getDmg() + (level * 2);
        System.out.println(name+" ("+role+") attacks with "+weapon.getName());
        System.out.println( "⚔ Attack Damage: "+damage+" (Weapon Base: "+weapon.getDmg()+" + Level Bonus: "+(level * 2)+")");
        return damage;
    }

    public void takeDamage(int damage){
        if (hp <= 0){
            setHp(0);
        } else {
            setHp(hp-damage);
        }
        System.out.println(name+" takes "+damage+" damage! Current HP: "+(hp-damage)+"/"+maxHp);
    }

    public void levelUp(){
        this.level = getLevel() + 1;
        this.maxHp = getMaxHp() + 10;
        this.hp = getMaxHp();
        System.out.println("Arthur leveled up to Level "+level);
        System.out.println("⏫ Max Health increased to "+maxHp+" (full heal applied)");
    }
}
