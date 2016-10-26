package mojong;

import java.util.List;

public interface MojoService {
	public List<MoJoPai> initDeafaultPaiZu();
	public Boolean isGreatter(MoJoPai p1, MoJoPai p2);
	public Boolean isYaoJiu(MoJoPai pai);
	public void toSortPlayerPaizu(List<MoJoPai> player);
	public void showPai(List<MoJoPai> all,String name,int line,Boolean isAdmin);
	public Boolean isQiDuiZiWaiting(List<MoJoPai> player);
	public Boolean isCanRon(List<MoJoPai> player);
	public Boolean isGuoShiWuShuang(List<MoJoPai> player);
	public Boolean isFengPai(MoJoPai pai);
	public String getPaiString(List<MoJoPai> all, Boolean isAdmin);
}
