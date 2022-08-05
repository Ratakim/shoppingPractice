package com.kubg.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kubg.domain.CartListVO;
import com.kubg.domain.CartVO;
import com.kubg.domain.GoodsViewVO;
import com.kubg.domain.OrderDetailVO;
import com.kubg.domain.OrderListVO;
import com.kubg.domain.OrderVO;
import com.kubg.domain.ReplyListVO;
import com.kubg.domain.ReplyVO;
import com.kubg.persistence.ShopDAO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Inject
	private ShopDAO dao;

	// 카테고리별 상품 리스트
	@Override
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception {
	 
	 int cateCodeRef = 0;  // 카테고리 참조 코드. 없어도 무관
	 
	 if(level == 1) {  // lavel 1 = 1차 분류.
	  
	  cateCodeRef = cateCode;
	  return dao.list(cateCode, cateCodeRef);
	  // 두가지 모두 cateCode로 해도 무관
	  
	 } else {  // lavel 2 = 2차 분류
	  
	  return dao.list(cateCode);
	  
	 }
	 
	}

	//상품 조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		
		return dao.goodsView(gdsNum);
	}

	@Override
	public void registReply(ReplyVO reply) throws Exception {
		
		dao.registReply(reply);
		
	}

	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
				
		return dao.replyList(gdsNum);
	}

	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		
		dao.deleteReply(reply);
		
	}

	@Override
	public String idCheck(int repNum) throws Exception {
		
		return dao.idCheck(repNum);
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		
		dao.modifyReply(reply);
		
	}

	@Override
	public void addCart(CartVO cart) throws Exception {
		
		dao.addCart(cart);
		
	}

	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		
		return dao.cartList(userId);
	}

	@Override
	public void deleteCart(CartVO cart) throws Exception {
	  
		dao.deleteCart(cart);
		
	}

	@Override
	public void orderInfo(OrderVO order) throws Exception {

       dao.orderInfo(order);
		
	}

	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		
		dao.orderInfo_Details(orderDetail);
		
	}

	@Override
	public void cartAllDelete(String userId) throws Exception {
	
		dao.cartAllDelete(userId);
		
	}

	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		
		return dao.orderList(order);
	}

	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		
		return dao.orderView(order);
	}
}
