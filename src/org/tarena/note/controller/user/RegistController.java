package org.tarena.note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.entity.NoteResult;
import org.tarena.note.service.UserService;
@Controller
@RequestMapping("/user")
public class RegistController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public NoteResult execute(String name,String password,String nickname) throws Exception{
		NoteResult result = userService.regist(name, nickname, password);
		return result;
	}
}
