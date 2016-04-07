package com.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import com.board.dao.BoardDAO;
import com.dao.*;
public class MemberListModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("title", "회원목록");
		BoardDAO boardDao = BoardDAO();
		MemberXML xml = MemberXML.newInstance();
		List<MemberVO> list = xml.memberListData();
		request.setAttribute("list", list);
		return "list";
	}
}
