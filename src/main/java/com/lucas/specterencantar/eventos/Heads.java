package com.lucas.specterencantar.eventos;

import java.lang.reflect.Field;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

public class Heads {

	public static ItemStack Sharpness;
	public static ItemStack Unbreaking;
	public static ItemStack Fireaspect;
	public static ItemStack Protection;
	public static ItemStack Looting;
	public static ItemStack Eficiencia;
	public static ItemStack Explosivo;
	
	static {
		Sharpness = getSkull("http://textures.minecraft.net/texture/93a69c3caa31304e9952328c72cee0b57b2a2bd46ce9c5cb88c07d1266277d6a");
		Unbreaking = getSkull("http://textures.minecraft.net/texture/36505b1befba242170a46e8947b52aea54a59060f3e1c36f21cebb44690f8b0c");
		Fireaspect = getSkull("http://textures.minecraft.net/texture/d53fa1b57e4f784d16e5a2daa2f746b2ecfe624ccd74a4d4acc6a2e6a083f54e");
		Protection = getSkull("http://textures.minecraft.net/texture/8be2baf40fd85eb573fe5b2e5b6c8817cf50f883d95769415807ab07288a47cd");
		Looting = getSkull("http://textures.minecraft.net/texture/ac92e5111ea7d7eb3f055833e1f35d651c0da55643c9383e0bce6c23696d58b9");
		Eficiencia = getSkull("http://textures.minecraft.net/texture/32ea85c85fe0484af6c815efb655d2b21e109863c96333b9280b59b80d6ac98f");
		Explosivo = getSkull("http://textures.minecraft.net/texture/d53fa1b57e4f784d16e5a2daa2f746b2ecfe624ccd74a4d4acc6a2e6a083f54e");
	}
	
	public static ItemStack getSkull(String url) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        if (url == null || url.isEmpty())
            return skull;
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = skullMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        profileField.setAccessible(true);
        try {
            profileField.set(skullMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        skull.setItemMeta(skullMeta);
        return skull;
    }
}
