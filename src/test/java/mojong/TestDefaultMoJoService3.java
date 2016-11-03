package mojong;

import org.testng.annotations.Test;

import mojong.MoJoPai;

public class TestDefaultMoJoService3 {
	@Test
	public void TestIsFengPaiFunc() {
		DefaultMojongService mojongService = new DefaultMojongService();
		assert mojongService.isFengPai(new MoJoPai(MoJoPaiCode.DONG)) == true;
		assert mojongService.isFengPai(new MoJoPai(MoJoPaiCode.NAN)) == true;
		assert mojongService.isFengPai(new MoJoPai(MoJoPaiCode.XI)) == true;
		assert mojongService.isFengPai(new MoJoPai(MoJoPaiCode.BEI)) == true;
		assert mojongService.isFengPai(new MoJoPai(MoJoPaiCode.FA)) == false;
		assert mojongService.isFengPai(new MoJoPai(MoJoPaiCode.ZHONG)) == false;
		assert mojongService.isFengPai(new MoJoPai(MoJoPaiCode.WAN3)) == false;
		assert mojongService.isFengPai(new MoJoPai(MoJoPaiCode.SUO1)) == false;
		assert mojongService.isFengPai(new MoJoPai(MoJoPaiCode.SUO5)) == false;
		assert mojongService.isFengPai(new MoJoPai(MoJoPaiCode.WAN1)) == false;

	}
}
