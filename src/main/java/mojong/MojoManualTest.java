package mojong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MojoManualTest {

	public static List<MoJoPai> paizu;
	public static List<MoJoPai> paizu2;
	public static List<MoJoPai> player;
	public static List<MoJoPai> player2;
	public static List<MoJoPai> player3;
	public static List<MoJoPai> player4;
	public static List<MoJoPai> lingShangPai;
	public static int zongPaiShu = 108 + 28;

	public static void main(String[] args) {
		// for(int i=0;i<10;i++){
		// System.out.println(new Random().nextInt(2));
		// }
		initDeafaultPaiZu();
		// System.out.println("paizu:");
		// for (MoJoPai pai : paizu) {
		// System.out.println(pai.toString());
		// }

		// show random quanbu paizu
		// System.out.println("paizu2:");
		// int sum = 0;
		// for (int i=0;i<zongPaiShu;i++) {
		// sum++;
		// System.out.print(paizu2.get(i).toString() + " ");
		// if (sum % (zongPaiShu/4) == 0) {
		// System.out.print("\n");
		// }
		// }

		// fapai
		for (int i = 0; i < 14; i++) {
			player.add(paizu2.get(i));
			player2.add(paizu2.get(i + 14));
			player3.add(paizu2.get(i + 28));
			player4.add(paizu2.get(i + 14 * 3));
		}
		// get lingshang
		for (int i = zongPaiShu - 1; i > zongPaiShu - 1 - 14; i--) {
			lingShangPai.add(paizu2.get(i));
		}
		// show lingshang
		System.out.println(lingShangPai.size());
		for (MoJoPai pai : lingShangPai) {
			System.out.print(pai.toString() + " ");
		}

		showPlayerString(player, "player1", false);
		showPlayerString(player, "player1", true);

		// showAdminVersionString();
		// showPlayerVersionString();

		DefaultMojongService mojongService = new DefaultMojongService();
		mojongService.toSortPlayerPaizu(player);
		mojongService.toSortPlayerPaizu(player2);
		mojongService.toSortPlayerPaizu(player3);
		mojongService.toSortPlayerPaizu(player4);

		showAdminVersionString();
		showPlayerVersionString();

	}

	private static void showPlayerVersionString() {
		showPlayerString(player, "player1", false);
		showPlayerString(player2, "player2", false);
		showPlayerString(player3, "player3", false);
		showPlayerString(player4, "player4", false);
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

	private static void showAdminVersionString() {
		showPlayerString(player, "player1", true);
		showPlayerString(player2, "player2", true);
		showPlayerString(player3, "player3", true);
		showPlayerString(player4, "player4", true);
	}

	private static void initDeafaultPaiZu() {
		paizu = new ArrayList<MoJoPai>();
		paizu2 = new ArrayList<MoJoPai>();
		player = new ArrayList<MoJoPai>();
		player2 = new ArrayList<MoJoPai>();
		player3 = new ArrayList<MoJoPai>();
		player4 = new ArrayList<MoJoPai>();
		lingShangPai = new ArrayList<MoJoPai>();

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
