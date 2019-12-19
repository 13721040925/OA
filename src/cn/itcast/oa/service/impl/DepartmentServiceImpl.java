package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IDepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.IDepartmentService;

/**
 * 部门管理
 * @author zhaoqx
 *
 */
@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService{
	@Resource
	private IDepartmentDao departmentDao;
	
	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	@Override
	public void delete(Department model) {
		departmentDao.delete(model.getId());
	}

	@Override
	public Department getById(Long parentId) {
		return departmentDao.getById(parentId);
	}

	@Override
	public void save(Department model) {
		departmentDao.save(model);
	}

	@Override
	public void update(Department dept) {
		departmentDao.update(dept);
	}


}
