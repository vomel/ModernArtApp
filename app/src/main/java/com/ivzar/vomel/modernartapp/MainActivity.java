package com.ivzar.vomel.modernartapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Modern_UI";
    private String URL;
    private String CHOOSER_TEXT;
    public static final String SEEKBAR_POSITION = "SEEKBAR_POSITION";
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "MainActivity.onCreate");
        URL = getResources().getString(R.string.moma_url);
        CHOOSER_TEXT = "Load " + URL + " with:";
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final View leftTop = getView(R.id.leftUp);
        final View leftBottom = getView(R.id.leftBottom);
        final View rightTop = getView(R.id.rightUp);
        final View rightBottom = getView(R.id.rightBottom);

        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * @param seekBar  The SeekBar whose progress has changed
             * @param progress The current progress level. This will be in the range 0..max where
             *                 max was set by setMax(int). (The default value for max is 100.)
             * @param fromUser True if the progress change was initiated by the user.
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                changeColor(progress, leftTop);
                changeColor(progress, leftBottom);
                changeColor(progress, rightTop);
                changeColor(progress, rightBottom);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "Progress so far: " + seekBar.getProgress());
                int originalColor = (Integer) leftTop.getTag();
                int red = Color.red(originalColor);
                int green = Color.green(originalColor);
                int blue = Color.blue(originalColor);
                Log.d(TAG, "RGB: " + red + " " + green + " " + blue);
            }
        });
        if (savedInstanceState != null)
            seekBar.setProgress(savedInstanceState.getInt(SEEKBAR_POSITION));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SEEKBAR_POSITION, seekBar.getProgress());
        super.onSaveInstanceState(outState);
    }

    @NonNull
    private View getView(int id) {
        final View view = findViewById(id);
        view.setTag(((ColorDrawable) view.getBackground()).getColor());
        return view;
    }

    private static void changeColor(int progress, View view) {
        int originalColor = (Integer) view.getTag();
        int red = Color.red(originalColor);
        int green = Color.green(originalColor);
        int blue = Color.blue(originalColor);
        int newColor = Color.rgb(
                getNewColor(progress, red),
                getNewColor(progress, green),
                getNewColor(progress, blue)
        );
        view.setBackgroundColor(newColor);
    }

    static int getNewColor(int progress, int originalColor) {
        return originalColor + progress * (255 - originalColor) / 100;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(TAG, "MainActivity.onCreateOptionsMenu");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(TAG, "MainActivity.onOptionsItemSelected");
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setView(this.getLayoutInflater().inflate(R.layout.more_info_view, null))
                    .setPositiveButton(R.string.visit_moma, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            Uri webpage = Uri.parse(URL);
                            Intent baseIntent = new Intent(Intent.ACTION_VIEW, webpage);

                            // Create a chooser intent, for choosing which Activity
                            Intent chooserIntent = Intent.createChooser(baseIntent, CHOOSER_TEXT);

                            // Start the chooser Activity, using the chooser intent
                            startActivity(chooserIntent);
                        }
                    })
                    .setNegativeButton(R.string.not_now, null).create();
            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    Button no = ((AlertDialog) dialogInterface).getButton(DialogInterface.BUTTON_NEGATIVE);
                    no.setBackgroundColor(Color.RED);
                    no.invalidate();

                    Button yes = ((AlertDialog) dialogInterface).getButton(DialogInterface.BUTTON_POSITIVE);
                    yes.setBackgroundColor(Color.GREEN);
                    yes.invalidate();
                }
            });
            dialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
