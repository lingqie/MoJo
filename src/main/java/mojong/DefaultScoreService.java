package mojong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultScoreService implements ScoreService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultScoreService.class);

	public long shouldPay(long jibendian, Boolean isZhuangJia, Boolean isWinnerZhuangJia, Boolean isFangPao) {
		LOGGER.info("基本点:{}",jibendian);
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

	public long getJiBenDian(int fushu, int fanshu) {
		int jibendian = fushu * ((int) Math.pow(2, fanshu + 2));
		return jibendian;
	}

	public long get100BeiShu(long num) {
		if (num % 100 == 0) {
			return num;
		}
		long num2 = num + 100 - num % 100;
		return num2;
	};

}
