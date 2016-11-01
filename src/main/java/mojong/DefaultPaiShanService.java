package mojong;

import org.springframework.beans.factory.annotation.Autowired;

public class DefaultPaiShanService implements PaiShanService {
	
	@Autowired
	private DefaultMojongService mojongService;
	public void fapai(Player player,PaiShan paishan){
		player.getPlayerPaiZu().add(paishan.getFirstMoJo());
	}
	

}
