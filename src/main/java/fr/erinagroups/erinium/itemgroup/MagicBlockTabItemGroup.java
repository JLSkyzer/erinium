
package fr.erinagroups.erinium.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import fr.erinagroups.erinium.block.MagicBlockLavaBlock;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class MagicBlockTabItemGroup extends EriniumModElements.ModElement {
	public MagicBlockTabItemGroup(EriniumModElements instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmagic_block_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MagicBlockLavaBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
