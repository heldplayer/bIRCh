package me.heldplayer.bIRCh;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class bIRCh extends JavaPlugin {
	protected PluginDescriptionFile pdfFile;
	protected final static int primaryVersion = 0;
	protected final static int secondaryVersion = 1;
	protected final static int minorVersion = 0;
	protected final static String updateUrl = "http://dsiwars.co.cc/jars/bIRCh/";
	
	public void onDisable() {
		this.getLogger().info(pdfFile.getFullName() + " is now disabled!");
	}

	public void onEnable() {
		pdfFile = this.getDescription();

		this.getLogger().info(pdfFile.getFullName() + " is now enabled!");
	}
}
