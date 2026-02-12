package com.rpg.lab02;

public class Healer extends Character {
    private int baseHeal;

    public Healer(String name, int level, int hp,int damage, int defense, Weapon weapon, int baseHeal) {
        super(name, level, hp, damage,defense, weapon,"Healer");
        this.baseHeal = baseHeal;
    }


    @Override
    public void displayCharacterDetails(){
        System.out.println("--- "+name+" ---");
        System.out.println(" Class: "+ role );
        System.out.println(" Level: "+ level);
        System.out.println(" Health Points: "+hp+"/"+maxHp);
        System.out.println(" Damage:"+damage);
        System.out.println(" Defense"+defense);
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
