package mojong;
import mojong.MoJoPai;

public class TestIsYaoJiuFunc {
	public static void main(String[] args) {
		System.out.println(isYaoJiu(new MoJoPai(1,"z", 1)));
		System.out.println(isYaoJiu(new MoJoPai(7,"z", 1)));
		System.out.println(isYaoJiu(new MoJoPai(9,"s", 1)));
		System.out.println(isYaoJiu(new MoJoPai(1,"s", 1)));
		System.out.println(isYaoJiu(new MoJoPai(5,"s", 1)));
		System.out.println(isYaoJiu(new MoJoPai(1,"m", 1)));
		
	}
	
	public static Boolean isYaoJiu(MoJoPai pai) {
		if(pai.code==1||pai.code==9||pai.type.equals("z")){
			return true;
		}
		return false;
	}
}
