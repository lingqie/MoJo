package mojong;

import org.testng.annotations.Test;

public class TestDefaultScoreService {
	@Test(groups = "score")
	public void get100BeiShu() {
		DefaultScoreService scoreService = new DefaultScoreService();
		//点闲家炮 
		assert scoreService.shouldPay(scoreService.getJiBenDian(30, 1), true, false, true)==1000:scoreService.shouldPay(scoreService.getJiBenDian(30, 1), true, false, true);
		assert scoreService.shouldPay(scoreService.getJiBenDian(40, 1), true, false, true)==1300;
		assert scoreService.shouldPay(scoreService.getJiBenDian(50, 1), true, false, true)==1600;
		assert scoreService.shouldPay(scoreService.getJiBenDian(60, 1), true, false, true)==2000;
		assert scoreService.shouldPay(scoreService.getJiBenDian(70, 1), true, false, true)==2300;
		assert scoreService.shouldPay(scoreService.getJiBenDian(80, 1), true, false, true)==2600;
		assert scoreService.shouldPay(scoreService.getJiBenDian(90, 1), true, false, true)==2900;
		assert scoreService.shouldPay(scoreService.getJiBenDian(100, 1), true, false, true)==3200;
		assert scoreService.shouldPay(scoreService.getJiBenDian(110, 1), true, false, true)==3600;

		//点庄家炮
		assert scoreService.shouldPay(scoreService.getJiBenDian(30, 1), false, true, true)==1500;
		assert scoreService.shouldPay(scoreService.getJiBenDian(40, 1), false, true, true)==2000;
		assert scoreService.shouldPay(scoreService.getJiBenDian(50, 1), false, true, true)==2400;
		assert scoreService.shouldPay(scoreService.getJiBenDian(60, 1), false, true, true)==2900;
		assert scoreService.shouldPay(scoreService.getJiBenDian(70, 1), false, true, true)==3400;
		assert scoreService.shouldPay(scoreService.getJiBenDian(80, 1), false, true, true)==3900;
		assert scoreService.shouldPay(scoreService.getJiBenDian(90, 1), false, true, true)==4400;
		assert scoreService.shouldPay(scoreService.getJiBenDian(100, 1), false, true, true)==4800;
		assert scoreService.shouldPay(scoreService.getJiBenDian(110, 1), false, true, true)==5300;
		
		assert scoreService.shouldPay(scoreService.getJiBenDian(20, 2), false, true, true)==2000:scoreService.shouldPay(scoreService.getJiBenDian(20, 2), false, true, true);
		assert scoreService.shouldPay(scoreService.getJiBenDian(25, 2), false, true, true)==2400:scoreService.shouldPay(scoreService.getJiBenDian(25, 2), false, true, true);
		assert scoreService.shouldPay(scoreService.getJiBenDian(30, 2), false, true, true)==2900;
		assert scoreService.shouldPay(scoreService.getJiBenDian(40, 2), false, true, true)==3900;
		assert scoreService.shouldPay(scoreService.getJiBenDian(50, 2), false, true, true)==4800;
		assert scoreService.shouldPay(scoreService.getJiBenDian(60, 2), false, true, true)==5800;
		assert scoreService.shouldPay(scoreService.getJiBenDian(70, 2), false, true, true)==6800;
		assert scoreService.shouldPay(scoreService.getJiBenDian(80, 2), false, true, true)==7700;
		assert scoreService.shouldPay(scoreService.getJiBenDian(90, 2), false, true, true)==8700;
		assert scoreService.shouldPay(scoreService.getJiBenDian(100, 2), false, true, true)==9600;
		assert scoreService.shouldPay(scoreService.getJiBenDian(110, 2), false, true, true)==10600;
		
		assert scoreService.shouldPay(scoreService.getJiBenDian(20, 3), false, true, true)==3900:scoreService.shouldPay(scoreService.getJiBenDian(20, 3), false, true, true);
		assert scoreService.shouldPay(scoreService.getJiBenDian(25, 3), false, true, true)==4800;
		assert scoreService.shouldPay(scoreService.getJiBenDian(30, 3), false, true, true)==5800;
		assert scoreService.shouldPay(scoreService.getJiBenDian(40, 3), false, true, true)==7700;
		assert scoreService.shouldPay(scoreService.getJiBenDian(50, 3), false, true, true)==9600;
		assert scoreService.shouldPay(scoreService.getJiBenDian(60, 3), false, true, true)==11600;
//		assert scoreService.shouldPay(scoreService.getJiBenDian(70, 3), false, true, true)==6800;
//		assert scoreService.shouldPay(scoreService.getJiBenDian(80, 3), false, true, true)==7700;
//		assert scoreService.shouldPay(scoreService.getJiBenDian(90, 3), false, true, true)==8700;
//		assert scoreService.shouldPay(scoreService.getJiBenDian(100, 3), false, true, true)==9600;
//		assert scoreService.shouldPay(scoreService.getJiBenDian(110, 3), false, true, true)==10600;
		
		//庄家被闲家自摸
		assert scoreService.shouldPay(scoreService.getJiBenDian(30, 1), true, false, false)==500;
		assert scoreService.shouldPay(scoreService.getJiBenDian(40, 1), true, false, false)==700;
		assert scoreService.shouldPay(scoreService.getJiBenDian(50, 1), true, false, false)==800;
		assert scoreService.shouldPay(scoreService.getJiBenDian(60, 1), true, false, false)==1000;
		assert scoreService.shouldPay(scoreService.getJiBenDian(70, 1), true, false, false)==1200;
		assert scoreService.shouldPay(scoreService.getJiBenDian(80, 1), true, false, false)==1300;
		assert scoreService.shouldPay(scoreService.getJiBenDian(90, 1), true, false, false)==1500;
		assert scoreService.shouldPay(scoreService.getJiBenDian(100, 1), true, false, false)==1600;
		assert scoreService.shouldPay(scoreService.getJiBenDian(110, 1), true, false, false)==1800;
		
		//闲家被庄家自摸
		assert scoreService.shouldPay(scoreService.getJiBenDian(30, 1), false, true, false)==500;
		assert scoreService.shouldPay(scoreService.getJiBenDian(40, 1), false, true, false)==700;
		assert scoreService.shouldPay(scoreService.getJiBenDian(50, 1), false, true, false)==800;
		assert scoreService.shouldPay(scoreService.getJiBenDian(60, 1), false, true, false)==1000;
		assert scoreService.shouldPay(scoreService.getJiBenDian(70, 1), false, true, false)==1200;
		assert scoreService.shouldPay(scoreService.getJiBenDian(80, 1), false, true, false)==1300;
		assert scoreService.shouldPay(scoreService.getJiBenDian(90, 1), false, true, false)==1500;
		assert scoreService.shouldPay(scoreService.getJiBenDian(100, 1), false, true, false)==1600;
		assert scoreService.shouldPay(scoreService.getJiBenDian(110, 1), false, true, false)==1800;
		
		
		//闲家被闲家自摸
		assert scoreService.shouldPay(scoreService.getJiBenDian(30, 1), false, false, false)==300;
		assert scoreService.shouldPay(scoreService.getJiBenDian(40, 1), false, false, false)==400;
		assert scoreService.shouldPay(scoreService.getJiBenDian(50, 1), false, false, false)==400;
		assert scoreService.shouldPay(scoreService.getJiBenDian(60, 1), false, false, false)==500;
		assert scoreService.shouldPay(scoreService.getJiBenDian(70, 1), false, false, false)==600;
		assert scoreService.shouldPay(scoreService.getJiBenDian(80, 1), false, false, false)==700;
		assert scoreService.shouldPay(scoreService.getJiBenDian(90, 1), false, false, false)==800;
		assert scoreService.shouldPay(scoreService.getJiBenDian(100, 1), false, false, false)==800;
		assert scoreService.shouldPay(scoreService.getJiBenDian(110, 1), false, false, false)==900;
		
		
		
	}
}
