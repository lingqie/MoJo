package mojong;

import org.apache.commons.lang.StringUtils;

public class MoJoPai {
	public String code;
	public Boolean isDora;
	public Boolean isRed;

	public MoJoPai(String code, Boolean isDora, Boolean isRed) {
		this.code = code;
		this.isDora = isDora;
		this.isRed = isRed;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsDora() {
		return isDora;
	}

	public void setIsDora(Boolean isDora) {
		this.isDora = isDora;
	}

	public Boolean getIsRed() {
		return isRed;
	}

	public void setIsRed(Boolean isRed) {
		this.isRed = isRed;
	}

	@Override
	public String toString() {
		// if(isRed){
		// if(isDora){
		// return code+"T"+"R";
		// }
		// return code+"F"+"R";
		// }
		if (isDora) {
			return code + "T";
		}
		return code + "F";
	}

	public String toPlayerString() {
		if(code.toCharArray()[0]=='5'&&code.toCharArray()[2]=='1'&&code.toCharArray()[1]!='z'){
			return "R"+StringUtils.substring(code, 0, 2);
		}
		return StringUtils.substring(code, 0, 2);
	}
}
