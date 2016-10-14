package mojong;

import mojong.MoJoPai;

public class TestMoJo {
	public static void main(String[] args) {
		System.out.println(new MoJoPai(1,"s",1).hashCode());
		System.out.println(new MoJoPai(1,"s",1).hashCode());
		System.out.println(new MoJoPai(1,"s",2).hashCode());
		System.out.println(new MoJoPai(5,"s",1).hashCode());
		System.out.println(new MoJoPai(1,"z",1).hashCode());

		System.out.println(new MoJoPai(1,"s",1).equals((new MoJoPai(1,"s",1))));
		System.out.println(new MoJoPai(1,"s",1).equals((new MoJoPai(1,"s",2))));
		System.out.println(new MoJoPai(1,"s",1).equals((new MoJoPai(5,"s",1))));
		System.out.println(new MoJoPai(5,"s",1, true, true).equals((new MoJoPai(5,"s",1))));

	}
}
