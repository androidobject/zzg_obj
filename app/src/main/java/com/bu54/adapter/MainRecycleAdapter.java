package com.bu54.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bu54.canvas.R;
import com.bu54.interf.OnRecycleItemClickListener;
import com.bu54.model.MainModel;
import com.bu54.ui.MainActivity;

import java.util.List;
import java.util.Random;

/**
 * Created by apple on 2016/11/15.
 */

public class MainRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;

    private List<MainModel> mList;
    private OnRecycleItemClickListener onItemClickListener;

    public MainRecycleAdapter(List<MainModel> mList) {
        this.mList = mList;
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
            return null;
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


}
