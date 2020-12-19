
package net.mcreator.superiorarmor.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.superiorarmor.item.ObsidionArmorItem;
import net.mcreator.superiorarmor.SuperiorarmorModElements;

@SuperiorarmorModElements.ModElement.Tag
public class SuperiorArmorItemGroup extends SuperiorarmorModElements.ModElement {
	public SuperiorArmorItemGroup(SuperiorarmorModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsuperior_armor") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ObsidionArmorItem.body, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
