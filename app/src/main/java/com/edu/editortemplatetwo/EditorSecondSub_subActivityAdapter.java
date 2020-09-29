package com.edu.editortemplatetwo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.edu.aplis.R;
import com.edu.discover.ClickAdapter;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditorSecondSub_subActivityAdapter extends RecyclerView.Adapter<EditorSecondSub_subActivityAdapter.SampleViewHolders>
{
    private List<EditorSub_subModel> itemList;
    private Context context;
    private ClickAdapter clickAdapter;
    public EditorSecondSub_subActivityAdapter(Context context, List<EditorSub_subModel> itemList, ClickAdapter clickAdapter)
    {
        this.itemList = itemList;
        this.context = context;
        this.clickAdapter = clickAdapter;
    }

    @Override
    public SampleViewHolders onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.editor_secondsub_sub_adapter, null);
        SampleViewHolders rcv = new SampleViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final SampleViewHolders holder, final int position)
    {

/*
        Glide.with(context).load(itemList.get(position).getBtn_bg_image()).asBitmap().into(new SimpleTarget<Bitmap>((R.dimen.dp140), (R.dimen.dp140)) {


            @Override
            public void onLoadStarted(Drawable placeholder) {
                super.onLoadStarted(placeholder);
                Drawable color = new ColorDrawable(Color.parseColor(itemList.get(position).getBtn_image()));

//                LayerDrawable ld = new LayerDrawable(new Drawable[]{color, errorDrawable});
//                imageView.setImageDrawable(ld);
                Log.e("TAGEDITORbg_image","failed"+itemList.get(position).getColor_code());

                holder.circle_image.setImageDrawable(color);
            }

            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(context.getResources(), resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    holder.circle_image.setImageBitmap(resource);
                }
            }

            @Override
            public void onLoadFailed(Exception e, Drawable errorDrawable) {
                super.onLoadFailed(e, errorDrawable);
                Drawable color = new ColorDrawable(Color.parseColor(itemList.get(position).getBtn_image()));

//                LayerDrawable ld = new LayerDrawable(new Drawable[]{color, errorDrawable});
//                imageView.setImageDrawable(ld);

                holder.circle_image.setImageDrawable(color);





            }

        });
*/
        String imageUrl=itemList.get(position).getBtn_bg_image();
        if (imageUrl!=null && !TextUtils.isEmpty(imageUrl)) {

            Glide.with(context).load(itemList.get(position).getBtn_bg_image()).asBitmap().into(new SimpleTarget<Bitmap>((R.dimen.dp140), (R.dimen.dp140)) {
                @Override
                public void onLoadStarted(Drawable placeholder) {
                    super.onLoadStarted(placeholder);
                    //  Drawable color = new ColorDrawable(Color.parseColor(itemList.get(position).getBtn_image()));

//                LayerDrawable ld = new LayerDrawable(new Drawable[]{color, errorDrawable});
//                imageView.setImageDrawable(ld);
                    Log.e("TAGEDITORbg_image", "failed" + itemList.get(position).getColor_code());

                    // holder.circle_image.setImageDrawable(color);
                    holder.circle_image.setImageDrawable(context.getResources().getDrawable(R.drawable.placeholder));
                }


                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    Drawable drawable = new BitmapDrawable(context.getResources(), resource);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        holder.circle_image.setImageBitmap(resource);
                    }
                }

                @Override
                public void onLoadFailed(Exception e, Drawable errorDrawable) {
                    super.onLoadFailed(e, errorDrawable);
                    //  Drawable color = new ColorDrawable(Color.parseColor(itemList.get(position).getBtn_image()));

//                LayerDrawable ld = new LayerDrawable(new Drawable[]{color, errorDrawable});
//                imageView.setImageDrawable(ld);
                    Log.e("TAGEDITORbg_image", "failed" + itemList.get(position).getColor_code());

                    // holder.circle_image.setImageDrawable(color);
                    holder.circle_image.setImageDrawable(context.getResources().getDrawable(R.drawable.placeholder));

                }

            });
        }
        else
        {
            // Drawable color = new ColorDrawable(Color.parseColor(itemList.get(position).getBtn_image()));
            // holder.circle_image.setImageDrawable(color);
            holder.circle_image.setImageDrawable(context.getResources().getDrawable(R.drawable.placeholder));
        }
        holder.circle_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAGEDITORbg_image","failed"+itemList.get(position).getColor_code());

                clickAdapter.clickoncard(holder.circle_image,Integer.parseInt(itemList.get(position).getId()),itemList.get(position).getMime_type(),itemList.get(position).getSub_title(),itemList.get(position).getTitle(),itemList.get(position).getDescription(),null,itemList.get(position).getAr_url(),null);
//                        Toast.makeText(context,
//                                "Clicked Position = " + position+ " "+itemList.get(position).getId(), Toast.LENGTH_SHORT)
//                                .show();
            }
        });



        Log.e("TAGEDITORbg_image","color"+itemList.get(position).getColor_code());
//        holder.circle_bg.setBackground();
        holder.subactivity_text.setText(itemList.get(position).getTitle());
    }

    @Override
    public int getItemCount()
    {
        return this.itemList.size();
    }


    public class SampleViewHolders extends RecyclerView.ViewHolder
    {
        public CircleImageView circle_image;
        public TextView subactivity_text;
        public LinearLayout circle_bg;

        public SampleViewHolders(View itemView)
        {
            super(itemView);
            circle_image =  itemView.findViewById(R.id.circle_image);
            circle_bg =  itemView.findViewById(R.id.circle_bg);
            subactivity_text = (TextView) itemView.findViewById(R.id.subactivity_text);
        }

    }



}
