package annocation_aspectj.service.impl;

import annocation_aspectj.pojo.Role;
import annocation_aspectj.service.RoleVerifier;

public class RoleVerifierImpl implements RoleVerifier {
    @Override
    public boolean verify(Role role) {
        return role != null;
    }
}
