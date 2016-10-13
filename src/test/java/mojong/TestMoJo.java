package mojong;

import mojong.MoJoPai;

public class TestMoJo {
	public static void main(String[] args) {
		System.out.println(new MoJoPai("1s",1, false, false).hashCode());
		System.out.println(new MoJoPai("1s",1, false, false).hashCode());
		System.out.println(new MoJoPai("1s",2, false, false).hashCode());
		System.out.println(new MoJoPai("5s",1, false, false).hashCode());
		System.out.println(new MoJoPai("1z",1, false, false).hashCode());

		System.out.println(new MoJoPai("1s",1, false, false).equals((new MoJoPai("1s",1, false, false))));
		System.out.println(new MoJoPai("1s",1, false, false).equals((new MoJoPai("1s",2, false, false))));
		System.out.println(new MoJoPai("1s",1, false, false).equals((new MoJoPai("5s",1, false, false))));
		System.out.println(new MoJoPai("5s",1, true, true).equals((new MoJoPai("5s",1, false, false))));

	}
}
