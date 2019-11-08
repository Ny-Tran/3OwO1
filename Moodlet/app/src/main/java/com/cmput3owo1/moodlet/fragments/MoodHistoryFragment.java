package com.cmput3owo1.moodlet.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cmput3owo1.moodlet.R;
import com.cmput3owo1.moodlet.adapters.MoodEventAdapter;
import com.cmput3owo1.moodlet.models.EmotionalState;
import com.cmput3owo1.moodlet.models.MoodEvent;

import java.util.ArrayList;

public class MoodHistoryFragment extends Fragment implements MoodEventAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private MoodEventAdapter recyclerAdapter;
    private ArrayList<MoodEvent> moodEventList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mood_history, container, false);

        recyclerView = view.findViewById(R.id.mood_event_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        moodEventList = new ArrayList<>();

        EmotionalState[] emotions = {EmotionalState.HAPPY, EmotionalState.ANGRY, EmotionalState.SCARED, EmotionalState.SAD};

        for (int i = 0; i < emotions.length; ++i) {
            moodEventList.add((new MoodEvent(emotions[i])));
        }

        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

        recyclerAdapter = new MoodEventAdapter(moodEventList, this);
        recyclerView.setAdapter(recyclerAdapter);


        return view;


    }

    @Override
    public void onItemClick(int pos) {
        // Implement for editing a mood event
    }

    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            moodEventList.remove(viewHolder.getAdapterPosition());
            recyclerAdapter.notifyDataSetChanged();
        }
    };
}
