package com.ikang.springbootcxfservice.service;

import com.ikang.springbootcxfservice.constant.WsConst;
import com.ikang.springbootcxfservice.dto.AuthorDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = WsConst.NAMESPACE_URI, name = "authorPortType")
public interface AuthorService {

	/**
	 * 根据名称查询作者信息
	 * @param authorName 作者名称
	 */
	@WebMethod(operationName = "getAuthorByName")
	AuthorDto getAuthor(@WebParam(name = "authorName") String authorName);

	/**
	 * 获取作者列表信息
	 */
	@WebMethod
	List<AuthorDto> getAuthorList();


	/**
	 * 返回字符串测试
	 */
	String getAuthorString(@WebParam(name = "authorName") String authorName);


}
