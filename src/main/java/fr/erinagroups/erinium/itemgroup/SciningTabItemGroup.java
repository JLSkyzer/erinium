
package fr.erinagroups.erinium.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import fr.erinagroups.erinium.block.SciningSandBlock;
import fr.erinagroups.erinium.EriniumModElements;

@EriniumModElements.ModElement.Tag
public class SciningTabItemGroup extends EriniumModElements.ModElement {
	public SciningTabItemGroup(EriniumModElements instance) {
		super(instance, 69);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabscining_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SciningSandBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
