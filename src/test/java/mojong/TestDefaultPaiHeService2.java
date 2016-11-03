package mojong;

import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultPaiHeService2 {
	@Test
	public void isContain() {
		DefaultPaiHeService paiHeService = new DefaultPaiHeService();
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("1111222233334z");

		Player player = new Player();
		PaiHe paiHe = new PaiHe();

		paiHe.setTruePaiZu(pais);
		player.setPaihe(paiHe);
		assert !paiHeService.isContain(player, new MoJoPai(MoJoPaiCode.SUO5));
		paiHeService.addInPaiHe(player, new MoJoPai(MoJoPaiCode.SUO5));
		assert paiHeService.isContain(player, new MoJoPai(MoJoPaiCode.SUO5));
	}
}
