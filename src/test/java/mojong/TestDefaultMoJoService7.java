package mojong;

import org.testng.annotations.Test;

public class TestDefaultMoJoService7 {
	@Test
	public void TestIsYaoJiuFunc() {
		DefaultMojongService mojongService = new DefaultMojongService();
		assert mojongService.isYaoJiu(new MoJoPai("1z")) == true;
		assert mojongService.isYaoJiu(new MoJoPai("7z")) == true;
		assert mojongService.isYaoJiu(new MoJoPai("9s")) == true;
		assert mojongService.isYaoJiu(new MoJoPai("1s")) == true;
		assert mojongService.isYaoJiu(new MoJoPai("5s")) == false;
		assert mojongService.isYaoJiu(new MoJoPai("1m")) == true;
	}

}
