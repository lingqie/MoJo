package mojong;
import mojong.MoJoPai;

public class TestIsFengPaiFunc {
	public static void main(String[] args) {
		System.out.println(isFengPai(new MoJoPai("1z")));
		System.out.println(isFengPai(new MoJoPai("2z")));
		System.out.println(isFengPai(new MoJoPai("3z")));
		System.out.println(isFengPai(new MoJoPai("4z")));
		System.out.println(isFengPai(new MoJoPai("5z")));
		System.out.println(isFengPai(new MoJoPai("7z")));
		System.out.println(isFengPai(new MoJoPai("9s")));
		System.out.println(isFengPai(new MoJoPai("1s")));
		System.out.println(isFengPai(new MoJoPai("5s")));
		System.out.println(isFengPai(new MoJoPai("1m")));
		
	}
	
	public static Boolean isFengPai(MoJoPai pai) {
		if (pai.toPlayerString().equals("1z") || pai.toPlayerString().equals("2z")
				|| pai.toPlayerString().equals("3z")
				|| pai.toPlayerString().equals("4z")) 
		{
			return true;
		}
		return false;
	}
}
