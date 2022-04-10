package com.zouhhhhh.repository;

import com.zouhhhhh.entity.Borrow;

import java.util.List;

public interface BorrowRepository {

    void insert(Integer bookid, Integer readerid, String borrowtime, String returntime, Integer adminid, Integer state);

    List<Borrow> findAllByReaderId(Integer id);
}
