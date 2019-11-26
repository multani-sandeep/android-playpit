package com.johnlewis.occo.mfd;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView txtView = findViewById(R.id.textarea);

        setRandomumber((TextView)findViewById(R.id.firstnum));
        setRandomumber((TextView)findViewById(R.id.secondnum));

        TextView operation = findViewById(R.id.operation);
        operation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String operation = ((TextView)findViewById(R.id.operation)).getText().toString();
                ((TextView)findViewById(R.id.operation)).setText(operation.equals("+")?"-":"+");
            }
        });

        FloatingActionButton back = findViewById(R.id.fab_left);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomumber((TextView)findViewById(R.id.firstnum));
                setRandomumber((TextView)findViewById(R.id.secondnum));
                ((TextView)findViewById(R.id.resultMessage)).setText(">");
            }
        });
        FloatingActionButton forward = findViewById(R.id.fab_right);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });

        /*WebView webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClientImpl(getParent()));
        webView.getSettings().setJavaScriptEnabled(true);

        //webView.loadUrl("http://contact-centre-test3.project4.com");
        webView.loadUrl("https://www.yahoo.com");

        FloatingActionButton fab = findViewById(R.id.fab_left);
        BottomNavigationView nav = findViewById(R.id.nav_bar);
        //nav.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView webView = (WebView) findViewById(R.id.webview);
               webView.loadUrl("http://contact-centre-test3.project4.com/dashboard/security");
            }
        });
        FloatingActionButton fabr = findViewById(R.id.fab_right);
        fabr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView webView = (WebView) findViewById(R.id.webview);
                webView.loadUrl("https://www.yahoo.com");
            }
        });
        */
    }

    protected void calculate(){
        int firstnum =  Integer.parseInt(((TextView)findViewById(R.id.firstnum)).getText().toString());
        int secondnum =  Integer.parseInt(((TextView)findViewById(R.id.secondnum)).getText().toString());
        int result =  Integer.parseInt(((TextView)findViewById(R.id.result)).getText().toString());

        int resultInternal =firstnum+secondnum;

        ((TextView)findViewById(R.id.resultMessage)).setText(
                resultInternal == result? "Correct !":"Try again!"
        );

    }

    protected void setRandomumber(TextView view){
        int num = new Random().nextInt(100);
        view.setText(""+num);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
