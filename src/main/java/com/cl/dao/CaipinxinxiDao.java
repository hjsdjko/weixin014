package com.cl.dao;

import com.cl.entity.CaipinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CaipinxinxiView;


/**
 * 菜品信息
 * 
 * @author 
 * @email 
 * @date 2024-04-10 23:56:25
 */
public interface CaipinxinxiDao extends BaseMapper<CaipinxinxiEntity> {
	
	List<CaipinxinxiView> selectListView(@Param("ew") Wrapper<CaipinxinxiEntity> wrapper);

	List<CaipinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<CaipinxinxiEntity> wrapper);
	
	CaipinxinxiView selectView(@Param("ew") Wrapper<CaipinxinxiEntity> wrapper);
	

}
