package com.faishalbadri.hijab.ui.intro;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.util.SessionManager;

public class IntroActivity extends AppCompatActivity {

  @BindView(R.id.view_pager)
  ViewPager viewPager;
  @BindView(R.id.layoutDots)
  LinearLayout layoutDots;
  @BindView(R.id.btn_next)
  Button btnNext;
  @BindView(R.id.btn_skip)
  Button btnSkip;
  SessionManager sessionManager;
  private MyViewPagerAdapter myViewPagerAdapter;
  private TextView[] dots;
  private int[] layouts;
  ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

    @Override
    public void onPageSelected(int position) {
      addBottomDots(position);

      // changing the next button text 'NEXT' / 'GOT IT'
      if (position == layouts.length - 1) {
        // last page. make button text to GOT IT
        btnNext.setText(getString(R.string.text_register));
        btnSkip.setVisibility(View.GONE);
      } else {
        // still pages are left
        btnNext.setText(getString(R.string.text_next));
        btnSkip.setVisibility(View.VISIBLE);
      }
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    sessionManager = new SessionManager(this);

    if (!sessionManager.isFirstTimeLaunch()) {
      launchAwalScreen();
      finish();
    }

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);

    setContentView(R.layout.activity_intro);
    ButterKnife.bind(this);

    layouts = new int[]{
        R.layout.intro_layout_news,
        R.layout.intro_layout_video,
        R.layout.intro_layout_voting,
        R.layout.intro_layout_event,
        R.layout.intro_layout_ebook
    };

    addBottomDots(0);

    myViewPagerAdapter = new MyViewPagerAdapter();
    viewPager.setAdapter(myViewPagerAdapter);
    viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

  }

  private void addBottomDots(int currentPage) {
    dots = new TextView[layouts.length];

    int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
    int[] colorsInActive = getResources().getIntArray(R.array.array_dot_inactive);

    layoutDots.removeAllViews();
    for (int i = 0; i < dots.length; i++) {
      dots[i] = new TextView(this);
      dots[i].setText(Html.fromHtml("&#8226;"));
      dots[i].setTextSize(35);
      dots[i].setTextColor(colorsInActive[currentPage]);
      layoutDots.addView(dots[i]);
    }

    if (dots.length > 0) {
      dots[currentPage].setTextColor(colorsActive[currentPage]);
    }
  }

  private int getItem(int i) {
    return viewPager.getCurrentItem() + i;
  }

  private void launchAwalScreen() {
    sessionManager.setFirstTimeLaunch(false);
    sessionManager.checkLogin();
  }

  @OnClick(R.id.btn_next)
  public void onBtnNextClicked() {
    int current = getItem(+1);
    if (current < layouts.length) {
      viewPager.setCurrentItem(current);
    } else {
      launchAwalScreen();
    }

  }

  @OnClick(R.id.btn_skip)
  public void onBtnSkipClicked() {
    launchAwalScreen();
  }

  public class MyViewPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;

    public MyViewPagerAdapter() {

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

      View view = layoutInflater.inflate(layouts[position], container, false);
      container.addView(view);

      return view;
    }

    @Override
    public int getCount() {
      return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
      return view == obj;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      View view = (View) object;
      container.removeView(view);
    }
  }
}
