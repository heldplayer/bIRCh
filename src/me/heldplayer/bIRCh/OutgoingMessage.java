package me.heldplayer.bIRCh;

import org.bukkit.entity.Player;

public class OutgoingMessage {
	protected String message;
	
	protected OutgoingMessage(Channel channel, Player player, String message, String format){
		this.message = String.format(format, channel.getName(), player.getDisplayName(), message);
	}
	
	protected OutgoingMessage(String raw){
		message = raw;
	}
}
