package com.faishalbadri.hijab.ui.voting_dialog_fragment;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.di.VotingDialogRepositoryInject;
import com.faishalbadri.hijab.util.server.Server;

/**
 * A simple {@link Fragment} subclass.
 */
public class VotingDialogFragment extends DialogFragment implements
    VotingDialogContract.VotingDialogViewGetSession,
    VotingDialogContract.VotingDialogViewVotingRate {


  @BindView(R.id.image_fragment_voting_dialog)
  ImageView imageFragmentVotingDialog;
  @BindView(R.id.button_before_like_voting)
  ImageView buttonBeforeLikeVoting;
  @BindView(R.id.button_after_like_voting)
  ImageView buttonAfterLikeVoting;
  @BindView(R.id.textview_name_dialog_fragment_voting)
  TextView textviewNameDialogFragmentVoting;
  @BindView(R.id.button_share_voting)
  ImageView buttonShareVoting;
  @BindView(R.id.invisible_relative_dialog_fragment_voting)
  RelativeLayout invisibleRelativeDialogFragmentVoting;
  @BindView(R.id.progress)
  ProgressBar progress;
  private String nama, img, id_voting, id_session, status_session, voting;
  private VotingDialogPresenterGetSession votingDialogPresenterGetSession;
  private VotingDialogPresenterVotingRate votingDialogPresenterVotingRate;

  public VotingDialogFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_voting_dialog, container, false);
    ButterKnife.bind(this, v);
    getIntent();
    setPresenter();
    setView();
    buttonShareVoting.setOnClickListener(v1 -> {
      IntentShare();
    });
    buttonAfterLikeVoting.setOnClickListener(v12 -> {
      buttonBeforeLikeVoting.setVisibility(View.VISIBLE);
      buttonAfterLikeVoting.setVisibility(View.INVISIBLE);
      votingDialogPresenterVotingRate
          .getDataVotingDialogViewVotingRate(id_voting, "unvote", id_session);
    });

    buttonBeforeLikeVoting.setOnClickListener(v13 -> {
      buttonAfterLikeVoting.setVisibility(View.VISIBLE);
      buttonBeforeLikeVoting.setVisibility(View.INVISIBLE);
      votingDialogPresenterVotingRate.getDataVotingDialogViewVotingRate(id_voting, "vote", "0");
    });
    return v;
  }

  private void setView() {
    textviewNameDialogFragmentVoting.setText(nama);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888);
    Glide.with(getActivity())
        .load(Server.BASE_ASSETS + img)
        .apply(options)
        .into(imageFragmentVotingDialog);
    voting =
        "Dapatkan aplikasi ini di Google Playstore. \nDan jangan lupa untuk mensupport "
            + nama
            + " sebagai pemenang Pinky Hijab Ambassadors di tahun 2018"
            + "\nhttp://play.google.com/store/apps/details?id=" + getActivity().getPackageName();
  }

  private void setPresenter() {
    votingDialogPresenterGetSession = new VotingDialogPresenterGetSession(
        VotingDialogRepositoryInject.provideToVotingDialogRepository(getActivity()));
    votingDialogPresenterVotingRate = new VotingDialogPresenterVotingRate(
        VotingDialogRepositoryInject.provideToVotingDialogRepository(getActivity()));
    votingDialogPresenterGetSession.onAttachView(this);
    votingDialogPresenterVotingRate.onAttachView(this);
    votingDialogPresenterGetSession.getDataVotingDialogGetSession(id_voting);
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    Dialog dialog = super.onCreateDialog(savedInstanceState);
    dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
    return dialog;
  }

  @Override
  public void onStart() {
    super.onStart();
    Dialog dialog = getDialog();
    if (dialog != null) {
      int width = LayoutParams.MATCH_PARENT;
      int height = LayoutParams.WRAP_CONTENT;
      dialog.getWindow().setLayout(width, height);
    }
  }

  private void getIntent() {
    Bundle mArgs = getArguments();
    nama = mArgs.getString("nama");
    id_voting = mArgs.getString("id_voting");
    img = mArgs.getString("img");
  }

  @Override
  public void onSuccesVotingDialogGetSession(String msg, String id_session, String status_session) {
    this.id_session = id_session;
    this.status_session = status_session;
    if (status_session.equals("1")) {
      buttonBeforeLikeVoting.setVisibility(View.INVISIBLE);
      buttonAfterLikeVoting.setVisibility(View.VISIBLE);
    }
    invisibleRelativeDialogFragmentVoting.setVisibility(View.VISIBLE);
    progress.setVisibility(View.GONE);
  }

  private void IntentShare() {
    Intent share = new Intent(Intent.ACTION_SEND);
    share.setType("text/plain");
    share.putExtra(Intent.EXTRA_SUBJECT, "PINKY HIJAB");
    share.putExtra(Intent.EXTRA_TEXT, voting);
    startActivity(Intent.createChooser(share, "Bagikan dengan"));
  }

  @Override
  public void onSuccesVotingDialogGetSessionNull(String msg) {
    invisibleRelativeDialogFragmentVoting.setVisibility(View.VISIBLE);
    progress.setVisibility(View.GONE);
  }

  @Override
  public void onErrorVotingDialogGetSession(String msg) {
    dismiss();
  }

  @Override
  public void onSuccesVotingDialogViewVotingRate(String msg) {
    if (msg.equals("You've already voting")) {
      Toast.makeText(getActivity(), "Kamu telah memilih seseorang", Toast.LENGTH_SHORT).show();
      buttonBeforeLikeVoting.setVisibility(View.VISIBLE);
      buttonAfterLikeVoting.setVisibility(View.INVISIBLE);
    }
    votingDialogPresenterGetSession.getDataVotingDialogGetSession(id_voting);
  }

  @Override
  public void onErrorVotingDialogViewVotingRate(String msg) {

  }
}
