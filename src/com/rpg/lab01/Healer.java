package com.rpg.lab01;

public class Healer extends Character{
    private int baseHeal;

    public Healer(String name, int level, int hp, Weapon weapon, int baseHeal, String role) {
        super(name, level, hp, weapon,role);
        this.baseHeal = baseHeal;
    }


    @Override
    public void displayCharacterDetails(){
        System.out.println("--- "+name+" ---");
        System.out.println(" Class: "+ role );
        System.out.println(" Level: "+ level);
        System.out.println(" Health Points: "+hp+"/"+maxHp);
        System.out.println(" Weapon: "+weapon.toString());
        System.out.println(" Healing Power: "+(baseHeal + (level * 3)));
        System.out.println();
    }

    public void heal(){
        System.out.println(name+" ("+role+") casts a healing spell!");
        int heal = baseHeal + (level * 3);
        System.out.println("⭐ Healing Amount: "+heal+" (Base: "+baseHeal+" + Level Bonus: "+(level*3)+")");
        if (maxHp <= (heal + hp)){
            setHp(maxHp);
        } else {
            setHp(heal+hp);
        }
        System.out.println("\uD83D\uDC9A Restored "+heal+" HP! Current HP: "+hp+"/"+maxHp);
    }

    public void healAlly(Character ally){
        System.out.println(name+" ("+role+") casts a healing spell on "+ ally.name+"!");
        int heal = baseHeal + (level * 3);
        System.out.println("⭐ Healing Amount: "+heal+" (Base: "+baseHeal+" + Level Bonus: "+(level*3)+")");
        if (ally.maxHp <= (heal + ally.hp)){
            ally.setHp(ally.maxHp);
        } else {
            ally.setHp(heal+ally.hp);
        }
        System.out.println("\uD83D\uDC9A Restored "+heal+" HP to "+ally.name+"! Their HP: "+ally.hp+"/"+ally.maxHp);
    }
}
