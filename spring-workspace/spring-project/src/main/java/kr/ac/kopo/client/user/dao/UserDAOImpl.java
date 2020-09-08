package kr.ac.kopo.client.user.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.client.user.vo.UserVO;


@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public UserVO login(UserVO user) {
		
		UserVO userVO = sqlSession.selectOne("client.user.dao.UserDAO.login", user);
		return userVO;
	}

	@Override
	public UserVO getUserInfo(String id) {
		
		UserVO userVO = sqlSession.selectOne("client.user.dao.UserDAO.getUserInfo", id);
		return userVO;
	}

	@Override
	public void updateElecFinanceStatus(String regNo) {
		
		sqlSession.update("client.user.dao.UserDAO.updateElecFinanceStatus", regNo);
	}

}
