package mojong;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

public class AgariBacktrack {

    static final int[] n_zero;
    
    static {
        n_zero = new int[34];
        Arrays.fill(n_zero, 0);
    }
    
    
    // 牌の種類ごとの個数を求める 
    static int[] analyse(int[] hai) {
        int[] n = n_zero.clone();
      
        for (int i : hai) {
            n[i]++;
        }
        return n;
    }
    
    
    // バックトラック法で雀頭と面子の組み合わせを求める
    static List<Integer[][]> agari(int[] n) {//输入对应统计数
        List<Integer[][]> ret = new ArrayList<Integer[][]>();
        
        for (int i = 0; i < 34; i++) {
            for (int kotsu_first = 0; kotsu_first < 2; kotsu_first++) {
                Integer[] janto = new Integer[1];
                ArrayList<Integer> kotsu = new ArrayList<Integer>();
                ArrayList<Integer> shuntsu = new ArrayList<Integer>();
                
                int[] t = n.clone();//tonngji shu
                if (t[i] >= 2) { //t[0]>=2 man>2
                    // 雀頭をはじめに取り出す
                    t[i] -= 2;//man-2
                    janto[0] = i;//man

                    if (kotsu_first == 0) {
                        // 刻子を先に取り出す
                        for (int j = 0; j < 34; j++) {
                            if (t[j] >= 3) {
                                t[j] -= 3;
                                kotsu.add(j);
                            }
                        }
                        // 順子を後に取り出す
                        for (int a = 0; a < 3; a++) {
                            for (int b = 0; b < 7;) {
                                if (t[9*a+b] >= 1 &&
                                    t[9*a+b+1] >= 1 &&
                                    t[9*a+b+2] >= 1) {
                                    t[9*a+b]--;
                                    t[9*a+b+1]--;
                                    t[9*a+b+2]--;
                                    shuntsu.add(9*a+b);
                                } else {
                                    b++;
                                }
                            }
                        }
                    } else {
                        // 順子を先に取り出す
                        for (int a = 0; a < 3; a++) {
                            for (int b = 0; b < 7;) {
                                if (t[9*a+b] >= 1 &&
                                    t[9*a+b+1] >= 1 &&
                                    t[9*a+b+2] >= 1) {
                                    t[9*a+b]--;
                                    t[9*a+b+1]--;
                                    t[9*a+b+2]--;
                                    shuntsu.add(9*a+b);
                                } else {
                                    b++;
                                }
                            }
                        }
                        // 刻子を後に取り出す
                        for (int j = 0; j < 34; j++) {
                            if (t[j] >= 3) {
                                t[j] -= 3;
                                kotsu.add(j);
                            }
                        }
                    }

                    // 和了の形か調べる
                    if (Arrays.equals(t, n_zero)) {//suoyoupai yongguangle,nengwanmeixiaohao
                        ret.add(new Integer[][] {janto, kotsu.toArray(new Integer[0]), shuntsu.toArray(new Integer[0])});
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
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
            n = analyse(hai);
            ret = agari(n);
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
        }
    }
}