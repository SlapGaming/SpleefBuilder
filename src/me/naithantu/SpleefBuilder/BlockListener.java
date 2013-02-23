package me.naithantu.SpleefBuilder;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockFadeEvent;

public class BlockListener implements Listener {
	SpleefBuilder plugin;

	BlockListener(SpleefBuilder instance) {
		plugin = instance;
	}

	@EventHandler
	public void onBlockDamage(BlockDamageEvent event) {
		Boolean spleef = SpleefBuilder.spleefing;
		if (spleef == true) {
			Player player = event.getPlayer();
			Location blockLocation = event.getBlock().getLocation();
			int x = blockLocation.getBlockX();
			int y = blockLocation.getBlockY();
			int z = blockLocation.getBlockZ();

			if (event.getBlock().getType() == Material.GLOWSTONE) {
				if (-40 > x && -62 < x && 62 > y && 59 < y && -894 > z && -941 < z && player.getWorld().getName().equals("world")) {
					event.getBlock().setType(Material.AIR);
				}
			}
			if (event.getBlock().getType() == Material.SNOW_BLOCK || event.getBlock().getType() == Material.ICE || event.getBlock().getType() == Material.SOUL_SAND) {
				if (-40 > x && -62 < x && 62 > y && 59 < y && -894 > z && -941 < z && player.getWorld().getName().equals("world")) {
					event.getBlock().setType(Material.AIR);
				}
			}
		}
	}
	@EventHandler
	public void onBlockFade(BlockFadeEvent event) {
		Location blockLocation = event.getBlock().getLocation();
		int x = blockLocation.getBlockX();
		int y = blockLocation.getBlockY();
		int z = blockLocation.getBlockZ();
		if (-40 > x && -62 < x && 62 > y && 59 < y && -895 > z && -941 < z && blockLocation.getWorld().getName().equals("world")) {
			event.setCancelled(true);
		}
	}
}
