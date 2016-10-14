package mojong;

import mojong.MoJoPai;

public class TestMoJo {
	public static void main(String[] args) {
		System.out.println(new MoJoPai(1,"s",1, false, false).hashCode());
		System.out.println(new MoJoPai(1,"s",1, false, false).hashCode());
		System.out.println(new MoJoPai(1,"s",2, false, false).hashCode());
		System.out.println(new MoJoPai(5,"s",1, false, false).hashCode());
		System.out.println(new MoJoPai(1,"z",1, false, false).hashCode());

		System.out.println(new MoJoPai(1,"s",1, false, false).equals((new MoJoPai(1,"s",1, false, false))));
		System.out.println(new MoJoPai(1,"s",1, false, false).equals((new MoJoPai(1,"s",2, false, false))));
		System.out.println(new MoJoPai(1,"s",1, false, false).equals((new MoJoPai(5,"s",1, false, false))));
		System.out.println(new MoJoPai(5,"s",1, true, true).equals((new MoJoPai(5,"s",1, false, false))));

	}
}
