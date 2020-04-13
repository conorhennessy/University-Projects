package mobiledev.unb.ca.labexam;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mobiledev.unb.ca.labexam.model.GamesInfo;
import mobiledev.unb.ca.labexam.util.JsonUtils;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the RecyclerView and configure it
        mRecyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        // TODO: SharedPreferences
        //  Setup the instance of shared preferences you will be using
        preferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        // TODO
        //  Create an instance of LoadDataTask and execute it
        LoadDataTask task = new LoadDataTask();
        task.execute();
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<GamesInfo> mDataset;

        public MyAdapter(ArrayList<GamesInfo> myDataset) {
            mDataset = myDataset;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView mTextView;
            public CheckBox mCheckBox;

            public ViewHolder(LinearLayout v) {
                super(v);
                mTextView = v.findViewById(R.id.item_textview);
                mCheckBox = v.findViewById(R.id.item_checkbox);
            }
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_layout, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // TODO
            //  Get the item at index position in mDataSet
            final GamesInfo game = mDataset.get(position);

            // TODO
            //  Set the TextView in the ViewHolder to be the name for the city
            holder.mTextView.setText(game.getHostCity());

            // TODO
            //  Set the onClickListener for the TextView in the ViewHolder such
            //  that when it is clicked, it creates an explicit intent to launch DetailActivity
            //  with extra pieces of information in this intent.
            holder.mTextView.setOnClickListener(new View.OnClickListener() {
                Intent detailIntent = new Intent(getApplicationContext(), DetailActivity.class);

                @Override
                public void onClick(View v) {
                    detailIntent.putExtra("num", game.getNumber());
                    detailIntent.putExtra("year", game.getYear());
                    detailIntent.putExtra("date", game.getDates());
                    detailIntent.putExtra("wikiPage", game.getWikipediaLink());
                    detailIntent.putExtra("hostCity", game.getHostCity());

                    startActivity(detailIntent);
                }
            });

            // TODO: SharedPreference
            //  Set the CheckBox in the ViewHolder (holder) to be checked if the
            //  value stored in the shared preferences for the number for this GamesInfo is true, and to
            //  be not checked otherwise; if there is no value in the shared
            //  preferences for this id, then the checkbox should not be checked
            //  (i.e., assume a default value of false for anything not in
            //  the shared preferences).
            holder.mCheckBox.setChecked(preferences.getBoolean(game.getNumber(), false));

            // Hints:
            // https://developer.android.com/reference/android/content/SharedPreferences.html#getBoolean(java.lang.String,%20boolean)
            // https://developer.android.com/reference/android/widget/CheckBox.html
            // https://developer.android.com/reference/android/widget/CompoundButton.html#setChecked(boolean)//

            holder.mCheckBox.setOnCheckedChangeListener(
                    new CompoundButton.OnCheckedChangeListener() {

                        // This method is called when a CheckBox is clicked, and its status
                        // changes from checked to not checked, or from not checked to checked.
                        // isChecked will be true if the CheckBox is now checked, and false if
                        // the CheckBox is now not checked.
                        public void onCheckedChanged(CompoundButton v, boolean isChecked) {
                            // TODO: SharedPreferences
                            //  Get a SharedPreferences.Editor for SharedPreferences
                            //  Hint: https://developer.android.com/reference/android/content/SharedPreferences.html#edit()
                            SharedPreferences.Editor prefEditor = preferences.edit();

                            // TODO: Shared Preferences
                            //  Set the value stored in SharedPreferences for the number for this GamesInfo to be
                            //  the value of isChecked
                            //  Hint: https://developer.android.com/reference/android/content/SharedPreferences.Editor.html#putBoolean(java.lang.String,%20boolean)
                            prefEditor.putBoolean(game.getNumber(), isChecked);

                            // TODO: SharedPreferences
                            //  Apply the changes from this editor
                            //  Hint: https://developer.android.com/reference/android/content/SharedPreferences.Editor.html#apply()
                            prefEditor.apply();
                        }
                    }
            );
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }

    private class LoadDataTask extends AsyncTask<Void, Void, ArrayList<GamesInfo>> {

        protected ArrayList<GamesInfo> doInBackground(Void... params) {
            // TODO
            //  Load the data from the JSON assets file and return the list of cities
            JsonUtils json = new JsonUtils(getApplicationContext());
            return json.getHostCities();
        }

        protected void onPostExecute(ArrayList<GamesInfo> result) {
            // TODO
            //  Use result to set the adapter for the RecyclerView in MainActivity
            mRecyclerView.setAdapter(new MyAdapter(result));
        }
    }
}
