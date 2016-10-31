package mojong;

import java.util.List;

public class MoJoManualTest {

	public static void main(String[] args) {
		Room room = new Room();
		DefaultMojongService mojongService = new DefaultMojongService();

		room.getMojoPaiZu().setPaizu(mojongService.initDeafaultPaiZu());

		mojongService.showPai(room.getMojoPaiZu().getPaizu(), "zongpaizu", 4, true);

		mojongService.initPlayerPai(room);

		List<MoJoPai> player1PaiZu = room.getPlayer1().getPlayerPaiZu();
		List<MoJoPai> player2PaiZu = room.getPlayer2().getPlayerPaiZu();
		List<MoJoPai> player3PaiZu = room.getPlayer3().getPlayerPaiZu();
		List<MoJoPai> player4PaiZu = room.getPlayer4().getPlayerPaiZu();

		showAllPlayerPaiZu(mojongService, player1PaiZu, player2PaiZu, player3PaiZu, player4PaiZu);

		mojongService.toSortPlayerPaizu(player1PaiZu);
		mojongService.toSortPlayerPaizu(player2PaiZu);
		mojongService.toSortPlayerPaizu(player3PaiZu);
		mojongService.toSortPlayerPaizu(player4PaiZu);

		// showAllPlayerPaiZu(mojongService, player1PaiZu, player2PaiZu,
		// player3PaiZu, player4PaiZu);
		mojongService.initPaiShan(room);
		mojongService.initWangPai(room);
		mojongService.showPai(room.getWangPai(), "lingshangpai", 2, true);
		mojongService.showPai(room.getPaiShan(), "Paishan", 2, true);
	}

	private static void showAllPlayerPaiZu(DefaultMojongService mojongService, List<MoJoPai> player1PaiZu,
			List<MoJoPai> player2PaiZu, List<MoJoPai> player3PaiZu, List<MoJoPai> player4PaiZu) {
		mojongService.showPai(player1PaiZu, "player1", 1, true);
		mojongService.showPai(player2PaiZu, "player2", 1, true);
		mojongService.showPai(player3PaiZu, "player3", 1, true);
		mojongService.showPai(player4PaiZu, "player4", 1, true);
	}
}
