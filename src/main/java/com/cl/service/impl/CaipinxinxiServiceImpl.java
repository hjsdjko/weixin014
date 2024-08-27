package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.CaipinxinxiDao;
import com.cl.entity.CaipinxinxiEntity;
import com.cl.service.CaipinxinxiService;
import com.cl.entity.view.CaipinxinxiView;

@Service("caipinxinxiService")
public class CaipinxinxiServiceImpl extends ServiceImpl<CaipinxinxiDao, CaipinxinxiEntity> implements CaipinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaipinxinxiEntity> page = this.selectPage(
                new Query<CaipinxinxiEntity>(params).getPage(),
                new EntityWrapper<CaipinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaipinxinxiEntity> wrapper) {
		  Page<CaipinxinxiView> page =new Query<CaipinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CaipinxinxiView> selectListView(Wrapper<CaipinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaipinxinxiView selectView(Wrapper<CaipinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
