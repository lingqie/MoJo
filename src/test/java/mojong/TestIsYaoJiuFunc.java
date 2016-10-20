package mojong;

import java.util.List;

import org.testng.annotations.Test;

import mojong.MoJoPai;

public class TestIsYaoJiuFunc {
	@Test
	public void TestIsYaoJiuFunc() {
		DefaultMojongService mojongService = new DefaultMojongService();
		assert mojongService.isYaoJiu(new MoJoPai("1z"))==true;
		assert mojongService.isYaoJiu(new MoJoPai("7z"))==true;
		assert mojongService.isYaoJiu(new MoJoPai("9s"))==true;
		assert mojongService.isYaoJiu(new MoJoPai("1s"))==true;
		assert mojongService.isYaoJiu(new MoJoPai("5s"))==false;
		assert mojongService.isYaoJiu(new MoJoPai("1m"))==true;
	}

}
