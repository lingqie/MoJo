package mojong;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService8 {
	@Test
	public void TestToMoJoCodeArray() {
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("19m19p19s12345677z");
		List<MoJoPai> pais2 = mojongService.createMoJoPais("119m19p19s1234567z");
		List<MoJoPai> pais3 = mojongService.createMoJoPais("1199m1199p1199s11z");
		List<MoJoPai> pais4 = mojongService.createMoJoPais("9m19p19s12345677z");

		int[] moJoCodeArray = mojongService.toMoJoCodeArray(pais);
		int[] moJoCodeArray2 = mojongService.toMoJoCodeArray(pais2);
		int[] moJoCodeArray3 = mojongService.toMoJoCodeArray(pais3);
		int[] moJoCodeArray4 = mojongService.toMoJoCodeArray(pais4);
		
		assert Arrays.equals(moJoCodeArray, new int[]{0,8,9,17,18,26,27,28,29,30,31,32,33,33});
		assert Arrays.equals(moJoCodeArray2, new int[]{0,0,8,9,17,18,26,27,28,29,30,31,32,33});
		assert Arrays.equals(moJoCodeArray3, new int[]{0,0,8,8,9,9,17,17,18,18,26,26,27,27});
		assert Arrays.equals(moJoCodeArray4, new int[]{8,9,17,18,26,27,28,29,30,31,32,33,33});

	}

}
