package edu.snhu633.jhrichardson.ace.recycler.restaurant.list.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.snhu633.jhrichardson.ace.recycler.restaurant.R;
import edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AppMainMenuModel;

public class RecyclerViewListAdapter extends RecyclerView.Adapter {

    ArrayList mValues;
    Context mContext;
    protected ItemListener mListener;

    public RecyclerViewListAdapter(ArrayList<AppMainMenuModel> mValues, Context mContext, ItemListener mListener) {
        this.mValues = mValues;
        this.mContext = mContext;
        this.mListener = mListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder Vholder, int position) {
        ViewHolder viewHolder = (ViewHolder)Vholder;
        viewHolder.setData((AppMainMenuModel) mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(AppMainMenuModel item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        public AppMainMenuModel item;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            textView = (TextView) v.findViewById(R.id.textView);
            imageView = (ImageView) v.findViewById(R.id.imageView);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);
        }

        public void setData(AppMainMenuModel item) {
            this.item = item;
            textView.setText(item.getText());
            imageView.setImageResource(item.getDrawable());
            relativeLayout.setBackgroundColor(Color.parseColor(item.getColor()));
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }
}
