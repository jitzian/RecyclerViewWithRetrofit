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
 * Created by User on 10/7/2016.
 */

public class CheeseListAdapter extends RecyclerView.Adapter<CheeseListAdapter.ViewHolder>  {
    public static final String TAG = CheeseListAdapter.class.getName();
    private ArrayList<String> mCheeseList;
    Context context;

    //This is the good constructor
    public CheeseListAdapter(Context context, ArrayList<String> mCheeseList){
        this.context = context;
        this.mCheeseList = mCheeseList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtCheese.setText(mCheeseList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mCheeseList != null ? mCheeseList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtCheese;
        public ViewHolder(View itemView) {
            super(itemView);
            txtCheese = (TextView) itemView.findViewById(R.id.txtCheese);
        }
    }

}
