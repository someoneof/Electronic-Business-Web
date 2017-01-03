package myshop.serviceImpl;


import org.springframework.stereotype.Service;

import myshop.base.DaoSupport;
import myshop.bean.Order;
import myshop.service.OrderService;

@Service
public class OrderServiceImpl extends DaoSupport<Order> implements OrderService {


}
