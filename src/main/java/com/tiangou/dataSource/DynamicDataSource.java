package com.tiangou.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		System.out.println(DataSourceContextHolder.getDbType());
		return DataSourceContextHolder.getDbType();
	}
}
