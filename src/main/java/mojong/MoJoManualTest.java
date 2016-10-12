package mojong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.builder.CompareToBuilder;;

public class MoJoManualTest {
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
		 System.out.println("paizu2:");
		 int sum = 0;
		 for (int i=0;i<zongPaiShu;i++) {
		 sum++;
		 System.out.print(paizu2.get(i).toString() + " ");
		 if (sum % (zongPaiShu/4) == 0) {
		 System.out.print("\n");
		 }
		 }
		for (int i = 0; i < 14; i++) {
			player.add(paizu2.get(i));
			player2.add(paizu2.get(i + 14));
			player3.add(paizu2.get(i + 28));
			player4.add(paizu2.get(i + 14 * 3));
		}
		for(int i=zongPaiShu-1;i>zongPaiShu-1-14;i--){
			lingShangPai.add(paizu2.get(i));
		}
		System.out.println(lingShangPai.size());
		for (MoJoPai pai : lingShangPai) {
			System.out.print(pai.toString()+" ");
		}

		// showAdminVersionString();
		// showPlayerVersionString();
		// System.out.println(isGreatter(new MoJoPai("1s", false, false), new
		// MoJoPai("1z", false, false)));
		// System.out.println(isGreatter(new MoJoPai("1s", false, false), new
		// MoJoPai("9z", false, false)));
		// System.out.println(isGreatter(new MoJoPai("9s", false, false), new
		// MoJoPai("1z", false, false)));
		// System.out.println(isGreatter(new MoJoPai("1z", false, false), new
		// MoJoPai("1s", false, false)));
		// System.out.println(isGreatter(new MoJoPai("1z", false, false), new
		// MoJoPai("9s", false, false)));
		// System.out.println(isGreatter(new MoJoPai("9z", false, false), new
		// MoJoPai("9z", false, false)));
		
//		toSortPlayerPaizu(player);
//		toSortPlayerPaizu(player2);
//		toSortPlayerPaizu(player3);
//		toSortPlayerPaizu(player4);
//		showAdminVersionString();
//		showPlayerVersionString();

	}
	
	
	
	private static void showPlayerVersionString() {
		showPlayer1VersionString();
		showPlayer2VersionString();
		showPlayer3VersionString();
		showPlayer4VersionString();
	}

	private static void showPlayer4VersionString() {
		System.out.println("");
		System.out.println("player4");
		for (MoJoPai pai : player4) {
			System.out.print(pai.toPlayerString() + " ");
		}
	}

	private static void showPlayer3VersionString() {
		System.out.println("");
		System.out.println("player3");
		for (MoJoPai pai : player3) {
			System.out.print(pai.toPlayerString() + " ");
		}
	}

	private static void showPlayer2VersionString() {
		System.out.println("");
		System.out.println("player2");
		for (MoJoPai pai : player2) {
			System.out.print(pai.toPlayerString() + " ");
		}
	}

	private static void showPlayer1VersionString() {
		System.out.println("");
		System.out.println("player");
		for (MoJoPai pai : player) {
			System.out.print(pai.toPlayerString() + " ");
		}
	}

	private static void showAdminVersionString() {
		showAdmin1VersionString();
		showAdmin2VersionString();
		showAdmin3VersionString();
		showAdmin4VersionString();
	}

	private static void showAdmin4VersionString() {
		System.out.println("");
		System.out.println("player4");
		for (MoJoPai pai : player4) {
			System.out.print(pai.toString() + " ");
		}
	}

	private static void showAdmin3VersionString() {
		System.out.println("");
		System.out.println("player3");
		for (MoJoPai pai : player3) {
			System.out.print(pai.toString() + " ");
		}
	}

	private static void showAdmin2VersionString() {
		System.out.println("");
		System.out.println("player2");
		for (MoJoPai pai : player2) {
			System.out.print(pai.toString() + " ");
		}
	}

	private static void showAdmin1VersionString() {
		System.out.println("");
		System.out.println("player");
		for (MoJoPai pai : player) {
			System.out.print(pai.toString() + " ");
		}
	}

	private static void initDeafaultPaiZu() {
		paizu = new ArrayList<MoJoPai>();
		paizu2 = new ArrayList<MoJoPai>();
		player = new ArrayList<MoJoPai>();
		player2 = new ArrayList<MoJoPai>();
		player3 = new ArrayList<MoJoPai>();
		player4 = new ArrayList<MoJoPai>();
		lingShangPai=new ArrayList<MoJoPai>();

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

	private static void toSortPlayerPaizu(List<MoJoPai> player) {
		int count = 1;
		// List<MoJoPai> sortedPai=new ArrayList<MoJoPai>();
		for (int j = 0; j < player.size(); j++) {
			for (int i = 0; i < player.size() - 1 - j; i++) {
				if (isGreatter(player.get(i), player.get(i + 1))) {
					MoJoPai tmp = player.get(i + 1);
					player.set(i + 1, player.get(i));
					player.set(i, tmp);
				}
				// System.out.print("di "+(count++)+" ci");
				// showPlayer1VersionString();
				// System.out.println("");
				// System.out.println("");
			}
		}

	}

	private static Boolean isGreatter(MoJoPai p1, MoJoPai p2) {
		char[] p1String = p1.toString().toCharArray();
		char[] p2String = p2.toString().toCharArray();

		if (p1String[1] > p2String[1]) {
			return true;
		}
		if (p1String[1] == p2String[1]) {
			if (p1String[0] > p2String[0]) {
				return true;
			}
			if (p1String[0] == p2String[0] && p1String[1] == p2String[1] && p1String[2] > p2String[2]) {
				return true;
			}
			return false;
		}
		return false;
	}

}
