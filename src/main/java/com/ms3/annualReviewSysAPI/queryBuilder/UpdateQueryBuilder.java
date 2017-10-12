package com.ms3.annualReviewSysAPI.queryBuilder;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
/**
 * 
 * @author ZTej
 * Builds Update Query using uri params and payload
 */
public class UpdateQueryBuilder implements Callable{
	
	public static final String COMMA = ",";
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {	
		MuleMessage muleMessage = eventContext.getMessage();
		Map payloadMap =  (Map) muleMessage.getPayload();	
		Map<String, String> uriParams = muleMessage.getInboundProperty("http.uri.params");
		String annualReviewId = uriParams.get("annualReviewId");
		String updateQuery = buildUpdateQuery(payloadMap, annualReviewId);
		eventContext.getMessage().setInvocationProperty("updateQuery", updateQuery);
		return eventContext.getMessage().getPayload();
	}
	
	/**
	 * 
	 * @param payloadMap
	 * @param annualReviewId
	 * @return
	 */
	private static String buildUpdateQuery(Map payloadMap, String annualReviewId){
		StringBuilder updateQuery = new StringBuilder();
		updateQuery.append(" UPDATE ANNUAL_REVIEW SET ");
		Iterator it = payloadMap.entrySet().iterator();
		int iteration=1;
		while(it.hasNext()){
			if(iteration>1){
				updateQuery.append(COMMA);
			}
			Map.Entry pair = (Map.Entry)it.next();		
			String key = null;
			String value = null;
			if(pair.getKey()!=null){
		     key = pair.getKey().toString();
			}
			 
			if(pair.getValue()!=null){
		    value = pair.getValue().toString();
			}
			if(StringUtils.isNumeric(value)){
				updateQuery.append(key+" = "+value);
				System.out.println(updateQuery);
			}else{
			 updateQuery.append(key+" = '"+value+"'");
			 System.out.println(updateQuery);
			}
			iteration++;
		}
		System.out.println(updateQuery);
		return (updateQuery.toString()+ " WHERE annual_review_id = "+annualReviewId);
	}

}
