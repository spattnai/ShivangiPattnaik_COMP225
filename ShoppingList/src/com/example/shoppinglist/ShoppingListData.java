package com.example.shoppinglist;

import static android.provider.BaseColumns._ID;
import static com.example.shoppinglist.Constants.TABLE_NAME;
import static com.example.shoppinglist.Constants.Itemname;
import static com.example.shoppinglist.Constants.Quantity;
import static com.example.shoppinglist.Constants.price;
import static com.example.shoppinglist.Constants.units;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ShoppingListData extends SQLiteOpenHelper {
   private static final String DATABASE_NAME = "shoppinglist.db";
   private static final int DATABASE_VERSION = 1;

   /** Create a helper object for the Events database */
   public ShoppingListData(Context ctx) {
      super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
      db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Itemname+ "VARCHAR" + 
             price+" Integer"  + Quantity+" Integer" + units +"VARCHAR"+"TEXT NOT NULL);");
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion,
         int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
      onCreate(db);
   }

}




