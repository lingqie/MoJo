package mojong;

import java.util.List;

public class Room {
	public Player player1;
	public Player player2;
	public Player player3;
	public Player player4;
	public PaiZu mojoPaiZu;
	public int lizhibangshu;
	public int jushu;
	public int changshu;// er ben chang

	public Room() {
		this.player1 = new Player();
		this.player2 = new Player();
		this.player3 = new Player();
		this.player4 = new Player();
		this.mojoPaiZu = new PaiZu();
	}

	public int getLizhibangshu() {
		return lizhibangshu;
	}

	public void setLizhibangshu(int lizhibangshu) {
		this.lizhibangshu = lizhibangshu;
	}

	public int getJushu() {
		return jushu;
	}

	public void setJushu(int jushu) {
		this.jushu = jushu;
	}

	public int getChangshu() {
		return changshu;
	}

	public void setChangshu(int changshu) {
		this.changshu = changshu;
	}

	public PaiZu getMojoPaiZu() {
		return mojoPaiZu;
	}

	public void setMojoPaiZu(PaiZu mojoPaiZu) {
		this.mojoPaiZu = mojoPaiZu;
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

	public List<MoJoPai> getWangPai() {
		return mojoPaiZu.getWangPai().getWangpais();
	}

	public void setWangPai(List<MoJoPai> p) {
		mojoPaiZu.getWangPai().setWangpais(p);
	}

	public List<MoJoPai> getPaiShan() {
		return mojoPaiZu.getPaiShan().getPaiShan();
	}

	public void setPaiShan(List<MoJoPai> p) {
		mojoPaiZu.getPaiShan().setPaiShan(p);
	}
	
	public String getJuShuString(){
		return MoJoPaiCode.jushu[jushu];
	}
	
	public String getChangShuString(){
		 return String.valueOf(changshu+1);
	}
}
