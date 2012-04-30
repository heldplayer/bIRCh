package me.heldplayer.bIRCh;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class bIRCh extends JavaPlugin {
	protected PluginDescriptionFile pdfFile;
	public static final Version version = new Version(0, 0, 1, 3);
	public final static String updateUrl = "http://dsiwars.co.cc/jars/bIRCh/";
	private static Logger logger;

	public void onDisable() {
		log(Level.INFO, pdfFile.getFullName() + " is now disabled!");
	}

	public void onEnable() {
		logger = getLogger();
		
		pdfFile = this.getDescription();
		
		try {
			if(Updater.isOutdated()){
				log(Level.INFO, "An update for bIRCh is available!");
			}
		} catch (IOException e) {
			log(Level.INFO, "Error while checking for updates");
			e.printStackTrace();
		}

		log(Level.INFO, pdfFile.getFullName() + " is now enabled!");
	}
	
	public static void log(Level level, String message){
		logger.log(level, message);
	}
}
