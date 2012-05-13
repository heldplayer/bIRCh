package me.heldplayer.bIRCh.event;

import me.heldplayer.bIRCh.Channel;
import me.heldplayer.bIRCh.IrcUser;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author heldplayer
 *         Holds information for when an IRC message is relayed to the server
 */
public class IRCMessageRecievedEvent extends Event {
	private static final HandlerList handlers = new HandlerList();

	private Channel channel;
	private IrcUser sender;
	private String message;
	private String format = "[%1$s] <%2$s> %3$s";

	public IRCMessageRecievedEvent(Channel channel, IrcUser sender, String message) {
		this.channel = channel;
		this.sender = sender;
		this.message = message;
	}

	/**
	 * Gets the message that is being sent
	 * 
	 * @return The message being sent
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message that is being sent
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the format used to send the message to the server
	 * 
	 * @return String.Format compatible format string
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Sets the format used to send the message to the server
	 * 
	 * @param format
	 *            String.Format compatible format string
	 */
	public void setFormat(String format) {
		try {
			String.format(format, channel.getName(), sender.getDisplayName(), message);
		} catch (RuntimeException ex) {
			ex.fillInStackTrace();
			throw ex;
		}

		this.format = format;
	}

	/**
	 * Gets the user the message was sent from
	 * 
	 * @return The user the message was sent from
	 */
	public IrcUser getuser() {
		return sender;
	}

	/**
	 * Gets the channel the message was sent from
	 * 
	 * @return The channel the message was sent from
	 */
	public Channel getChannel() {
		return channel;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
