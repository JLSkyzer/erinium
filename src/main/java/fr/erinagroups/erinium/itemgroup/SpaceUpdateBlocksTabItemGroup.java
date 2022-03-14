
package fr.erinagroups.erinium.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import fr.erinagroups.erinium.block.SiliconeOreBlock;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class SpaceUpdateBlocksTabItemGroup extends EriniumModElements.ModElement {
	public SpaceUpdateBlocksTabItemGroup(EriniumModElements instance) {
		super(instance, 109);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabspace_update_blocks_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SiliconeOreBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
