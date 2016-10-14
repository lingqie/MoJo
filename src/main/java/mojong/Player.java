package mojong;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	public int Score;
	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public List<MoJoPai> playerPaiZu;
	
	public Player() {
		this.playerPaiZu=new ArrayList<MoJoPai>();
	}

	public List<MoJoPai> getPlayerPaiZu() {
		return playerPaiZu;
	}

	public void setPlayerPaiZu(List<MoJoPai> playerPaiZu) {
		this.playerPaiZu = playerPaiZu;
	}
}
