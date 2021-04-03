package com.example.endlessrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final int VIEW_TYPE_ITEM=0;
    private final int VIEW_TYPE_LOADING=1;

    private List<String> mItemList;

    public RecylerViewAdapter(List<String> itemList)
    {
        mItemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
            return new ItemViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
            return new LoadingviewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ItemViewHolder) {

            populateItemRows((ItemViewHolder) holder, position);
        } else if (holder instanceof LoadingviewHolder) {
            showLoadingView((LoadingviewHolder) holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

public int getItemViewType(int position)
{
    return mItemList.get(position)==null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
}

public class ItemViewHolder extends RecyclerView.ViewHolder
{
    TextView tvItem;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        tvItem = itemView.findViewById(R.id.tvItem);
    }
}

private class LoadingviewHolder extends RecyclerView.ViewHolder
{
  ProgressBar progressBar;
    public LoadingviewHolder(@NonNull View itemView) {
        super(itemView);
        progressBar = itemView.findViewById(R.id.progressbar);
    }
}

private void showLoadingView(LoadingviewHolder viewHolder, int position)
{
   //Progressbar would be displayed
}

private  void populateItemRows(ItemViewHolder viewHolder, int position)
{
    String item = mItemList.get(position);
    viewHolder.tvItem.setText(item);
}
}
