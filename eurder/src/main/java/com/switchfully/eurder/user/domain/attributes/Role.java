package com.switchfully.eurder.user.domain.attributes;

import java.util.List;

public enum Role {
    CUSTOMER(List.of(Right.ORDER_ITEM)),
    ADMIN(List.of(Right.CREATE_ADMIN, Right.CREATE_ITEM, Right.UPDATE_ITEM, Right.VIEW_ALL_CUSTOMERS, Right.DETAILS_OF_CUSTOMER));

    private List<Right> rights;

    // Private constructor to initialize the list of RoleRights for each UserRole
    private Role(List<Right> rights) {
        this.rights = rights;
    }

    public List<Right> getRights() {
        return rights;
    }
}