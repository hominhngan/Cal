package com.example.vocab;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Vocab.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract VocabDAO vocabDAO();


}
