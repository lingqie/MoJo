package mojong;

import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService2 {
	@Test
	public void TestGetPaiString() {
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("1111222233334z");
		assert mojongService.getPaiString(pais, false).equals("1z1z1z1z2z2z2z2z3z3z3z3z4z") : mojongService
				.getPaiString(pais, true);
		assert mojongService.getPaiString(pais, true).equals("1zF1zF1zF1zF2zF2zF2zF2zF3zF3zF3zF3zF4zF") : mojongService
				.getPaiString(pais, true);

	}

}
