package mojong;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class MoJoPai {
	public int code;//1,2,3,4,5
	public String type;//m,s,p,z
	public int num;
	public Boolean isDora;
	public Boolean isRed;

	public MoJoPai(int code,String type,int num,Boolean isDora, Boolean isRed) {
		this.code = code;
		this.type = type;
		this.num=num;
		this.isDora = isDora;
		this.isRed = isRed;
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

	@Override
	public String toString() {
		// if(isRed){
		// if(isDora){
		// return code+"T"+"R";
		// }
		// return code+"F"+"R";
		// }
		if (isDora) {
			return code+type+num+ "T";
		}
		return code + type +num +"F";
	}

	public String toPlayerString() {
		//the first 5'x' pai is the Red Dora Pai
		if (code == 5 && num == 1 && type!= "z") {
			return "R" + code + type;
		}
		return  code+type;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
			builder.append(type, another.type);
			return builder.isEquals();
		}
		return false;
	}

	public int hashCode() {
		return new HashCodeBuilder().append(code).append(type).append(num).append(isDora).append(isRed).toHashCode();
	}

}
