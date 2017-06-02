package mcl.poc;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@ApplicationPath("/rest")
public class PocApp extends Application {
	
	// Logger for execution visibility
	private static final Logger _log = LogManager.getLogger(PocApp.class);
	
	public PocApp() {
		super();
		
		_log.debug("Init PocApp");
	}
}
