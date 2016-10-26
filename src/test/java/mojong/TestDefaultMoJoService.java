package mojong;

import java.util.List;

import org.testng.annotations.Test;

public class TestDefaultMoJoService {
	@Test
	public void testCreate() {
		String s = "111222m33344p666z";
		String s2 = "11122233344666z";
		String s3 = "123m456p789s12344z";
		// use 0 to replace r5p
		// actully in new MoJoPai(0,"p",true,true)will change 0 to 5 to save in
		// the code filed,
		String s4 = "123m406p789s12344z";

		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais(s);
		List<MoJoPai> pais2 = mojongService.createMoJoPais(s2);
		List<MoJoPai> pais3 = mojongService.createMoJoPais(s3);
		List<MoJoPai> pais4 = mojongService.createMoJoPais(s4);

		assert mojongService.getPaiString(pais, false).equals("1m1m1m2m2m2m3p3p3p4p4p6z6z6z");
		assert mojongService.getPaiString(pais2, false).equals("1z1z1z2z2z2z3z3z3z4z4z6z6z6z");
		assert mojongService.getPaiString(pais3, false).equals("1m2m3m4p5p6p7s8s9s1z2z3z4z4z");
		assert mojongService.getPaiString(pais4, false).equals("1m2m3m4pR5p6p7s8s9s1z2z3z4z4z");

	}

}
