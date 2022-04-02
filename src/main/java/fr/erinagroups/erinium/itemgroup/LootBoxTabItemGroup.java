
package fr.erinagroups.erinium.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import fr.erinagroups.erinium.block.ClassicLootboxBlock;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class LootBoxTabItemGroup extends EriniumModElements.ModElement {
	public LootBoxTabItemGroup(EriniumModElements instance) {
		super(instance, 213);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabloot_box_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ClassicLootboxBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
