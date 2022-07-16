package bymapper.mapper;

import bymapper.pojo.Role;


/**
 * Mybatis运用了动态代理技术使接口能运行起来，会为接这个接口生成一个代理对象，
 * 代理对象去处理相关的逻辑
 * @author zouhao
 * @date 2022/5/6
 */
public interface RoleMapper {

    public Role getRole(Long id);

}
