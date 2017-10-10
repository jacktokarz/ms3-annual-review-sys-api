package com.ms3.annualReviewSysAPI.queryBuilder;

import java.util.HashMap;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

import com.google.common.base.CaseFormat;
/**
 * 
 * @author ZTej
 * Builds WHERE clause based on the query params passed
 */
public class WhereQueryBuilder implements Callable{

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		MuleMessage muleMessage = eventContext.getMessage();
	    Map<String, String> queryParams = muleMessage.getInboundProperty("http.query.params");
		String whereClause = generateWhereClause(queryParams);
	    eventContext.getMessage().setInvocationProperty("whereClause", whereClause);
	        return eventContext.getMessage().getPayload();
	    }
	/**
	 * 
	 * @param queryParams
	 * @return
	 */
	private static String generateWhereClause(Map<String, String> queryParams){
		StringBuilder whereClause = new StringBuilder();
		if (queryParams.isEmpty()) {
			return whereClause.toString();
		}
		whereClause.append(" WHERE ");
		boolean isFirstParam = true;
		for (Map.Entry<String, String> entry : queryParams.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (isFirstParam) {
				whereClause.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, key) + " = " + value);
				isFirstParam = false;
			} else {
				whereClause.append(" AND " + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, key) + " = " + value);
			}
		}
		return whereClause.toString();
	}

	
}
