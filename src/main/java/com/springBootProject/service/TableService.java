package com.springBootProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBootProject.dto.TableDTO;
import com.springBootProject.mapper.TableMapper;

@Service
public class TableService {

	@Autowired
	TableMapper tableMapper;

	public List<TableDTO> selectTableList() {
		// TODO Auto-generated method stub
		List<TableDTO> list = tableMapper.selectTableList();
		return list;
	}

	public void insertTable(TableDTO tableDto) {
		// TODO Auto-generated method stub
		tableMapper.insertTable(tableDto);
		
	}

	@Transactional
	public void deleteTable(int index) {
		// TODO Auto-generated method stub
		tableMapper.deleteTable(index);
	}

    @Transactional
	public TableDTO readTable(int index) {
		// TODO Auto-generated method stub
    	return tableMapper.readTable(index);

	}
    
	public void updateTable(TableDTO tableDto) {
		// TODO Auto-generated method stub
    	tableMapper.updateTable(tableDto);
		
	}

}
