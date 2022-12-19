package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService {

	private final ReplyMapper replyMapper;
	private final BoardMapper boardMapper;
	
	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		// work
		return new ReplyPageDTO(replyMapper.getCountByBno(bno), replyMapper.getListWithPaging(cri, bno));
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		// work
		log.info("......getList Cri =" + cri);
		log.info("......getList bno =" + bno);
		return replyMapper.getListWithPaging(cri, bno);
	}
	
	@Transactional
	@Override
	public int register(ReplyVO reply) {
		log.info(".......register = " + reply);
		boardMapper.updateReplyCnt(reply.getBno(), 1);
		return replyMapper.insert(reply);
	}

	@Override
	public ReplyVO get(Long rno) {
		
		log.info(".........get = " + rno);
		return replyMapper.read(rno);
	}

	@Override
	public int modify(ReplyVO reply) {
		log.info("........modify = " + reply);
		return replyMapper.update(reply);
	}
	
	@Transactional
	@Override
	public int remove(ReplyVO vo) { // Long rno
		log.info("..........remove = " + vo.getRno());
		ReplyVO reply = replyMapper.getReplyById(vo);
//		ReplyVO reply = replyMapper.read(vo.getRno());
		if(reply != null) {
			boardMapper.updateReplyCnt(reply.getBno(), -1);
			return replyMapper.delete(reply.getRno());
		}
		
		return 0;
	}
	
	
	
}




