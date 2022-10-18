package com.beckytech.biologygrade9studenttextbook;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder> {

    private final List<ModelViewPager> modelViewPagers;
    private final viewPagerClickListener clickListener;

    public ViewPagerAdapter(List<ModelViewPager> modelViewPagers, viewPagerClickListener clickListener) {
        this.modelViewPagers = modelViewPagers;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pager_item_list, parent, false);
        return new ViewPagerHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewPagerHolder holder, int position) {
        ModelViewPager viewPager = modelViewPagers.get(position);
        holder.title.setText(viewPager.getTitle());
        holder.desc.setText("Download from play store");
        holder.imageView.setImageResource(viewPager.getImage());
        holder.itemView.setOnClickListener(v -> clickListener.itemClicked(viewPager));

    }

    @Override
    public int getItemCount() {
        return modelViewPagers.size();
    }

    public interface viewPagerClickListener {
        void itemClicked(ModelViewPager modelViewPager);
    }

    public static class ViewPagerHolder extends RecyclerView.ViewHolder {
        TextView title, desc;
        ImageView imageView;
        public ViewPagerHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_view_pager);
            desc = itemView.findViewById(R.id.subTitle_view_pager);
            imageView = itemView.findViewById(R.id.image_view_pager);
        }
    }
}
