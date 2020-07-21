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

/**
 * This class is used as the view adapter for the application main menu.  It manages all the
 * children in the view nad holds them for the layout.
 *
 * @see edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AppMainMenuModel
 * @see androidx.recyclerview.widget.RecyclerView
 *
 * @author jhrichardson
 */
public class RecyclerViewListAdapter extends RecyclerView.Adapter {

    ArrayList mValues;
    Context mContext;
    protected ItemListener mListener;

    /**
     * Constructor for the RecyclerViewListAdapter
     * @param mValues the model to manage as children
     * @param mContext the calling context
     * @param mListener callback used on the children for click notifications
     */
    public RecyclerViewListAdapter(ArrayList<AppMainMenuModel> mValues,
                                   Context mContext, ItemListener mListener) {
        this.mValues = mValues;
        this.mContext = mContext;
        this.mListener = mListener;
    }


    /**
     * Callback used to inflate the layout and create the view.
     * @param parent  The parent ViewGroup
     * @param viewType The type of View
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item,
                parent, false);
        return new ViewHolder(view);
    }

    /**
     * The model binder for the view
     * @param Vholder The view holder holding the model to be bound
     * @param position  the position of the model item
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder Vholder, int position) {
        ViewHolder viewHolder = (ViewHolder)Vholder;
        viewHolder.setData((AppMainMenuModel) mValues.get(position));
    }

    /**
     * Get the size of the model
     * @return the count or size of the model being managed
     */
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    /**
     * Public interface that is required to be implemented to receive
     * onClick notifications
     */
    public interface ItemListener {
        void onItemClick(AppMainMenuModel item);
    }

    /**
     * Inner class used as the View Holder.  Does all the work for managing
     * the view and bound model
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        public AppMainMenuModel item;

        /**
         * Constructor for ViewHolder.  Collects all the children and their associated data
         * for the model
         * @param v The view for this holder
         */
        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            textView = (TextView) v.findViewById(R.id.textView);
            imageView = (ImageView) v.findViewById(R.id.imageView);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);
        }

        /**
         * Set the data from the model on the view
         * @param item The model item
         *
         * @see edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AppMainMenuModel
         */
        public void setData(AppMainMenuModel item) {
            this.item = item;
            textView.setText(item.getText());
            imageView.setImageResource(item.getDrawable());
            relativeLayout.setBackgroundColor(Color.parseColor(item.getColor()));
        }

        /**
         * Calls the registered ItemListener's onItemClick callback
         * @param view the view invoking this callback
         */
        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }
}
