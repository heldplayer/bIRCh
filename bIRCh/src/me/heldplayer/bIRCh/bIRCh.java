package me.heldplayer.bIRCh;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class bIRCh extends JavaPlugin {
	protected PluginDescriptionFile pdfFile;
	public static final Version version = new Version(0, 0, 1, 2);
	public final static String updateUrl = "http://dsiwars.co.cc/jars/bIRCh/";

	public void onDisable() {
		this.getLogger().info(pdfFile.getFullName() + " is now disabled!");
	}

	public void onEnable() {
		pdfFile = this.getDescription();

		this.getLogger().info(pdfFile.getFullName() + " is now enabled!");
	}
}
