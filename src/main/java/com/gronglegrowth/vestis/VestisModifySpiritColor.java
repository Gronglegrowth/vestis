package com.gronglegrowth.vestis;

import com.sammy.malum.core.systems.spirit.type.SpiritLike;
import com.sammy.malum.registry.common.magic.MalumSpiritTypes;
import net.minecraft.world.item.ItemStack;
import tech.thatgravyboat.vanity.api.design.DesignManager;

public class VestisModifySpiritColor
{
	public static SpiritLike modify(
			SpiritLike current,
			ItemStack itemStack
	)
	{
		var style = DesignManager.client().getStyleFromItem(itemStack);
		if(style != null && style.hasAsset(VestisAssetTypes.MALUM_SPIRIT))
		{
			var assetId = style.asset(VestisAssetTypes.MALUM_SPIRIT);
			if(MalumSpiritTypes.SPIRIT_TYPES_REGISTRY.containsKey(assetId))
			{
				return MalumSpiritTypes.SPIRIT_TYPES_REGISTRY.get(assetId);
			}
		}
		return current;
	}
}
