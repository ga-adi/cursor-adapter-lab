package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {


    ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();


        String brands[] = {
                "Colgate",
                "Downy",
                "Green Giant"
        };
        String items[] = {
                "toothpaste",
                "fabric softener",
                "frozen peas"
        };
        Integer prices[] = {
                5, 4, 3
        };

        SQLiteDatabase db;
        db = openOrCreateDatabase("SHOPPING_LIST.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null);

        db.setVersion(7);
        db.setLocale(Locale.getDefault());

        String createTableSql = "CREATE TABLE IF NOT EXISTS list\n" +
                "            (_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "            brand TEXT,\n" +
                "            item TEXT,\n" +
                "            price INTEGER);";

        db.execSQL(createTableSql);

        Cursor mCursor = db.query("list", null, null, null, null, null, null, null);


        mListView = (ListView) findViewById(R.id.shopping_list_view);

        CursorAdapter mCursorAdapter = new CursorAdapter(MainActivity.this, mCursor, 0) {
            @Override
            public View newView(Context context, Cursor Cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,
                        parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor Cursor) {
                TextView txt = (TextView) view.findViewById(android.R.id.text1);
                String rowData = Cursor.getString(Cursor.getColumnIndex("brand")) +
                         Cursor.getString(Cursor.getColumnIndex("item"));
                txt.setText(rowData);
            }


        };

        mListView.setAdapter(mCursorAdapter);
    }

















    }



