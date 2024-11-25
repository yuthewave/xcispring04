package net.developia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;
import net.developia.mapper.Sample1Mapper;
import net.developia.mapper.Sample2Mapper;

@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService {
	
	@Autowired
	private Sample1Mapper mapper1;
	
	@Autowired
	private Sample2Mapper mapper2;
	
	@Transactional
	@Override
	public void addData(String value) {
		
		log.info("mapper1.........................");
		mapper1.insertCol1(value);
		
		log.info("mapper2.........................");
		mapper2.insertCol2(value);
		
		log.info("end.............................");
		
	}

}
