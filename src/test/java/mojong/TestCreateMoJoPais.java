package mojong;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.util.string.IStringSequence;

import mojong.MoJoPai;

public class TestCreateMoJoPais {
	public static void main(String[] args) {
		String s = "111222m33344p666z";
		String s2 = "11122233344666z";
		DefaultMojongService mojongService = new DefaultMojongService();
		List<MoJoPai> pais = mojongService.createMoJoPais(s);
		List<MoJoPai> pais2 = mojongService.createMoJoPais(s2);
		mojongService.showPai(pais, "s", 1, false);
		mojongService.showPai(pais2, "s2", 1, false);
		// show(s);

	}

//	public static void show(String text) {
//		String line = text;
//		String pattern = "(\\d*m+)?(\\d*p+)?(\\d*s+)?(\\d*z+)?";
//		Pattern r = Pattern.compile(pattern);
//		Matcher m = r.matcher(line);
//		if (m.find()) {
//			System.out.println("Found value: " + m.group(0));// all
//			System.out.println("Found value: " + m.group(1));// mpart
//			System.out.println("Found value: " + m.group(2));// ppart
//			System.out.println("Found value: " + m.group(3));// spart
//			System.out.println("Found value: " + m.group(4));// zpart
//		} else {
//			System.out.println("NO MATCH");
//		}
//	}
}
