package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.util.ValueStack;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Role;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	/**
	 * ��ѯ��λ�б�
	 */
	public String list() {
		List<Role> list = roleService.findAll();
		ValueStack vs = getValueStack();
		vs.set("list", list);
		return "list";
	}

	/**
	 * ����idɾ����λ
	 */
	public String delete() {
		roleService.delete(model);
		return "toList";

	}

	/**
	 * ��ת���޸�ҳ��
	 */
	public String editUI() {
		// ����id��ѯ��λ�����ڻ���
		Role role = roleService.getById(model.getId());
		getValueStack().push(role);
		return "editUI";

	}

	/**
	 * �޸ĸ�λ
	 */
	public String edit() {
		// �Ȳ�ѯ�����޸�
		try {
			Role role = roleService.getById(model.getId());

			role.setName(model.getName());// URLDecoder.decode(model.getName(), "utf-8")
			role.setDescription(model.getDescription());

			roleService.update(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "toList";
	}
	
	/**
	 * ��ת�����ҳ��
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * ��Ӹ�λ
	 */
	public String add(){
		roleService.save(model);
		
		return "toList";
	}
}
