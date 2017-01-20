package jim.mytbook.activity;

import java.util.ArrayList;
import java.util.List;

import jim.mytbook.R;
import jim.mytbook.R.layout;
import jim.mytbook.adapter.MyPagerAdapter;
import jim.mytbook.fragment.CartFragment;
import jim.mytbook.fragment.ShoppingFragment;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {

	//控件
	private ViewPager viewPager;
	private RadioGroup rg;
	private RadioButton btnShop;
	private RadioButton btnCar;
	private RadioButton btnMyTBook;
	
	private List<Fragment> fragmentList;
	private MyPagerAdapter adapter; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setView();
		setListeners();
		setFragment();
		setAdapter();
	}
	/**
	 * 初始化控件
	 */
	private void setView() {
		viewPager=(ViewPager) findViewById(R.id.viewPager);
		rg=(RadioGroup) findViewById(R.id.rg_bottom);
		btnShop=(RadioButton) findViewById(R.id.rb_bookShop);
		btnCar=(RadioButton) findViewById(R.id.rb_bookCar);
		btnMyTBook=(RadioButton) findViewById(R.id.rb_myTBook);
	}
	/**
	 * 监听器
	 */
	private void setListeners() {
		viewPager.addOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					btnShop.setChecked(true);
					break;
				case 1:
					btnCar.setChecked(true);
					break;
				case 2:
					btnMyTBook.setChecked(true);
					break;
				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case 0:
					viewPager.setCurrentItem(checkedId);
					break;
				case 1:
					viewPager.setCurrentItem(checkedId);
					break;
				case 2:
					viewPager.setCurrentItem(checkedId);
					break;
				default:
					break;
				}
			}
		});
	}
	/**
	 * 
	 */
	private void setFragment() {
		fragmentList=new ArrayList<Fragment>();
		fragmentList.add(new ShoppingFragment());
		fragmentList.add(new CartFragment());
		fragmentList.add(new ShoppingFragment());
	}
	private void setAdapter() {
		adapter=new MyPagerAdapter();
		viewPager.setAdapter(adapter);
	}


	
	class MyPagerAdapter extends FragmentPagerAdapter{
		
		public MyPagerAdapter( ) {
			super(getSupportFragmentManager());
		}

		@Override
		public Fragment getItem(int arg0) {
			return fragmentList.get(arg0);
		}

		@Override
		public int getCount() {
			return fragmentList.size();
		}
		
	}
}
