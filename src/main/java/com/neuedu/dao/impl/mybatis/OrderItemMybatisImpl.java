package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;

import java.util.List;

public class OrderItemMybatisImpl implements OrderItemDao {
    @Override
    public boolean addOrderItems(List<UserOrderItem> orederItems) {
        return false;
    }

    @Override
    public int generateOrderItemId() {
        return 0;
    }
}
