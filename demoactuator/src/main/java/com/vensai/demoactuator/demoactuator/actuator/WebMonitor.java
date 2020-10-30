package com.vensai.demoactuator.demoactuator.actuator;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id= "web-monitor")
public class WebMonitor {
	
	@ReadOperation
	public String read() {
		return "Read Operation";
	}

	@WriteOperation
	public String post() {
		return "Write Operation";
	}
	
	@DeleteOperation
	public String delete() {
		return "Delete Operation";
	}
}
