package com.mybatisMapper4.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mybatisMapper4.domain.Category;
import com.mybatisMapper4.domain.Product;

import tk.mybatis.mapper.common.Mapper;

/**  
* @ClassName: ProductMapper  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月31日 下午7:08:37    
*    
*/
public interface ProductMapper extends Mapper<Product>{
    
    @Select("select * from product where pid = #{pid}")
    @Results(value= {@Result(column="pid",property="pid")
                    ,@Result(column="pname",property="pname")
    ,@Result(column="market_price",property="marketPrice")
    ,@Result(column="shop_price",property="shopPrice")
    ,@Result(column="pimage",property="pimage")
    ,@Result(column="pdate",property="pdate")
    ,@Result(column="is_hot",property="isHot")
    ,@Result(column="pdesc",property="pdesc")
    ,@Result(column="pflag",property="pflag")
    ,@Result(column="cid",property="cid")})
    Product queryProductBykey(@Param("pid") String pid);
    
    @Select("select * from product where pid = #{pid}")
    @Results(value= {@Result(column="pid",property="pid")
                    ,@Result(column="pname",property="pname")
    ,@Result(column="market_price",property="marketPrice")
    ,@Result(column="shop_price",property="shopPrice")
    ,@Result(column="pimage",property="pimage")
    ,@Result(column="pdate",property="pdate")
    ,@Result(column="is_hot",property="isHot")
    ,@Result(column="pdesc",property="pdesc")
    ,@Result(column="pflag",property="pflag")
    ,@Result(column="pflag",property="pflag")
    ,@Result(column="cid",property="category",javaType=Category.class,one=@One(select="com.mybatisMapper4.dao.CategoryMapper.selectByPrimaryKey"))})
    Product queryProductBykey2(@Param("pid") String pid);
    
    @Select("select * from product where pid = #{pid}")
    @Results(value= {
    @Result(column="cid",property="category",javaType=Category.class,one=@One(select="com.mybatisMapper4.dao.CategoryMapper.selectByPrimaryKey"))})
    Product queryProductBykey3(@Param("pid") String pid);
}
