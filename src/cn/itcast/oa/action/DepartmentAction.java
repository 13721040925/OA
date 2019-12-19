package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	/**
	 * 查询部门列表
	 */
	public String list() {
		List<Department> list = departmentService.findAll();
		getValueStack().set("list", list);
		return "list";
	}

	/**
	 * 根据id删除部门
	 */
	public String delete() {
		departmentService.delete(model);
		return "toList";
	}
}
