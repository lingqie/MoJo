package mojong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DefaultMojongService implements MojoService {
	private static List<MoJoPai> paizu;
	public static int zongPaiShu = 108 + 28;
	// player pai 13*4
	// paishan 70
	// lingshang 14
	
	@Override
	public List<MoJoPai> initDeafaultPaiZu() {
		paizu = new ArrayList<MoJoPai>();
		addMMoJoPai();
		addSMoJoPai();
		addPMoJoPai();
		addZMoJoPai();
		List<MoJoPai> paizu2 = new ArrayList<MoJoPai>();
		for (int i = 0; i < zongPaiShu; i++) {
			int num = new Random().nextInt(paizu.size());
			paizu2.add(paizu.get(num));
			paizu.remove(num);
		}
		return paizu2;
	}
	

	private static void addZMoJoPai() {
		addMoJoPai(1,"z");
		addMoJoPai(2,"z");
		addMoJoPai(3,"z");
		addMoJoPai(4,"z");
		addMoJoPai(5,"z");
		addMoJoPai(6,"z");
		addMoJoPai(7,"z");
		
	}

	private static void addPMoJoPai() {
		addMoJoPai(1,"p");
		addMoJoPai(2,"p");
		addMoJoPai(3,"p");
		addMoJoPai(4,"p");
		addRedMoJoPai(5,"p");
		addMoJoPai(6,"p");
		addMoJoPai(7,"p");
		addMoJoPai(8,"p");
		addMoJoPai(9,"p");
		
	}

	private static void addSMoJoPai() {
		addMoJoPai(1,"s");
		addMoJoPai(2,"s");
		addMoJoPai(3,"s");
		addMoJoPai(4,"s");
		addRedMoJoPai(5,"s");
		addMoJoPai(6,"s");
		addMoJoPai(7,"s");
		addMoJoPai(8,"s");
		addMoJoPai(9,"s");
		
	}

	private static void addMMoJoPai() {
		addMoJoPai(1,"m");
		addMoJoPai(2,"m");
		addMoJoPai(3,"m");
		addMoJoPai(4,"m");
		addRedMoJoPai(5,"m");
		addMoJoPai(6,"m");
		addMoJoPai(7,"m");
		addMoJoPai(8,"m");
		addMoJoPai(9,"m");
		
	}

	private static void addMoJoPai(int s,String type) {
		paizu.add(new MoJoPai(s ,type, 1, false, false));
		paizu.add(new MoJoPai(s ,type, 2, false, false));
		paizu.add(new MoJoPai(s ,type, 3, false, false));
		paizu.add(new MoJoPai(s ,type, 4, false, false));
	}

	private static void addRedMoJoPai(int s,String type) {
		paizu.add(new MoJoPai(s ,type, 1, true, true));
		paizu.add(new MoJoPai(s ,type, 2, false, false));
		paizu.add(new MoJoPai(s ,type, 3, false, false));
		paizu.add(new MoJoPai(s ,type, 4, false, false));
	}

	@Override
	public Boolean isGreatter(MoJoPai p1, MoJoPai p2) {
		

		if (p1.type.compareTo(p2.type)>0) {
			return true;
		}
		if (p1.type == p2.type) {
			if (p1.code > p2.code) {
				return true;
			}
			if (p1.code== p2.code && p1.type.equals( p2.type) && p1.num > p2.num) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public void toSortPlayerPaizu(List<MoJoPai> player) {
		int count = 1;
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

	@Override
	public void showPai(List<MoJoPai> all, String name, int line, Boolean isAdmin) {
		if (line <= 0) {
			System.out.println("can't put out " + line + "line");
		}
		System.out.println(name + ":");
		int sum = 0;
		for (int i = 0; i < all.size(); i++) {
			sum++;
			System.out.print(all.get(i).getShowTest(isAdmin) + " ");
			if (sum % (all.size() / line) == 0) {
				System.out.print("\n");
			}
		}
	}

	@Override
	public Boolean isQiDuiZiWaiting(List<MoJoPai> player) {
		int qiduiziCount = 0;
		for (int i = 0; i < player.size() - 1; i++) {
			if (player.get(i).equals(player.get(i + 1))) {
				qiduiziCount++;
			}
		}
		if (qiduiziCount == 6) {
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean isYaoJiu(MoJoPai pai) {
		if(pai.code==1||pai.code==9||pai.type.equals("z")){
			return true;
		}
		return false;
	}

	
}
