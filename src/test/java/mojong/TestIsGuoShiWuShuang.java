package mojong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.wicket.util.string.IStringSequence;

import mojong.MoJoPai;

public class TestIsGuoShiWuShuang {
	public static void main(String[] args) {
		DefaultMojongService mojongService = new DefaultMojongService();

		List<MoJoPai> pais = mojongService.createMoJoPais("19m19p19s1234567z");
		List<MoJoPai> pais2 = mojongService.createMoJoPais("119m19p19s123456z");
		List<MoJoPai> pais3 = mojongService.createMoJoPais("1199m1199p1199s11z");
		List<MoJoPai> pais4 = mojongService.createMoJoPais("9m19p19s12345677z");

		System.out.println(isGuoShiWuShuang(pais));
		System.out.println(isGuoShiWuShuang(pais2));
		System.out.println(isGuoShiWuShuang(pais3));
		System.out.println(isGuoShiWuShuang(pais4));

	}

	public static Boolean isGuoShiWuShuang(List<MoJoPai> paizu) {
		int yaojiuCount = 0;
		for (MoJoPai moJoPai : paizu) {
			if (isYaoJiu(moJoPai)) {
				yaojiuCount++;
			}
		}
		// System.out.println("yaojiucount"+yaojiuCount);
		// showPai(paizu, "paizu", 1, false);
		ArrayList<MoJoPai> list = new ArrayList<MoJoPai>(new HashSet<MoJoPai>(paizu));
		// showPai(list, "quchonglist", 1, false);
		// waiting yaojiu size 13 ,list size should be 12~13
		// reach yaojiu size 14,list size should be 13
		if (yaojiuCount >= 13 && list.size() >= 12) {
			return true;
		}

		return false;

	}

	public static Boolean isYaoJiu(MoJoPai pai) {
		if (pai.code == 1 || pai.code == 9 || pai.type.equals("z")) {
			return true;
		}
		return false;
	}

	public static void showPai(List<MoJoPai> all, String name, int line, Boolean isAdmin) {
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

}
