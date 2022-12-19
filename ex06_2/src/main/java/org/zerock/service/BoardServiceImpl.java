package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper boardMapper;
	
	private final BoardAttachMapper boardAttachMapper;
	
	private final ReplyMapper replyMapper;
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		// work
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public BoardVO get(Long bno) {
		// work
		return boardMapper.read(bno);
	}
	
	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		// TODO Auto-generated method stub
		
		return boardAttachMapper.findByBno(bno);
	}
	
	
	@Transactional
	@Override
	public void register(BoardVO board) {
		boardMapper.insert(board);
		if(board.getAttachList() == null || 
				board.getAttachList().size() <= 0) {
			return;
		}
		
		board.getAttachList().forEach(attach -> {
			attach.setBno(board.getBno());
			boardAttachMapper.insert(attach);
		});
	}

	@Transactional
	@Override
	public boolean remove(Long bno) {
		// work
		log.info("remove......." + bno);
		boardAttachMapper.deleteAll(bno);
		replyMapper.deleteAll(bno);
		return boardMapper.delete(bno) == 1;
	}

	@Override
	public boolean modify(BoardVO board) {
		// work
		boardAttachMapper.deleteAll(board.getBno());
		boolean modifyResult = boardMapper.update(board) == 1;
		if(   modifyResult 
		   && board.getAttachList() != null 
		   && board.getAttachList().size() > 0 ) {
			
			board.getAttachList().forEach(attach -> {
				attach.setBno(board.getBno());
				boardAttachMapper.insert(attach);
			});
			
		}
			
		return modifyResult;
	}

	@Override
	public int getTotal(Criteria cri) {
		return boardMapper.getTotalCount(cri);
	}
}
