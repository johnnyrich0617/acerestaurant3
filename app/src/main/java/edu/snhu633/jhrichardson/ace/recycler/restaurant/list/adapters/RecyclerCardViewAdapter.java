package edu.snhu633.jhrichardson.ace.recycler.restaurant.list.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.snhu633.jhrichardson.ace.recycler.restaurant.R;
import edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AboutUsCardViewModel;
import edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AppMainMenuModel;


public class RecyclerCardViewAdapter extends RecyclerView.Adapter{

    ArrayList cardValues;
    Context mContext;
    protected ItemListener mListener;

    public RecyclerCardViewAdapter(ArrayList<AboutUsCardViewModel> cardValues, Context mContext,
                                   ItemListener mListener) {
        this.cardValues = cardValues;
        this.mContext = mContext;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.notables_card_view,
                parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyclerCardViewAdapter.CardViewHolder viewHolder = (RecyclerCardViewAdapter.CardViewHolder)holder;
        viewHolder.setData((AboutUsCardViewModel) cardValues.get(position));
    }

    @Override
    public int getItemCount() {
        return cardValues.size();
    }

    /**
     * Public interface that is required to be implemented to receive
     * onClick notifications
     */
    public interface ItemListener {
        void onItemClick(AboutUsCardViewModel item);
    }

    /**
     * Inner class used as the View Holder.  Does all the work for managing
     * the view and bound model
     */
    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView cardTitleView;
        public TextView cardNameView;
        public ImageView cardImageView;
        public TextView  cardTextView;
        public AboutUsCardViewModel item;

        /**
         * Constructor for ViewHolder.  Collects all the children and their associated data
         * for the model
         * @param v The view for this holder
         */
        public CardViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            cardTitleView = (TextView) v.findViewById(R.id.cardTitle);
            cardNameView = (TextView) v.findViewById(R.id.cardName);
            cardTextView = (TextView) v.findViewById(R.id.cardText);
            cardImageView = (ImageView) v.findViewById(R.id.cardImage);
        }

        /**
         * Set the data from the model on the view
         * @param item The model item
         *
         * @see edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AboutUsCardViewModel
         */
        public void setData(AboutUsCardViewModel item) {
            this.item = item;
            cardTitleView.setText(item.getCardTitlePlaceholder());
            cardNameView.setText(item.getCardNamePlaceholder());
            cardTextView.setText(item.getCardTextPlaceholder());
            cardImageView.setImageResource(item.getCardIconIdPlaceholder());
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
