package com.kubg.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kubg.domain.CategoryVO;
import com.kubg.domain.GoodsVO;
import com.kubg.domain.GoodsViewVO;
import com.kubg.domain.OrderListVO;
import com.kubg.domain.OrderVO;
import com.kubg.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	private AdminDAO dao;

	@Override
	public List<CategoryVO> category() throws Exception {
		
		return  dao.category();
	}

	@Override
	public void register(GoodsVO vo) throws Exception {
		dao.register(vo);
		
	}

	@Override
	public List<GoodsViewVO> goodsList() throws Exception {
		
		return dao.goodsList();
	}

	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		
		return dao.goodsView(gdsNum);
	}

	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
		
	}

	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		dao.goodsDelete(gdsNum);
		
	}

	@Override
	public List<OrderVO> orderList() throws Exception {
		
		return dao.orderList();
	}

	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		
		return dao.orderView(order);
	}

	@Override
	public void delivery(OrderVO order) throws Exception {
		
		dao.delivery(order);
		
	}

	@Override
	public void changeStock(GoodsVO goods) throws Exception {
		dao.changeStock(goods);
		
	}

}
