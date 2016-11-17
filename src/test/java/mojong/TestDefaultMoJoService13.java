package mojong;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService13 {
	@Test
	public void TestIsQiDuiZiWaiting() {
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("1122334455667z");
		List<MoJoPai> pais2 = mojongService.createMoJoPais("11223344556677z");
		List<MoJoPai> pais3 = mojongService.createMoJoPais("19m19p19s1234567z");
		List<MoJoPai> pais4 = mojongService.createMoJoPais("19m19p19s12345567z");
		List<MoJoPai> pais5 = mojongService.createMoJoPais("123567m456p45s77z");
		List<MoJoPai> pais6 = mojongService.createMoJoPais("123567m456p345s77z");
		assert mojongService.isWaitingRon(pais);
		assert mojongService.isRon(pais2);
		assert mojongService.isWaitingRon(pais3);
		assert mojongService.isRon(pais4);
		assert mojongService.isWaitingRon(pais5);
		assert mojongService.isRon(pais6);
		
		

	}

}
