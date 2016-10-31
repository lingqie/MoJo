package mojong;

import org.testng.annotations.Test;

public class TestDefaultScoreService2 {
	@Test
	public void get100BeiShu() {
		DefaultScoreService scoreService = new DefaultScoreService();
		assert scoreService.get100BeiShu(640)==700;
		assert scoreService.get100BeiShu(1280)==1300;
		assert scoreService.get100BeiShu(2560)==2600;
		assert scoreService.get100BeiShu(6*640)==3900;
	}
}
