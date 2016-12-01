package mojong;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService15 {
	@Test
	public void TestIsQiDuiZiWaiting() {
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("111133334446667z");
		List<MoJoPai> pais2 = mojongService.createMoJoPais("11223344556677z");
		List<MoJoPai> pais3 = mojongService.createMoJoPais("1111222233344z");
		List<MoJoPai> pais4 = mojongService.createMoJoPais("19m19p19s1234567z");

		assert mojongService.waitingForThisToGang(pais).equals(Arrays.asList(MoJoPaiCode.BEI, MoJoPaiCode.FA));
		assert mojongService.waitingForThisToGang(pais2).isEmpty();
		assert mojongService.waitingForThisToGang(pais3)
				.equals(Arrays.asList(MoJoPaiCode.NAN));
		assert mojongService.waitingForThisToGang(pais4).isEmpty();
	}
}
