package com.test.app.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.app.R;
import com.test.app.model.Album;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> mAlbum;
    private AlbumAdapter.ClickListener mClickListener;

    public AlbumAdapter(ClickListener clickListener) {
        this.mClickListener = clickListener;
        mAlbum = new ArrayList<>() ;
    }


    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        AlbumViewHolder myViewHolder = new AlbumViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder albumViewHolder, int i) {
        System.out.println("Nikhil 22222::>"+mAlbum);
        albumViewHolder.mTxtUserID.setText(mAlbum.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mAlbum.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {

        TextView mTxtUserID;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            mTxtUserID = itemView.findViewById(R.id.txtUserID);
        }

    }

    public interface ClickListener {
        void launchIntent(String ablumsName);
    }

    public void setData(List<Album> albums) {
        this.mAlbum.addAll(albums);
        notifyDataSetChanged();
    }
}
