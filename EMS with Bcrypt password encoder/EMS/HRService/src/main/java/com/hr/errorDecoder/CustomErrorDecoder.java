package com.hr.errorDecoder;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.util.StreamUtils;

import com.hr.exceptions.HRException;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		// TODO Auto-generated method stub
		if(response.status() == 404) {
			String res = getResponseBody(response);
			return new HRException(res); 
		}
		return FeignException.errorStatus(methodKey, response);
	}
	
	private String getResponseBody(Response response) {

        try {

            if (response.body() != null) {

                return StreamUtils.copyToString(response.body().asInputStream(), Charset.defaultCharset());

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return "Resource not found"; // Default message if the response body is empty

    }

}
