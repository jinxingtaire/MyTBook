package jim.mytbook.model.impl;

import java.util.Iterator;
import java.util.List;

import android.util.Log;
import jim.mytbook.app.MyApplication;
import jim.mytbook.entity.Books;
import jim.mytbook.entity.Cart;
import jim.mytbook.entity.CartItem;
import jim.mytbook.model.cratmodel.ICartItemModel;

public class CartItemModelImpl implements ICartItemModel{

	
	/**
	 * ��ȡ���ﳵ
	 */
	@Override
	public Cart getCart() {
		// TODO Auto-generated method stub
		return MyApplication.getCart();
	}

	/**
	 * ������Ʒ
	 * 	1������Ѿ����빺�ﳵ��������1
	 * 		1.1ʹ�õ���������
	 * 	2��������ﳵ��û�д���Ʒ������빺�ﳵ
	 */

	@Override
	public void buy(Books book) {
		//ѭ�����Ϊfalse���жϹ��ﳵ���Ƿ��Ѵ��ڴ���Ʒ
		boolean flag=false;
		Cart cart=MyApplication.getCart();
		List<CartItem> list=cart.getList();
		Iterator it=list.iterator();
		int id=book.getId();

		for(int position=0;position<list.size();position++){
			if(id==list.get(position).getBook().getId()){
				MyApplication.addCount(position);
				//ѭ�����Ϊtrue
				flag=true;
				break;
			}
		}
		//�ж�ѭ����ǣ�falseΪ�����ڣ�trueΪ����
		if(flag==false){
			MyApplication.addCartItem(book);
		}
		
	}

	@Override
	public float getTotalPrice(float price) {
		Cart cart=MyApplication.getCart();
		List<CartItem> list=cart.getList();
		Log.i("info",list.size()+"����Ʒ");
		for(CartItem cartitem:list){
			price=(cartitem.getBook().getFixedPrice())*((float)cartitem.getCount());
			Log.i("info",price+"Ԫ");
		}
		return price;
	}

	


}
