package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);

	public int getCountByBno(Long bno);
	
	public int insert(ReplyVO reply);

	public ReplyVO read(Long rno);
	
	public ReplyVO getReplyById(ReplyVO vo);

	public int delete(Long rno);
	
	public int deleteAll(Long bno);

	public int update(ReplyVO reply);
	
}
