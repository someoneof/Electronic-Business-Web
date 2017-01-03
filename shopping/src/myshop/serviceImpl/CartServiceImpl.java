package myshop.serviceImpl;


import org.springframework.stereotype.Service;

import myshop.base.DaoSupport;
import myshop.bean.BuyCart;
import myshop.service.CartService;

@Service
public class CartServiceImpl extends DaoSupport<BuyCart> implements CartService {


}
