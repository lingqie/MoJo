package mojong;

import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService9 {
	@Test
	public void TestAgari() {
		DefaultMojongService mojongService = new DefaultMojongService();
		int[] hai = {
	            MoJoPaiCode.WAN1, MoJoPaiCode.WAN1, MoJoPaiCode.WAN1,
	            MoJoPaiCode.WAN2, MoJoPaiCode.WAN3, MoJoPaiCode.WAN4,
	            MoJoPaiCode.WAN5, MoJoPaiCode.WAN6, MoJoPaiCode.WAN7,
	            MoJoPaiCode.WAN8, MoJoPaiCode.WAN9, MoJoPaiCode.WAN9,
	            MoJoPaiCode.WAN9, MoJoPaiCode.WAN1
	      };
	        

	        int[] n = null;
	        List<Integer[][]> ret = null;
	        
	        long time = System.currentTimeMillis();
	        for (int i = 0; i < 100000; i++) {//十万次测试
	            n = mojongService.analyse(hai);
	            ret = mojongService.agari(n);
	        }
	        System.out.println("agari run 100000 times need "+(System.currentTimeMillis() - time) +"ms");
	        
	        for (Integer[][] r : ret) {
	            System.out.print("雀頭=");
	            System.out.println(r[0][0]);
	            for (Integer kotsu : r[1]) {
	                System.out.print("刻子=");
	                System.out.println(kotsu);
	            }
	            for (Integer shuntsu : r[2]) {
	                System.out.print("順子=");
	                System.out.println(shuntsu);
	            }
	        }	}

}
