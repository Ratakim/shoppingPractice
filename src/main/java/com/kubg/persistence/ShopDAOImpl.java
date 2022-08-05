package com.kubg.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kubg.domain.CartListVO;
import com.kubg.domain.CartVO;
import com.kubg.domain.GoodsViewVO;
import com.kubg.domain.OrderDetailVO;
import com.kubg.domain.OrderListVO;
import com.kubg.domain.OrderVO;
import com.kubg.domain.ReplyListVO;
import com.kubg.domain.ReplyVO;

@Repository
public class ShopDAOImpl implements ShopDAO {

	@Inject
	private SqlSession sql;

	// 메퍼
	private static String namespace = "com.kubg.mappers.shopMapper";

	// 카테고리별 상품 리스트 : 1차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {
	 
	 HashMap<String, Object> map = new HashMap<String, Object>();
	 
	 map.put("cateCode", cateCode);
	 map.put("cateCodeRef", cateCodeRef);
	 
	 return sql.selectList(namespace + ".list_1", map);
	}

	// 카테고리별 상품 리스트 : 2차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
	 
	 return sql.selectList(namespace + ".list_2", cateCode);
	}

	//상품 조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		
		return sql.selectOne("com.kubg.mappers.adminMapper" + ".goodsView", gdsNum);
	}

	//상품 댓글 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		
		sql.insert(namespace + ".registReply", reply);
		
	}

	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		
		return sql.selectList(namespace + ".replyList", gdsNum);
	}

	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		
		sql.delete(namespace + ".deleteReply", reply);
		
	}

	@Override
	public String idCheck(int repNum) throws Exception {
		
		return sql.selectOne(namespace + ".replyUserIdCheck", repNum);
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		
		sql.update(namespace + ".modifyReply", reply);
		
	}

	@Override
	public void addCart(CartVO cart) throws Exception {
		
		sql.insert(namespace + ".addCart", cart);
		
	}

	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		
		return sql.selectList(namespace + ".cartList", userId);
	}

	@Override
	public void deleteCart(CartVO cart) throws Exception {
		
		sql.delete(namespace + ".deleteCart", cart);
		
	}

	@Override
	public void orderInfo(OrderVO order) throws Exception {
		sql.insert(namespace + ".orderInfo", order);
	}

	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		sql.insert(namespace + ".orderInfo_Details", orderDetail);
		
	}

	@Override
	public void cartAllDelete(String userId) throws Exception {
		sql.delete(namespace + ".cartAllDelete", userId);
		
	}

	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		
		return sql.selectList(namespace+ ".orderList", order);
	}

	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		
		return sql.selectList(namespace + ".orderView", order);
	}
}
