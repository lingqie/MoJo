package mojong;

import java.util.List;

public class DefaultWangPaiService implements WangPaiService {
	@Override
	public MoJoPai getLastWangPai(WangPai wangpai){
		List<MoJoPai> wangpais = wangpai.getWangpais();
		MoJoPai pai = wangpais.get(wangpais.size()-1);
		return pai;
	}
	
	
	
	
}
