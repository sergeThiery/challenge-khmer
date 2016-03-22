package com.challenge.domain;

import java.util.Date;

public class Goal {
	
	private Player player;
	
	private Date date;
	
	public Goal(Player player, Date date){
		this.player = player;
		this.date = date;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
