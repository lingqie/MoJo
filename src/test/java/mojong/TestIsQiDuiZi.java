package mojong;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.util.string.IStringSequence;

import mojong.MoJoPai;

public class TestIsQiDuiZi {
	public static void main(String[] args) {
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais("1111222233334z");
		System.out.println(isQiDuiZiWaiting(pais));
		
		
	}
	
	public static Boolean isQiDuiZiWaiting(List<MoJoPai> player) {
		int qiduiziCount = 0;
		for (int i = 0; i < player.size() - 1; i++) {
			if (player.get(i).equals(player.get(i + 1))) {
				qiduiziCount++;
			}
		}
		if (qiduiziCount >= 6) {
			return true;
		}
		return false;
	}
}
