package mojong;
import mojong.MoJoPai;

public class TestMoJo {
	public static void main(String[] args) {
		System.out.println(new MoJoPai("1s", false, false).hashCode());
		System.out.println(new MoJoPai("1s", false, false).hashCode());
		System.out.println(new MoJoPai("5s", false, false).hashCode());
		System.out.println(new MoJoPai("1z", false, false).hashCode());
		
		System.out.println(new MoJoPai("1s", false, false).equals((new MoJoPai("1s", false, false))));
		System.out.println(new MoJoPai("1s", false, false).equals((new MoJoPai("5s", false, false))));
		System.out.println(new MoJoPai("5s", true, true).equals((new MoJoPai("5s", false, false))));
		System.out.println(new MoJoPai("5s", false, true).equals((new MoJoPai("5s", false, false))));
		System.out.println(new MoJoPai("5s", true, false).equals((new MoJoPai("5s", false, false))));

	}
	
	
}
