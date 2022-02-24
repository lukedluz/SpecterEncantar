package com.lucas.specterencantar.eventos;

import java.util.ArrayList;

import com.lucas.specterencantar.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Eventos implements Listener {

	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE) {
				e.setCancelled(true);
				if (p.getItemInHand().getType().toString().contains("SWORD")) {
					MenuAPI.OpenSword(p, p.getItemInHand());
					return;
				} else if (p.getItemInHand().getType().toString().contains("HELMET")
						|| p.getItemInHand().getType().toString().contains("CHESTPLATE")
						|| p.getItemInHand().getType().toString().contains("LEGGINGS")
						|| p.getItemInHand().getType().toString().contains("BOOTS")) {
					MenuAPI.OpenArmor(p, p.getItemInHand());
					return;
				} else if (p.getItemInHand().getType().toString().contains("AXE")
						&& !p.getItemInHand().getType().toString().contains("PICKAXE")) {
					MenuAPI.OpenFerramentas(p, p.getItemInHand());
					return;
				} else if (p.getItemInHand().getType().toString().contains("PICKAXE")) {
					MenuAPI.OpenFerramentas2(p, p.getItemInHand());
					return;
				} else {
					p.sendMessage("�cVoc� n�o pode encantar esse item");
					return;
				}
			}
		}
	}

	@EventHandler
	public void ClickPrincipal(InventoryClickEvent e) {
		Inventory Inv = e.getInventory();
		Player p = (Player) e.getWhoClicked();
		if (Inv.getTitle().equalsIgnoreCase("�eEncantamentos - Espadas")) {
			if (p.getItemInHand().getType().toString().contains("SWORD")) {
				e.setCancelled(true);
				if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aSharpness")) {
						if (e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", "").toString()
								.equalsIgnoreCase("�cN�vel m�ximo atingido"))
							return;
						Integer Nivel = Integer
								.valueOf(e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", ""));
						Double Preco = Main.m.getConfig().getDouble("Sharpness.Preco") * Nivel;
						if (Main.economy.getBalance(p) >= Preco) {
							MenuAPI.EnchantItem(p.getItemInHand(), Enchantment.DAMAGE_ALL, Nivel);
							Main.economy.withdrawPlayer(p, Preco);
							p.closeInventory();
							MenuAPI.OpenSword(p, p.getItemInHand());
						} else {
							p.sendMessage("�cVoc� n�o possui money suficiente.");
							p.closeInventory();
						}
					} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aUnbreaking")) {
						if (e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", "").toString()
								.equalsIgnoreCase("�cN�vel m�ximo atingido"))
							return;
						Integer Nivel = Integer
								.valueOf(e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", ""));
						Double Preco = Main.m.getConfig().getDouble("Unbreaking.Preco") * Nivel;
						if (Main.economy.getBalance(p) >= Preco) {
							MenuAPI.EnchantItem(p.getItemInHand(), Enchantment.DURABILITY, Nivel);
							Main.economy.withdrawPlayer(p, Preco);
							p.closeInventory();
							MenuAPI.OpenSword(p, p.getItemInHand());
						} else {
							p.sendMessage("�cVoc� n�o possui money suficiente.");
							p.closeInventory();
						}
					} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aFire Aspect")) {
						if (e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", "").toString()
								.equalsIgnoreCase("�cN�vel m�ximo atingido"))
							return;
						Integer Nivel = Integer
								.valueOf(e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", ""));
						Double Preco = Main.m.getConfig().getDouble("FireAspect.Preco") * Nivel;
						if (Main.economy.getBalance(p) >= Preco) {
							MenuAPI.EnchantItem(p.getItemInHand(), Enchantment.FIRE_ASPECT, Nivel);
							Main.economy.withdrawPlayer(p, Preco);
							p.closeInventory();
							MenuAPI.OpenSword(p, p.getItemInHand());
						} else {
							p.sendMessage("�cVoc� n�o possui money suficiente.");
							p.closeInventory();
						}
					}
				}
			} else {
				p.closeInventory();
				p.sendMessage("�cEncantamento inv�lido para esse item");
			}
		} else if (Inv.getTitle().equalsIgnoreCase("�eEncantamentos - Ferramentas")) {
			e.setCancelled(true);
			if (p.getItemInHand().getType().toString().contains("AXE")) {
				if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aEficiencia")) {
						if (e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", "").toString()
								.equalsIgnoreCase("�cN�vel m�ximo atingido"))
							return;
						Integer Nivel = Integer
								.valueOf(e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", ""));
						Double Preco = Main.m.getConfig().getDouble("Eficiencia.Preco") * Nivel;
						if (Main.economy.getBalance(p) >= Preco) {
							MenuAPI.EnchantItem(p.getItemInHand(), Enchantment.DIG_SPEED, Nivel);
							Main.economy.withdrawPlayer(p, Preco);
							p.closeInventory();
							MenuAPI.OpenFerramentas(p, p.getItemInHand());
						} else {
							p.sendMessage("�cVoc� n�o possui money suficiente.");
							p.closeInventory();
						}
					} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aUnbreaking")) {
						if (e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", "").toString()
								.equalsIgnoreCase("�cN�vel m�ximo atingido"))
							return;
						Integer Nivel = Integer
								.valueOf(e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", ""));
						Double Preco = Main.m.getConfig().getDouble("Unbreaking.Preco") * Nivel;
						if (Main.economy.getBalance(p) >= Preco) {
							MenuAPI.EnchantItem(p.getItemInHand(), Enchantment.DURABILITY, Nivel);
							Main.economy.withdrawPlayer(p, Preco);
							p.closeInventory();
							MenuAPI.OpenFerramentas(p, p.getItemInHand());
						} else {
							p.sendMessage("�cVoc� n�o possui money suficiente.");
							p.closeInventory();
						}
					} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aFortuna")) {
						if (e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", "").toString()
								.equalsIgnoreCase("�cN�vel m�ximo atingido"))
							return;
						Integer Nivel = Integer
								.valueOf(e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", ""));
						Double Preco = Main.m.getConfig().getDouble("Fortuna.Preco") * Nivel;
						if (Main.economy.getBalance(p) >= Preco) {
							MenuAPI.EnchantItem(p.getItemInHand(), Enchantment.LOOT_BONUS_BLOCKS, Nivel);
							Main.economy.withdrawPlayer(p, Preco);
							p.closeInventory();
							MenuAPI.OpenFerramentas(p, p.getItemInHand());
						} else {
							p.sendMessage("�cVoc� n�o possui money suficiente.");
							p.closeInventory();
						}
					} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aExplosivo")) {
						if (e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", "").toString()
								.equalsIgnoreCase("�cN�vel m�ximo atingido"))
							return;
						if (!p.getItemInHand().getType().toString().contains("PICKAXE")) {
							Double Preco = Main.m.getConfig().getDouble("Exposivo.Preco");
							if (Main.economy.getBalance(p) >= Preco) {

								ItemStack explosivo = p.getItemInHand();
								ItemMeta explosivoMeta = explosivo.getItemMeta();
								ArrayList<String> explosivoLore = new ArrayList<String>();
								if (p.getItemInHand().getItemMeta().getLore() != null) {
									explosivoLore.addAll(p.getItemInHand().getItemMeta().getLore());
								}
								explosivoLore.add("�7Explosivo");
								explosivoMeta.setLore(explosivoLore);
								explosivo.setItemMeta(explosivoMeta);
								p.setItemInHand(explosivo);

								Main.economy.withdrawPlayer(p, Preco);
								p.closeInventory();
								MenuAPI.OpenFerramentas(p, p.getItemInHand());
							} else {
								p.sendMessage("�cVoc� n�o possui money suficiente.");
								p.closeInventory();
							}
						} else {
							p.closeInventory();
							p.sendMessage("�cEncantamento inv�lido para esse item");
						}
					}
				}
			} else {
				p.closeInventory();
				p.sendMessage("�cEncantamento inv�lido para esse item");
			}
		} else if (Inv.getTitle().equalsIgnoreCase("�eEncantamentos - Armaduras")) {
			e.setCancelled(true);
			if (p.getItemInHand().getType().toString().contains("HELMET")
					|| p.getItemInHand().getType().toString().contains("CHESTPLATE")
					|| p.getItemInHand().getType().toString().contains("LEGGINGS")
					|| p.getItemInHand().getType().toString().contains("BOOTS")) {
				if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
					if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aProtection")) {
						if (e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", "").toString()
								.equalsIgnoreCase("�cN�vel m�ximo atingido"))
							return;
						Integer Nivel = Integer
								.valueOf(e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", ""));
						Double Preco = Main.m.getConfig().getDouble("Protection.Preco") * Nivel;
						if (Main.economy.getBalance(p) >= Preco) {
							MenuAPI.EnchantItem(p.getItemInHand(), Enchantment.PROTECTION_ENVIRONMENTAL, Nivel);
							Main.economy.withdrawPlayer(p, Preco);
							p.closeInventory();
							MenuAPI.OpenArmor(p, p.getItemInHand());
						} else {
							p.sendMessage("�cVoc� n�o possui money suficiente.");
							p.closeInventory();
						}
					} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aUnbreaking")) {
						if (e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", "").toString()
								.equalsIgnoreCase("�cN�vel m�ximo atingido"))
							return;
						Integer Nivel = Integer
								.valueOf(e.getCurrentItem().getItemMeta().getLore().get(1).replace("�aN�vel: ", ""));
						Double Preco = Main.m.getConfig().getDouble("Unbreaking.Preco") * Nivel;
						if (Main.economy.getBalance(p) >= Preco) {
							MenuAPI.EnchantItem(p.getItemInHand(), Enchantment.DURABILITY, Nivel);
							Main.economy.withdrawPlayer(p, Preco);
							p.closeInventory();
							MenuAPI.OpenArmor(p, p.getItemInHand());
						} else {
							p.sendMessage("�cVoc� n�o possui money suficiente.");
							p.closeInventory();
						}
					}
				}
			} else {
				p.closeInventory();
				p.sendMessage("�cEncantamento inv�lido para esse item");
			}
		}
	}
}
