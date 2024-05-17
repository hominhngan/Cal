package com.example.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class DatabaseManager {
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DatabaseManager(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Thêm một dòng mới vào cơ sở dữ liệu
    public void addData(String expression, double result) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_EXPRESSION, expression);
        values.put(DBHelper.COLUMN_RESULT, result);
        database.insert(DBHelper.TABLE_NAME, null, values);
    }

    // Lấy tất cả dữ liệu từ cơ sở dữ liệu
    public List<Calculation> getAllData() {
        List<Calculation> dataList = new ArrayList<>();
        Cursor cursor = database.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_ID));
            String expression = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_EXPRESSION));
            double result = cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_RESULT));
            dataList.add(new Calculation(id, expression, result));
            cursor.moveToNext();
        }
        cursor.close();
        return dataList;
    }
    //hãy sửa lại ứng dụng để nút = sẽ bị vô hiệu hóa (disable) khi biểu thức phía trên chưa hoàn thiện (không thể tính toán được). Ví dụ 2+ hoặc 3*2//8
}