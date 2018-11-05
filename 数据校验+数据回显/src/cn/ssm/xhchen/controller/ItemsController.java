package cn.ssm.xhchen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.ssm.xhchen.po.ItemsCustomer;
import cn.ssm.xhchen.po.ItemsQueryVo;
import cn.ssm.xhchen.service.ItemsService;
import cn.ssm.xhchen.validaGroups.ValidaGroupItemsName;
import cn.ssm.xhchen.validaGroups.ValidaGroupItems_Price;

/**
 * 
 * ClassName: ItemsController
 * 
 * @Description: ��Ʒ�������
 * @author XHChen
 * @date 2018��10��26�� ����10:28:22
 */
@Controller
// խ������ӳ��,��url���з������
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	/**
	 * 
	 * @Description: ��ѯ��Ʒ��Ϣ,pojo��
	 * @param @param itemsQueryVo pojo��
	 * @param @return ������Ʒ�б�
	 * @param @throws Exception
	 * @return ModelAndView
	 * @throws
	 * @author XHChen
	 * @date 2018��10��26�� ����10:23:36
	 */
	@RequestMapping("/queryItems.action")
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo)
			throws Exception {

		// ����service������ѯ���ݿ�
		List<ItemsCustomer> itemsList = itemsService.findItemsList(itemsQueryVo);

		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);

		// ָ����ͼ
		// ·��ǰ׺�ͺ�׺����springmvc.xml����
		modelAndView.setViewName("items/itemsList");

		return modelAndView;

	}

	
	/**
	 * 
	 * @Description: ��Ʒ��Ϣ�޸�ҳ��
	 * @param @param request ͨ��request�����ȡ������Ϣ
	 * @param @param id ��Ʒ��Ϣid
	 * @param @return �����޸�ҳ��
	 * @param @throws Exception
	 * @return ModelAndView
	 * @throws
	 * @author XHChen
	 * @date 2018��10��26�� ����10:16:06
	 */
	// 1.Integer id��Ҫ��request���ز���������controller�β�����һ��
	// 2.@RequestParam�Լ����͵Ĳ������а�
	// 	a.@RequestParam,ָ��request���ز���������controller�β����ư�
	// 	b.required,ָ���������봫��
	// 	c.defaultValue,idĬ�ϲ���
	@RequestMapping("/editItems.action")
	public ModelAndView editItems(HttpServletRequest request,
			@RequestParam(value = "id", required = true, defaultValue = "id") Integer id)
			throws Exception {

		// ����itemsService�ӿڣ���ѯ��Ʒ��Ϣ
		ItemsCustomer itemsCustomer = itemsService.findItemsById(id);

		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();

		// �������ݵ�ҳ��
		modelAndView.addObject("itemsCustomer", itemsCustomer);

		// ָ����ͼ
		// ·��ǰ׺�ͺ�׺����springmvc.xml����
		modelAndView.setViewName("items/editItems");

		// ����ָ����ͼ
		return modelAndView;

	}
	
	
	/**
	 * 
	 * @Description: �޸���Ʒ��Ϣ
	 * @param @param request ͨ��request�����ȡ������Ϣ
	 * @param @param id ��Ʒ��Ϣid
	 * @param @param itemsCustomer
	 * @param @return ������Ʒ�б�
	 * @param @throws Exception
	 * @return ModelAndView
	 * @throws
	 * @author XHChen
	 * @date 2018��10��26�� ����10:18:14
	 */
	// ����ҪУ���pojoǰ�����@Validated��������BindingResult bindingResult����У�������Ϣ
	// ע�⣺@Validated��BindingResult bindingResult����Գ��֡�
	// @Validated(value=ValidaGroupItemsName.class)ָ��У�����
	@RequestMapping("/editItemsSubmit.action")
	public ModelAndView editItemsSubmit(HttpServletRequest request, Integer id, 
			@Validated(value=ValidaGroupItems_Price.class) ItemsCustomer itemsCustomer,BindingResult bindingResult,
			ItemsQueryVo itemsQueryVo) throws Exception {
		
		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		// ���У�������Ϣ
		if (bindingResult.hasErrors()) {
			
			List<ObjectError> objectErrors = bindingResult.getAllErrors();
			
			// ��ʾ������Ϣ��ҳ��
			modelAndView.addObject("objectErrors", objectErrors);
			
			// ָ����ͼ
			modelAndView.setViewName("items/editItems");
			
		} else {
			// ����itemsService�����޸���Ʒ��Ϣ����Ҫ��ҳ�������ύ���˷���
			itemsService.updateItems(id, itemsCustomer);

			// ���²�ѯ��Ʒ��Ϣ
			List<ItemsCustomer> itemsList = itemsService.findItemsList(itemsQueryVo);

			// ���ز�����ҳ��
			modelAndView.addObject("itemsList", itemsList);

			// ָ����ͼ
			modelAndView.setViewName("items/itemsList");

		}
		// ����ָ����ͼ
		return modelAndView;
		
	}
	
	
	/**
	 * 
	 * @Description: ����idɾ����Ʒ
	 * @param @param request ͨ��request�����ȡ������Ϣ
	 * @param @param id ��Ʒ��Ϣid
	 * @param @param itemsQueryVo ��Ʒ��Ϣ��װ
	 * @param @return   
	 * @return ModelAndView  
	 * @throws Exception 
	 * @throws
	 * @author XHChen
	 * @date 2018��11��2�� ����9:32:31
	 */
	@RequestMapping("/deleteItemsById.action")
	public ModelAndView deleteItemsById(HttpServletRequest request, 
			Integer id, ItemsQueryVo itemsQueryVo) throws Exception {
		
		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		// ����itemsService�ӿڷ���ɾ����Ϣ
		itemsService.deleteItemsById(id);
		
		// ���²�ѯ���ݿ�
		List<ItemsCustomer> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		// ��������
		modelAndView.addObject("itemsList", itemsList);
		
		// ָ����ͼ
		modelAndView.setViewName("items/itemsList");
		
		// ������ͼ
		return modelAndView;
	}

	
	/**
	 * 
	 * @Description: ����ɾ����Ʒ
	 * @param @param items_id ��ҳ��checkbox�����Ʊ���һ��,�����
	 * @param @return ������Ʒ�б�
	 * @return String
	 * @throws Exception
	 * @throws
	 * @author XHChen
	 * @date 2018��10��26�� ����9:57:26
	 */
	@RequestMapping("/deleteItems.action")
	public ModelAndView deleteItems(HttpServletRequest requests, ItemsQueryVo itemsQueryVo) throws Exception {

		// ����itemsService����
		// ��һɾ����Ʒ��Ϣ
		itemsService.deleteItemsArray(itemsQueryVo.getItems_ids());
		
		// һ��ɾ����Ʒ��Ϣ,��Ҫsqlƴ��
		// itemsService.deleteItemsArrayAllIn(itemsQueryVo.getItems_ids());

		// ���²�ѯ��Ʒ��Ϣ
		List<ItemsCustomer> itemsList = itemsService.findItemsList(itemsQueryVo);

		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();

		// ���ز�����ҳ��
		modelAndView.addObject("itemsList", itemsList);

		// ָ����ͼ
		modelAndView.setViewName("items/itemsList");

		// ����ָ����ͼ
		return modelAndView;
	}
	
	
	/**
	 * 
	 * @Description: �����޸���Ʒ��Ϣҳ�� ,list��
	 * @param @param request ͨ��request�����ȡ������Ϣ
	 * @param @param itemsQueryVo pojo��
	 * @param @return ���������޸���Ʒ��Ϣҳ��
	 * @param @throws Exception   
	 * @return ModelAndView  
	 * @throws
	 * @author XHChen
	 * @date 2018��10��26�� ����9:14:40
	 */
	@RequestMapping("/editItemsQuery.action")
	public ModelAndView editItemsQuery(HttpServletRequest request, ItemsQueryVo itemsQueryVo)
			throws Exception {
		
		// ��ѯ������Ʒ��Ϣ
		List<ItemsCustomer> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		// ��ҳ�洫������
		modelAndView.addObject("itemsList", itemsList);
		
		// ָ����ͼ
		modelAndView.setViewName("items/editItemsQuery");
		
		// ����ָ����ͼ
		return modelAndView;
		
	}
	

	/**
	 * 
	 * @Description: �ύ�����޸���Ʒ��Ϣ
	 * ��ԭ��ͨ��ItemsQueryVo�����ύ��Ʒ��Ϣ������Ʒ��Ϣ�洢��ItemsQueryVo��itemsList������
	 * @param @param request ͨ��request�����ȡ������Ϣ
	 * @param @param itemsQueryVo pojo��
	 * @param @return ������Ʒ��Ϣҳ��
	 * @param @throws Exception   
	 * @return ModelAndView  
	 * @throws
	 * @author XHChen
	 * @date 2018��10��26�� ����9:30:23
	 */
	@RequestMapping("/editItemsAllSubmit.action")
	public ModelAndView editItemsAllSubmit(HttpServletRequest request,
			@Validated ItemsQueryVo itemsQueryVo, BindingResult bindingResult) 
			throws Exception {
		
		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		// ��У�����
		if (bindingResult.hasErrors()) {
			// ��ý���Ŀ������Ϣ
			List<ObjectError> objectErrors = bindingResult.getAllErrors();
			
			// ҳ����ʾ������Ϣ
			// ��Ӵ�����Ϣ
			modelAndView.addObject("objectErrors", objectErrors);
			
			// ���²�ѯ������Ʒ��Ϣ
			List<ItemsCustomer> itemsList = itemsService.findItemsList(itemsQueryVo);
			
			// ��������
			modelAndView.addObject("itemsList", itemsList);
			
			// ָ����ͼ
			modelAndView.setViewName("items/editItemsQuery");
			
		} else {
			// û��У�����
			// ����itemsService�ӿڷ���
			// �����ύ�����޸���Ʒ��Ϣ
			itemsService.updateAllItems(itemsQueryVo.getItemsList());

			// һ�����ύ�����޸���Ʒ��Ϣ,��Ҫsqlƴ��
			// itemsService.updateAllItemsSubmit(itemsQueryVo.getItemsList());
			
			// ���²�ѯ������Ʒ��Ϣ
			List<ItemsCustomer> itemsList = itemsService.findItemsList(itemsQueryVo);
			
			// ��ҳ�洫������
			modelAndView.addObject("itemsList", itemsList);
			
			// ָ����ͼ
			modelAndView.setViewName("items/itemsList");
			
		}
		// ������ͼ
		return modelAndView;
	}
	
}
