package cache.pojo;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

    public static final long serialVersionUID = 598736524547906734L;

    private Long id;
    private String roleName;
    private String note;

    // 关联用户信息，一对多关联
    private List<User> userList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
