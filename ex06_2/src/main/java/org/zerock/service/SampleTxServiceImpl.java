package org.zerock.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.Sample1Mapper;
import org.zerock.mapper.Sample2Mapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class SampleTxServiceImpl implements SampleTxService {
	
	private final Sample1Mapper sample1Mapper;
	private final Sample2Mapper sample2Mapper;
	
	@Transactional
	@Override
	public void addData(String value) {
		log.info("mapper1...............");
		sample1Mapper.insertCol1(value);
		
		log.info("mapper2...............");
		sample2Mapper.insertCol1(value);
		
		log.info("end...................");
	}
	
}




