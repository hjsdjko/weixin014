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


import com.cl.dao.DiscusscaipinxinxiDao;
import com.cl.entity.DiscusscaipinxinxiEntity;
import com.cl.service.DiscusscaipinxinxiService;
import com.cl.entity.view.DiscusscaipinxinxiView;

@Service("discusscaipinxinxiService")
public class DiscusscaipinxinxiServiceImpl extends ServiceImpl<DiscusscaipinxinxiDao, DiscusscaipinxinxiEntity> implements DiscusscaipinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusscaipinxinxiEntity> page = this.selectPage(
                new Query<DiscusscaipinxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusscaipinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusscaipinxinxiEntity> wrapper) {
		  Page<DiscusscaipinxinxiView> page =new Query<DiscusscaipinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscusscaipinxinxiView> selectListView(Wrapper<DiscusscaipinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusscaipinxinxiView selectView(Wrapper<DiscusscaipinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
