package com.ikang.springbootcxfservice.service.impl;

import com.ikang.springbootcxfservice.constant.WsConst;
import com.ikang.springbootcxfservice.dto.AuthorDto;
import com.ikang.springbootcxfservice.dto.Sex;
import com.ikang.springbootcxfservice.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebService(
		targetNamespace = WsConst.NAMESPACE_URI,   // wsdl 命名空间
		name = "authorPortType",				   // portType 名称，客户端生成代码时，为接口名称
		serviceName = "authorName",				   // 服务 name 名称
		portName = "authorPortName", 			   // port 名称
		endpointInterface = "com.ikang.springbootcxfservice.service.AuthorService" // 指定发布 webservice 接口，此类也需要注解 @WebService
)
@Service
public class AuthorServiceImpl implements AuthorService {


	@Override public AuthorDto getAuthor(String authorName) {
		AuthorDto author = new AuthorDto();
		author.setName(authorName);
		author.setSex(Sex.MALE);
		author.setBirthday("1999-00-11");
		author.setHobby(Arrays.asList("电影", "旅游"));
		author.setDescription("描述：程序员一枚，现在时间是：" + new Date().getTime());
		return author;
	}
	@Override public List<AuthorDto> getAuthorList() {
		List<AuthorDto> resultList = new ArrayList<>();
		AuthorDto author = new AuthorDto();
		author.setBirthday("1990-01-23");
		author.setName("姓名：oKong");
		author.setSex(Sex.MALE);
		author.setHobby(Arrays.asList("电影","旅游"));
		author.setDescription("描述：一枚趔趄的猿。现在时间：" + new Date().getTime());
		resultList.add(author);
		resultList.add(author);
		return resultList;
	}
	@Override public String getAuthorString(String authorName) {
		AuthorDto author = getAuthor(authorName);
		return author.toString();
	}
}
