package myshop.serviceImpl;

import myshop.base.DaoSupport;
import myshop.bean.supportbean.OrderDeliverInfo;
import myshop.service.OrderDeliverInfoService;

import org.springframework.stereotype.Service;

@Service
public class OrderDeliverInfoServiceImpl extends DaoSupport<OrderDeliverInfo> implements
		OrderDeliverInfoService {

}
