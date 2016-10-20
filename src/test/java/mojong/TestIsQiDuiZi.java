package mojong;
import java.util.List;

import org.testng.annotations.Test;

public class TestIsQiDuiZi
{ 
	 @Test 
	 public void TestIsQiDuiZi() 
	 { 
		 DefaultMojongService mojongService = new DefaultMojongService();
		 List<MoJoPai> pais = mojongService.createMoJoPais("1111222233334z");
		 assert mojongService.isQiDuiZiWaiting(pais)==true;
	 } 
	
}

