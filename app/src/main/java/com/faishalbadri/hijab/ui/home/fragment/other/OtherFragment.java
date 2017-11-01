package com.faishalbadri.hijab.ui.home.fragment.other;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.DataOtherFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends Fragment {


  @BindView(R.id.recyclerview_fragment_other)
  RecyclerView recyclerviewFragmentOther;
  OtherFragmentAdapter otherFragmentAdapter;
  List<DataOtherFragment> data_list_other;
  String kritiksaran, kirimartikel, share, about;
  private int[] image;

  public OtherFragment() {
    // Required empty public constructor
  }


  public static OtherFragment instance() {
    return new OtherFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_other, container, false);
    ButterKnife.bind(this, view);
    setView();
    setString();
    dataOtherFragment();
    return view;
  }

  private void dataOtherFragment() {
    data_list_other.add(new DataOtherFragment(kritiksaran, image[0]));
    data_list_other.add(new DataOtherFragment(kirimartikel, image[1]));
    data_list_other.add(new DataOtherFragment(share, image[2]));
    data_list_other.add(new DataOtherFragment(about, image[3]));
    otherFragmentAdapter.notifyDataSetChanged();
  }

  private void setView() {
    data_list_other = new ArrayList<>();
    otherFragmentAdapter = new OtherFragmentAdapter(getActivity(), data_list_other);
    LinearLayoutManager llmOtherFragment = new LinearLayoutManager(getActivity());
    llmOtherFragment.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerviewFragmentOther.setLayoutManager(llmOtherFragment);
    recyclerviewFragmentOther.setAdapter(otherFragmentAdapter);
  }

  private void setString() {
    image = new int[]{
        R.drawable.ic_feedback,
        R.drawable.ic_send_blue,
        R.drawable.ic_share,
        R.drawable.ic_info_outline
    };

    kritiksaran = getActivity().getResources().getString(R.string.text_other_kritik_saran);
    kirimartikel = getActivity().getResources().getString(R.string.text_other_kirim_artikel);
    share = getActivity().getResources().getString(R.string.text_other_share);
    about = getActivity().getResources().getString(R.string.text_other_about);
  }

}
