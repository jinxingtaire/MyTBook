package jim.mytbook.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> list;

	public Cart() {
		list=new ArrayList<CartItem>();
	}

	public List<CartItem> getList() {
		return list;
	}

	public void setList(List<CartItem> list) {
		this.list = list;
	}
	
	

}
