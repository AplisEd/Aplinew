package com.edu.notification;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.edu.aplis.R;
import com.edu.discover.ClickAdapter;
import com.edu.search.BooksSearch;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private Context mcontext;
    private ArrayList<NotificationData> notificationList;
    ClickAdapter clickAdapter;

    public NotificationAdapter(Context context, ArrayList<NotificationData> notificationList, ClickAdapter clickAdapter) {
        this.mcontext = context;
        this.notificationList = notificationList;
        this.clickAdapter = clickAdapter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_notification, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

        final NotificationData listModel = notificationList.get(position);

        viewHolder.DescriptionTV.setText(listModel.getTitle());
        viewHolder.TimeTV.setText(listModel.getCreatedAt());
        String title_Des = "";
       /* viewHolder.eventslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAdapter.clickoncard(viewHolder.image,position,listModel.getProduct_id(),listModel.getPro_image(),"","",null,""
                ,"");
            }
        });*/

       if (!TextUtils.isEmpty((CharSequence) listModel.getImage())) {
           Glide.with(mcontext)
                   .load(listModel.getImage())
                   .thumbnail(0.05f)
                   .centerCrop()
                   .placeholder(R.drawable.placeholder)
                   .error(R.drawable.placeholder)
                   .into(viewHolder.ImageIV);
       }
       else
       {
           viewHolder.ImageIV.setImageDrawable(mcontext.getResources().getDrawable(R.drawable.placeholder));
       }
    }


    public void removeItem(int position) {
        notificationList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, notificationList.size());
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        RelativeLayout notifyRL;
        TextView DescriptionTV, TimeTV;
        ImageView ImageIV, ImageIVText;
        Activity activity;
        int pos;

        public ViewHolder(View itemView) {
            super(itemView);
            this.activity = activity;

            DescriptionTV = (TextView) itemView.findViewById(R.id.descriptionTV);
            notifyRL = (RelativeLayout) itemView.findViewById(R.id.notifyRL);
            TimeTV = (TextView) itemView.findViewById(R.id.timeTV);

            ImageIV = (ImageView) itemView.findViewById(R.id.imageIV);
            ImageIVText = (ImageView) itemView.findViewById(R.id.imageIVText);

        }
    }
}