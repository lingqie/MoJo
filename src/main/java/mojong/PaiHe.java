package mojong;

import java.util.ArrayList;
import java.util.List;

public class PaiHe {
	public List<MoJoPai> truePaiZu;

	public PaiHe() {
		this.truePaiZu = new ArrayList<MoJoPai>();
	}

	public List<MoJoPai> getVisualPaiHe() {
		List<MoJoPai> visualPaihe = new ArrayList<MoJoPai>();
		for (MoJoPai moJoPai : truePaiZu) {
			if (moJoPai.getIsCanLook()) {
				visualPaihe.add(moJoPai);
			}
		}
		return visualPaihe;
	}

	public List<MoJoPai> getTruePaiZu() {
		return truePaiZu;
	}

	public void setTruePaiZu(List<MoJoPai> truePaiZu) {
		this.truePaiZu = truePaiZu;
	}

	public void add(MoJoPai pai) {
		this.truePaiZu.add(pai);
	}
}
