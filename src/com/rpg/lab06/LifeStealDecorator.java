package com.rpg.lab06;

public class LifeStealDecorator extends AttackDecorator{
    private final double ratio;
    public LifeStealDecorator(Attack wrappedAttack, double ratio) {
        super(wrappedAttack);
        if (ratio < 0 || ratio > 1) {
            throw new IllegalArgumentException("Life steal ratio must be between 0 and 1.");
        }
        this.ratio = ratio;
    }
    @Override
    public void attack(Character attacker, Destructible target) {
        int hpBefore = attacker.getHp();
        wrappedAttack.attack(attacker, target);
        if (!attacker.isAlive()) {
            return;
        }
        int healBase = attacker.getDamage() + attacker.getWeapon().getDmg();
        int healAmount = Math.max(1, (int) Math.round(healBase * ratio));
        int missing = attacker.getMaxHp() - attacker.getHp();
        if (missing <= 0) {
            return;
        }
        int restored = Math.min(healAmount, missing);
        attacker.setHp(attacker.getHp() + restored);
        System.out.println(" [Decorator] Life Steal restored " + restored + " HP to " + attacker.getName() + " (" + hpBefore + " -> " + attacker.getHp() + ")");
    }
}
