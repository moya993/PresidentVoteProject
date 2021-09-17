package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Check {
	
	@RequestMapping("/checkInfo")
	public String checInfo(Model model, User user) {

		model.addAttribute("user", user);
		Dao dao = new Dao();
		System.out.println("üũ����"+user.uname);
		String result = dao.userCheck(user.uname, user.utel);
		
		// �ſ� Ȯ�� �� �ǰų� ��ǥ �̷� ������ ù ȭ������
		return (result.equals("1")) ? "VoteView" : "Fail" ;
	}
	
	@RequestMapping("/voting")
	public String voting(Model model, User user) {
		model.addAttribute("user", user);
		Dao dao = new Dao();
		dao.vote(user.uname, user.utel, user.num);
		System.out.println(user.uname+" "+user.num);
		return "Success";
	}
}
