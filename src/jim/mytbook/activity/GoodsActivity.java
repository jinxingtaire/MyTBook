package jim.mytbook.activity;

import java.util.ArrayList;
import java.util.List;

import jim.mytbook.R;
import jim.mytbook.R.layout;
import jim.mytbook.entity.Books;
import jim.mytbook.fragment.CartFragment;
import jim.mytbook.fragment.GoodsFragment;
import jim.mytbook.presenter.IBookDetailPresenter;
import jim.mytbook.presenter.impl.BookDetailPresentImpl;
import jim.mytbook.view.IBookDetailView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class GoodsActivity extends FragmentActivity implements IBookDetailView {

	private List<Fragment> fragments;
	private Books book;
	private ViewPager viewPager;
	private GoodsPagerAdapter adapter;
	private Button btnAddCart;
	private IBookDetailPresenter presenter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goods);
		setView();
		getBook();
		setFragment();
		setAdapter();
		setPresenter();
		setListener();
	}


	private void setView() {
		viewPager=(ViewPager) findViewById(R.id.vp_goods_vp);
		btnAddCart=(Button) findViewById(R.id.btn_put_in_cart);
	}
	private void getBook() {
		Intent intent=getIntent();
		 book=(Books) intent.getSerializableExtra(Books.key);
		Log.i("info", book.getAuthor());		
	}
	/**
	 * 创建Fragment，并将book实例传递过去
	 */
	private void setFragment(){
		GoodsFragment goodsFragment=new GoodsFragment();
		Bundle bundle=new Bundle();
		bundle.putSerializable(Books.key, book);
		goodsFragment.setArguments(bundle);
		fragments=new ArrayList<Fragment>();
		fragments.add(goodsFragment);
	}
	private void setAdapter(){
		adapter=new GoodsPagerAdapter();
		viewPager.setAdapter(adapter);
	}
	
	private void setListener() {
		btnAddCart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				presenter.addToCart(book);
			}
		});
	}

	
	private void setPresenter() {
		presenter=new BookDetailPresentImpl(this);
	}
	
	class GoodsPagerAdapter extends FragmentPagerAdapter{

		public GoodsPagerAdapter() {
			super(getSupportFragmentManager());
		}

		@Override
		public Fragment getItem(int arg0) {
			return fragments.get(arg0);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}
		
	}


	@Override
	public void addToCartSuccess() {
		
		Toast.makeText(this, "已成功加入购物车", Toast.LENGTH_SHORT).show();
	}
	@Override
	public void addToCartFail(String errormsg) {
		// TODO Auto-generated method stub
		
	}
}
