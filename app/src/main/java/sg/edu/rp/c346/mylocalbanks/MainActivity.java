package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    String type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonDBS);
        btnOCBC = findViewById(R.id.buttonOCBC);
        btnUOB = findViewById(R.id.buttonUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);



    }
    //Creating a context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        int id = v.getId();
        if (id == R.id.buttonDBS) {
            type = "DBS";
        } else if (id == R.id.buttonOCBC) {
            type = "OCBC";
        } else {
            type = "UOB";
        }


    }
    //creating on click context items
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //for item.getItemId = 0
        if (item.getItemId() == 0) {
            if (type.equals("DBS")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

            } else if (type.equals("OCBC")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

            } else {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);

            }


        }
        //for item.getItemId 1
        else {
            if (type.equals("DBS")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18001111111"));
                startActivity(intentCall);

            } else if (type.equals("OCBC")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18003633333"));
                startActivity(intentCall);

            } else {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18002222121"));
                startActivity(intentCall);

            }

        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText(R.string.eDBS);
            btnOCBC.setText(R.string.eOCBC);
            btnUOB.setText(R.string.eUOB);

            return true;
        }else if (id == R.id.ChineseSelection) {
            btnDBS.setText(R.string.cDBS);
            btnOCBC.setText(R.string.cOCBC);
            btnUOB.setText(R.string.cUOB);
            return true;

        }else  {
            btnDBS.setText("Error translation");
            btnOCBC.setText("Error translation");
            btnUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }



}
