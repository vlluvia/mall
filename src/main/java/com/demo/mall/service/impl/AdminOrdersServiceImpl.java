package com.demo.mall.service.impl;

import com.demo.mall.mapper.AdminOrdersDao;
import com.demo.mall.service.AdminOrdersService;
import com.demo.mall.vo.OrderVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminOrdersServiceImpl implements AdminOrdersService {

    @Resource
    AdminOrdersDao adminOrdersDao;

    @Override
    public PageInfo<OrderVo> queryOrders(String id, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<OrderVo> list;
        if ("1".equals(id)){
            list = adminOrdersDao.queryOrdersAll();
        }else if("2".equals(id)){
            //待付款
            list = adminOrdersDao.queryOrdersByIsPay(false,false);
        }else if("3".equals(id)){
            //代发货
            list =adminOrdersDao.queryOrdersByIsPay(true,false);
        }else if("4".equals(id)){
            //已发货
            list =adminOrdersDao.queryOrdersByIsSend(true,true,false);
        }else{
            //已完成
            list =adminOrdersDao.queryOrdersByIsFinish(true);
        }
        return new PageInfo<>(list);
    }

    @Override
    public void deliverGoods(int goodsId) {
        adminOrdersDao.deliverGoods(goodsId);
    }
}
