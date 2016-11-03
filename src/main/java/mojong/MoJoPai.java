package mojong;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class MoJoPai {
	public int code;// 1,2,3,4,5
//	public String type;// m,s,p,z
	public Boolean isDora;
	public Boolean isRed;
	public Boolean isCanLook;
	
	

	public MoJoPai(int code) {
		this.code = code;
		this.isDora = false;
		this.isRed = false;
		this.isCanLook = true;
	}

	public MoJoPai(int code, Boolean isDora, Boolean isRed) {
		this.code = code;
		this.isDora = isDora;
		this.isRed = isRed;
		this.isCanLook = true;

	}

	public MoJoPai(int code, Boolean isDora, Boolean isRed, Boolean isCanLook) {
		this.code = code;
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
				return "R" + MoJoPaiCode.PAILIST[code] + "T";
			}
			return MoJoPaiCode.PAILIST[code] + "T";
		}
		return MoJoPaiCode.PAILIST[code] + "F";
	}

	public String toPlayerString() {
		if (isRed) {
			return "R" + MoJoPaiCode.PAILIST[code];
		}
		return MoJoPaiCode.PAILIST[code];
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
			return builder.isEquals();
		}
		return false;
	}

	public int hashCode() {
		return new HashCodeBuilder().append(code).append(isDora).append(isRed).toHashCode();
	}

}
