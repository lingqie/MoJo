package mojong;

public class DefaultPaiShanService implements PaiShanService {

	public void fapai(Player player, PaiShan paishan) {
		if(paishan.getFirstMoJo()!=null){
			player.getPlayerPaiZu().add(paishan.getFirstMoJo());
		}
	}

}
