package mojong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoJoManualTest {

	
	public static List<MoJoPai> paizu2;
	public static Player player1;
	public static Player player2;
	public static Player player3;
	public static Player player4;
//	public static List<MoJoPai> player1;
//	public static List<MoJoPai> player2;
//	public static List<MoJoPai> player3;
//	public static List<MoJoPai> player4;
	public static List<MoJoPai> player1PaiHe;
	public static List<MoJoPai> player2PaiHe;
	public static List<MoJoPai> player3PaiHe;
	public static List<MoJoPai> player4PaiHe;
	public static List<MoJoPai> lingShangPai;
	public static List<MoJoPai> paiShan;

	public static int zongPaiShu = 108 + 28;
	// player pai 13*4
	// paishan 70
	// lingshang 14

	public static void main(String[] args) {
		player1=new Player();
		player2=new Player();
		player3=new Player();
		player4=new Player();
		lingShangPai=new ArrayList<MoJoPai>();
		paiShan=new ArrayList<MoJoPai>();
		
		
		DefaultMojongService mojongService = new DefaultMojongService();

		paizu2=mojongService.initDeafaultPaiZu();
		mojongService.showPai(paizu2, "zongpaizu", 4, true);
		initPlayerPai();

		mojongService.showPai(player1.getPlayerPaiZu(), "player1", 1, true);
		mojongService.showPai(player2.getPlayerPaiZu(), "player2", 1, true);
		mojongService.showPai(player3.getPlayerPaiZu(), "player3", 1, true);
		mojongService.showPai(player4.getPlayerPaiZu(), "player4", 1, true);


		mojongService.showPai(paiShan, "paishan", 2, true);
		initLingShangPai();
		mojongService.showPai(lingShangPai, "lingshangpai", 2, true);

		// showPlayerString(player1, "player1", false);
		// showPlayerString(player1, "player1", true);

		long starttime = System.nanoTime();

		mojongService.toSortPlayerPaizu(player1.getPlayerPaiZu());
		mojongService.toSortPlayerPaizu(player2.getPlayerPaiZu());
		mojongService.toSortPlayerPaizu(player3.getPlayerPaiZu());
		mojongService.toSortPlayerPaizu(player4.getPlayerPaiZu());

		System.out.println("");
		System.out.println("player pai sort time:");
		System.out.println((System.nanoTime() - starttime) / 1000);

		mojongService.showPai(player1.getPlayerPaiZu(), "player1", 1, false);
		mojongService.showPai(player2.getPlayerPaiZu(), "player2", 1, false);
		mojongService.showPai(player3.getPlayerPaiZu(), "player3", 1, false);
		mojongService.showPai(player4.getPlayerPaiZu(), "player4", 1, false);

	}

	private static void initLingShangPai() {
		// get lingshang
		for (int i = zongPaiShu - 14; i < zongPaiShu; i++) {
			lingShangPai.add(paizu2.get(i));
		}
	}

	private static void initPlayerPai() {
		// fapai
		for (int i = 0; i < 13; i++) {
			player1.getPlayerPaiZu().add(paizu2.get(i));
			player2.getPlayerPaiZu().add(paizu2.get(i + 13 * 1));
			player3.getPlayerPaiZu().add(paizu2.get(i + 13 * 2));
			player4.getPlayerPaiZu().add(paizu2.get(i + 13 * 3));
		}
	}

	public static void showPlayerString(List<MoJoPai> p, String who, Boolean isAdmin) {
		System.out.println("");
		System.out.println(who + ":");
		if (isAdmin) {
			for (MoJoPai pai : p) {
				System.out.print(pai.toString() + " ");
			}
		} else {
			for (MoJoPai pai : p) {
				System.out.print(pai.toPlayerString() + " ");
			}
		}
	}

}
