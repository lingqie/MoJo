package mojong;

import java.util.List;

public class DefaultPaiHeService implements PaiHeService {

	@Override
	public Boolean isContain(Player player, MoJoPai pai) {
		List<MoJoPai> paiZu = player.getPaihe().getTruePaiZu();
		if (paiZu.contains(pai)) {
			return true;
		}
		return false;
	}

	@Override
	public void addInPaiHe(Player player, MoJoPai pai) {
		player.getPaihe().add(pai);
	}

}
