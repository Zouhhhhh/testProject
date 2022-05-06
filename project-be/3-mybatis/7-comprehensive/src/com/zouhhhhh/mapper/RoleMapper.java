package com.zouhhhhh.mapper;

import com.zouhhhhh.pojo.Role;

import java.util.List;

/**
 * @author zouhao
 * @date 2022/5/6
 */
public interface RoleMapper {

    /**
     * 新增Role
     * @param role
     * @return
     */
    public int insertRole(Role role);

    /**
     * 删除Role
     * @param id
     * @return
     */
    public int deleteRole(Long id);

    /**
     * 更新Role
     * @param role
     * @return
     */
    public int updateRole(Role role);

    /**
     * 获取Role
     * @param id
     * @return
     */
    public Role getRole(Long id);

    /**
     * 根据name获取全部Role
     * @param roleName
     * @return
     */
    public List<Role> findRoles(String roleName);

}
