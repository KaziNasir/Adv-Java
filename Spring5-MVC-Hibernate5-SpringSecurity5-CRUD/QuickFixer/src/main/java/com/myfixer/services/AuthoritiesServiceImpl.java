package com.myfixer.services;

import java.util.List;
import java.util.logging.Logger;

import com.myfixer.dao.AuthorityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfixer.entity.Authorities;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

	private Logger logger = Logger.getLogger(AuthoritiesServiceImpl.class.getName());
	@Autowired
    AuthorityDAO authorityDAO;

	@Override
	public List<Authorities> list() {
		List<Authorities> list = authorityDAO.list();
		return list;
	}
}
