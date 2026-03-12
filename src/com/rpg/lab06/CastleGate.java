package com.rpg.lab06;

public class CastleGate implements Destructible {
    private String name;
    private int durability;
    private int maxDurability;
    private String status;
    private boolean isLock;
    private boolean isReinforce;

    public CastleGate(String name, int durability, boolean isLock, boolean isReinforce) {
        this.name = name;
        this.durability = durability;
        this.maxDurability = durability;
        this.isLock = isLock;
        this.isReinforce = isReinforce;
        this.status = "Intact";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public void setMaxDurability(int maxDurability) {
        this.maxDurability = maxDurability;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public boolean isReinforce() {
        return isReinforce;
    }

    public void setReinforce(boolean reinforce) {
        isReinforce = reinforce;
    }

    public void displayGateDetails(){
        System.out.println("--- "+name+" ---");
        System.out.println("Status: "+ status);
        System.out.println("Durability: "+durability+"/"+maxDurability);
        if (isLock){
            System.out.println("Locked: Yes");
        }else {
            System.out.println("Locked: No");
        }
        if (isReinforce){
            System.out.println("Reinforced: Yes");
        }else {
            System.out.println("Reinforced: No");
        }
        System.out.println();
    }

    @Override
    public void takeDamage(int amount) {
        if(isDestroyed()) {
            System.out.println(name + " is already destroyed.");
            return;
        }
        int finalDamage = amount;
        if (isReinforce) {
            finalDamage = amount / 2;
            System.out.println(" 🛡️ "+name+" is REINFORCED! (reduces damage from "+amount+" to "+finalDamage+")");
        }
        if ((durability - finalDamage ) >= 0) {
            setDurability(durability- finalDamage);
        } else {
            setDurability(0);
            System.out.println("\uD83C\uDFF0 "+name+" takes "+finalDamage+" damage! (Durability: "+durability+"/"+maxDurability+")");
            System.out.println("\uD83D\uDCA5 "+name+" has been BREACHED! The gate COLLAPSES!");
            setStatus("Breached");
            return;
        }
        System.out.println("\uD83C\uDFF0 "+name+" takes "+finalDamage+" damage! (Durability: "+durability+"/"+maxDurability+")");
    }

    @Override
    public boolean isDestroyed() {
        if (durability <= 0){
            return true;
        } else {
            return false;
        }
    }
}
