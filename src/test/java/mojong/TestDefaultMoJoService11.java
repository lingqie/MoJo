package mojong;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService11 {
	@Test
	public void TestcalcWaitingGuoShiWuShuang() {
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("111m999p222s5577z");
		List<MoJoPai> pais2 = mojongService.createMoJoPais("19m19p19s1123456z");
		List<MoJoPai> pais3 = mojongService.createMoJoPais("19m19p19s1234567z");

		assert mojongService.waitingForThisToGuoShiWuShuang(pais).isEmpty();
		assert mojongService.waitingForThisToGuoShiWuShuang(pais2).equals(Arrays.asList(
				MoJoPaiCode.ZHONG));
		assert mojongService.waitingForThisToGuoShiWuShuang(pais3).equals(Arrays.asList(
				MoJoPaiCode.WAN1,MoJoPaiCode.WAN9,
				MoJoPaiCode.BIN1,MoJoPaiCode.BIN9,
				MoJoPaiCode.SUO1,MoJoPaiCode.SUO9,
				MoJoPaiCode.DONG,MoJoPaiCode.NAN,
				MoJoPaiCode.XI,MoJoPaiCode.BEI,
				MoJoPaiCode.BAI,MoJoPaiCode.FA,
				MoJoPaiCode.ZHONG
				));
	}
}
