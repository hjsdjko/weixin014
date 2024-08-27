package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.OrdersEntity;
import com.cl.entity.view.OrdersView;

import com.cl.service.OrdersService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 商品订单
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-10 23:56:25
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,OrdersEntity orders,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		orders.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			orders.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
                        if(orders.getUserid()!=null) {
                                orders.setUserid(null);
                        }
		}
        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();

		PageUtils page = ordersService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, orders), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,OrdersEntity orders, 
		HttpServletRequest request){
        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();

		PageUtils page = ordersService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, orders), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( OrdersEntity orders){
       	EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();
      	ew.allEq(MPUtil.allEQMapPre( orders, "orders")); 
        return R.ok().put("data", ordersService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(OrdersEntity orders){
        EntityWrapper< OrdersEntity> ew = new EntityWrapper< OrdersEntity>();
 		ew.allEq(MPUtil.allEQMapPre( orders, "orders")); 
		OrdersView ordersView =  ordersService.selectView(ew);
		return R.ok("查询商品订单成功").put("data", ordersView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        OrdersEntity orders = ordersService.selectById(id);
		orders = ordersService.selectView(new EntityWrapper<OrdersEntity>().eq("id", id));
        return R.ok().put("data", orders);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        OrdersEntity orders = ordersService.selectById(id);
		orders = ordersService.selectView(new EntityWrapper<OrdersEntity>().eq("id", id));
        return R.ok().put("data", orders);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OrdersEntity orders, HttpServletRequest request){
    	orders.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(orders);
    	orders.setUserid((Long)request.getSession().getAttribute("userId"));
        ordersService.insert(orders);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody OrdersEntity orders, HttpServletRequest request){
    	orders.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(orders);
        ordersService.insert(orders);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody OrdersEntity orders, HttpServletRequest request){
        //ValidatorUtils.validateEntity(orders);
        ordersService.updateById(orders);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ordersService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
