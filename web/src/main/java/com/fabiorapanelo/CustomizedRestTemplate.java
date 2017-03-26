package com.fabiorapanelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomizedRestTemplate extends RestTemplate {

	public <T> List<T> getForList(String url, Class<T> responseType, String jsonPath) throws IOException {

		List<T> items = new ArrayList<>();

		RestTemplate template = new RestTemplate();
		String result = template.getForObject(url, String.class);

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(result);
			
			if(StringUtils.isEmpty(jsonPath)){
				throw new IllegalArgumentException("jsonPath can't be null");
			}
			
			for(String key: jsonPath.split("/")){
				node = node.get(key);
			}
			
			node.elements().forEachRemaining(item -> {
				try {
					items.add(mapper.readValue(item.toString(), responseType));
				} catch (IOException e) {}
			});
			
		} catch (IOException e) {}

		return items;

	}
}
