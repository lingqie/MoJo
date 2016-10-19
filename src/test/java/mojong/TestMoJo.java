package mojong;

import mojong.MoJoPai;

public class TestMoJo {
	public static void main(String[] args) {
		System.out.println(new MoJoPai("1s").hashCode());
		System.out.println(new MoJoPai("5s").hashCode());
		System.out.println(new MoJoPai("R5s").hashCode());
		System.out.println(new MoJoPai("1z").hashCode());

		System.out.println(new MoJoPai("1s").equals((new MoJoPai("1s"))));
		System.out.println(new MoJoPai("1s").equals((new MoJoPai("1z"))));
		System.out.println(new MoJoPai("1s").equals((new MoJoPai("5s"))));
		//now this time Red Pai and pai is equal
		System.out.println(new MoJoPai("R5s").equals((new MoJoPai("5s"))));
		
		System.out.println(new MoJoPai("7z").toPlayerString());
		System.out.println(new MoJoPai("R5s").toPlayerString());

	}
}
