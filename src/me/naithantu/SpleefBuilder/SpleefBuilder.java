package me.naithantu.SpleefBuilder;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SpleefBuilder extends JavaPlugin {
	public String enabledstartup = "Enabled On Startup";
	public boolean enabled;
	public final PlayerListener playerListener = new PlayerListener(this);
	public final BlockListener blockListener = new BlockListener(this);
	public static SpleefBuilder plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	int timer;
	public static boolean spleefStarting = false;
	World world;
	Boolean rebuildDouble = false;
	int x;
	int y;
	int z;
	int b;// Block (air/snow for second layer). USE THIS TO ALSO ALLOW
			// ICE/LEAVES AND MOAR!
	int g;// Glowstone (air/glowstone for second layer) USED FOR THE GLOWSTONE
			// LINES!
	//TODO Make pigs not die in spleef.
	public boolean arenaPvp = true;
	public boolean haveRebuilt = true;
	public static boolean spleefing = false;
	boolean noGlowstone;

	@Override
	public void onDisable() {
	}

	@Override
	public void onEnable() { //TODO Add ender eye spleef. 
		plugin = this;
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.playerListener, this);
		pm.registerEvents(this.blockListener, this);
		World arenaworld = (World) Bukkit.getServer().getWorld("World");
		Location testSpleef = new Location(arenaworld, -57.0, 61.0, -901.0);
		if (testSpleef.getBlock().getType() != Material.SMOOTH_BRICK) {
			spleefing = true;
		} else {
			spleefing = false;
		}
	}

	public void rebuildArena() {
		for (z = -930; z < -905; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -933; z < -902; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -935; z < -900; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -937; z < -898; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -938; z < -897; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -939; z < -896; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}

		x++;
		for (z = -940; z < -895; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -940; z < -895; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -940; z < -895; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -940; z < -895; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(g);
		}
		x++;
		for (z = -940; z < -895; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(g);
		}
		x++; // 1
		for (z = -940; z < -895; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -940; z < -895; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -940; z < -895; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}

		x++;
		for (z = -939; z < -896; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -938; z < -897; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -937; z < -898; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -935; z < -900; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -933; z < -902; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);
		}
		x++;
		for (z = -930; z < -905; z++) {
			Block blockToChange = world.getBlockAt(x, y, z);
			blockToChange.setTypeId(b);

		}
		if (rebuildDouble == true) {
			x = -61;
			y = 60;
			z = -940;
			rebuildDouble = false;
			haveRebuilt = true;
			rebuildArena();
		} else {
			if (haveRebuilt == false) {
				haveRebuilt = true;
				x = -61;
				y = 60;
				z = -940;
				b = 0;
				g = 0;
				rebuildArena();
			} else {
				x = -61;
				y = 61;
				z = -940;
			}
		}
	}

	public void noTimer() {
		haveRebuilt = false;
		spleefStarting = false;
		x = -61;
		y = 61;
		z = -940;
		g = 89;
		if (b != 98) {
			spleefing = true;
		} else {
			spleefing = false;
		}
		rebuildArena();
	}

	public void arenaTimer(final int centerLine) {
		spleefStarting = true;
		getServer().broadcastMessage("[" + ChatColor.DARK_PURPLE + "Arena" + ChatColor.WHITE + "] " + ChatColor.YELLOW + "Spleef in: 3");
		this.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			public void run() {

				getServer().broadcastMessage("[" + ChatColor.DARK_PURPLE + "Arena" + ChatColor.WHITE + "] " + ChatColor.YELLOW + "Spleef in: 2");
				getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						getServer().broadcastMessage("[" + ChatColor.DARK_PURPLE + "Arena" + ChatColor.WHITE + "] " + ChatColor.YELLOW + "Spleef in: 1");
						getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

							public void run() {
								spleefStarting = false;
								getServer().broadcastMessage("[" + ChatColor.DARK_PURPLE + "Arena" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + "Go!"); // pvp.
								x = -61;
								y = 61;
								z = -940;
								g = centerLine;
								if (b != 98) {
									spleefing = true;
								} else {
									spleefing = false;
								}
								haveRebuilt = false;
								rebuildArena();
							}
						}, 16L);
					}
				}, 20L);
			}
		}, 20L);
	}

	public boolean onCommand(final CommandSender sender, Command cmd, String commandLabel, String[] args) {

		Player player = null;
		player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("warparena")) {
			if (player.hasPermission("spleefbuilder.warparena")) {
				Boolean emptyInv = true;
				PlayerInventory inv = player.getInventory();
				for (ItemStack stack : inv.getContents()) {
					try {
						if (stack.getType() != (Material.AIR)) {
							emptyInv = false;
						}
					} catch (NullPointerException e) {
					}
				}
				for (ItemStack stack : inv.getArmorContents()) {
					try {
						if (stack.getType() != (Material.AIR)) {
							emptyInv = false;
						}
					} catch (NullPointerException e) {
					}
				}
				if (emptyInv == true) {
					if (spleefing == false) {
						Double xArenaloc = -50.5;
						Double yArenaloc = 62.0;
						Double zArenaloc = -918.0;
						World arenaWorld = (World) Bukkit.getServer().getWorld("World");
						Location arenaloc = new Location(arenaWorld, xArenaloc, yArenaloc, zArenaloc);
						player.teleport(arenaloc);
						player.sendMessage("[" + ChatColor.DARK_PURPLE + "Arena" + ChatColor.WHITE + "] " + "You have been warped into the arena!");
					} else {
						Double xArenaloc = -51.0;
						Double yArenaloc = 66.0;
						Double zArenaloc = -941.5;
						World arenaWorld = (World) Bukkit.getServer().getWorld("World");
						Location arenaloc = new Location(arenaWorld, xArenaloc, yArenaloc, zArenaloc);
						player.teleport(arenaloc);
						player.sendMessage("[" + ChatColor.DARK_PURPLE + "Arena" + ChatColor.WHITE + "] " + "You have been warped to the spectator area because they are spleefing!");
					}
				} else {
					player.sendMessage("[" + ChatColor.DARK_PURPLE + "Arena" + ChatColor.WHITE + "] " + "Empty your inventory and take of your armor, then use /warparena again!");
				}
			} else {
				player.sendMessage(ChatColor.RED + "You do not have access to that command.");
			}
		}
		if (cmd.getName().equalsIgnoreCase("rebuildarena") || cmd.getName().equalsIgnoreCase("rba")) {
			if (player.hasPermission("spleefbuilder.rebuildarena")) {
				noGlowstone = false;
				String arg = "";
				try {
					arg = args[0];
				} catch (ArrayIndexOutOfBoundsException e) {
					player.sendMessage("Use /rebuildarena pvp or /rebuildarena spleef!"); // Help
																							// information
																							// for
																							// /rebuildspleef
					return true;
				}
				if (arg.equalsIgnoreCase("stopspleef")) {

					world = player.getWorld();
					if (world.getName().equals("world")) {
						spleefStarting = false;
						b = 98;
						arenaPvp = false;
						noTimer();
						player.sendMessage("[" + ChatColor.DARK_PURPLE + "Arena" + ChatColor.WHITE + "] " + "Spleef has been force stopped!");

					} else { // check if the player is in the overworld for
								// stone
						player.sendMessage(ChatColor.RED + "You need to be in the overworld to do this!");
					}
				}
				if (spleefStarting == false) {
					g = 89;// Glowstone (air/glowstone for second layer) USED
							// FOR THE GLOWSTONE LINES!
					rebuildDouble = false;
					if ((sender instanceof Player)) {
						player = (Player) sender;
					}
					try {
						arg = args[0];
					} catch (ArrayIndexOutOfBoundsException e) {
						player.sendMessage("Use /rebuildarena pvp or /rebuildarena spleef!");
						return true;
					}

					if (arg.equalsIgnoreCase("spleef")) {
						b = 80;
						world = player.getWorld();
						if (!world.getName().equals("world")) {
							player.sendMessage(ChatColor.RED + "You need to be in the overworld to do this!");
							return true;
						}
						try {
							arg = args[1];
						} catch (ArrayIndexOutOfBoundsException e) {

						}
						if (arg.equalsIgnoreCase("double")) {
							spleefStarting = true;
							arenaPvp = false;
							rebuildDouble = true;
							arenaTimer(89);
						} else {
							spleefStarting = true;
							arenaPvp = false;
							arenaTimer(89);
						}
					}
					if (arg.equalsIgnoreCase("ice")) {
						b = 79;
						world = player.getWorld();
						if (!world.getName().equals("world")) {
							player.sendMessage(ChatColor.RED + "You need to be in the overworld to do this!");
							return true;
						}
						try {
							arg = args[1];
						} catch (ArrayIndexOutOfBoundsException e) {

						}
						if (arg.equalsIgnoreCase("double")) {
							spleefStarting = true;
							arenaPvp = false;
							rebuildDouble = true;
							arenaTimer(79);
						} else {
							spleefStarting = true;
							arenaPvp = false;
							arenaTimer(79);
						}
					}
					if (arg.equalsIgnoreCase("leaves")) {
						b = 18;
						world = player.getWorld();
						if (!world.getName().equals("world")) {
							player.sendMessage(ChatColor.RED + "You need to be in the overworld to do this!");
							return true;
						}
						try {
							arg = args[1];
						} catch (ArrayIndexOutOfBoundsException e) {

						}
						noGlowstone = true;
						if (arg.equalsIgnoreCase("double")) {
							spleefStarting = true;
							arenaPvp = false;
							rebuildDouble = true;
							arenaTimer(18);
						} else {
							spleefStarting = true;
							arenaPvp = false;
							arenaTimer(18);
						}
					}

					if (arg.equalsIgnoreCase("soulsand")) {
						b = 88;
						world = player.getWorld();
						if (!world.getName().equals("world")) {
							player.sendMessage(ChatColor.RED + "You need to be in the overworld to do this!");
							return true;
						}
						try {
							arg = args[1];
						} catch (ArrayIndexOutOfBoundsException e) {

						}
						if (arg.equalsIgnoreCase("double")) {
							spleefStarting = true;
							arenaPvp = false;
							rebuildDouble = true;
							arenaTimer(88);
						} else {
							spleefStarting = true;
							arenaPvp = false;
							arenaTimer(88);
						}
					}
					if (arg.equalsIgnoreCase("stone")) {
						world = player.getWorld();
						if (world.getName().equals("world")) {
							spleefStarting = true;
							b = 98;
							arenaPvp = false;
							noTimer();

						} else {
							player.sendMessage(ChatColor.RED + "You need to be in the overworld to do this!");
						}
					}

					if (arg.equalsIgnoreCase("snow")) {
						world = player.getWorld();
						if (world.getName().equals("world")) {
							spleefStarting = true;
							b = 80;
							arenaPvp = false;
							noTimer();
						} else {
							player.sendMessage(ChatColor.RED + "You need to be in the overworld to do this!");
						}
					}

				} else {
					player.sendMessage(ChatColor.RED + "Spleef is starting, can't use that now!");
				}
			} else {
				player.sendMessage(ChatColor.RED + "You do not have access to that command.");
			}
		}
		return true;
	}
}
