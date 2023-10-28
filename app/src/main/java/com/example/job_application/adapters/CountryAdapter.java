package com.example.job_application.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.job_application.R;
import com.example.job_application.models.CountryDetailedInfo;
import com.makeramen.roundedimageview.RoundedImageView;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private List<CountryDetailedInfo> data; // Replace 'String' with your actual data type
    private LayoutInflater inflater;
    private ItemClickListener clickListener;
    private Context context ;
    // Constructor
    public CountryAdapter(Context context, List<CountryDetailedInfo> data) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the item layout and create the ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_countries, parent, false);
        return new ViewHolder(view);
    }

    // Bind data to the ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CountryDetailedInfo item = data.get(position);
        holder.tvCountryName.setText(item.name.common);
        Glide.with(context)
                .load(item.flags.png)
                .centerCrop()
                .into(holder.imgCountryFlag);
    }

    // Return the total number of items
    @Override
    public int getItemCount() {
        return data.size();
    }

    // Provide a reference to the views for each data item
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCountryName;
        RoundedImageView imgCountryFlag;

        ViewHolder(View itemView) {
            super(itemView);
            tvCountryName = itemView.findViewById(R.id.tvCountryName);
            imgCountryFlag = itemView.findViewById(R.id.imgCountryFlag);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    // Convenience method for getting data at click position
    public CountryDetailedInfo getItem(int id) {
        return data.get(id);
    }

    // Allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    // Parent activity or fragment will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
