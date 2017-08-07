package com.jtrent238.client.Client.Command.Commands;

import com.jtrent238.client.Client.Command.Command;
import com.jtrent238.client.Main.Main;

import me.deftware.client.framework.Wrappers.IChat;

public class Info extends Command {

	@Override
	public void onCommand(String args) {

			IChat.sendClientMessage(Main.name);
			IChat.sendClientMessage("Made by: jtrent238!");
			
			

	}

}
