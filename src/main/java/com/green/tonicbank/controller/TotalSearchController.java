package com.green.tonicbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.tonicbank.model.SearchCondition;
import com.green.tonicbank.service.CommunityService;
import com.green.tonicbank.service.InfoBoardService;
import com.green.tonicbank.service.ProdBoardService;

@Controller
public class TotalSearchController {

	private final ProdBoardService prodBoardSvc; // ��ǰ�Խ���
	private final InfoBoardService infoBoardSvc; // �����Խ���
	private final CommunityService communitySvc; // �����Խ���
	
	@Autowired
	public TotalSearchController(ProdBoardService prodBoardSvc, InfoBoardService infoBoardSvc, CommunityService communitySvc) {
		super();
		this.prodBoardSvc = prodBoardSvc;
		this.infoBoardSvc = infoBoardSvc;
		this.communitySvc = communitySvc;
	}
	
	@GetMapping("/search")
	public String totalSearch(SearchCondition sc, Model model) {
		sc.setOption("A");
		sc.setPageSize(5);
		System.out.println("���հ˻� : " + sc);
		return "totalSearch";
	}
	
}
