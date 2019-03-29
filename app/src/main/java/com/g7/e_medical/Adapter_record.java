package com.g7.e_medical;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter_record extends RecyclerView.Adapter<Adapter_record.recoredHolder> {

    private List<M_recored> m_recoreds = new ArrayList<>();

    private OnItemClickListener listener;


    @NonNull
    @Override
    public recoredHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recored_item, viewGroup, false);
        return new recoredHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recoredHolder recoredHolder, int i) {
        M_recored current_recored = m_recoreds.get(i);
        recoredHolder.name.setText(current_recored.getName());
        recoredHolder.blood.setText(current_recored.getBlood());
    }

    @Override
    public int getItemCount() {
        return m_recoreds.size();
    }

    public void setM_recoreds(List<M_recored> m_recoreds) {
        this.m_recoreds = m_recoreds;
        notifyDataSetChanged();//change
    }

    public M_recored getM_record(int i) {
        return m_recoreds.get(i);
    }

    class recoredHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView blood;

        public recoredHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            blood = itemView.findViewById(R.id.blood);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int p = getAdapterPosition();
                    if (listener != null && p != RecyclerView.NO_POSITION) {
                        listener.onItemClick(m_recoreds.get(p));
                    }
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onItemClick(M_recored m_recored);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


}
