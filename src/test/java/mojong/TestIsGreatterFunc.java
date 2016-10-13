package mojong;
import mojong.MoJoPai;

public class TestIsGreatterFunc {
	public static void main(String[] args) {
		System.out.println(isGreatter(new MoJoPai("1s",1, false, false), new MoJoPai("1z",1, false, false)));
		System.out.println(isGreatter(new MoJoPai("1s",1, false, false), new MoJoPai("9z",1, false, false)));
		System.out.println(isGreatter(new MoJoPai("9s",1, false, false), new MoJoPai("1z",1, false, false)));
		System.out.println(isGreatter(new MoJoPai("1z",1, false, false), new MoJoPai("1s",1, false, false)));
		System.out.println(isGreatter(new MoJoPai("1z",1, false, false), new MoJoPai("9s",1, false, false)));
		System.out.println(isGreatter(new MoJoPai("9z",1, false, false), new MoJoPai("9z",1, false, false)));
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
