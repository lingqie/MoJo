package mojong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultMojongService implements MojoService {
	private static List<MoJoPai> paizu;
	private static List<MoJoPai> paizu2;
	public static int zongPaiShu = 108 + 28;// 136
	public int[] n_zero = new int[34];

	// player pai 13*4
	// paishan 70
	// lingshang 14

	private static final Logger logger = LoggerFactory.getLogger(DefaultMojongService.class);

	@Override
	public List<MoJoPai> initDeafaultPaiZu() {
		paizu = new ArrayList<MoJoPai>();
		addMoJoPai();
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

	private static void addMoJoPai() {
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
	public Boolean isQiDuiZi(List<MoJoPai> player) {
		if (duiziCount(player) == 7) {
			return true;
		}
		return false;
	}

	public Boolean isWaitingQiDuiZi(List<MoJoPai> pais) {
		if (duiziCount(pais) != 6) {
			return false;
		}
		int[] array = analyse(toMoJoCodeArray(pais));
		int count = 0;
		for (int i = 0; i < 34; i++) {
			if (array[i] > 2) {
				count++;
			}
		}
		if (count > 0) {
			return false;
		}
		return true;

	}

	public int duiziCount(List<MoJoPai> pais) {
		int[] array = analyse(toMoJoCodeArray(pais));
		int qiduiziCount = 0;
		for (int i = 0; i < 34; i++) {
			if (array[i] == 2) {
				qiduiziCount++;
			}
		}
		return qiduiziCount;
	}

	@Override
	// TEST DONE
	public Boolean isGuoShiWuShuang(List<MoJoPai> player) {
		int yaojiuCount = countYaoJiu(player);
		ArrayList<MoJoPai> list = new ArrayList<MoJoPai>(new HashSet<MoJoPai>(player));
		// waiting yaojiu size 13 ,list size should be 12~13
		// ron yaojiu size 14,list size should be 13
		if (yaojiuCount >= 13 && list.size() == 13 && player.size() == 14) {
			return true;
		}
		return false;
	}

	public Boolean isWaitingGuoShiWuShuang(List<MoJoPai> pais) {
		int yaojiuCount = countYaoJiu(pais);
		ArrayList<MoJoPai> list = new ArrayList<MoJoPai>(new HashSet<MoJoPai>(pais));
		// waiting yaojiu size 13 ,list size should be 12~13
		// ron yaojiu size 14,list size should be 13
		if (yaojiuCount == 13 && list.size() >= 12 && pais.size() == 13) {
			return true;
		}
		return false;
	}

	private int countYaoJiu(List<MoJoPai> pais) {
		int yaojiuCount = 0;
		for (MoJoPai moJoPai : pais) {
			if (isYaoJiu(moJoPai)) {
				yaojiuCount++;
			}
		}
		return yaojiuCount;
	}

	public List<Integer> waitingForThisToGuoShiWuShuang(List<MoJoPai> pais) {
		List<Integer> result = new ArrayList<Integer>();
		ArrayList<MoJoPai> list = new ArrayList<MoJoPai>(new HashSet<MoJoPai>(pais));
		if (isWaitingGuoShiWuShuang(pais) && list.size() == 12) {
			int[] analyse = analyse(toMoJoCodeArray(pais));
			for (int i : MoJoPaiCode.YAOJIULIST) {
				if (analyse[i] == 0) {
					result.add(i);
				}
			}
		}
		if (isWaitingGuoShiWuShuang(pais) && list.size() == 13) {
			for (int i : MoJoPaiCode.YAOJIULIST) {
				result.add(i);
			}
		}
		return result;
	}

	public List<Integer> waitingForThisToQiDuiZi(List<MoJoPai> pais) {
		List<Integer> result = new ArrayList<Integer>();
		if (isWaitingQiDuiZi(pais)) {
			int[] array = analyse(toMoJoCodeArray(pais));
			for (int i = 0; i < 34; i++) {
				if (array[i] == 1) {
					result.add(i);
				}
			}
		}
		return result;
	}

	@Override
	// TEST DONE
	public Boolean isYaoJiu(MoJoPai pai) {
		if (ArrayUtils.contains(MoJoPaiCode.YAOJIULIST, pai.getCode())) {
			return true;
		}
		return false;
	}

	@Override
	// TEST DONE
	public Boolean isFengPai(MoJoPai pai) {
		if (ArrayUtils.contains(MoJoPaiCode.FENGPAILIST, pai.getCode())) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean isWaitingRon(List<MoJoPai> pais) {
		if (isWaitingGuoShiWuShuang(pais) || isWaitingQiDuiZi(pais) || !waitingForThisToAgari(pais).isEmpty()) {
			return true;
		}
		return false;
	}

	public Boolean isRon(List<MoJoPai> pais) {
		if (isGuoShiWuShuang(pais) || isQiDuiZi(pais) || !agari(analyse(toMoJoCodeArray(pais))).isEmpty()) {
			return true;
		}
		return false;
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

			// System.out.println("mpart"+mpart);
			// System.out.println("ppart"+ppart);
			// System.out.println("spart"+spart);
			// System.out.println("zpart"+zpart);

			create(list, mpart, -1);
			create(list, ppart, 8);
			create(list, spart, 17);
			create(list, zpart, 26);
			return list;
		}
		return null;
	}

	private void create(List<MoJoPai> list, String part, int type) {
		if (part != null) {
			for (int i = 0; i < part.length(); i++) {
				// System.out.println(Integer.valueOf(Character.getNumericValue(part.charAt(i)))+type);
				list.add(new MoJoPai(Integer.valueOf(Character.getNumericValue(part.charAt(i))) + type));
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

	@Override
	public int[] toMoJoCodeArray(List<MoJoPai> pais) {
		int[] ret = new int[pais.size()];
		Iterator<MoJoPai> iter = pais.iterator();
		for (int i = 0; iter.hasNext(); i++) {
			ret[i] = iter.next().getCode();
		}
		return ret;
	}

	@Override
	public List<Integer> waitingForThisToAgari(List<MoJoPai> pais) {
		int[] result = calculateWhichIsWaiting(pais);
		List<Integer> resultList = new ArrayList<Integer>();
		for (int i = 0; i < result.length; i++) {
			if (result[i] > 0) {
				resultList.add(i);
			}
		}
		return resultList;
	}

	@Override
	public List<Integer> waitingForThisToPeng(List<MoJoPai> pais) {
		int[] result = analyse(toMoJoCodeArray(pais));
		List<Integer> resultList = new ArrayList<Integer>();
		for (int i = 0; i < result.length; i++) {
			if (result[i] > 1&&result[i]>4) {
				resultList.add(i);
			}
		}
		return resultList;
	}

	@Override
	public List<Integer> waitingForThisToGang(List<MoJoPai> pais) {
		int[] result = analyse(toMoJoCodeArray(pais));
		List<Integer> resultList = new ArrayList<Integer>();
		for (int i = 0; i < result.length; i++) {
			if (result[i] > 2&& result[i]>4) {
				resultList.add(i);
			}
		}
		return resultList;
	}

	
	@Override
	public int[] calculateWhichIsWaiting(List<MoJoPai> pais) {
		int[] result = new int[34];
		for (int i = 0; i < 34; i++) {
			List<MoJoPai> tempPais = new ArrayList<MoJoPai>();
			tempPais.addAll(pais);
			tempPais.add(new MoJoPai(i));
			toSortPlayerPaizu(tempPais);
			int[] n = analyse(toMoJoCodeArray(tempPais));
			List<Integer[][]> ret = agari(n);
			if (!ret.isEmpty()) {
				result[i]++;
			}
		}
		return result;
	}

	@Override
	// 计算每种牌的个数。
	public int[] analyse(int[] hai) {

		int[] n = n_zero.clone();

		for (int i : hai) {
			n[i]++;
		}
		return n;
	}

	@Override
	public List<Integer[][]> agari(int[] n) {// 输入对应统计数
		List<Integer[][]> ret = new ArrayList<Integer[][]>();
		for (int i = 0; i < 34; i++) {
			for (int kotsu_first = 0; kotsu_first < 2; kotsu_first++) {
				Integer[] janto = new Integer[1];
				ArrayList<Integer> kotsu = new ArrayList<Integer>();
				ArrayList<Integer> shuntsu = new ArrayList<Integer>();

				int[] t = n.clone();// tonngji shu
				if (t[i] >= 2) { // t[0]>=2 man1>2
					// 雀頭をはじめに取り出す
					t[i] -= 2;
					janto[0] = i;

					if (kotsu_first == 0) {
						// 刻子を先に取り出す
						for (int j = 0; j < 34; j++) {
							if (t[j] >= 3) {
								t[j] -= 3;
								kotsu.add(j);
							}
						}
						// 順子を後に取り出す
						for (int a = 0; a < 3; a++) {
							for (int b = 0; b < 7;) {
								if (t[9 * a + b] >= 1 && t[9 * a + b + 1] >= 1 && t[9 * a + b + 2] >= 1) {
									t[9 * a + b]--;
									t[9 * a + b + 1]--;
									t[9 * a + b + 2]--;
									shuntsu.add(9 * a + b);
								} else {
									b++;
								}
							}
						}
					} else {
						// 順子を先に取り出す
						for (int a = 0; a < 3; a++) {
							for (int b = 0; b < 7;) {
								if (t[9 * a + b] >= 1 && t[9 * a + b + 1] >= 1 && t[9 * a + b + 2] >= 1) {
									t[9 * a + b]--;
									t[9 * a + b + 1]--;
									t[9 * a + b + 2]--;
									shuntsu.add(9 * a + b);
								} else {
									b++;
								}
							}
						}
						// 刻子を後に取り出す
						for (int j = 0; j < 34; j++) {
							if (t[j] >= 3) {
								t[j] -= 3;
								kotsu.add(j);
							}
						}
					}

					// 和了の形か調べる
					if (Arrays.equals(t, n_zero)) {// 所有牌用光了
						ret.add(new Integer[][] { janto, kotsu.toArray(new Integer[0]),
								shuntsu.toArray(new Integer[0]) });
					}
				}
			}
		}
		return ret;
	}

}
