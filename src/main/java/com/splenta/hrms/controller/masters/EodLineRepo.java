package com.splenta.hrms.controller.masters;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.splenta.hrms.common.GenericRepository;

@Repository
public interface EodLineRepo extends GenericRepository<EodLine>{

	List<EodLine> findByEodId(UUID eodId);

}
