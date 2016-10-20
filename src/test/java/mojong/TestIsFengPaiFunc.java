package mojong;
import org.testng.annotations.Test;

import mojong.MoJoPai;

public class TestIsFengPaiFunc {
	@Test
	public  void TestIsFengPaiFunc() {
		DefaultMojongService mojongService = new DefaultMojongService();
		assert mojongService.isFengPai(new MoJoPai("1z"))==true;
		assert mojongService.isFengPai(new MoJoPai("2z"))==true;
		assert mojongService.isFengPai(new MoJoPai("3z"))==true;
		assert mojongService.isFengPai(new MoJoPai("4z"))==true;
		assert mojongService.isFengPai(new MoJoPai("5z"))==false;
		assert mojongService.isFengPai(new MoJoPai("7z"))==false;
		assert mojongService.isFengPai(new MoJoPai("9s"))==false;
		assert mojongService.isFengPai(new MoJoPai("1s"))==false;
		assert mojongService.isFengPai(new MoJoPai("5s"))==false;
		assert mojongService.isFengPai(new MoJoPai("1m"))==false;
		
	}
}
