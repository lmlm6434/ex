package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.zerock.domain.BoardAttachVO;

public interface BoardAttachMapper {
	
	public List<BoardAttachVO> getOldFiles();
	
	public void insert(BoardAttachVO vo);
	
	public void delete(String uuid);
	
	public List<BoardAttachVO> findByBno(Long bno);
	
	public void deleteAll(Long bno);

}







