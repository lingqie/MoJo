package mojong;

import java.util.Arrays;

import org.testng.annotations.Test;

import mojong.MoJoPai;

public class TestMoJo {

	@Test
	public void TestNewsMoJo() {

		assert new MoJoPai(MoJoPaiCode.SUO1).hashCode() == new MoJoPai(MoJoPaiCode.SUO1).hashCode();
		assert new MoJoPai(MoJoPaiCode.SUO5).hashCode() != new MoJoPai(MoJoPaiCode.SUO1).hashCode();
		assert new MoJoPai(MoJoPaiCode.DONG).hashCode() == new MoJoPai(MoJoPaiCode.DONG).hashCode();

		assert new MoJoPai(MoJoPaiCode.SUO1).equals(new MoJoPai(MoJoPaiCode.SUO1));
		assert !new MoJoPai(MoJoPaiCode.SUO1).equals(new MoJoPai(MoJoPaiCode.DONG));
		assert !new MoJoPai(MoJoPaiCode.SUO1).equals(new MoJoPai(MoJoPaiCode.SUO5));

		assert new MoJoPai(MoJoPaiCode.ZHONG).toPlayerString().equals("7z");

	}

}
