package com.decagon.controller;

import com.decagon.entity.Queue;
import com.decagon.entity.Staffs;
import com.decagon.service.CashierService;
import com.decagon.service.serviceImpl.CashierServiceImpl;
import com.decagon.utils.StoreLists;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;
public class CashierController implements Runnable {

    private String id;
    private final PriorityBlockingQueue<Queue> queue;
    CashierServiceImpl service;

    CashierService cashierService = new CashierServiceImpl();

    public CashierController(String id, PriorityBlockingQueue<Queue> queue){
        this.id = id;
        this.queue =queue;
    }

    @Override
    public void run() {
        synchronized (this.queue) {
            boolean flag = false;

            for (Staffs cashier : StoreLists.getCashierList()) {
                if ((cashier.getId().equals(id)) && (cashier.isHired())) {
                    flag = true;
                    queuePoll(cashier, queue);
                }
            }
            if (!flag) {
                System.out.println("You cannot Sell. Wrong CashierID");
            }
        }



    }
    private void queuePoll(Staffs cashier,PriorityBlockingQueue<Queue> priorityQueue){
        while(true) {
            Queue queue = priorityQueue.poll();
            cashierService.setConfirmBuyerList(cashier,queue);

            if (queue == null) break;
        }
    }

}
