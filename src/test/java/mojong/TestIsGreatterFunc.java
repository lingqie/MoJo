package mojong;
import mojong.MoJoPai;

public class TestIsGreatterFunc {
	public static void main(String[] args) {
		System.out.println(isGreatter(new MoJoPai(1,"s",1), new MoJoPai(1,"z",1)));
		System.out.println(isGreatter(new MoJoPai(1,"s",1), new MoJoPai(9,"z",1)));
		System.out.println(isGreatter(new MoJoPai(9,"s",1), new MoJoPai(1,"z",1)));
		System.out.println(isGreatter(new MoJoPai(1,"z",1), new MoJoPai(1,"s",1)));
		System.out.println(isGreatter(new MoJoPai(1,"z",1), new MoJoPai(9,"s",1)));
		System.out.println(isGreatter(new MoJoPai(9,"z",1), new MoJoPai(9,"z",1)));
	}
	
	public static Boolean isGreatter(MoJoPai p1, MoJoPai p2) {
		

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
}
