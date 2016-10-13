package mojong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoJoManualTest {

	public static List<MoJoPai> paizu;
	public static List<MoJoPai> paizu2;
	public static List<MoJoPai> player1;
	public static List<MoJoPai> player2;
	public static List<MoJoPai> player3;
	public static List<MoJoPai> player4;
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
		DefaultMojongService mojongService = new DefaultMojongService();

		initDeafaultPaiZu();
		mojongService.showPai(paizu2, "zongpaizu", 4, true);
		initPlayerPai();

		mojongService.showPai(player1, "player", 1, true);
		mojongService.showPai(player2, "player", 1, true);
		mojongService.showPai(player3, "player", 1, true);
		mojongService.showPai(player4, "player", 1, true);

		initPaiShan();

		mojongService.showPai(paiShan, "paishan", 2, true);
		initLingShangPai();
		mojongService.showPai(lingShangPai, "lingshangpai", 2, true);

		// showPlayerString(player1, "player1", false);
		// showPlayerString(player1, "player1", true);

		long starttime = System.nanoTime();

		mojongService.toSortPlayerPaizu(player1);
		mojongService.toSortPlayerPaizu(player2);
		mojongService.toSortPlayerPaizu(player3);
		mojongService.toSortPlayerPaizu(player4);

		System.out.println("");
		System.out.println("player pai sort time:");
		System.out.println((System.nanoTime() - starttime) / 1000);

		mojongService.showPai(player1, "player1", 1, false);
		mojongService.showPai(player2, "player2", 1, false);
		mojongService.showPai(player3, "player3", 1, false);
		mojongService.showPai(player4, "player4", 1, false);

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
			player1.add(paizu2.get(i));
			player2.add(paizu2.get(i + 13 * 1));
			player3.add(paizu2.get(i + 13 * 2));
			player4.add(paizu2.get(i + 13 * 3));
		}
	}

	private static void initPaiShan() {
		for (int i = 13 * 4; i < zongPaiShu - 14; i++) {
			paiShan.add(paizu2.get(i));
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

	private static void initDeafaultPaiZu() {
		paizu = new ArrayList<MoJoPai>();
		paizu2 = new ArrayList<MoJoPai>();
		player1 = new ArrayList<MoJoPai>();
		player2 = new ArrayList<MoJoPai>();
		player3 = new ArrayList<MoJoPai>();
		player4 = new ArrayList<MoJoPai>();
		lingShangPai = new ArrayList<MoJoPai>();
		paiShan = new ArrayList<MoJoPai>();

		addMMoJoPai();
		addSMoJoPai();
		addPMoJoPai();
		addZMoJoPai();

		for (int i = 0; i < zongPaiShu; i++) {
			int num = new Random().nextInt(paizu.size());
			paizu2.add(paizu.get(num));
			paizu.remove(num);
		}

	}

	private static void addZMoJoPai() {
		addMoJoPai("1z");
		addMoJoPai("2z");
		addMoJoPai("3z");
		addMoJoPai("4z");
		addMoJoPai("5z");
		addMoJoPai("6z");
		addMoJoPai("7z");
	}

	private static void addPMoJoPai() {
		addMoJoPai("1p");
		addMoJoPai("2p");
		addMoJoPai("3p");
		addMoJoPai("4p");
		addRedMoJoPai("5p");
		addMoJoPai("6p");
		addMoJoPai("7p");
		addMoJoPai("8p");
		addMoJoPai("9p");
	}

	private static void addSMoJoPai() {
		addMoJoPai("1s");
		addMoJoPai("2s");
		addMoJoPai("3s");
		addMoJoPai("4s");
		addRedMoJoPai("5s");
		addMoJoPai("6s");
		addMoJoPai("7s");
		addMoJoPai("8s");
		addMoJoPai("9s");
	}

	private static void addMMoJoPai() {
		addMoJoPai("1m");
		addMoJoPai("2m");
		addMoJoPai("3m");
		addMoJoPai("4m");
		addRedMoJoPai("5m");
		addMoJoPai("6m");
		addMoJoPai("7m");
		addMoJoPai("8m");
		addMoJoPai("9m");
	}

	private static void addMoJoPai(String s) {
		paizu.add(new MoJoPai(s + "1", false, false));
		paizu.add(new MoJoPai(s + "2", false, false));
		paizu.add(new MoJoPai(s + "3", false, false));
		paizu.add(new MoJoPai(s + "4", false, false));
	}

	private static void addRedMoJoPai(String s) {
		paizu.add(new MoJoPai(s + "1", true, true));
		paizu.add(new MoJoPai(s + "2", false, false));
		paizu.add(new MoJoPai(s + "3", false, false));
		paizu.add(new MoJoPai(s + "4", false, false));
	}

}
