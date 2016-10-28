package mojong;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public int Score;
	public List<MoJoPai> playerPaiZu;
	public PaiHe paihe;
	public Boolean isZhuangjia;

	public Boolean getIsZhuangjia() {
		return isZhuangjia;
	}

	public void setIsZhuangjia(Boolean isZhuangjia) {
		this.isZhuangjia = isZhuangjia;
	}

	public PaiHe getPaihe() {
		return paihe;
	}

	public void setPaihe(PaiHe paihe) {
		this.paihe = paihe;
	}

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
