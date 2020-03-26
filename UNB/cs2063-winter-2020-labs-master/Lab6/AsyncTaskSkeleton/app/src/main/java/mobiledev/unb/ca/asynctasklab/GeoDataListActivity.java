package mobiledev.unb.ca.asynctasklab;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import mobiledev.unb.ca.asynctasklab.model.GeoData;

/**
 * An activity representing a list of GeoData. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link GeoDataDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class GeoDataListActivity extends AppCompatActivity {

    private static final String TAG = "GeoDataListActivity";
    private static final int DOWNLOAD_TIME = 4;      // Download time simulation

    private List<GeoData> mGeoDataList;
    private Button mBgButton;

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_geodata_list);

        mBgButton = findViewById(R.id.button);

        // HINT:
        // Nothing to do here, just note that you will be completing the downloadGeoData()
        // function. It will set mGeoDataList to contain the downloaded geo data.
        downloadGeoData();

        // Test if we're on a tablet
        if(findViewById(R.id.geodata_detail_container) != null) {
            mTwoPane = true;
            // Create a new detail fragment if one does not exist
            GeoDataDetailFragment geoDataDetailFragment = (GeoDataDetailFragment) fragmentManager.findFragmentByTag("Detail");
            if (geoDataDetailFragment == null) {
                // Init new detail fragment
                geoDataDetailFragment = new GeoDataDetailFragment();
                Bundle args = new Bundle();

                geoDataDetailFragment.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.geodata_detail_container, geoDataDetailFragment, "Detail").commit();
            }
        }

        mBgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Update the geo data
                downloadGeoData();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "I'm working!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (findViewById(R.id.geodata_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    /**
     *  Setting up of RecyclerView with relevant data
     */
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(mGeoDataList));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<GeoData> mValues;

        public SimpleItemRecyclerViewAdapter(List<GeoData> data) {
            mValues = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.geodata_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mGeoData = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).getTitle());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**
                     * Setting the data to be sent to the Detail portion of the template.
                     * Here, we send the title, longitude, and latitude of the Earthquake
                     * that was clicked in the RecyclerView. The Detail Activity/Fragment
                     * will then display this information. Condition check is whether we
                     * are twoPane on a Tablet, which varies how we pass arguments to the
                     * participating activity/fragment.
                     */
                    String title = holder.mGeoData.getTitle();
                    String lng = holder.mGeoData.getLongitude();
                    String lat = holder.mGeoData.getLatitude();

                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(GeoDataDetailFragment.TITLE, title);
                        arguments.putString(GeoDataDetailFragment.LNG, lng);
                        arguments.putString(GeoDataDetailFragment.LAT, lat);
                        GeoDataDetailFragment fragment = new GeoDataDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.geodata_detail_container, fragment)
                                .commit();
                    } else {
                        // TODO
                        //  Create an Intent to start GeoDataDetailActivity. You'll need
                        //  to add some extras to this intent. Look at that class, and the
                        //  example Fragment transaction for the two pane case above, to
                        //  figure out what you need to add.

                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public GeoData mGeoData;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = view.findViewById(R.id.id);
                mContentView = view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }

    private void downloadGeoData() {
        // TODO
        //  Check whether there is a network connection. If there is, Create a DownLoaderTask
        //  and execute it. If there isn't, create a Toast indicating that there is no network
        //  connection.
        //  Hint: Read this for help on checking network connectivity:
        //  https://developer.android.com/training/monitoring-device-state/connectivity-monitoring.html
        //  Hint: Read this for help with Toast:
        //  http://developer.android.com/guide/topics/ui/notifiers/toasts.html
    }

    public class DownloaderTask extends AsyncTask<Void, Integer, String> {
        // TODO
        //  Get a reference to the progress bar so we can interact with it later

        @Override
        protected void onPreExecute() {
            /** Anything executed in here will be done on the UI thread before
             *  the doInBackground method is executed. This allows some prep work
             *  to be completed on the UI thread before the new thread activates.
             */

            // TODO
            //  Disable the button so it can't be clicked again once a download has been started
            //  Hint: Button is subclass of TextView. Read this document to see how to disable it.
            //  http://developer.android.com/reference/android/widget/TextView.html


            // TODO
            //  Set the progress bar's maximum to be DOWNLOAD_TIME, its initial progress to be
            //  0, and also make sure it's visible.
            //  Hint: Read the documentation on ProgressBar
            //  http://developer.android.com/reference/android/widget/ProgressBar.html


        }
        @Override
        protected String doInBackground(Void... params) {
            // TODO
            //  Create an instance of JsonUtils and get the data from it. Store the data
            //  in mGeoDataList

            // Leave this while loop here to simulate a lengthy download
            for(int i = 0; i < DOWNLOAD_TIME; i++) {
                try {
                    Thread.sleep(1000);
                    // TODO
                    //  Update the progress bar; calculate an appropriate value for
                    //  the new progress using i

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return getString(R.string.download_complete);
        }

        /** Once the DownloaderTask completes, hide the progress bar and update the
         *  RecyclerView with the geographic earthquake data we simulated downloading.
         */
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            // TODO
            //  Now that the download is complete, enable the button again


            // TODO
            //  Reset the progress bar, and make it disappear


            // TODO
            //  Setup the RecyclerView


            // TODO
            //  Create a Toast indicating that the download is complete. Set its text
            //  to be the result String from doInBackground

        }

        /** Handle mProgressBar display updates whenever the AsyncTask subclass
         * DownloaderTask notifies its onProgressUpdate()
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            // TODO
            //  Update the progress bar using values

        }
    }
}
