package mojong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Player {

	public int Score;
	public List<MoJoPai> playerPaiZu;
	public PaiHe paihe;
	public Boolean isZhuangjia;
	public int fangwei;

	public Player() {
		this.playerPaiZu = new ArrayList<MoJoPai>();
		this.Score = 0;
		this.paihe = new PaiHe();
	}

	public int getFangwei() {
		return fangwei;
	}

	public void setFangwei(int fangwei) {
		this.fangwei = fangwei;
	}

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
