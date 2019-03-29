package com.g7.e_medical;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;



@Dao
public interface record_DAO {
    @Insert
    void insert( M_recored record);

    @Update
    void update(M_recored record);

    @Delete
    void delete(M_recored record);

    @Query("SELECT * FROM m_recored")
    LiveData<List<M_recored>> getAllrecord();

    @Query("SELECT * FROM M_RECORED WHERE id = :id")
    LiveData<M_recored> loadVerifiedImageById(int id);

}
