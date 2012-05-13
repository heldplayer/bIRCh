package me.heldplayer.bIRCh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class bIRCh extends JavaPlugin {
	protected PluginDescriptionFile pdfFile;
	public static final Version version = new Version(0, 0, 1, 4);
	public final static String updateUrl = "http://dsiwars.co.cc/jars/bIRCh/";
	private static Logger logger;
	private final ArrayList<IncomingMessage> ircToMc = new ArrayList<IncomingMessage>();
	private final ArrayList<OutgoingMessage> mcToIrc = new ArrayList<OutgoingMessage>();
	private Boolean dirty = false;

	public void onDisable() {
		log(Level.INFO, pdfFile.getFullName() + " is now disabled!");
	}

	public void onEnable() {
		logger = getLogger();
		logger.setLevel(Level.ALL);
		for (Handler handler : logger.getHandlers()) {
			handler.setLevel(Level.ALL);
		}

		// TODO: add command stuff

		pdfFile = this.getDescription();

		try {
			if (Updater.isOutdated()) {
				log(Level.INFO, "An update for bIRCh is available!");
			}
		} catch (IOException e) {
			log(Level.WARNING, "Error while checking for updates");
			e.printStackTrace();
		}

		final bIRCh instance = this;

		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Thread() {
			@Override
			public void run() {
				synchronized (dirty) {
					if (dirty == false) {
						return;
					}

					IncomingMessage message = null;
					while ((message = ircToMc.remove(0)) != null) {
						message.parse(instance);
					}
				}
			}
		}, 5, 10);

		log(Level.INFO, pdfFile.getFullName() + " is now enabled!");
	}

	protected void addToMcList(IncomingMessage message) {
		ircToMc.add(message);
	}

	protected void addToIrcList(OutgoingMessage message) {
		mcToIrc.add(message);
	}

	public static void log(Level level, String message) {
		logger.log(level, message);
	}
}
