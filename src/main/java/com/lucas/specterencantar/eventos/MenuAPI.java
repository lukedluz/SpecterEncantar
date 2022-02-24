package com.lucas.specterencantar.eventos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.lucas.specterencantar.Main;

public class MenuAPI implements Listener {

	public static void OpenSword(Player s, ItemStack Item) {

		final Inventory guisword = Bukkit.createInventory(null, 27, "§eEncantamentos - Espadas");

		ItemStack sharpness = Heads.Sharpness;
		SkullMeta sharpnessmeta = (SkullMeta) sharpness.getItemMeta();
		sharpnessmeta.setDisplayName("§aSharpness");
		List<String> loresharpness = new ArrayList<String>();
		loresharpness.add("");
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DAMAGE_ALL)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DAMAGE_ALL) + 1;
			Integer max = Main.m.getConfig().getInt("Sharpness.Limite");
			if (i > max) {
				loresharpness.add("§aN§vel: §cN§vel m§ximo atingido");
			} else {
				loresharpness.add("§aN§vel: " + i.toString());
			}
		} else {
			loresharpness.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DAMAGE_ALL)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DAMAGE_ALL) + 1;
			Integer max = Main.m.getConfig().getInt("Sharpness.Limite");
			if (i > max) {
				loresharpness.add("§aPre§o: §cN§vel m§ximo atingido");
			} else {
				loresharpness.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Sharpness.Preco") * i));
			}
		} else {
			loresharpness.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Sharpness.Preco")));
		}
		sharpnessmeta.setLore(loresharpness);
		sharpness.setItemMeta(sharpnessmeta);

		ItemStack Unbreaking = Heads.Unbreaking;
		SkullMeta Unbreakingmeta = (SkullMeta) Unbreaking.getItemMeta();
		Unbreakingmeta.setDisplayName("§aUnbreaking");
		List<String> loreUnbreaking = new ArrayList<String>();
		loreUnbreaking.add("");
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DURABILITY)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DURABILITY) + 1;
			Integer max = Main.m.getConfig().getInt("Unbreaking.Limite");
			if (i > max) {
				loreUnbreaking.add("§aN§vel: §cN§vel m§ximo atingido");
			} else {
				loreUnbreaking.add("§aN§vel: " + i.toString());
			}
		} else {
			loreUnbreaking.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DURABILITY)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DURABILITY) + 1;
			Integer max = Main.m.getConfig().getInt("Unbreaking.Limite");
			if (i > max) {
				loreUnbreaking.add("§aPre§o: §cN§vel m§ximo atingido");
			} else {
				loreUnbreaking.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Unbreaking.Preco") * i));
			}
		} else {
			loreUnbreaking.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Unbreaking.Preco")));
		}
		Unbreakingmeta.setLore(loreUnbreaking);
		Unbreaking.setItemMeta(Unbreakingmeta);

		ItemStack FireAspect = Heads.Fireaspect;
		SkullMeta FireAspectmeta = (SkullMeta) FireAspect.getItemMeta();
		FireAspectmeta.setDisplayName("§aFire Aspect");
		List<String> loreFireAspect = new ArrayList<String>();
		loreFireAspect.add("");
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.FIRE_ASPECT)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.FIRE_ASPECT) + 1;
			Integer max = Main.m.getConfig().getInt("Fireaspect.Limite");
			if (i > max) {
				loreFireAspect.add("§aN§vel: §cN§vel m§ximo atingido");
			} else {
				loreFireAspect.add("§aN§vel: " + i.toString());
			}
		} else {
			loreFireAspect.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.FIRE_ASPECT)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.FIRE_ASPECT) + 1;
			Integer max = Main.m.getConfig().getInt("Fireaspect.Limite");
			if (i > max) {
				loreFireAspect.add("§aPre§o: §cN§vel m§ximo atingido");
			} else {
				loreFireAspect.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("FireAspect.Preco") * i));
			}
		} else {
			loreFireAspect.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("FireAspect.Preco")));
		}
		FireAspectmeta.setLore(loreFireAspect);
		FireAspect.setItemMeta(FireAspectmeta);

		guisword.setItem(11, sharpness);
		guisword.setItem(13, Unbreaking);
		guisword.setItem(15, FireAspect);

		s.openInventory(guisword);
	}

	public static void OpenFerramentas(Player s, ItemStack Item) {

		final Inventory guisword = Bukkit.createInventory(null, 27, "§eEncantamentos - Ferramentas");

		ItemStack Eficiencia = Heads.Eficiencia;
		SkullMeta Eficienciameta = (SkullMeta) Eficiencia.getItemMeta();
		Eficienciameta.setDisplayName("§aEficiencia");
		List<String> loreEficiencia = new ArrayList<String>();
		loreEficiencia.add("");
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DIG_SPEED)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DIG_SPEED) + 1;
			Integer max = Main.m.getConfig().getInt("Eficiencia.Limite");
			if (i > max) {
				loreEficiencia.add("§aN§vel: §cN§vel m§ximo atingido");
			} else {
				loreEficiencia.add("§aN§vel: " + i.toString());
			}
		} else {
			loreEficiencia.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DIG_SPEED)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DIG_SPEED) + 1;
			Integer max = Main.m.getConfig().getInt("Eficiencia.Limite");
			if (i > max) {
				loreEficiencia.add("§aPre§o: §cN§vel m§ximo atingido");
			} else {
				loreEficiencia.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Eficiencia.Preco") * i));
			}
		} else {
			loreEficiencia.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Eficiencia.Preco")));
		}
		Eficienciameta.setLore(loreEficiencia);
		Eficiencia.setItemMeta(Eficienciameta);

		ItemStack Unbreaking = Heads.Unbreaking;
		SkullMeta Unbreakingmeta = (SkullMeta) Unbreaking.getItemMeta();
		Unbreakingmeta.setDisplayName("§aUnbreaking");
		List<String> loreUnbreaking = new ArrayList<String>();
		loreUnbreaking.add("");
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DURABILITY)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DURABILITY) + 1;
			Integer max = Main.m.getConfig().getInt("Unbreaking.Limite");
			if (i > max) {
				loreUnbreaking.add("§aN§vel: §cN§vel m§ximo atingido");
			} else {
				loreUnbreaking.add("§aN§vel: " + i.toString());
			}
		} else {
			loreUnbreaking.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DURABILITY)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DURABILITY) + 1;
			Integer max = Main.m.getConfig().getInt("Unbreaking.Limite");
			if (i > max) {
				loreUnbreaking.add("§aPre§o: §cN§vel m§ximo atingido");
			} else {
				loreUnbreaking.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Unbreaking.Preco") * i));
			}
		} else {
			loreUnbreaking.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Unbreaking.Preco")));
		}
		Unbreakingmeta.setLore(loreUnbreaking);
		Unbreaking.setItemMeta(Unbreakingmeta);

		ItemStack Looting = Heads.Looting;
		SkullMeta Lootingmeta = (SkullMeta) Looting.getItemMeta();
		Lootingmeta.setDisplayName("§aFortuna");
		List<String> loreLooting = new ArrayList<String>();
		loreLooting.add("");
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 1;
			Integer max = Main.m.getConfig().getInt("Looting.Limite");
			if (i > max) {
				loreLooting.add("§aN§vel: §cN§vel m§ximo atingido");
			} else {
				loreLooting.add("§aN§vel: " + i.toString());
			}
		} else {
			loreLooting.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 1;
			Integer max = Main.m.getConfig().getInt("Looting.Limite");
			if (i > max) {
				loreLooting.add("§aPre§o: §cN§vel m§ximo atingido");
			} else {
				loreLooting.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Looting.Preco") * i));
			}
		} else {
			loreLooting.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Looting.Preco")));
		}
		Lootingmeta.setLore(loreLooting);
		Looting.setItemMeta(Lootingmeta);
		
		ItemStack Explosivo = Heads.Explosivo;
		SkullMeta Explosivometa = (SkullMeta) Explosivo.getItemMeta();
		Explosivometa.setDisplayName("§aExplosivo");
		List<String> loreExplosivo = new ArrayList<String>();
		loreExplosivo.add("");
		if (Item.hasItemMeta() && Item.getItemMeta().hasLore() && Item.getItemMeta().getLore().contains("§7Explosivo")) {
			loreExplosivo.add("§aN§vel: §cN§vel m§ximo atingido");
		} else {
			loreExplosivo.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.getItemMeta().hasLore() && Item.getItemMeta().getLore().contains("§7Explosivo")) {
			loreExplosivo.add("§aPre§o: §cN§vel m§ximo atingido");
		} else {
			loreExplosivo.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Explosivo.Preco")));
		}
		Explosivometa.setLore(loreExplosivo);
		Explosivo.setItemMeta(Explosivometa);

		guisword.setItem(10, Eficiencia);
		guisword.setItem(12, Unbreaking);
		guisword.setItem(14, Looting);
		guisword.setItem(16, Explosivo);

		s.openInventory(guisword);
	}
	
	public static void OpenFerramentas2(Player s, ItemStack Item) {

		final Inventory guisword = Bukkit.createInventory(null, 27, "§eEncantamentos - Ferramentas");

		ItemStack Eficiencia = Heads.Eficiencia;
		SkullMeta Eficienciameta = (SkullMeta) Eficiencia.getItemMeta();
		Eficienciameta.setDisplayName("§aEficiencia");
		List<String> loreEficiencia = new ArrayList<String>();
		loreEficiencia.add("");
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DIG_SPEED)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DIG_SPEED) + 1;
			Integer max = Main.m.getConfig().getInt("Eficiencia.Limite");
			if (i > max) {
				loreEficiencia.add("§aN§vel: §cN§vel m§ximo atingido");
			} else {
				loreEficiencia.add("§aN§vel: " + i.toString());
			}
		} else {
			loreEficiencia.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DIG_SPEED)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DIG_SPEED) + 1;
			Integer max = Main.m.getConfig().getInt("Eficiencia.Limite");
			if (i > max) {
				loreEficiencia.add("§aPre§o: §cN§vel m§ximo atingido");
			} else {
				loreEficiencia.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Eficiencia.Preco") * i));
			}
		} else {
			loreEficiencia.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Eficiencia.Preco")));
		}
		Eficienciameta.setLore(loreEficiencia);
		Eficiencia.setItemMeta(Eficienciameta);

		ItemStack Unbreaking = Heads.Unbreaking;
		SkullMeta Unbreakingmeta = (SkullMeta) Unbreaking.getItemMeta();
		Unbreakingmeta.setDisplayName("§aUnbreaking");
		List<String> loreUnbreaking = new ArrayList<String>();
		loreUnbreaking.add("");
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DURABILITY)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DURABILITY) + 1;
			Integer max = Main.m.getConfig().getInt("Unbreaking.Limite");
			if (i > max) {
				loreUnbreaking.add("§aN§vel: §cN§vel m§ximo atingido");
			} else {
				loreUnbreaking.add("§aN§vel: " + i.toString());
			}
		} else {
			loreUnbreaking.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DURABILITY)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DURABILITY) + 1;
			Integer max = Main.m.getConfig().getInt("Unbreaking.Limite");
			if (i > max) {
				loreUnbreaking.add("§aPre§o: §cN§vel m§ximo atingido");
			} else {
				loreUnbreaking.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Unbreaking.Preco") * i));
			}
		} else {
			loreUnbreaking.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Unbreaking.Preco")));
		}
		Unbreakingmeta.setLore(loreUnbreaking);
		Unbreaking.setItemMeta(Unbreakingmeta);

		ItemStack Looting = Heads.Looting;
		SkullMeta Lootingmeta = (SkullMeta) Looting.getItemMeta();
		Lootingmeta.setDisplayName("§aFortuna");
		List<String> loreLooting = new ArrayList<String>();
		loreLooting.add("");
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 1;
			Integer max = Main.m.getConfig().getInt("Looting.Limite");
			if (i > max) {
				loreLooting.add("§aN§vel: §cN§vel m§ximo atingido");
			} else {
				loreLooting.add("§aN§vel: " + i.toString());
			}
		} else {
			loreLooting.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 1;
			Integer max = Main.m.getConfig().getInt("Looting.Limite");
			if (i > max) {
				loreLooting.add("§aPre§o: §cN§vel m§ximo atingido");
			} else {
				loreLooting.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Looting.Preco") * i));
			}
		} else {
			loreLooting.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Looting.Preco")));
		}
		Lootingmeta.setLore(loreLooting);
		Looting.setItemMeta(Lootingmeta);
		
		guisword.setItem(11, Eficiencia);
		guisword.setItem(13, Unbreaking);
		guisword.setItem(15, Looting);

		s.openInventory(guisword);
	}

	public static void OpenArmor(Player s, ItemStack Item) {

		final Inventory guisword = Bukkit.createInventory(null, 27, "§eEncantamentos - Armaduras");

		ItemStack Unbreaking = Heads.Unbreaking;
		SkullMeta Unbreakingmeta = (SkullMeta) Unbreaking.getItemMeta();
		Unbreakingmeta.setDisplayName("§aUnbreaking");
		List<String> loreUnbreaking = new ArrayList<String>();
		loreUnbreaking.add("");
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DURABILITY)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DURABILITY) + 1;
			Integer max = Main.m.getConfig().getInt("Unbreaking.Limite");
			if (i > max) {
				loreUnbreaking.add("§aN§vel: §cN§vel m§ximo atingido");
			} else {
				loreUnbreaking.add("§aN§vel: " + i.toString());
			}
		} else {
			loreUnbreaking.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.DURABILITY)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.DURABILITY) + 1;
			Integer max = Main.m.getConfig().getInt("Unbreaking.Limite");
			if (i > max) {
				loreUnbreaking.add("§aPre§o: §cN§vel m§ximo atingido");
			} else {
				loreUnbreaking.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Unbreaking.Preco") * i));
			}
		} else {
			loreUnbreaking.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Unbreaking.Preco")));
		}
		Unbreakingmeta.setLore(loreUnbreaking);
		Unbreaking.setItemMeta(Unbreakingmeta);

		ItemStack Protection = Heads.Protection;
		SkullMeta Protectionmeta = (SkullMeta) Protection.getItemMeta();
		Protectionmeta.setDisplayName("§aProtection");
		List<String> loreProtection = new ArrayList<String>();
		loreProtection.add("");
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) + 1;
			Integer max = Main.m.getConfig().getInt("Protection.Limite");
			if (i > max) {
				loreProtection.add("§aN§vel: §cN§vel m§ximo atingido");
			} else {
				loreProtection.add("§aN§vel: " + i.toString());
			}
		} else {
			loreProtection.add("§aN§vel: 1");
		}
		if (Item.hasItemMeta() && Item.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
			Integer i = Item.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) + 1;
			Integer max = Main.m.getConfig().getInt("Protection.Limite");
			if (i > max) {
				loreProtection.add("§aPre§o: §cN§vel m§ximo atingido");
			} else {
				loreProtection.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Protection.Preco") * i));
			}
		} else {
			loreProtection.add("§aPre§o: " + FormatAPI.format(Main.m.getConfig().getDouble("Protection.Preco")));
		}
		Protectionmeta.setLore(loreProtection);
		Protection.setItemMeta(Protectionmeta);

		guisword.setItem(12, Protection);
		guisword.setItem(14, Unbreaking);

		s.openInventory(guisword);
	}

	public static void EnchantItem(ItemStack item, Enchantment enchant, Integer nivel) {
		if (nivel > enchant.getMaxLevel()) {
			item.addUnsafeEnchantment(enchant, nivel);
		} else {
			item.addEnchantment(enchant, nivel);
		}
	}

	public static Double GetFortuna(ItemStack item) {
		if (item.hasItemMeta() && item.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
			Integer i = item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
			return i * 0.2;
		} else {
			return 0.0;
		}
	}

}
