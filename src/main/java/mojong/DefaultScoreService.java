package mojong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultScoreService implements ScoreService {
	private static final Logger logger = LoggerFactory.getLogger(DefaultScoreService.class);

	public int shouldPay(int jibendian, Boolean isZhuangJia, Boolean isWinnerZhuangJia, Boolean isFangPao) {

		if (isFangPao && isWinnerZhuangJia) {
			return get100BeiShu(jibendian * 6);
		}
		if (isFangPao && !isWinnerZhuangJia) {
			return get100BeiShu(jibendian * 4);
		}
		if (!isFangPao && !isZhuangJia && !isWinnerZhuangJia) {
			return get100BeiShu(jibendian);
		}
		return get100BeiShu(jibendian * 2);
	}

	public int getJiBenDian(int fushu, int fanshu) {
		int jibendian = fushu * ((int) Math.pow(2, fanshu + 2));
		return jibendian;
	}

	public int get100BeiShu(int num) {
		if (num % 100 == 0) {
			return num;
		}
		int num2 = num + 100 - num % 100;
		return num2;
	};

}
