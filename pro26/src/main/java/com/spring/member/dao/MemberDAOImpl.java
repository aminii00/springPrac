package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.member.vo.MemberVO;

/*2. @Respository("memberDAO") 
     ->DAO는 어떻게 보면 저장소객체*/
@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	@Autowired
    private SqlSession sqlSession;

	@Override
	public List selectAllMemberList() throws DataAccessException {
		// 데이타를 주고받기때문에 DataAccessException을 걸어주어야 함
				List<MemberVO> membersList = null;
				membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
				return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}

	@Override
	public MemberVO selectMemberById(String id) throws DataAccessException {
		MemberVO memberVO  = sqlSession.selectOne("mapper.member.selectMemberById", id);
		return memberVO;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws DataAccessException {
		System.out.println("DAO");
		int result = sqlSession.update("mapper.member.updateMember", memberVO);
		return result;
	}
}