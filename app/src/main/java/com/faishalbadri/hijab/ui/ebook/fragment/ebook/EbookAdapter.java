package com.faishalbadri.hijab.ui.ebook.fragment.ebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbookWithCategory.DataBean;
import com.faishalbadri.hijab.ui.ebook.fragment.ebook.EbookAdapter.ViewHolder;
import com.faishalbadri.hijab.ui.ebook_by_category.EbookByCategoryActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class EbookAdapter extends Adapter<ViewHolder> {

  private Context context;
  private List<DataBean> list_ebook;

  public EbookAdapter(FragmentActivity ebookActivity, ArrayList<DataBean> resultItem) {
    this.context = ebookActivity;
    this.list_ebook = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_ebook_recycler, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.textviewTitleEbook.setText(list_ebook.get(position).getEbook_category_name());
    holder.ebookAdapterItem.setData(context, list_ebook.get(position).getEbook());
    holder.ebookAdapterItem.notifyDataSetChanged();
    holder.constraintTitle.setOnClickListener(v -> {
      Intent i = new Intent(v.getContext(), EbookByCategoryActivity.class);
      i.putExtra("category_id", list_ebook.get(position).getEbook_category_id());
      i.putExtra("category_title", list_ebook.get(position).getEbook_category_name());
      v.getContext().startActivity(i);
    });
  }

  @Override
  public int getItemCount() {
    return list_ebook.size();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = context.obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.textview_title_ebook)
    TextView textviewTitleEbook;
    @BindView(R.id.constraint_title)
    LinearLayout constraintTitle;
    @BindView(R.id.recyclerview_item_ebook)
    RecyclerView recyclerviewItemEbook;
    private EbookAdapterItem ebookAdapterItem;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      recyclerviewItemEbook.setLayoutManager(
          new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
      ebookAdapterItem = new EbookAdapterItem();
      recyclerviewItemEbook.setAdapter(ebookAdapterItem);

    }
  }
}
