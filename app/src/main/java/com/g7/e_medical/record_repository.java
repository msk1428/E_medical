package com.g7.e_medical;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class record_repository {
    private record_DAO record_dao;
    private LiveData<List<M_recored>> allrecord;

    public record_repository(Application application){
        record_DB db = record_DB.getInstance(application);
        record_dao= db.record_dao();
        allrecord = record_dao.getAllrecord();
    }

    public void insert(M_recored recored){
        new InsertrecoredAsynctask(record_dao).execute(recored);

    }
    public void update(M_recored recored){
        new updaterecoredAsynctask(record_dao).execute(recored);
    }
    public void delete(M_recored recored){
        new DeleterecoredAsynctask(record_dao).execute(recored);
    }
    public LiveData<List<M_recored>> getAllrecord(){
        return allrecord;
    }

    private static  class  InsertrecoredAsynctask extends AsyncTask<M_recored,Void,Void>{
        private record_DAO record_dao;

        private  InsertrecoredAsynctask(record_DAO record_dao){
            this.record_dao = record_dao;
        }
        @Override
        protected Void doInBackground(M_recored... m_recoreds) {
            record_dao.insert(m_recoreds[0]);
            return null;
        }
    }
    private static  class  updaterecoredAsynctask extends AsyncTask<M_recored,Void,Void>{
        private record_DAO record_dao;

        private updaterecoredAsynctask(record_DAO record_dao){
            this.record_dao = record_dao;
        }
        @Override
        protected Void doInBackground(M_recored... m_recoreds) {
            record_dao.update(m_recoreds[0]);
            return null;
        }
    }
    private static  class  DeleterecoredAsynctask extends AsyncTask<M_recored,Void,Void>{
        private record_DAO record_dao;

        private  DeleterecoredAsynctask(record_DAO record_dao){
            this.record_dao = record_dao;
        }
        @Override
        protected Void doInBackground(M_recored... m_recoreds) {
            record_dao.delete(m_recoreds[0]);
            return null;
        }
    }
}
