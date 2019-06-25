package com.ssb.app0625;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    //생성자
    public DBHelper(Context context){
        super(context,"soccer.db",null,1);
    }

    //데이터 베이스를 처음 사용할 때 호출되는 메소드
    //테이블을 생성하고 처음부터 존재해야 하는 데이터를 생성
    public void onCreate(SQLiteDatabase db){
        //테이블 만드는 구문
        String tableSQL = "create table soccer(_id integer primary key autoincrement, nation text, player text)";
        db.execSQL(tableSQL);
        db.execSQL("insert into soccer(nation,player) values('germany','프랭크 베켄바우어')");
        db.execSQL("insert into soccer(nation,player) values('england','데이비드 베컴')");
        Log.e("db생성", "성공");

    }

    //데이터 베이스 버전이 변경된 경우 호출되는 메소드
    //기존 데이터를 삭제하고 데이터를 다시 생성하는 코드를 작성
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table soccer");
        onCreate(db);
    }

}
