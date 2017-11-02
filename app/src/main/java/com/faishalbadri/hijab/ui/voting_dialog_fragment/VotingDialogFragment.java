package com.faishalbadri.hijab.ui.voting_dialog_fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.di.VotingDialogRepositoryInject;
import com.faishalbadri.hijab.util.Server;

/**
 * A simple {@link Fragment} subclass.
 */
public class VotingDialogFragment extends DialogFragment implements
    VotingDialogContract.VotingDialogViewGetSession, VotingDialogContract.VotingDialogViewLike,
    VotingDialogContract.VotingDialogViewUnlike {


  @BindView(R.id.image_fragment_voting_dialog)
  ImageView imageFragmentVotingDialog;
  @BindView(R.id.btn_before_like_voting)
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
  String nama, img, id_user, id_voting, id_session, status_session;
  VotingDialogPresenterGetSession votingDialogPresenterGetSession;
  VotingDialogPresenterLike votingDialogPresenterLike;
  VotingDialogPresenterUnlike votingDialogPresenterUnlike;

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
    buttonAfterLikeVoting.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        buttonBeforeLikeVoting.setVisibility(View.VISIBLE);
        buttonAfterLikeVoting.setVisibility(View.INVISIBLE);
        votingDialogPresenterUnlike.getDataVotingDialogUnlike(id_voting,id_session);
      }
    });

     buttonBeforeLikeVoting.setOnClickListener(new OnClickListener() {
       @Override
       public void onClick(View v) {
         buttonAfterLikeVoting.setVisibility(View.VISIBLE);
         buttonBeforeLikeVoting.setVisibility(View.INVISIBLE);
         votingDialogPresenterLike.getDataVotingDialogLike(id_voting,id_user);
       }
     });
    return v;
  }

  private void setView() {
    textviewNameDialogFragmentVoting.setText(nama);
    RequestOptions options = new RequestOptions().fitCenter().format(DecodeFormat.PREFER_ARGB_8888);
    Glide.with(getActivity())
        .load(Server.BASE_IMG + img)
        .apply(options)
        .into(imageFragmentVotingDialog);
  }

  private void setPresenter() {
    votingDialogPresenterGetSession = new VotingDialogPresenterGetSession(
        VotingDialogRepositoryInject.provideToVotingDialogRepository(getActivity()));
    votingDialogPresenterLike = new VotingDialogPresenterLike(
        VotingDialogRepositoryInject.provideToVotingDialogRepository(getActivity()));
    votingDialogPresenterUnlike = new VotingDialogPresenterUnlike(
        VotingDialogRepositoryInject.provideToVotingDialogRepository(getActivity()));
    votingDialogPresenterGetSession.onAttachView(this);
    votingDialogPresenterLike.onAttachView(this);
    votingDialogPresenterUnlike.onAttachView(this);
    votingDialogPresenterGetSession.getDataVotingDialogGetSession(id_user,id_voting);
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
    id_user = mArgs.getString("id_user");
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
  public void onSuccesVotingDialogLike(String msg) {
    votingDialogPresenterGetSession.getDataVotingDialogGetSession(id_user,id_voting);
  }

  @Override
  public void onErrorVotingDialogLike(String msg) {
    dismiss();
  }

  @Override
  public void onSuccesVotingDialogUnlike(String msg) {
    votingDialogPresenterGetSession.getDataVotingDialogGetSession(id_user,id_voting);
  }

  @Override
  public void onErrorVotingDialogUnlike(String msg) {

  }
}
