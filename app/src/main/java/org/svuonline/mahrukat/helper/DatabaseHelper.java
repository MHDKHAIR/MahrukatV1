package org.svuonline.mahrukat.helper;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import org.svuonline.mahrukat.model.admin;
import org.svuonline.mahrukat.model.city;
import org.svuonline.mahrukat.model.complaint;
import org.svuonline.mahrukat.model.customer;
import org.svuonline.mahrukat.model.distributor;
import org.svuonline.mahrukat.model.distributor_sectors;
import org.svuonline.mahrukat.model.order;
import org.svuonline.mahrukat.model.sector;
import org.svuonline.mahrukat.utils.utils;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, utils.DATABASE_NAME, null, utils.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_admins_table = " CREATE TABLE admins ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'username' TEXT NOT NULL, 'password' TEXT NOT NULL);";
        String create_admins = "INSERT INTO admins (username, password) VALUES ('admin', 'password');";

        String create_distributors_table = " CREATE TABLE distributors ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'full_name' TEXT , 'password' TEXT, 'mobile' INTEGER, 'national_id' INTEGER," +
                "'address' TEXT, 'profile_pic' TEXT, 'cr_no' INTEGER, 'status' TEXT DEFAULT 'active', " +
                "'max_cylinders' INTEGER, 'city_id' INTEGER, 'sector_id' INTEGER, FOREIGN KEY (city_id) REFERENCES cities(id), FOREIGN KEY (sector_id) REFERENCES sectors(id));";

        String create_distributor = "INSERT INTO distributors (full_name, password, mobile, national_id, address, cr_no, max_cylinders) " +
                "VALUES ('distributor', 'password', '0967828483', '1231121', 'dasdm dsdd ll akk', '123456', '100');";

        String create_customers_table = " CREATE TABLE customers ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'full_name' TEXT NOT NULL, 'password' TEXT NOT NULL, 'mobile' INTEGER NOT NULL UNIQUE, 'national_id' INTEGER NOT NULL UNIQUE," +
                "'address' TEXT NOT NULL, 'profile_pic' TEXT, 'card_id' INTEGER NOT NULL UNIQUE, 'status' TEXT NOT NULL DEFAULT 'active', " +
                "'order_no' INTEGER, 'city_id' INTEGER NOT NULL, 'sector_id' INTEGER NOT NULL, 'distributor_id' INTEGER NOT NULL, " +
                "FOREIGN KEY (city_id) REFERENCES cities(id),FOREIGN KEY (distributor_id) REFERENCES distributors(id),  " +
                "FOREIGN KEY (sector_id) REFERENCES sectors(id));";

        String create_complaints_table = " CREATE TABLE complaints ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'distributor_id' INTEGER, 'customer_id' INTEGER, 'reason' TEXT, 'complaints_date' DATETIME, " +
                "'complaints_status' TEXT, FOREIGN KEY (distributor_id) REFERENCES distributors(id), " +
                "FOREIGN KEY (customer_id) REFERENCES customers(id));";

        String create_cities_table = " CREATE TABLE cities ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'name' TEXT NOT NULL);";

        String create_sectors_table = " CREATE TABLE sectors ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'name' TEXT NOT NULL);";
        String create_sectors = "INSERT INTO cities (name) VALUES ('Damascus'),('Aleppo'),('Hama'),('Homs')," +
                "('Tartous'),('Daraa'),('Swedaa'),('Der Al-Zor'),('Al-Hasakeh'),('Raqqa'),('Idleb'),('Qunaitira'),('Lattakia');";

/*        String create_distributor_sectors_table = " CREATE TABLE distributor_sectors ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'sector_id' INTEGER, 'distributor_id' INTEGER, FOREIGN KEY (sector_id) REFERENCES sectors(id), " +
                "FOREIGN KEY (distributor_id) REFERENCES distributors(id));";*/

        String create_orders_table = " CREATE TABLE orders ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'distributor_id' INTEGER, 'requested_quantity' INTEGER, 'request_date' DATETIME, 'status' TEXT NOT NULL, " +
                "'available_quantity' INTEGER NOT NULL, " +
                "'receiving_date' DATETIME, " +
                "FOREIGN KEY (distributor_id) REFERENCES distributors(id));";

        db.execSQL(create_admins_table);
        db.execSQL(create_admins);
        db.execSQL(create_distributors_table);
        db.execSQL(create_distributor);
        db.execSQL(create_customers_table);
        db.execSQL(create_complaints_table);
        db.execSQL(create_cities_table);
        db.execSQL(create_sectors_table);
        db.execSQL(create_sectors);
//        db.execSQL(create_distributor_sectors_table);
        db.execSQL(create_orders_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String drop_admins = "DROP TABLE IF EXISTS admins";
        db.execSQL(drop_admins);
        String drop_distributors = "DROP TABLE IF EXISTS distributors";
        db.execSQL(drop_distributors);
        String drop_customers = "DROP TABLE IF EXISTS customers";
        db.execSQL(drop_customers);
        String drop_complaints = "DROP TABLE IF EXISTS complaints";
        db.execSQL(drop_complaints);
        String drop_cities = "DROP TABLE IF EXISTS cities";
        db.execSQL(drop_cities);
        String drop_sectors = "DROP TABLE IF EXISTS sectors";
        db.execSQL(drop_sectors);
        String drop_distributor_sectors = "DROP TABLE IF EXISTS distributor_sectors";
        db.execSQL(drop_distributor_sectors);
        String drop_orders = "DROP TABLE IF EXISTS orders";
        db.execSQL(drop_orders);

        onCreate(db);
    }

    public long addDistributor(String full_name, String password, String mobile , String national_id, String city_id , String address, String cr_no, String sector_id, String max_cylinders){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("full_name",full_name);
            contentValues.put("password",password);
            contentValues.put("mobile",mobile);
            contentValues.put("national_id",national_id);
            contentValues.put("city_id",city_id);
            contentValues.put("address",address);
            contentValues.put("cr_no",cr_no);
            contentValues.put("sector_id",sector_id);
            contentValues.put("max_cylinders",max_cylinders);
            long res = db.insert("distributors",null,contentValues);
            db.close();
            return res;
        }

    public long addCustomer(String full_name, String password, String mobile , String national_id, String city_id , String address, String card_id, String sector_id, String distributor_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name",full_name);
        contentValues.put("password",password);
        contentValues.put("mobile",mobile);
        contentValues.put("national_id",national_id);
        contentValues.put("city_id",city_id);
        contentValues.put("address",address);
        contentValues.put("card_id",card_id);
        contentValues.put("sector_id",sector_id);
        contentValues.put("distributor_id",distributor_id);
        long res = db.insert("customers",null,contentValues);
        db.close();
        return res;
    }

    public boolean checkAdmin(String username, String password) {
        String[] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = " username " + "=?" + " and " + "password " + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query("admins", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    public boolean checkDistributorIfExist(String cr_no) {
        String[] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = " cr_no " + "=?";
        String[] selectionArgs = {cr_no};
        Cursor cursor = db.query("distributors", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    public boolean checkCustomerIfExist(String card_id) {
        String[] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = " card_id " + "=?";
        String[] selectionArgs = {card_id};
        Cursor cursor = db.query("customers", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    public boolean checkDistributor(String cr_no, String password) {
        String[] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = " cr_no " + "=?" + " and " + "password " + "=?";
        String[] selectionArgs = {cr_no, password};
        Cursor cursor = db.query("distributors", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    public boolean checkCustomer(String card_id, String password) {
        String[] columns = {"id"};
        SQLiteDatabase db = getReadableDatabase();
        String selection = " card_id " + "=?" + " and " + "password " + "=?";
        String[] selectionArgs = {card_id, password};
        Cursor cursor = db.query("customers", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    public List<String> getAllDistributors(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT full_name FROM Distributors";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }

    public List<String> getDistributor(String full_name){
        List<String> labels = new ArrayList<String>();

        String selectQuery = "SELECT * FROM distributors WHERE full_name =?";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,new String[] {full_name});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(0));
                labels.add(cursor.getString(1));
                labels.add(cursor.getString(2));
                labels.add(cursor.getString(3));
                labels.add(cursor.getString(4));
                labels.add(cursor.getString(5));
                labels.add(cursor.getString(6));
                labels.add(cursor.getString(7));
                labels.add(cursor.getString(8));
                labels.add(cursor.getString(9));
                labels.add(cursor.getString(10));
                labels.add(cursor.getString(11));
            } while (cursor.moveToNext());
        }
        // closing connection
        cursor.close();
        db.close();

        return labels;
    }

}