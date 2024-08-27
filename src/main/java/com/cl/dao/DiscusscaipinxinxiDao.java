package com.cl.dao;

import com.cl.entity.DiscusscaipinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusscaipinxinxiView;


/**
 * 菜品信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-10 23:56:26
 */
public interface DiscusscaipinxinxiDao extends BaseMapper<DiscusscaipinxinxiEntity> {
	
	List<DiscusscaipinxinxiView> selectListView(@Param("ew") Wrapper<DiscusscaipinxinxiEntity> wrapper);

	List<DiscusscaipinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusscaipinxinxiEntity> wrapper);
	
	DiscusscaipinxinxiView selectView(@Param("ew") Wrapper<DiscusscaipinxinxiEntity> wrapper);
	

}
