package com.rpg.lab01;

public class Weapon {
    private String name;
    private String type;
    private int dmg;
    private String skill;

    public Weapon(String name, String type, int dmg, String skill) {
        this.name = name;
        this.type = type;
        this.dmg = dmg;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString(){
        return name + " (Type: "+type+" ,Damage: "+dmg+", Ability: "+skill+")";
    }
}
