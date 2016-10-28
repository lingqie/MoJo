package mojong;

import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultScoreService3 {
	@Test
	public void get100BeiShu() {
		DefaultScoreService scoreService = new DefaultScoreService();
		assert scoreService.getJiBenDian(30, 1)==240;
		System.out.println(scoreService.shouldPay(scoreService.getJiBenDian(40, 6), false, true, true));
	}
}
