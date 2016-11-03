package mojong;

import java.util.List;

public class MoJoManualTest {

	public static void main(String[] args) {
		Room room = new Room();
		DefaultMojongService mojongService = new DefaultMojongService();
		DefaultPaiShanService paishanService = new DefaultPaiShanService();

		init(room, mojongService);

		mojongService.showPai(room.getMojoPaiZu().getPaizu(), "zongpaizu", 4, true);

		List<MoJoPai> player1PaiZu = room.getPlayer1().getPlayerPaiZu();
		List<MoJoPai> player2PaiZu = room.getPlayer2().getPlayerPaiZu();
		List<MoJoPai> player3PaiZu = room.getPlayer3().getPlayerPaiZu();
		List<MoJoPai> player4PaiZu = room.getPlayer4().getPlayerPaiZu();

		showAllPlayerPaiZu(mojongService, player1PaiZu, player2PaiZu, player3PaiZu, player4PaiZu);

		mojongService.toSortPlayerPaizu(player1PaiZu);
		mojongService.toSortPlayerPaizu(player2PaiZu);
		mojongService.toSortPlayerPaizu(player3PaiZu);
		mojongService.toSortPlayerPaizu(player4PaiZu);

		showAllPlayerPaiZu(mojongService, player1PaiZu, player2PaiZu, player3PaiZu, player4PaiZu);
		

//		paishanService.fapai(room.getPlayer1(), room.getMojoPaiZu().getPaiShan());
		// judge is can ron ro
		// judge is can reach lizhi
		// judge is can gang -lingshangkaihua
		// she pai ,next player turn
		// other player judge can peng chi,ron
//		mojongService.toSortPlayerPaizu(room.getPlayer1());

//		showAllPlayerPaiZu(mojongService, player1PaiZu, player2PaiZu, player3PaiZu, player4PaiZu);

		// mojongService.showPai(room.getWangPai(), "lingshangpai", 2, true);
		// mojongService.showPai(room.getPaiShan(), "Paishan", 2, true);
	}

	private static void init(Room room, DefaultMojongService mojongService) {
		room.getMojoPaiZu().setPaizu(mojongService.initDeafaultPaiZu());
		mojongService.initPlayerPai(room);
		mojongService.initPaiShan(room);
		mojongService.initWangPai(room);
	}

	private static void showAllPlayerPaiZu(DefaultMojongService mojongService, List<MoJoPai> player1PaiZu,
			List<MoJoPai> player2PaiZu, List<MoJoPai> player3PaiZu, List<MoJoPai> player4PaiZu) {
		mojongService.showPai(player1PaiZu, "player1", 1, true);
		mojongService.showPai(player2PaiZu, "player2", 1, true);
		mojongService.showPai(player3PaiZu, "player3", 1, true);
		mojongService.showPai(player4PaiZu, "player4", 1, true);
	}
}
