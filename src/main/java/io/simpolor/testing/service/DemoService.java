package io.simpolor.testing.service;

import io.simpolor.testing.domain.Demo;
import io.simpolor.testing.repository.DemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DemoService {

	private DemoRepository demoRepository;
	public DemoService(@Autowired DemoRepository demoRepository){
		this.demoRepository = demoRepository;
	}

	public long totalcount() {
		return demoRepository.count();
	}

	public List<Demo> list() {
		return demoRepository.findAll();
	}

	public Optional<Demo> view(long seq) {
		return demoRepository.findById(seq);
	}

	public Demo write(Demo demo) {
		return demoRepository.save(demo);
	}

	public Demo modify(long seq, Demo demo) {
		demo.setSeq(seq);
		return demoRepository.save(demo);
	}

	public void delete(long seq) {
		demoRepository.deleteById(seq);
	}


}