package mojong;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DefaultMojongService implements MojoService {

	@Override
	public Boolean isGreatter(MoJoPai p1, MoJoPai p2) {
		char[] p1String = p1.toString().toCharArray();
		char[] p2String = p2.toString().toCharArray();

		if (p1String[1] > p2String[1]) {
			return true;
		}
		if (p1String[1] == p2String[1]) {
			if (p1String[0] > p2String[0]) {
				return true;
			}
			if (p1String[0] == p2String[0] && p1String[1] == p2String[1] && p1String[2] > p2String[2]) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public void toSortPlayerPaizu(List<MoJoPai> player) {
		// int count = 1;
		for (int j = 0; j < player.size(); j++) {
			for (int i = 0; i < player.size() - 1 - j; i++) {
				if (isGreatter(player.get(i), player.get(i + 1))) {
					MoJoPai tmp = player.get(i + 1);
					player.set(i + 1, player.get(i));
					player.set(i, tmp);
				}
				// System.out.print("di "+(count++)+" ci");
				// showPlayer1VersionString();
				// System.out.println("");
				// System.out.println("");
			}
		}
		
	}
	
}
