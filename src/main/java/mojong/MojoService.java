package mojong;

import java.util.List;

public interface MojoService {
	public Boolean isGreatter(MoJoPai p1, MoJoPai p2);
	public void toSortPlayerPaizu(List<MoJoPai> player);
	public void showPai(List<MoJoPai> all,String name,int line,Boolean isAdmin);
	
}
