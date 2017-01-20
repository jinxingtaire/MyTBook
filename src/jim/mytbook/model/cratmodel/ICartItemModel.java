package jim.mytbook.model.cratmodel;

import jim.mytbook.entity.Books;
import jim.mytbook.entity.Cart;
import jim.mytbook.entity.CartItem;

public interface ICartItemModel {

	public Cart getCart();
	public void buy(Books book);
	public float getTotalPrice(float price);
}
