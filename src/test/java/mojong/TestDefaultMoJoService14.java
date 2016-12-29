package mojong;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService14 {
	@Test
	public void TestWaitForThisToPeng() {
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("1122334455667z");
		List<MoJoPai> pais2 = mojongService.createMoJoPais("11223344556677z");
		List<MoJoPai> pais3 = mojongService.createMoJoPais("1111222233344z");
		List<MoJoPai> pais4 = mojongService.createMoJoPais("19m19p19s1234567z");
		List<MoJoPai> pais5 = mojongService.createMoJoPais("123567m456p45s77z");
		List<MoJoPai> pais6 = mojongService.createMoJoPais("123567m456p345s77z");
		
		List<Integer> list = mojongService.waitingForThisToPeng(pais3);
		
//		for (Integer i : list) {
//			System.out.println(MoJoPaiCode.PAILIST[i]);
//		}
		
//		assert Arrays.asList(MoJoPaiCode.DONG, MoJoPaiCode.NAN,
//				MoJoPaiCode.XI, MoJoPaiCode.BEI, MoJoPaiCode.BAI, MoJoPaiCode.FA).containsAll(list);
		
		assert mojongService.waitingForThisToPeng(pais).equals(Arrays.asList(MoJoPaiCode.DONG, MoJoPaiCode.NAN,
				MoJoPaiCode.XI, MoJoPaiCode.BEI, MoJoPaiCode.BAI, MoJoPaiCode.FA));
		assert mojongService.waitingForThisToPeng(pais2).equals(Arrays.asList(MoJoPaiCode.DONG, MoJoPaiCode.NAN,
				MoJoPaiCode.XI, MoJoPaiCode.BEI, MoJoPaiCode.BAI, MoJoPaiCode.FA, MoJoPaiCode.ZHONG));
		assert mojongService.waitingForThisToPeng(pais3)
				.equals(Arrays.asList(MoJoPaiCode.BEI,MoJoPaiCode.XI));
		assert mojongService.waitingForThisToPeng(pais4).isEmpty();
		assert mojongService.waitingForThisToPeng(pais5).equals(Arrays.asList(MoJoPaiCode.ZHONG));
		assert mojongService.waitingForThisToPeng(pais6).equals(Arrays.asList(MoJoPaiCode.ZHONG));
		
	}
}
