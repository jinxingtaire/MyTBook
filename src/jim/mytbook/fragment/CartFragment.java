package jim.mytbook.fragment;

import java.util.List;

import jim.mytbook.R;
import jim.mytbook.adapter.CartAdapter;
import jim.mytbook.entity.CartItem;
import jim.mytbook.presenter.ICartItemPresenter;
import jim.mytbook.presenter.impl.CartItemPresenterImpl;
import jim.mytbook.view.ICartItemView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class CartFragment extends Fragment implements ICartItemView{

	private ListView lvCart;
	private ICartItemPresenter presenter;
	private CartAdapter adapter;
	private TextView tvTotalPrice;
	private ImageButton delButton;
	private Button btnEdit;
	private float price=0f;
	private boolean isEdit=false;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_cart, null);
		presenter =new CartItemPresenterImpl(this);
		setView(view);
		setPresenter();
		setListener();
		return view;
	}


	@Override
	public void onResume() {
		super.onResume();
		presenter.loadCartItem();
		presenter.loadTotalPrice(price);
	}

	private void setListener() {
		btnEdit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				isEdit=!isEdit;
				presenter.loadCartItem();
			}
		});
		
	}

	private void setView(View view) {
		lvCart=(ListView) view.findViewById(R.id.lvCart);
		tvTotalPrice=(TextView)view.findViewById(R.id.tvTotalPrice);
		btnEdit=(Button) view.findViewById(R.id.btnEdit);
	}
	private void setPresenter() {
		presenter.loadCartItem();
		presenter.loadTotalPrice(price);
	}



	@Override
	public void showList(List<CartItem> list) {
		adapter=new CartAdapter(list, getActivity(),isEdit);
		lvCart.setAdapter(adapter);
	}


	@Override
	public void showPrice(float price) {
		tvTotalPrice.setText(price+"");
	}
}
