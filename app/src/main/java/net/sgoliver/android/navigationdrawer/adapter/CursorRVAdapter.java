package net.sgoliver.android.navigationdrawer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.sgoliver.android.navigationdrawer.R;

import java.util.List;

/**
 * Created by raian on 14/10/16.
 */

public class CursorRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = CursorRVAdapter.class.getName();
    public List<String> lstRes;
    Context context;


    public CursorRVAdapter(Context context, List<String> lstRes){
        this.context = context;
        this.lstRes = lstRes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_row_contacts, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lstRes.size() > 0 ? lstRes.size() : 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtContacts;
        public ViewHolder(View itemView) {
            super(itemView);
            txtContacts = (TextView) itemView.findViewById(R.id.txtContacts);
        }
    }


}
