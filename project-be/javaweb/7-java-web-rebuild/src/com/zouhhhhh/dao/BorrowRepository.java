package com.zouhhhhh.dao;

import com.zouhhhhh.bean.Borrow;

import java.time.LocalDate;
import java.util.List;

/**
 * @author zouhao
 * @date 2022/4/20
 */
public interface BorrowRepository {

    /**
     * 借阅
     * @param bookId
     * @param readerId
     * @param borrowTime
     * @param returnTime
     */
    void addBorrow(String bookId, String readerId, LocalDate borrowTime, LocalDate returnTime);

    /**
     * 获取所有借阅信息
     * @param readerId
     * @param index
     * @param limit
     * @return
     */
    List<Borrow> findAllBorrowByReader(String readerId, Integer index, Integer limit);

    /**
     * 获取借阅记录的总数
     * @return
     */
    int getCountOfBorrow();

    /**
     * 通过状态获取所有借阅信息
     * @param state
     * @param index
     * @param limit
     * @return
     */
    List<Borrow> findAllBorrowByState(String state, Integer index, Integer limit);
}
