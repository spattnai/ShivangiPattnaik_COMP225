package com.example.shoppinglist;

import android.os.Bundle;



import static android.provider.BaseColumns._ID;
import static com.example.shoppinglist.Constants.TABLE_NAME;
//import static com.example.shoppinglist.Constants.price;
//import static com.example.shoppinglist.Constants.units;
import static com.example.shoppinglist.Constants.Itemname;
import static com.example.shoppinglist.Constants.Quantity;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;

//...

public class ShoppingList extends ListActivity {

   private static String[] FROM = { _ID,  Itemname,Quantity };
   private static String ORDER_BY = Itemname + " DESC";
   private static int[] TO = { R.id.rowid, R.id.itemname,R.id.quantity};
   private ShoppingListData shoppinglist;
    @Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        shoppinglist = new ShoppingListData(this);
        try {
           addItem("Chips");
           Cursor cursor = getItems();
           showItems(cursor);
        } finally {
           shoppinglist.close();
        }
    }

  
    

   private void addItem(String string) {
      // Insert a new record into the Events data source.
      // You would do something similar for delete and update.
      SQLiteDatabase db = shoppinglist.getWritableDatabase();
      ContentValues values = new ContentValues();
      values.put(Itemname, string);
      db.insertOrThrow(TABLE_NAME, null, values);
   }

   private Cursor getItems() {
      // Perform a managed query. The Activity will handle closing
      // and re-querying the cursor when needed.
      SQLiteDatabase db = shoppinglist.getReadableDatabase();
      Cursor cursor = db.query(TABLE_NAME, FROM, null, null, null,
            null, ORDER_BY);
      startManagingCursor(cursor);
      return cursor;
   }

   private void showItems(Cursor cursor) {
      // Set up data binding
      SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
            R.layout.item, cursor, FROM, TO);
      setListAdapter(adapter);
   }
}
