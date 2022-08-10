package com.example.pt08_2072030.Dao;

import java.util.List;

public interface DaoInterface<T> {
    List<T> getData();
    int addData(T data);
    int delData(T data);
    int updateData(T data);
}
