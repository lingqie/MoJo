package mojong;

import java.util.List;

public class Room {
	public Player player1;
	public Player player2;
	public Player player3;
	public Player player4;
	public static List<MoJoPai> paizu;
	
	public static List<MoJoPai> getPaizu() {
		return paizu;
	}
	public static void setPaizu(List<MoJoPai> paizu) {
		Room.paizu = paizu;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Player getPlayer3() {
		return player3;
	}
	public void setPlayer3(Player player3) {
		this.player3 = player3;
	}
	public Player getPlayer4() {
		return player4;
	}
	public void setPlayer4(Player player4) {
		this.player4 = player4;
	}
}
