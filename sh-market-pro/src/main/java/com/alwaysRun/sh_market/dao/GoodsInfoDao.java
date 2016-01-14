package com.alwaysRun.sh_market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alwaysRun.sh_market.bean.GoodsInfo;

public interface GoodsInfoDao {

	/**
	 * 添加一个商品信息
	 * @param goods
	 */
	void add(GoodsInfo goods);

	/**
	 * 更新商品信息（更新成功，发布时间修改为当前时间）
	 * @param goods
	 */
	void update(GoodsInfo goods);
	
	/**
	 * 删除商品信息（修改商品status字段为0）
	 * @param goodsId
	 */
	void delete(@Param("goodsId") int goodsId);

	/**
	 * 通过主键ID得到商品信息
	 * @param goodsId
	 * @return
	 */
	GoodsInfo findById(@Param("goodsId") int goodsId);

	/**
	 * 分页查询商品信息，可以附加分类号和用户ID条件
	 * @param classify 分类号
	 * @param pageNo 当前页
	 * @param pageSize 每个页面展示记录数
	 * @param userId 用户ID
	 * @return
	 */
	List<GoodsInfo> findByPage(@Param("classify") String classify,
			@Param("pageNo") int pageNo, @Param("pageSize") int pageSize,
			@Param("userId") int userId);

	/**
	 * 查询商品信息总记录数，可以附加分类号和用户ID条件
	 * @param classify 分类号
	 * @param userId 用户ID
	 * @return
	 */
	int findToTalNum(@Param("classify") String classify,
			@Param("userId") int userId);
	
	List<GoodsInfo> findAll(@Param("classify") String classify);
	
	/**
	 * 上架商品
	 * @param goodsId
	 */
	void usabel(@Param("goodsId") int goodsId);
	
	/**
	 * 下架商品
	 * @param goodsId
	 */
	void unUsabel(@Param("goodsId") int goodsId);
	
}
