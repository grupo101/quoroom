package com.team101.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team101.model.Member;

@Repository("memberDao")
public class MemberDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void insert(Member member){
		this.sessionFactory.getCurrentSession().save(member);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Member> getAll(){
		return this.sessionFactory.getCurrentSession().createQuery("from Member order by name asc").list();
	}
 
	@Transactional
	public void delete(Member member) {
		this.sessionFactory.getCurrentSession().delete(member);
		
	}
	
	@Transactional
	public void modify(Member member) {
		this.sessionFactory.getCurrentSession().update(member);		
	}
	
}
