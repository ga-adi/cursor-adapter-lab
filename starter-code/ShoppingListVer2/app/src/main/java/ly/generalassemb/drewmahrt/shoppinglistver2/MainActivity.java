package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;
import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.shopping_list_view);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        DatabaseHelper db = new DatabaseHelper(this);
        db.seedList();












    }


}
