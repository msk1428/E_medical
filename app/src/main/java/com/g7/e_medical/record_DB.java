package com.g7.e_medical;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


@Database(entities = {M_recored.class},version = 1,exportSchema = false)
public abstract class record_DB extends RoomDatabase {
    private static record_DB instance;

    public abstract record_DAO record_dao();

    public static synchronized  record_DB getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    record_DB.class,"record_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallbacck)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallbacck = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private record_DAO record_dao;

        private PopulateDbAsyncTask (record_DB db){
            record_dao = db.record_dao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
           record_dao.insert(new M_recored("B+","test","No","No","yes", "No","yes","No"));
           record_dao.insert(new M_recored("B+","test2","No","No","yes", "No","yes","No"));
           record_dao.insert(new M_recored("B+","test3","No","No","yes", "No","yes","No"));

            return null;
        }
    }
}
