package com.zzg.object.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzg.object.R;
import com.zzg.object.interf.OnRecycleItemClickListener;
import com.zzg.object.model.MainModel;
import com.zzg.object.view.BannerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by apple on 2016/11/15.
 */

public class MainRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //普通item
    public static final int TYPE_1 = 1;
    //bannerView
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;

    private List<MainModel> mList;
    private OnRecycleItemClickListener onItemClickListener;
    private Context mContext;
    private int[] imgs = {R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.f,R.mipmap.g,R.mipmap.h,R.mipmap.l};
    private List<View> viewList;

    public MainRecycleAdapter(List<MainModel> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        viewList = new ArrayList<View>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView image = new ImageView(mContext);
            image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //设置显示格式
            Glide.with(mContext)
                    .load(imgs[i])
                    .centerCrop()
                    .into(image);
            viewList.add(image);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getCode();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_1) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_1, parent, false);
            return new Hold(v);
        } else if (viewType == TYPE_2) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_2, parent, false);
            return new BannerHold(v);
        } else if (viewType == TYPE_3) {
            return null;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case TYPE_1:
                Hold hold = (Hold) holder;
                //随机颜色
                Random random = new Random();
                int ranColor = 0xff000000 | random.nextInt(0x00ffffff);
                hold.cardview.setCardBackgroundColor(ranColor);
                hold.mUsernameView.setText(mList.get(position).getTitle());
                break;
            case TYPE_2:
                BannerHold bannerHold=(BannerHold)holder;
                bannerHold.bannerView.setViewList(viewList);
                bannerHold.bannerView.startLoop(true);
                break;
            case TYPE_3:
                break;
        }


    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public void setOnRecyclerViewListener(OnRecycleItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    class Hold extends RecyclerView.ViewHolder {
        private TextView mUsernameView;
        private CardView cardview;

        public Hold(View itemView) {
            super(itemView);
            mUsernameView = (TextView) itemView.findViewById(R.id.mUsernameView);
            cardview = (CardView) itemView.findViewById(R.id.cardview);
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.click(getLayoutPosition(), mList.get(getLayoutPosition()));
                }
            });
        }
    }

    class BannerHold extends RecyclerView.ViewHolder {
        private BannerView bannerView;

        public BannerHold(View itemView) {
            super(itemView);
            bannerView = (BannerView) itemView.findViewById(R.id.banner);
        }
    }


}
