package mojong;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService10 {
	@Test
	public void TestcalcWaiting() {
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("111m999p222s5577z");
		List<MoJoPai> pais2 = mojongService.createMoJoPais("1112345678999m");

		assert mojongService.waitingForThisToAgari(pais).equals(Arrays.asList(MoJoPaiCode.BAI,MoJoPaiCode.ZHONG));
		assert mojongService.waitingForThisToAgari(pais2).equals(Arrays.asList(
				MoJoPaiCode.WAN1,MoJoPaiCode.WAN2,MoJoPaiCode.WAN3,
				MoJoPaiCode.WAN4,MoJoPaiCode.WAN5,MoJoPaiCode.WAN6,
				MoJoPaiCode.WAN7,MoJoPaiCode.WAN8,MoJoPaiCode.WAN9));
		
	}
}
