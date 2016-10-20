package mojong;

import java.util.List;

import org.testng.annotations.Test;

public class TestCreateMoJoPais {
	@Test
	public void testCreate(){
		String s = "111222m33344p666z";
		String s2 = "11122233344666z";
		String s3 = "123m456p789s12344z";
		//use 0 to replace r5p
		//actully in new MoJoPai(0,"p",true,true)will change 0 to 5 to save in the code filed,
		String s4 = "123m406p789s12344z";
		
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais(s);
		List<MoJoPai> pais2 = mojongService.createMoJoPais(s2);
		List<MoJoPai> pais3 = mojongService.createMoJoPais(s3);
		List<MoJoPai> pais4 = mojongService.createMoJoPais(s4);
		
		mojongService.showPai(pais, "s", 1, false);
		mojongService.showPai(pais2, "s2", 1, false);
		mojongService.showPai(pais3, "s3", 1, false);
		mojongService.showPai(pais4, "s4", 1, false);

	}

}
