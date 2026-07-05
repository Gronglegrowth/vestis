package com.gronglegrowth.vestis.mixin;

import com.gronglegrowth.vestis.VestisModifySpiritColor;
import com.sammy.malum.common.entity.scythe.AbstractScytheProjectileEntity;
import com.sammy.malum.core.systems.spirit.type.SpiritLike;
import com.sammy.malum.visual_effects.WeaponParticleEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(
		value = WeaponParticleEffects.class,
		remap = false
)
public class WeaponParticleEffectsMixin
{
	@ModifyVariable(
			method = "spawnMaelstromParticles",
			at = @At("STORE"),
			name = "spirit"
	)
	private static SpiritLike modifySpiritType(
			SpiritLike value,
			AbstractScytheProjectileEntity entity
	)
	{
		var itemStack = entity.getItem();
		return VestisModifySpiritColor.modify(value, itemStack);
	}
}
