package com.gronglegrowth.vestis.mixin;

import com.gronglegrowth.vestis.VestisModifySpiritColor;
import com.sammy.malum.client.renderer.entity.scythe.ScytheBoomerangEntityRenderer;
import com.sammy.malum.common.entity.scythe.ScytheBoomerangEntity;
import com.sammy.malum.core.systems.spirit.type.SpiritLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(
		value = ScytheBoomerangEntityRenderer.class,
		remap = false
)
public class ScytheBoomerangRendererMixin
{
	@ModifyVariable(
			method = "render(Lcom/sammy/malum/common/entity/scythe/ScytheBoomerangEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
			at = @At("STORE"),
			name = "spirit"
	)
	private SpiritLike modifySpiritType(
			SpiritLike value,
			ScytheBoomerangEntity entityIn
	)
	{
		var itemStack = entityIn.getItem();
		return VestisModifySpiritColor.modify(value, itemStack);
	}
}
