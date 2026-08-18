package com.nt.service;

import java.util.List;

import com.nt.entity.Cricketer;


public interface CricketerService 
{
	Cricketer saveCricketer(Cricketer cric);
	
	List<Cricketer> getAllCricketers();

	Cricketer getCricketerById(Integer id);

	Cricketer updateCricketer(Cricketer cric);

	void deleteCricketer(Integer id);

}
