package com.g7.e_medical;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class recordViewModel  extends AndroidViewModel {
    private record_repository repository;
    private LiveData<List<M_recored>> allrecord;
    public recordViewModel(@NonNull Application application) {
        super(application);
        repository = new record_repository(application);
        allrecord = repository.getAllrecord();
    }
    public void insert(M_recored m_recored){
        repository.insert(m_recored);
    }
    public void update(M_recored m_recored){
        repository.update(m_recored);
    }
    public void delete(M_recored m_recored){
        repository.delete(m_recored);
    }

    public LiveData<List<M_recored>> getAllrecored(){
        return allrecord;
    }
}
