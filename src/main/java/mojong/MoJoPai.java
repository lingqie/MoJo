package mojong;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
		if (code.toCharArray()[0] == '5' && code.toCharArray()[2] == '1' && code.toCharArray()[1] != 'z') {
			return "R" + StringUtils.substring(code, 0, 2);
		}
		return StringUtils.substring(code, 0, 2);
	}
	
	public String getShowTest(Boolean isAdmin){
		if(isAdmin){
			return toString();
		}
		return toPlayerString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MoJoPai) {
			MoJoPai another = (MoJoPai) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(code, another.code);
			builder.append(isDora, another.isDora);
			builder.append(isRed, another.isRed);
			return builder.isEquals();
		}
		return false;
	}

	public int hashCode() {
		return new HashCodeBuilder().append(code).append(isDora).append(isRed).toHashCode();
	}

}
