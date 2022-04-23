package com.zouhhhhh.repository;

import com.zouhhhhh.entity.Borrow;

import java.util.List;

public interface BorrowRepository {

    void insert(Integer bookid, Integer readerid, String borrowtime, String returntime, Integer adminid, Integer state);

    List<Borrow> findAllByReaderId(Integer id, Integer index, Integer limit);

    int count(Integer readerid);

    List<Borrow> findAllBorrowByState(Integer state, Integer index, Integer limit);

    int countByState(Integer state);

    void handle(Integer borrowId, Integer state, Integer adminId);
}
