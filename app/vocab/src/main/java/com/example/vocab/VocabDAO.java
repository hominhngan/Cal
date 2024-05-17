package com.example.vocab;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface VocabDAO {
    @Insert
    void insertAll(Vocab... vocabs);

    @Query("SELECT * FROM Vocab")
    List<Vocab> getAll();

}
