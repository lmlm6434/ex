package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;

	@Test
	public void testGetAttachList() {
		log.info(boardService.getAttachList(1572828L));
	}
	
	@Test
	public void testGetList() {
		Criteria cri = new Criteria(); // 1, 10
		cri.setAmount(100);
		cri.setPageNum(1);
		boardService.getList(cri).forEach(p -> log.info(p));
	}

	@Test
	public void testGet() {
		log.info("------------------------------");
		BoardVO vo = boardService.get(10L);
		log.info(vo);
	}

	@Test
	public void testRegister() {
		BoardVO board = BoardVO.builder().title("ASDF").content("QWER").writer("ZXCV").build();
//		boardMapper.insert(board);
		boardService.register(board);
		log.info("----------------------------------------------");
	}

	@Test
	public void testModify() {
		BoardVO board = BoardVO.builder().bno(5L).title("난나난").content("무나난").writer("루라랄").build();
		boolean result = boardService.modify(board);
		log.info("===========================================================");
		log.info("count.............." + result);
		log.info("===========================================================");
	}

	@Test
	public void testRemove() {
		boardService.remove(1572828L);
	}
	
	@Test
	public void testTotal() {
		Criteria cri = new Criteria();
		log.info(boardService.getTotal(cri));
	}
	

}
