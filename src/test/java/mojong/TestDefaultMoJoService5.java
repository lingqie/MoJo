package mojong;

import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService5 {
	@Test
	public void TestIsGuoShiWuShuang() {
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("19m19p19s12345677z");
		assert pais.size() == 14;
		List<MoJoPai> pais2 = mojongService.createMoJoPais("119m19p19s1234567z");
		List<MoJoPai> pais3 = mojongService.createMoJoPais("1199m1199p1199s11z");
		List<MoJoPai> pais4 = mojongService.createMoJoPais("9m19p19s12345677z");
		
		assert mojongService.isGuoShiWuShuang(pais) == true;
		assert mojongService.isGuoShiWuShuang(pais2) == true;
		assert mojongService.isGuoShiWuShuang(pais3) == false;
		assert mojongService.isGuoShiWuShuang(pais4) == false;
	}

}
