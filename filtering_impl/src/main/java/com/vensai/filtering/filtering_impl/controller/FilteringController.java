package com.vensai.filtering.filtering_impl.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.vensai.filtering.filtering_impl.entity.FilteringBean;

@RestController
public class FilteringController {

	// field1,field2
	@GetMapping("/filtering")
	public MappingJacksonValue retriveBean() {
		FilteringBean bean = new FilteringBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(filters);
		return mapping;
	}

	// field3
	@GetMapping("/filtering-list")
	public MappingJacksonValue listOfBeans() {
		List<FilteringBean> listBeans = Arrays.asList(new FilteringBean("value1", "value2", "value3"),
				new FilteringBean("value11", "value22", "value33"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(listBeans);
		mapping.setFilters(filters);
		return mapping;
	}

}
