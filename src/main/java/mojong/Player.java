package mojong;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public int Score;
	public List<MoJoPai> playerPaiZu;

	public Player() {
		this.playerPaiZu = new ArrayList<MoJoPai>();
		this.Score = 0;
	}

	public Player(List<MoJoPai> pai) {
		this.playerPaiZu = pai;
	}

	public Player(List<MoJoPai> pai, int score) {
		this.Score = score;
		this.playerPaiZu = pai;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public List<MoJoPai> getPlayerPaiZu() {
		return playerPaiZu;
	}

	public void setPlayerPaiZu(List<MoJoPai> playerPaiZu) {
		this.playerPaiZu = playerPaiZu;
	}
}
