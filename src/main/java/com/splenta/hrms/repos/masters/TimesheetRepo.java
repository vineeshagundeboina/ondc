package com.splenta.hrms.repos.masters;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.models.masters.Timesheet;

@Repository
public interface TimesheetRepo extends GenericRepository<Timesheet> {

	List<Timesheet> findByUserName(String userName);

}
