package com.decagon.service;

import com.decagon.entity.Queue;
import com.decagon.entity.Staffs;

public interface CashierService {
    void setConfirmBuyerList(Staffs cashier, Queue queue);

}
