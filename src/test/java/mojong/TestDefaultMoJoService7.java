package mojong;

import org.testng.annotations.Test;

public class TestDefaultMoJoService7 {
	@Test
	public void TestIsYaoJiuFunc() {
		DefaultMojongService mojongService = new DefaultMojongService();
		assert mojongService.isYaoJiu(new MoJoPai(MoJoPaiCode.DONG)) == true;
		assert mojongService.isYaoJiu(new MoJoPai(MoJoPaiCode.ZHONG)) == true;
		assert mojongService.isYaoJiu(new MoJoPai(MoJoPaiCode.SUO9)) == true;
		assert mojongService.isYaoJiu(new MoJoPai(MoJoPaiCode.SUO1)) == true;
		assert mojongService.isYaoJiu(new MoJoPai(MoJoPaiCode.SUO5)) == false;
		assert mojongService.isYaoJiu(new MoJoPai(MoJoPaiCode.WAN1)) == true;
	}

}
