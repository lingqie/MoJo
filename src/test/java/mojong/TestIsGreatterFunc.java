package mojong;
import mojong.MoJoPai;

public class TestIsGreatterFunc {
	public static void main(String[] args) {
//		System.out.println(isGreatter(new MoJoPai("1s"), new MoJoPai("1z")));
//		System.out.println(isGreatter(new MoJoPai("1s"), new MoJoPai("9z")));
//		System.out.println(isGreatter(new MoJoPai("9s"), new MoJoPai("1z")));
//		System.out.println(isGreatter(new MoJoPai("1z"), new MoJoPai("9s")));
		System.out.println(isGreatter(new MoJoPai("5z"), new MoJoPai("5z")));
		System.out.println(isGreatter(new MoJoPai("R5s"), new MoJoPai("5s")));
		System.out.println(isGreatter(new MoJoPai("5s"), new MoJoPai("R5s")));
		System.out.println(isGreatter(new MoJoPai("6s"), new MoJoPai("R5s")));
		
		
	}
	
	public static Boolean isGreatter(MoJoPai p1, MoJoPai p2) {
		

		if (p1.type.compareTo(p2.type)>0) {
			return true;
		}
		if (p1.type.equals(p2.type)) {
			if (p1.code > p2.code) {
				return true;
			}
//			System.out.println("judge:");
//			System.out.println(p1.code== p2.code && p1.type.equals( p2.type) && p2.isRed);
			if (p1.code== p2.code && p1.type.equals( p2.type) && p2.isRed) {
				return true;
			}
			return false;
		}
		return false;
	}
}
