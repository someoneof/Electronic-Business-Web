package myshop.serviceImpl;


import myshop.base.DaoSupport;
import myshop.bean.supportbean.IDCard;
import myshop.service.IDCardService;

import org.springframework.stereotype.Service;

@Service(value="iDCardServiceImpl")
public class IDCardServiceImpl extends DaoSupport<IDCard> implements IDCardService {


}
