package org.zerock.mapper;

import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	
	public MemberVO read(String userid);
	
	public int insert(MemberVO member);
	
	public int insertAuth(AuthVO auth);
}
