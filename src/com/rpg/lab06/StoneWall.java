package com.rpg.lab06;

public class StoneWall implements Destructible {
    private String name;
    private int durability;
    private int maxDurability;
    private String type;
    private String status;

    public StoneWall(String name, int durability, String type) {
        this.name = name;
        this.durability = durability;
        this.maxDurability = durability;
        this.type = type;
        this.status = "standing";
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayWallDetails(){
        System.out.println("--- "+name+" ---");
        System.out.println("Type: "+ type);
        System.out.println("Status: "+ status);
        System.out.println("Durability: "+durability+"/"+maxDurability);
        System.out.println();
    }

    @Override
    public void takeDamage(int amount) {
        if (isDestroyed()) {
            return;
        }

        if ((durability - amount) >= 0) {
            setDurability(durability- amount);
        } else {
            setDurability(0);
            System.out.println("\uD83E\uDDF1 "+name+" takes "+amount+" damage! (Durability: "+durability+"/"+maxDurability+")");
            System.out.println("\uD83D\uDCA5 "+name+" has CRUMBLED to pieces!");
            setStatus("Destroyed");
            return;
        }
        System.out.println("\uD83E\uDDF1 "+name+" takes "+amount+" damage! (Durability: "+durability+"/"+maxDurability+")");
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
