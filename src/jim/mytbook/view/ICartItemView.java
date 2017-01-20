package jim.mytbook.view;

import java.util.List;

import jim.mytbook.entity.CartItem;

public interface ICartItemView {

	public void showList(List<CartItem> list);
	void showPrice(float price);
}
