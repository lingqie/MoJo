package mojong;
import org.testng.annotations.Test;

import mojong.MoJoPai;

public class TestIsGreatterFunc {
	@Test
	public void TestIsGreatterFunc(){
		DefaultMojongService mojongService = new DefaultMojongService();
		assert mojongService.isGreatter(new MoJoPai("1s"), new MoJoPai("1z"))==false;
		assert mojongService.isGreatter(new MoJoPai("1s"), new MoJoPai("9z"))==false;
		assert mojongService.isGreatter(new MoJoPai("9s"), new MoJoPai("1z"))==false;
		assert mojongService.isGreatter(new MoJoPai("1z"), new MoJoPai("9s"))==true;
		assert mojongService.isGreatter(new MoJoPai("5z"), new MoJoPai("5z"))==false;
		assert mojongService.isGreatter(new MoJoPai("R5s"), new MoJoPai("5s"))==false;
		assert mojongService.isGreatter(new MoJoPai("5s"), new MoJoPai("R5s"))==true;
		assert mojongService.isGreatter(new MoJoPai("6s"), new MoJoPai("R5s"))==true;
	}
}
