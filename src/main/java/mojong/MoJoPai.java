package mojong;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class MoJoPai {
	public int code;// 1,2,3,4,5
	public String type;// m,s,p,z
	public Boolean isDora;
	public Boolean isRed;
	public Boolean isCanLook;

	public MoJoPai(String suoxie) {
		if (suoxie.charAt(0) == 'R') {
			this.code = Character.getNumericValue(suoxie.charAt(1));
			this.type = String.valueOf(suoxie.charAt(2));
			this.isDora = true;
			this.isRed = true;
			this.isCanLook = true;
		} else {
			this.code = Character.getNumericValue(suoxie.charAt(0));
			this.type = String.valueOf(suoxie.charAt(1));
			this.isDora = false;
			this.isRed = false;
			this.isCanLook = true;
		}
	}

	public MoJoPai(int code, String type) {
		this.code = code;
		this.type = type;
		this.isDora = false;
		this.isRed = false;
		this.isCanLook = true;
		if (code == 0) {
			this.code = 5;
			this.isDora = true;
			this.isRed = true;
		}
	}

	public MoJoPai(int code, String type, Boolean isDora, Boolean isRed) {
		this.code = code;
		this.type = type;
		if (code == 0) {
			this.code = 5;
		}
		this.isDora = isDora;
		this.isRed = isRed;
		this.isCanLook = true;

	}

	public MoJoPai(int code, String type, Boolean isDora, Boolean isRed, Boolean isCanLook) {
		this.code = code;
		this.type = type;
		if (code == 0) {
			this.code = 5;
		}
		this.isDora = isDora;
		this.isRed = isRed;
		this.isCanLook = isCanLook;

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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

	public Boolean getIsCanLook() {
		return isCanLook;
	}

	public void setIsCanLook(Boolean isCanLook) {
		this.isCanLook = isCanLook;
	}

	@Override
	public String toString() {

		if (isDora) {
			if (isRed) {
				return "R" + code + type + "T";
			}
			return code + type + "T";

		}
		return code + type + "F";
	}

	public String toPlayerString() {

		if (isRed) {
			return "R" + code + type;
		}
		return code + type;
	}
	
	public String toSuoxieString() {

		return code + type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShowTest(Boolean isAdmin) {
		if (isAdmin) {
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
			builder.append(type, another.type);
			return builder.isEquals();
		}
		return false;
	}

	public int hashCode() {
		return new HashCodeBuilder().append(code).append(type).append(isDora).append(isRed).toHashCode();
	}

}
