package com.chubbymobile.wwh.truckonroad.utility;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chubbymobile.wwh.truckonroad.PromotionActivity;
import com.chubbymobile.wwh.truckonroad.R;
import com.chubbymobile.wwh.truckonroad.bean.Model;
import com.chubbymobile.wwh.truckonroad.bean.Reservations;
import com.chubbymobile.wwh.truckonroad.utility.MultiViewTypeAdapter;

import java.util.ArrayList;
import java.util.List;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.events.OnBannerClickListener;
import ss.com.bannerslider.views.BannerSlider;

public class ChassisAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Reservations> dataList;
    private static final int ITEM_VIEW_TYPE_HEADER = 0;
    private static final int ITEM_VIEW_TYPE_ITEM = 1;
    private static final int ITEM_VIEW_TYPE_FOOTER = 2;

    public ChassisAdapter(List<Reservations> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_VIEW_TYPE_HEADER) {
            return new HeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_header, null));
        } else if (viewType == ITEM_VIEW_TYPE_ITEM){
            return new BodyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, null));
        } else if (viewType == ITEM_VIEW_TYPE_FOOTER){
           return new FooterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_footer, null));
        }else{
            return new BodyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, null));
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (isHeader(position)) {
            View v = holder.itemView;
            BannerSlider bannerSlider = v.findViewById(R.id.banner_slider1);
            List<Banner> banners = new ArrayList<>();
            banners.add(new DrawableBanner(R.drawable.banner1));
            banners.add(new DrawableBanner(R.drawable.banner2));
            banners.add(new DrawableBanner(R.drawable.banner3));
            bannerSlider.setBanners(banners);
            bannerSlider.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void onClick(int position) {
                    Context context = holder.itemView.getContext();
                    Intent i = new Intent(context, PromotionActivity.class);
                    context.startActivity(i);
                }
            });
        }
        else if(position>=1 && position<=2){
            Reservations res = dataList.get(position - 1);
            ((BodyViewHolder) holder).getTextView().setText(res.getDescription());
            ((BodyViewHolder) holder).getTitleView().setText(res.getNumbers());
        } else{
            ArrayList<Model> list= new ArrayList<>();
            list.add(new Model(Model.IMAGE_TYPE,"FE",R.drawable.fe));
            list.add(new Model(Model.IMAGE_TYPE,"FH",R.drawable.fh));
            list.add(new Model(Model.IMAGE_TYPE,"FM",R.drawable.fm));
            list.add(new Model(Model.IMAGE_TYPE,"FMX",R.drawable.fmx));

            MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list, holder.itemView.getContext());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext(), OrientationHelper.VERTICAL, false);

            RecyclerView mRecyclerView = holder.itemView.findViewById(R.id.recyclerView);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size() + 2;
    }

    public boolean isHeader(int position) {
        return position == 0;
    }

    public boolean isFooter(int position) {
        return position > 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)){
            return ITEM_VIEW_TYPE_HEADER;
        }
        else if (position>=1 && position<=2){
            return ITEM_VIEW_TYPE_ITEM;
        }
        else {
            return ITEM_VIEW_TYPE_FOOTER;
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class BodyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView titleView;
        public BodyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_tv);
            titleView = itemView.findViewById(R.id.title_tv);
        }
        public TextView getTextView() {
            return textView;
        }
        public TextView getTitleView() {
            return titleView;
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
