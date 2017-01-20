package jim.mytbook.entity;

import java.util.List;

public class Resp {

	private int code;
	private List<Books> data;
	public Resp() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<Books> getData() {
		return data;
	}
	public void setData(List<Books> data) {
		this.data = data;
	}
	
}
