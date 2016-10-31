package mojong;

import java.util.ArrayList;
import java.util.List;

public class PaiShan {
	public List<MoJoPai> paishan;
	
	public PaiShan(){
		this.paishan=new ArrayList<MoJoPai>(); 
	}
	
	public List<MoJoPai> getPaiShan() {
		return paishan;
	}

	public void setPaiShan(List<MoJoPai> playerShan) {
		this.paishan = playerShan;
	}
	
}
