package com.jtrent238.client.Client.Modules;

import com.jtrent238.client.Client.Client;
import me.deftware.client.framework.Event.Event;
import me.deftware.client.framework.Wrappers.IChat;

public abstract class Mod {

	private ModType type;
	private String name, description;
	private int keybind;
	private boolean state;

	/**
	 * Set keybind to -1 for no keybind
	 * 
	 * @param name
	 * @param description
	 * @param type
	 * @param keybind
	 */
	public Mod(String name, String description, ModType type, int keybind) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.keybind = Client.getSetting().getInt(this.getID() + "_bind", keybind);
		this.state = Client.getSetting().getBool(this.getID() + "_state", false);
	}

	/**
	 * Saves state+keybind to config
	 */
	private void save() {
		Client.getSetting().saveInt(this.getID() + "_bind", keybind);
		Client.getSetting().saveBool(this.getID() + "_state", state);
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public ModType getType() {
		return type;
	}

	public void setType(ModType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getKeybind() {
		return keybind;
	}

	public void setKeybind(int keybind) {
		this.keybind = keybind;
		save();
	}

	/**
	 * Returns this mods unique ID
	 */
	public String getID() {
		return this.name.toLowerCase().replace(" ", "_") + this.type.name().toLowerCase().replace(" ", "_");
	}

	public void toggle() {
		this.state = !state;
		save();
		IChat.sendClientMessage(this.getName() + " is now " + (state ? "enabled" : "disabled"));
		if (state) {
			this.onEnable();
		} else {
			this.onDisable();
		}
	}

	/*
	 * Handlers
	 */

	public abstract void onEvent(Event event);

	public abstract void onEnable();

	public abstract void onDisable();

}
