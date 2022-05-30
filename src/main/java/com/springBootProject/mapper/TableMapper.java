package com.springBootProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springBootProject.dto.TableDTO;

@Mapper
public interface TableMapper {

	List<TableDTO> selectTableList();

	TableDTO readTable(int index);

	void insertTable(TableDTO tableDto);

	void deleteTable(int index);

	void updateTable(TableDTO tableDto);
	

}
