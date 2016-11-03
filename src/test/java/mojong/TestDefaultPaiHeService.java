package mojong;

import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultPaiHeService {
	@Test
	public void addInPaiHe() {
		DefaultPaiHeService paiHeService = new DefaultPaiHeService();
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("1111222233334z");
		Player player = new Player();
		PaiHe paiHe = new PaiHe();
		paiHe.setTruePaiZu(pais);
		player.setPaihe(paiHe);
		paiHeService.addInPaiHe(player, new MoJoPai(MoJoPaiCode.SUO5));
		assert mojongService.getPaiString(player.getPaihe().getTruePaiZu(), false)
				.equals("1z1z1z1z2z2z2z2z3z3z3z3z4z5s");
	}
}
