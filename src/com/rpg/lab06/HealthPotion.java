package com.rpg.lab06;

public class HealthPotion implements Consumable {
    private String name;
    private int heal;
    private int amount;
    private String type;

    public HealthPotion(String name, int heal, int amount) {
        this.name = name;
        this.heal = heal;
        this.amount = amount;
        this.type = "Consumable";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void displayPotionDetails(){
        System.out.println("--- "+this.name+" ---");
        System.out.println(" Healing Power: "+ this.heal);
        System.out.println(" Quantity: "+amount);
        System.out.println(" Type: "+this.type);
    }


    @Override
    public void use(Character user) {

        if (user == null){
            System.out.println("Error Character Not Found");
            return;
        }
        if (amount <= 0){
            System.out.println(name+" is out of stock");
            return;
        }
        if (user.isDestroyed()){
            System.out.println(user.getName()+" can't use "+name+" because "+user.getName()+" is dead.");
            return;
        }

        int preHp = user.getHp();
        int newHp = Math.min(user.getMaxHp(), preHp + heal);
        user.setHp(newHp);
        amount--;

        System.out.println("    \uD83E\uDDEA "+user.getName()+" drinks "+name+" !");
        System.out.println("    \uD83D\uDC9A HP restored: "+preHp+" -> "+newHp);
        System.out.println("    \uD83D\uDCCA "+name+" remaining: "+amount);
        System.out.println();
    }
}
