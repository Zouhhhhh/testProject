package spring_mybatis.service.impl;

import com.mysql.cj.log.NullLogger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring_mybatis.mapper.RoleMapper;
import spring_mybatis.pojo.Role;
import spring_mybatis.service.RoleListService;
import spring_mybatis.service.RoleService;

import java.util.List;

@Service
public class RoleListServiceImpl implements RoleListService {

    @Autowired
    private RoleService roleService = null;

    Logger log = Logger.getLogger(RoleListServiceImpl.class);

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int insertRoleList(List<Role> roleList) {
        int result = 0;
        for (Role role : roleList) {
            try {
                result += roleService.insertRole(role);
            } catch (Exception e) {
                log.info(e);
            }
        }
        return result;
    }
}
