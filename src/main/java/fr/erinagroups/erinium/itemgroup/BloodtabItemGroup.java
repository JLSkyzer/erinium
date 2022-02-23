
package fr.erinagroups.erinium.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import fr.erinagroups.erinium.item.BloodLargeBottleItem;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class BloodtabItemGroup extends EriniumModElements.ModElement {
	public BloodtabItemGroup(EriniumModElements instance) {
		super(instance, 80);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbloodtab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BloodLargeBottleItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
