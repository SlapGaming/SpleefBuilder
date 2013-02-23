package me.naithantu.SpleefBuilder;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener {

	SpleefBuilder plugin;

	PlayerListener(SpleefBuilder instance) {
		plugin = instance;
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		if (SpleefBuilder.spleefStarting == true) {
			double x = event.getPlayer().getLocation().getX();
			double y = event.getPlayer().getLocation().getY();
			double z = event.getPlayer().getLocation().getZ();
			if (-40 > x && -62 < x && 66 > y && 59 < y && -895 > z && -941 < z) {
				if (!event.getPlayer().hasPermission("rebuildarena.override")) {
					event.setCancelled(true);
				}
			}
		}
	}
}