package mojong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DefaultMojongService implements MojoService {
	private static List<MoJoPai> paizu;
	private static List<MoJoPai> paizu2;
	public static int zongPaiShu = 108 + 28;// 136
	// player pai 13*4
	// paishan 70
	// lingshang 14

	@Override
	public List<MoJoPai> initDeafaultPaiZu() {
		paizu = new ArrayList<MoJoPai>();
		addMoJoPai("m");
		paizu2 = randomPaizu();
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

	private static void addMoJoPai(String type) {
		for (int i = 0; i < 34; i++) {
			addMoJoPai(i);
		}
	}

	private static void addMoJoPai(int s) {
		for (int i = 0; i < 4; i++) {
			paizu.add(new MoJoPai(s, false, false));
		}
	}

	@Override
	// TEST DONE
	public Boolean isGreatter(MoJoPai p1, MoJoPai p2) {
		if (p1.code > p2.code) {
			return true;
		}
		if (p1.code == p2.code && p2.isRed) {
			return true;
		}
		return false;
	}

	@Override
	public void toSortPlayerPaizu(List<MoJoPai> player) {
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
	public void toSortPlayerPaizu(Player player) {
		for (int j = 0; j < player.getPlayerPaiZu().size(); j++) {
			for (int i = 0; i < player.getPlayerPaiZu().size() - 1 - j; i++) {
				if (isGreatter(player.getPlayerPaiZu().get(i), player.getPlayerPaiZu().get(i + 1))) {
					MoJoPai tmp = player.getPlayerPaiZu().get(i + 1);
					player.getPlayerPaiZu().set(i + 1, player.getPlayerPaiZu().get(i));
					player.getPlayerPaiZu().set(i, tmp);
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
	public String getPaiString(List<MoJoPai> all, Boolean isAdmin) {
		String s = new String();
		for (MoJoPai moJoPai : all) {
			if (isAdmin) {
				s = s + moJoPai.toString();
			} else {
				s = s + moJoPai.toPlayerString();
			}

		}
		return s;
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
		for (MoJoPai moJoPai : player) {
			if (isYaoJiu(moJoPai)) {
				yaojiuCount++;
			}
		}
		ArrayList<MoJoPai> list = new ArrayList<MoJoPai>(new HashSet<MoJoPai>(player));
		// waiting yaojiu size 13 ,list size should be 12~13
		// ron yaojiu size 14,list size should be 13
		if (yaojiuCount >= 13 && list.size() == 13&& player.size()==14) {
			return true;
		}
		return false;
	}

	@Override
	// TEST DONE
	public Boolean isYaoJiu(MoJoPai pai) {
		
		if(ArrayUtils.contains(MoJoPaiCode.YAOJIULIST, pai.getCode())){;
			return true;
		}
		return false;
	}

	@Override
	// TEST DONE
	public Boolean isFengPai(MoJoPai pai) {
		if(ArrayUtils.contains(MoJoPaiCode.FENGPAILIST, pai.getCode())){;
		return true;
	}
	return false;
	}

	@Override
	public Boolean isCanRon(List<MoJoPai> player) {
		//1fan duanyao
		//hunyise
		//qingyise
		
		
		return null;
	}

	@Override
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
			
			System.out.println("mpart"+mpart);
			System.out.println("ppart"+ppart);
			System.out.println("spart"+spart);
			System.out.println("zpart"+zpart);
			
			create(list, mpart, -1);
			create(list, ppart, 8);
			create(list, spart, 17);
			create(list, zpart, 26);
			return list;
		}
		return null;
	}

	// public String createMoJoPaisText(List<MoJoPai> pais){
	// String s=new String();
	// for (MoJoPai moJoPai : pais) {
	// s=s+moJoPai.toPlayerString();
	// }
	// return s;
	// }

	private void create(List<MoJoPai> list, String part, int type) {
		if (part != null) {
			for (int i = 0; i < part.length(); i++) {
				System.out.println(Integer.valueOf(Character.getNumericValue(part.charAt(i)))+type);
				list.add(new MoJoPai(Integer.valueOf(Character.getNumericValue(part.charAt(i)))+type));
			}
		}
	}

	@Override
	public void initPlayerPai(Room room) {
		// fapai
		List<MoJoPai> paizu2 = room.getMojoPaiZu().getPaizu();
		for (int i = 0; i < 13; i++) {
			room.getPlayer1().getPlayerPaiZu().add(paizu2.get(i));
			room.getPlayer2().getPlayerPaiZu().add(paizu2.get(i + 13 * 1));
			room.getPlayer3().getPlayerPaiZu().add(paizu2.get(i + 13 * 2));
			room.getPlayer4().getPlayerPaiZu().add(paizu2.get(i + 13 * 3));
		}
	}

	@Override
	public void initWangPai(Room room) {
		for (int i = zongPaiShu - 14; i < zongPaiShu; i++) {
			room.getWangPai().add(paizu2.get(i));
		}
	}

	@Override
	public void initPaiShan(Room room) {
		for (int i = 13 * 4; i < zongPaiShu - 14; i++) {
			room.getPaiShan().add(paizu2.get(i));
		}
	}

}
