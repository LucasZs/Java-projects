package common;

import player.Player;

public interface Rule {
	void init();
	boolean isEndGame();
	Player nextPlayer();
}
