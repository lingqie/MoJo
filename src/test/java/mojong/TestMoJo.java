package mojong;

import org.testng.annotations.Test;

import mojong.MoJoPai;

public class TestMoJo {
	@Test
	public void TestNewssMoJo() {

		assert new MoJoPai("1s").hashCode() == new MoJoPai("1s").hashCode();
		assert new MoJoPai("5s").hashCode() != new MoJoPai("1s").hashCode();
		assert new MoJoPai("R5s").hashCode() != new MoJoPai("5s").hashCode();
		assert new MoJoPai("1z").hashCode() == new MoJoPai("1z").hashCode();

		assert new MoJoPai("1s").equals(new MoJoPai("1s"));
		assert !new MoJoPai("1s").equals(new MoJoPai("1z"));
		assert !new MoJoPai("1s").equals(new MoJoPai("5s"));
		// now this time Red Pai and pai is equal
		assert new MoJoPai("R5s").equals((new MoJoPai("5s")));

		assert new MoJoPai("7z").toPlayerString().equals("7z");
		assert new MoJoPai("R5s").toPlayerString().equals("R5s");

	}
}
