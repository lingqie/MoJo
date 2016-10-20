package mojong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		addMoJoPai("m");
		addMoJoPai("p");
		addMoJoPai("s");
		addZMoJoPai();
		List<MoJoPai> paizu2 = randomPaizu();
		return paizu2;
	}

	private List<MoJoPai> randomPaizu() {
		List<MoJoPai> paizu2 = new ArrayList<MoJoPai>();
		for (int i = 0; i < zongPaiShu; i++) {
			int num = new Random().nextInt(paizu.size());
			paizu2.add(paizu.get(num));
			paizu.remove(num);
		}
		return paizu2;
	}

	private static void addZMoJoPai() {
		for (int i = 1; i < 8; i++) {
			addMoJoPai(i, "z");
		}
	}

	private static void addMoJoPai(String type) {
		for (int i = 1; i < 10; i++) {
			if (i == 5) {
				addRedMoJoPai(5, type);
				continue;
			}
			addMoJoPai(i, type);
		}
	}

	private static void addMoJoPai(int s, String type) {
		for (int i = 0; i < 4; i++) {
			paizu.add(new MoJoPai(s, type, false, false));
		}
	}

	private static void addRedMoJoPai(int s, String type) {
		paizu.add(new MoJoPai(s, type, true, true));
		for (int i = 0; i < 3; i++) {
			paizu.add(new MoJoPai(s, type, false, false));
		}
	}

	@Override
	// TEST DONE
	public Boolean isGreatter(MoJoPai p1, MoJoPai p2) {

		if (p1.type.compareTo(p2.type) > 0) {
			return true;
		}
		if (p1.type.equals(p2.type)) {
			if (p1.code > p2.code) {
				return true;
			}
			if (p1.code == p2.code && p1.type.equals(p2.type) && p2.isRed) {
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
		if (qiduiziCount >= 6) {
			return true;
		}
		return false;
	}

	@Override
	// TEST DONE
	public Boolean isGuoShiWuShuang(List<MoJoPai> player) {
		int yaojiuCount = 0;
		for (MoJoPai moJoPai : paizu) {
			if (isYaoJiu(moJoPai)) {
				yaojiuCount++;
			}
		}
		ArrayList<MoJoPai> list = new ArrayList<MoJoPai>(new HashSet<MoJoPai>(paizu));
		// waiting yaojiu size 13 ,list size should be 12~13
		// reach yaojiu size 14,list size should be 13
		if (yaojiuCount >= 13 && list.size() >= 12) {
			return true;
		}
		return false;
	}

	@Override
	// TEST DONE
	public Boolean isYaoJiu(MoJoPai pai) {
		if (pai.code == 1 || pai.code == 9 || pai.type.equals("z")) {
			return true;
		}
		return false;
	}

	@Override
	//TEST DONE
	public Boolean isFengPai(MoJoPai pai) {
		if (pai.toPlayerString().equals("1z") || pai.toPlayerString().equals("2z")
				|| pai.toPlayerString().equals("3z")
				|| pai.toPlayerString().equals("4z")) 
		{
			return true;
		}
		return false;
	}

	@Override
	public Boolean isCanRon(List<MoJoPai> player) {

		return null;
	}

	// TEST DONE
	public List<MoJoPai> createMoJoPais(String text) {

		List<MoJoPai> list = new ArrayList<MoJoPai>();
		String pattern = "(\\d*m+)?(\\d*p+)?(\\d*s+)?(\\d*z+)?";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(text);
		if (m.find()) {// must judge
			String mpart = m.group(1);
			String ppart = m.group(2);
			String spart = m.group(3);
			String zpart = m.group(4);
			mpart = StringUtils.replace(mpart, "m", "");
			ppart = StringUtils.replace(ppart, "p", "");
			spart = StringUtils.replace(spart, "s", "");
			zpart = StringUtils.replace(zpart, "z", "");

			create(list, mpart, "m");
			create(list, ppart, "p");
			create(list, spart, "s");
			create(list, zpart, "z");
			return list;
		}
		return null;
	}

	private void create(List<MoJoPai> list, String part, String type) {
		if (part != null) {
			for (int i = 0; i < part.length(); i++) {
				list.add(new MoJoPai(Character.getNumericValue(part.charAt(i)), type));
			}
		}
	}
}
