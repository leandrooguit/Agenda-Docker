package br.com.ufpe.agenda.configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON;

public class GatewayFallBack implements FallbackProvider {

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		
		Error error = Error.builder()
							.cause(cause)
							.route(route)
							.build();
		
        return new GatewayErrorResponse(error);
	}
	
	class GatewayErrorResponse implements ClientHttpResponse{

		private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		private Error error;

		public GatewayErrorResponse(Error error) {
			this.error = error;
		}

		@Override
		public InputStream getBody() throws IOException {
            return new ByteArrayInputStream(error.toJSONString().getBytes());
		}

		@Override
		public HttpHeaders getHeaders() {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(APPLICATION_JSON);
			return httpHeaders;
		}

		@Override
		public HttpStatus getStatusCode() throws IOException {
			return status;
		}

		@Override
		public int getRawStatusCode() throws IOException {
			return status.value();
		}

		@Override
		public String getStatusText() throws IOException {
			return status.toString();
		}

		@Override
		public void close() {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
