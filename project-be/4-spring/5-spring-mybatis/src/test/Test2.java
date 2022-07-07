package test;

import mapper.RoleMapper;
import utils.SpringUtils;

public class Test2 {

    // 测试注册Mapper
    public static void main(String[] args) {
        RoleMapper roleMapper = (RoleMapper) SpringUtils.getBean(RoleMapper.class);
        System.out.println(roleMapper.getRole(2L).getRoleName());
    }
}
