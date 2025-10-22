package com.quizeduca.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TemaAdapter extends RecyclerView.Adapter<TemaAdapter.TemaViewHolder> {

    private List<TemaItem> temaItems;
    // Cache simples por resourceId -> Bitmap já aparado
    private static final LruCache<Integer, Bitmap> bitmapCache = new LruCache<>(20);

    public TemaAdapter(List<TemaItem> temaItems) {
        this.temaItems = temaItems;
    }

    @NonNull
    @Override
    public TemaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tema, parent, false);
        return new TemaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemaViewHolder holder, int position) {
        TemaItem item = temaItems.get(position);
        int resId = item.getImageResId();
        Bitmap bmp = bitmapCache.get(resId);
        if (bmp == null) {
            Bitmap decoded = BitmapFactory.decodeResource(holder.imageView.getResources(), resId);
            bmp = BitmapUtils.trimTransparentBorders(decoded);
            if (bmp != null) {
                bitmapCache.put(resId, bmp);
            }
        }
        if (bmp != null) {
            holder.imageView.setImageBitmap(bmp);
        } else {
            holder.imageView.setImageResource(resId);
        }
    }

    @Override
    public int getItemCount() {
        return temaItems.size();
    }

    public static class TemaViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public TemaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgTema);
        }
    }
}