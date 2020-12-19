
package net.mcreator.superiorarmor.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.superiorarmor.SuperiorarmorModElements;

@SuperiorarmorModElements.ModElement.Tag
public class ObsidionArmorItem extends SuperiorarmorModElements.ModElement {
	@ObjectHolder("superiorarmor:obsidion_armor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("superiorarmor:obsidion_armor_chestplate")
	public static final Item body = null;
	@ObjectHolder("superiorarmor:obsidion_armor_leggings")
	public static final Item legs = null;
	@ObjectHolder("superiorarmor:obsidion_armor_boots")
	public static final Item boots = null;
	public ObsidionArmorItem(SuperiorarmorModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 32;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{7, 10, 11, 7}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 20;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.horse.armor"));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.OBSIDIAN, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "obsidion_armor";
			}

			public float getToughness() {
				return 2.3000000000000003f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "superiorarmor:textures/models/armor/obsidion__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("obsidion_armor_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "superiorarmor:textures/models/armor/obsidion__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("obsidion_armor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "superiorarmor:textures/models/armor/obsidion__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("obsidion_armor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "superiorarmor:textures/models/armor/obsidion__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("obsidion_armor_boots"));
	}
}
