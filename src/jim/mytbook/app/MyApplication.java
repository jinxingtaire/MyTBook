package jim.mytbook.app;

import java.lang.ref.SoftReference;
import java.util.HashMap;

import jim.mytbook.entity.Books;
import jim.mytbook.entity.Cart;
import jim.mytbook.entity.CartItem;

import org.xutils.x;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.Log;

public class MyApplication extends Application{
	private static RequestQueue queue;
	private static HashMap<String,SoftReference<Bitmap>> bitMap;
	private static Cart cart;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		queue=Volley.newRequestQueue(this);
		x.Ext.init(this);
		x.Ext.setDebug(true);
		bitMap=new HashMap<String, SoftReference<Bitmap>>();
		cart=new Cart();
	}
	public static RequestQueue getRequestQueue(){
		return queue;
	}
	public static HashMap<String,SoftReference<Bitmap>> getBitmap(){
		return bitMap;

	}
	public static Cart getCart(){
		return cart;
	}
	public static void addCartItem(Books book){
		cart.getList().add(new CartItem(book,1));
		Log.i("info", "成功添加"+book.getProductName());
		Log.i("info", "共有"+cart.getList().size()+"本书");
		
	}
	public static void addCount(int position){
		cart.getList().get(position).addCount();
		Log.i("info", "成功添加"+cart.getList().get(position).getBook().getProductName());
		Log.i("info", "共有"+cart.getList().size()+"本书");
	}

}
