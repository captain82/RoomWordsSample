package com.captain.ak.roomwordssample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LayoutInflater mInflater;

    private List<Word> mWords;  //Catched copy of words

    WordListAdapter(Context context){mInflater = LayoutInflater.from(context);}

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View itemView = mInflater.inflate(R.layout.recyclerview_item,viewGroup,false);
        return new WordViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int i) {

        if (mWords!=null)
        {
            Word current = mWords.get(i);
            wordViewHolder.wordItemview.setText(current.getmWord());
        }
        else
        {
            wordViewHolder.wordItemview.setText("No Word");
        }
    }

    void setWords(List<Word> words)
    {
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mWords!=null)
            return mWords.size();
        else
            return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder{

        private final TextView wordItemview;



        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemview = itemView.findViewById(R.id.textView);
        }
    }
}
