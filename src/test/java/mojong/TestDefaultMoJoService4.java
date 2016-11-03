package mojong;

import org.testng.annotations.Test;

import mojong.MoJoPai;

public class TestDefaultMoJoService4 {
	@Test
	public void TestIsGreatterFunc() {
		DefaultMojongService mojongService = new DefaultMojongService();
		assert mojongService.isGreatter(new MoJoPai(MoJoPaiCode.SUO1), new MoJoPai(MoJoPaiCode.DONG)) == false;
		assert mojongService.isGreatter(new MoJoPai(MoJoPaiCode.SUO9), new MoJoPai(MoJoPaiCode.DONG)) == false;
		assert mojongService.isGreatter(new MoJoPai(MoJoPaiCode.DONG), new MoJoPai(MoJoPaiCode.SUO9)) == true;
		assert mojongService.isGreatter(new MoJoPai(MoJoPaiCode.BAI), new MoJoPai(MoJoPaiCode.BAI)) == false;
	}
}
