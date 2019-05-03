package com.captain.ak.roomwordssample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application)
    {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }

    public void insert(Word word)
    {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word,Void,Void> {

        private WordDao mAsynctaskDao;

        insertAsyncTask(WordDao dao)
        {
            mAsynctaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsynctaskDao.insert(params[0]);
            return null;
        }
    }
}
