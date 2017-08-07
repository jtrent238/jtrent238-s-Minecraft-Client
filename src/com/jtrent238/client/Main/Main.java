package com.jtrent238.client.Main;

import com.jtrent238.client.Client.Client;
import com.jtrent238.client.Client.EventBus;
import me.deftware.client.framework.Client.EMCClient;
import me.deftware.client.framework.Event.Event;

public class Main extends EMCClient {
	
	public static final String name = "jtrent238's Minecraft Client";
	public static final int build = 1;
	
	private EMCClientInfo clientInfo;
	private Client client;
	
	@Override
	public void initialize() {
		clientInfo = new EMCClientInfo(name, String.valueOf(build));
		client = new Client(this);
		client.initialize();
	}

	@Override
	public EMCClientInfo getClientInfo() {
		return clientInfo;
	}

	@Override
	public void onEvent(Event event) {
		EventBus.onEvent(event);
	}

}
