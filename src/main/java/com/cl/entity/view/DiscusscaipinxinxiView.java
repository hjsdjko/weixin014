package com.cl.entity.view;

import com.cl.entity.DiscusscaipinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 菜品信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-10 23:56:26
 */
@TableName("discusscaipinxinxi")
public class DiscusscaipinxinxiView  extends DiscusscaipinxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusscaipinxinxiView(){
	}
 
 	public DiscusscaipinxinxiView(DiscusscaipinxinxiEntity discusscaipinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discusscaipinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
