package mojong;
import mojong.MoJoPai;

public class TestIsYaoJiuFunc {
	public static void main(String[] args) {
		System.out.println(isYaoJiu(new MoJoPai("1z")));
		System.out.println(isYaoJiu(new MoJoPai("7z")));
		System.out.println(isYaoJiu(new MoJoPai("9s")));
		System.out.println(isYaoJiu(new MoJoPai("1s")));
		System.out.println(isYaoJiu(new MoJoPai("5s")));
		System.out.println(isYaoJiu(new MoJoPai("1m")));
		
	}
	
	public static Boolean isYaoJiu(MoJoPai pai) {
		if(pai.code==1||pai.code==9||pai.type.equals("z")){
			return true;
		}
		return false;
	}
}
