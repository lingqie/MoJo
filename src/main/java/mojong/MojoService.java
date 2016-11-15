package mojong;

import java.util.List;

public interface MojoService {
	public List<MoJoPai> initDeafaultPaiZu();
	public Boolean isGreatter(MoJoPai p1, MoJoPai p2);
	public Boolean isYaoJiu(MoJoPai pai);
	public void toSortPlayerPaizu(List<MoJoPai> player);
	public void showPai(List<MoJoPai> all,String name,int line,Boolean isAdmin);
	public Boolean isQiDuiZi(List<MoJoPai> player);
	public Boolean isCanRon(List<MoJoPai> player);
	public Boolean isGuoShiWuShuang(List<MoJoPai> player);
	public Boolean isFengPai(MoJoPai pai);
	public String getPaiString(List<MoJoPai> all, Boolean isAdmin);
	public void toSortPlayerPaizu(Player player);
	public List<MoJoPai> createMoJoPais(String text);
	public void initWangPai(Room room);
	public void initPaiShan(Room room);
	public void initPlayerPai(Room room);
	public int[] toMoJoCodeArray(List<MoJoPai> pais);
	public int[] analyse(int[] hai);
	public List<Integer[][]> agari(int[] n);
}
