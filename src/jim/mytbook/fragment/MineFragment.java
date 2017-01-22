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
	//�ǳ�
	private TextView tvNickname;
	//ͷ��
	private CircleImageView ivHead;
	//�ղ�
	private TextView tvMyFavorite;
	//�ջ���ַ
	private TextView tvTotalDesc;
	//����
	private TextView tvMyOrder;
	//����
	private TextView tvSetting;
	//�˳�
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
			//��ת��½
			startActivity(new Intent(getActivity(),LoginActivity.class));
			break;
		case R.id.tvNickname:
			//�޸��ǳ�
			break;
		case R.id.tvMyFavorite:
			//��ת�ղ�
			startActivity(new Intent(getActivity(),MyFavoriteActivity.class));
			break;
		case R.id.tvTotalDesc:
			//��ת�ջ���ַ
			startActivity(new Intent(getActivity(),MyTotalDescActivity.class));
			break;
		case R.id.tvMyOrder:
			//��ת����
			startActivity(new Intent(getActivity(),MyOrderActivity.class));
			break;
		case R.id.tvSetting:
			//��ת����ҳ��
			startActivity(new Intent(getActivity(),MySettingActivity.class));
			break;
		default:
			break;
		}
	}
}
