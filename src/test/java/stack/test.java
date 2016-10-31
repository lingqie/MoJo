package stack;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) throws FileNotFoundException {
		String text="aZ2";
		String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";
		//至少一大写字母 小写字母 数字
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(text);
		if (m.find()) {
			System.out.println(m.group());
		}
	}
}
