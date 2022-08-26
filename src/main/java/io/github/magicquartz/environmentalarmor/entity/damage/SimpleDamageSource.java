package io.github.magicquartz.environmentalarmor.entity.damage;

import net.minecraft.entity.damage.DamageSource;

public class SimpleDamageSource extends DamageSource {
    public static final SimpleDamageSource NATURAL_CAUSES = new SimpleDamageSource("natual_causes")
        .setBypassesArmor().setBypassesProtection().setUnblockable();
    
    public SimpleDamageSource(String name) {
        super(name);
    }
    
    protected SimpleDamageSource setBypassesArmor() {
        super.setBypassesArmor();
        return this;
    }
    
    protected SimpleDamageSource setFallingBlock() {
        super.setFallingBlock();
        return this;
    }
    
    protected SimpleDamageSource setOutOfWorld() {
        super.setOutOfWorld();
        return this;
    }
    
    protected SimpleDamageSource setUnblockable() {
        super.setUnblockable();
        return this;
    }
    
    protected SimpleDamageSource setBypassesProtection() {
        super.setBypassesProtection();
        return this;
    }
    
    protected SimpleDamageSource setFire() {
        super.setFire();
        return this;
    }
    
    public SimpleDamageSource setNeutral() {
        super.setNeutral();
        return this;
    }
    
    public SimpleDamageSource setScaledWithDifficulty() {
        super.setScaledWithDifficulty();
        return this;
    }
    
    public SimpleDamageSource setUsesMagic() {
        super.setUsesMagic();
        return this;
    }
    
    public SimpleDamageSource setFromFalling() {
        super.setFromFalling();
        return this;
    }
    
}
