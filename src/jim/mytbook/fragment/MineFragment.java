package jim.mytbook.fragment;

import jim.mytbook.R;
import jim.mytbook.activity.LoginActivity;
import jim.mytbook.activity.MyFavoriteActivity;
import jim.mytbook.activity.MyOrderActivity;
import jim.mytbook.activity.MySettingActivity;
import jim.mytbook.activity.MyTotalDescActivity;
import jim.mytbook.ui.CircleImageView;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MineFragment extends Fragment implements OnClickListener{
	//昵称
	private TextView tvNickname;
	//头像
	private CircleImageView ivHead;
	//收藏
	private TextView tvMyFavorite;
	//收货地址
	private TextView tvTotalDesc;
	//订单
	private TextView tvMyOrder;
	//设置
	private TextView tvSetting;
	//退出
	private TextView tvExit;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =inflater.inflate(R.layout.fragment_mine, null);
		setViews(view);
		setListeners();
		return view;
	}

	private void setViews(View view) {
		tvNickname=(TextView) view.findViewById(R.id.tvNickname);
		ivHead=(CircleImageView) view.findViewById(R.id.ivPhoto);
		tvMyFavorite=(TextView) view.findViewById(R.id.tvMyFavorite);
		tvTotalDesc=(TextView) view.findViewById(R.id.tvTotalDesc);
		tvMyOrder=(TextView) view.findViewById(R.id.tvMyOrder);
		tvSetting=(TextView) view.findViewById(R.id.tvSetting);
		tvExit=(TextView) view.findViewById(R.id.tvExit);
	}
	private void setListeners() {
		tvNickname.setOnClickListener(this);
		ivHead.setOnClickListener(this);
		tvMyFavorite.setOnClickListener(this);
		tvTotalDesc.setOnClickListener(this);
		tvMyOrder.setOnClickListener(this);
		tvSetting.setOnClickListener(this);
		tvExit.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ivPhoto:
			//跳转登陆
			startActivity(new Intent(getActivity(),LoginActivity.class));
			break;
		case R.id.tvNickname:
			//修改昵称
			break;
		case R.id.tvMyFavorite:
			//跳转收藏
			startActivity(new Intent(getActivity(),MyFavoriteActivity.class));
			break;
		case R.id.tvTotalDesc:
			//跳转收货地址
			startActivity(new Intent(getActivity(),MyTotalDescActivity.class));
			break;
		case R.id.tvMyOrder:
			//跳转订单
			startActivity(new Intent(getActivity(),MyOrderActivity.class));
			break;
		case R.id.tvSetting:
			//跳转设置页面
			startActivity(new Intent(getActivity(),MySettingActivity.class));
			break;
		default:
			break;
		}
	}
}
