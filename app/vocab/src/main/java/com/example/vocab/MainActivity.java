package com.example.vocab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements VocabPageChangeInterface {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Vocab> listVocab = new ArrayList();
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "vocab_database ").build();

// Insert vocab into the database
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.vocabDAO().insertAll(
                        new Vocab("Cat", "Mèo", "[kæt] "),
                        new Vocab("Tiger", "Hổ", "[ˈtaɪɡər] "),
                        new Vocab("Fish", "Cá", "[fɪʃ] "),
                        new Vocab("Bird", "Chim", "[bɜrd] "),
                        new Vocab("Elephant", "Voi", "[ˈɛlɪfənt] "),
                        new Vocab("Snake", "Rắn", "[sneɪk] "),
                        new Vocab("Monkey", "Khỉ", "[ˈmʌŋki] "),
                        new Vocab("Bear", "Gấu", "[bɛr] "),
                        new Vocab("Cow", "Bò", "[kaʊ] "),
                        new Vocab("Horse", "Ngựa", "[hɔrs] "),
                        new Vocab("Duck", "Vịt", "[dʌk] "),
                        new Vocab("Chicken", "Gà", "[ˈtʃɪkɪn] "),
                        new Vocab("Sheep", "Cừu", "[ʃiːp] "),
                        new Vocab("Goat", "Dê", "[ɡoʊt] "),
                        new Vocab("Wolf", "Sói", "[wʊlf] "),
                        new Vocab("Fox", "Cáo", "[fɑks] "),
                        new Vocab("Rabbit", "Thỏ", "[ˈræbɪt] "),
                        new Vocab("Frog", "Ếch", "[frɔɡ] "),
                        new Vocab("Ant", "Kiến", "[ænt] "),
                        new Vocab("Bee", "Ong", "[bi] ")

                );
            }
        }).start();

// Get all vocabs from the database
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Vocab> listVocab = db.vocabDAO().getAll();
                // Use listVocab here
                // Khởi tạo Adapter và đặt Adapter cho RecyclerView
                MyAdapter adapter = new MyAdapter(getApplicationContext(), (ArrayList<Vocab>) listVocab, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }
        }).start();

        // Khởi tạo Adapter và đặt Adapter cho RecyclerView


    }
        @Override
        public void goToNextPage() {
            // Implement the logic to go to the next page here
        }

    @Override
    public void gotoPreviousPage() {

    }

    @Override
    public void goBack() {

    }
}
