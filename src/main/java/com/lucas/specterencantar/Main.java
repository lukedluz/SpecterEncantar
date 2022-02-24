package com.lucas.specterencantar;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import com.lucas.specterencantar.eventos.MenuAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.lucas.specterencantar.eventos.Eventos;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	
	public static Main m;
	public static Economy economy;
	public static ArrayList<String> delaychat = new ArrayList<String>();
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§7==========================");
		Bukkit.getConsoleSender().sendMessage("§7| §bSpecterEncantar        §7|");
		Bukkit.getConsoleSender().sendMessage("§7| §bVersão 1.0             §7|");
		Bukkit.getConsoleSender().sendMessage("§7| §fStatus: §aLigado       §7|");
		Bukkit.getConsoleSender().sendMessage("§7==========================");
		Bukkit.getConsoleSender().sendMessage("");

		m = this;
		saveDefaultConfig();
		setupEconomy();
		
		Bukkit.getPluginManager().registerEvents(new Eventos(), this);
		Bukkit.getPluginManager().registerEvents(new MenuAPI(), this);
	}
	
	public static String format(final double valor) {
		final NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
		format.setMaximumFractionDigits(1);
		return format.format(valor);
	}
	
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager()
				.getRegistration(Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
			return true;
		} else {
			return false;
		}
	}
}
