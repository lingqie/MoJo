package mojong;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService12 {
	@Test
	public void TestIsQiDuiZiWaiting() {
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("1122334455667z");
		List<MoJoPai> pais2 = mojongService.createMoJoPais("11223344m1234567z");
		List<MoJoPai> pais3 = mojongService.createMoJoPais("1111222233334z");
		List<MoJoPai> pais4 = mojongService.createMoJoPais("1122344556677z");
		assert mojongService.isWaitingQiDuiZi(pais) == true;
		assert mojongService.waitingForThisToQiDuiZi(pais).equals(Arrays.asList(MoJoPaiCode.ZHONG));
		assert mojongService.isWaitingQiDuiZi(pais2) == false;
		assert mojongService.waitingForThisToQiDuiZi(pais2).isEmpty();
		assert mojongService.isWaitingQiDuiZi(pais3) == false;
		assert mojongService.waitingForThisToQiDuiZi(pais3).isEmpty();
		assert mojongService.isWaitingQiDuiZi(pais4) == true;
		assert mojongService.waitingForThisToQiDuiZi(pais4).equals(Arrays.asList(MoJoPaiCode.XI));
	}

}
