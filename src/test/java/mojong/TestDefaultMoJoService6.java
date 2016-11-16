package mojong;

import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService6 {
	@Test
	public void TestIsQiDuiZi() {
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("11223344556677z");
		List<MoJoPai> pais2 = mojongService.createMoJoPais("11223344m1234567z");
		List<MoJoPai> pais3 = mojongService.createMoJoPais("111122223333444455z");
		assert mojongService.isQiDuiZi(pais) == true;
		assert mojongService.isQiDuiZi(pais2) == false;
		assert mojongService.isQiDuiZi(pais3) == false;
	}

}
