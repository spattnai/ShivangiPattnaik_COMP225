package com.example.shoppinglist;

import android.net.Uri;
import android.provider.BaseColumns;

public interface Constants extends BaseColumns {
   public static final String TABLE_NAME = "Shopping List";
   
   public static final String AUTHORITY = "com.example.shoppinglist";
   public static final Uri CONTENT_URI = Uri.parse("content://"
         + AUTHORITY + "/" + TABLE_NAME);

   
   public static final String price = "Price";
   public static final String Itemname = "Item Name";
   public static final String Quantity = "Quantity";
   public static final String units = "units";
   
   
}
