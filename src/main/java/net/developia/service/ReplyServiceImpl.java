package net.developia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.developia.domain.Criteria;
import net.developia.domain.ReplyVO;
import net.developia.mapper.ReplyMapper;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private ReplyMapper mapper;

	@Override
	public int register(ReplyVO vo) {
		
		log.info("register......" + vo);
		
		return mapper.insert(vo);
		
	}

	@Override
	public ReplyVO get(Long rno) {
		
		log.info("get......" + rno);
		
		return mapper.read(rno);
		
	}

	@Override
	public int modify(ReplyVO vo) {
		
		log.info("modify......" + vo);
		
		return mapper.update(vo);
		
	}

	@Override
	public int remove(Long rno) {
		
		log.info("remove...." + rno);
		
		return mapper.delete(rno);
		
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		
		log.info("get Reply List of a Board " + bno);
		
		return mapper.getListWithPaging(cri, bno);
		
	}
	
}
