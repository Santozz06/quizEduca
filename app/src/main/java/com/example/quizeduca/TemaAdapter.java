package com.example.quizeduca;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TemaAdapter extends RecyclerView.Adapter<TemaAdapter.TemaViewHolder> {

    private List<TemaItem> temaItems;

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
        holder.imageView.setImageResource(item.getImageResId());
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