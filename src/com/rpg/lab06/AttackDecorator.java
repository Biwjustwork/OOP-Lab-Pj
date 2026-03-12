package com.rpg.lab06;

public abstract class AttackDecorator implements Attack{

    protected final Attack wrappedAttack;

    @Override
    public void attack(Character attacker, Destructible target) {
    }

    protected AttackDecorator(Attack wrappedAttack) {
        if (wrappedAttack == null) {
            throw new IllegalArgumentException("Wrapped attack cannot be null.");
        }
        this.wrappedAttack = wrappedAttack;
    }
}
