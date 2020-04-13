package mobiledev.unb.ca.labexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // TODO
        //  Get the intent that started this activity along with the extras added to it
        String num = getIntent().getStringExtra("num");
        String year = getIntent().getStringExtra("year");
        String dates = getIntent().getStringExtra("dates");
        String wikiPage = getIntent().getStringExtra("wikiPage");
        String hostCity = getIntent().getStringExtra("hostCity");

        // TODO
        //  Set the details for the number, year, and dates text views
        TextView numText = findViewById(R.id.number_textview);
        TextView yearText = findViewById(R.id.year_textview);
        TextView datesText = findViewById(R.id.dates_textview);
        numText.setText(num);
        yearText.setText(year);
        datesText.setText(dates);

        // TODO
        //  Set an onClickListener such that when this button is clicked, an implicit intent is started
        //  to open the wikipedia URL in a web browser. Be sure to check that there is
        //  an application installed that can handle this intent before starting it.
        //  If the intent can't be started, show a toast indicating this.
        // Hints:
        // https://developer.android.com/reference/android/content/Intent.html#resolveActivity(android.content.pm.PackageManager)
        // https://developer.android.com/guide/components/intents-common.html#Browser
        // https://developer.android.com/reference/android/net/Uri.html#parse(java.lang.String)

        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(wikiPage));

        Button wikiButton = findViewById(R.id.wiki_button);
        wikiButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Unable to open Wiki page! Can not open intent", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        // TODO
        //  Set the title of the action bar to be the host city name
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(hostCity);
    }
}
