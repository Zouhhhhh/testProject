package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

//public class BookMapperImpl implements BookMapper{
public class BookMapperImpl {

    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

//    @Override
    public int addBook(Books books) {
        return sqlSessionTemplate.getMapper(BookMapper.class).addBook(books);
    }

//    @Override
    public int deleteBookById(int id) {
        return 0;
    }

//    @Override
    public int updateBook(Books books) {
        return 0;
    }

//    @Override
    public Books queryBookById(int id) {
        return null;
    }

//    @Override
    public List<Books> queryAllBook() {
        return null;
    }
}
