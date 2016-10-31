package mojong;

import java.util.List;

public class PaiZu {
	public List<MoJoPai> paizu;
	public PaiShan paiShan;
	public WangPai wangPai;

	public PaiZu() {
		this.paiShan = new PaiShan();
		this.wangPai = new WangPai();
	}

	public PaiShan getPaiShan() {
		return paiShan;
	}

	public void setPaiShan(PaiShan paiShan) {
		this.paiShan = paiShan;
	}

	public WangPai getWangPai() {
		return wangPai;
	}

	public void setWangPai(WangPai wangPai) {
		this.wangPai = wangPai;
	}

	public List<MoJoPai> getPaizu() {
		return paizu;
	}

	public void setPaizu(List<MoJoPai> paizu) {
		this.paizu = paizu;
	}

}
