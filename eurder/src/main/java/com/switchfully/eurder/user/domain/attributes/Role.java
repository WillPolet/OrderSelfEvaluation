package com.switchfully.eurder.user.domain.attributes;

import java.util.List;

public enum Role {
    CUSTOMER(List.of(Rights.ORDER_ITEM)),
    ADMIN(List.of(Rights.CREATE_ADMIN, Rights.CREATE_ITEM, Rights.UPDATE_ITEM, Rights.VIEW_ALL_CUSTOMERS, Rights.DETAILS_OF_CUSTOMER));

    private List<Rights> rights;

    // Private constructor to initialize the list of RoleRights for each UserRole
    private Role(List<Rights> rights) {
        this.rights = rights;
    }

    public List<Rights> getRights() {
        return rights;
    }
}