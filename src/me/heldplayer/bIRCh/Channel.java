package me.heldplayer.bIRCh;

import java.util.ArrayList;

/**
 * @author heldplayer
 *         Represents an IRC channel
 */
public class Channel {
	protected final String name;
	protected final ArrayList<IrcUser> users;

	public Channel(String name, IrcUser[] users) {
		this.name = name;
		this.users = new ArrayList<IrcUser>();
		for (IrcUser user : users) {
			this.users.add(user);
		}
	}

	/**
	 * Gets the name of the channel
	 * 
	 * @return The name of the channel
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the amount of users on the channel
	 * 
	 * @return The total amount of users on the channel
	 */
	public int getUserCount() {
		return this.users.size();
	}

	/**
	 * Sends a message to the channel
	 * 
	 * @param message
	 *            The message to send
	 */
	public void sendMessage(String message) {
		// TODO: add code to this
	}
}
