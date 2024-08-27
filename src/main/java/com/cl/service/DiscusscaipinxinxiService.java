package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusscaipinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusscaipinxinxiView;


/**
 * 菜品信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-10 23:56:26
 */
public interface DiscusscaipinxinxiService extends IService<DiscusscaipinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusscaipinxinxiView> selectListView(Wrapper<DiscusscaipinxinxiEntity> wrapper);
   	
   	DiscusscaipinxinxiView selectView(@Param("ew") Wrapper<DiscusscaipinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusscaipinxinxiEntity> wrapper);
   	

}

