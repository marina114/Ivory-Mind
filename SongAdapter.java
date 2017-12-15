package com.example.zsyoc_000.musicplayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pawankumar on 30/05/17.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    private ArrayList<SongInfo> _songs = new ArrayList<SongInfo>();
    private Context context;
    private OnItemClickListener mOnItemClickListener;

    public SongAdapter(Context context, ArrayList<SongInfo> _songs) {
        this.context = context;
        this._songs = _songs;
    }

    public interface OnItemClickListener {
        void onItemClick(Button b ,View v, SongInfo obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }


    @Override
    public SongHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View myView = LayoutInflater.from(context).inflate(R.layout.row_song,viewGroup,false);
        return new SongHolder(myView);
    }

    @Override
    public void onBindViewHolder(final SongHolder songHolder, final int i) {
        final SongInfo c = _songs.get(i);
        songHolder.tvSongName.setText(_songs.get(i).getSongname());
        songHolder.tvSongArtist.setText(_songs.get(i).getArtistname());
        songHolder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(songHolder.btnAction,v, c, i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return _songs.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        TextView tvSongName,tvSongArtist;
        Button btnAction;
        public SongHolder(View itemView) {
            super(itemView);
            tvSongName = (TextView) itemView.findViewById(R.id.tvSongName);
            tvSongArtist = (TextView) itemView.findViewById(R.id.tvArtistName);
            btnAction = (Button) itemView.findViewById(R.id.btnPlay);
        }
    }
}
