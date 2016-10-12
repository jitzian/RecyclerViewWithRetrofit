package net.sgoliver.android.navigationdrawer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.sgoliver.android.navigationdrawer.R;

import java.util.ArrayList;

/**
 * Created by User on 10/11/2016.
 */

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {
    public static final String TAG = PostListAdapter.class.getName();
    private ArrayList<String>lstRes;
    Context context;

    public PostListAdapter(Context context, ArrayList<String>lstRes){
        this.context = context;
        this.lstRes = lstRes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtPost.setText(lstRes.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return lstRes != null ? lstRes.size() : 0;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtPost;
        public ViewHolder(View itemView) {
            super(itemView);
            txtPost = (TextView) itemView.findViewById(R.id.txtPost);
        }
    }

}
