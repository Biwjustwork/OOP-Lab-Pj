package com.rpg.lab06;

public class WoodenBox implements Destructible {
    private String name;
    private int hp;
    private int maxHp;
    private boolean isLock;
    private String reward;
    private String status;

    public WoodenBox(String name, int hp, boolean isLock, String reward) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.isLock = isLock;
        this.reward = reward;
        this.status = "Intact";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayBoxDetails(){
        System.out.println("--- "+this.name+" (WOODEN BOX) ---");
        System.out.println(" Status: "+ this.status);
        System.out.println(" Health: "+this.hp+"/"+this.maxHp);
        if (this.isLock){
            System.out.println(" Locked: Yes \uD83D\uDD12");
        } else {
            System.out.println(" Locked: No \uD83D\uDD13");
        }
        System.out.println(" Contains: "+this.reward);

    }

    public void breakOpen(){
        if (!status.equalsIgnoreCase("Intact")){
            System.out.println(" \uD83D\uDD13 The lock broke! "+this.name+" breaks open!");
            System.out.println(" \uD83C\uDF81 Contents revealed: "+ this.reward);
        } else {
            System.out.println(" ⚠\uFE0F Cannot break open "+this.name+" - it's still intact!");
        }
    }

    @Override
    public void takeDamage(int amount) {
        if (isDestroyed()) {
            return;
        }
        if ((hp - amount) >= 0) {
            setHp(hp- amount);
        } else {
            setHp(0);
            System.out.println(" \uD83D\uDCA5 "+name+" takes "+amount+" damage!");
            System.out.println(" \uD83D\uDCE6 "+name+" HP: "+hp+"/"+maxHp+" (DESTROYED!)");
            setStatus("Destroyed");
            return;
        }
        System.out.println(" \uD83D\uDCA5 "+name+" takes "+amount+" damage!");
        System.out.println(" \uD83D\uDCE6 "+name+" HP: "+hp+"/"+maxHp);
    }

    @Override
    public boolean isDestroyed() {
        if (hp <= 0){
            return true;
        } else {
            return false;
        }

    }
}
