package xml.test;

import xml.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class TestMapperXml {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        System.out.println("xml的：" + sqlSession);
    }
}
