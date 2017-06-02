package mcl.poc;

import java.util.concurrent.ConcurrentLinkedQueue;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/PocSvc")
public class PocSvc {
	
	private static final Logger _log = LogManager.getLogger(PocSvc.class);
	
	private ConcurrentLinkedQueue<Object> _q = new ConcurrentLinkedQueue<Object>();
	
	private RocketProducer _producer;
	
	public PocSvc() {
		try {
			_producer = new RocketProducer(_q);
		} catch (NullPointerException e) {
			_log.error(e.toString());
		} catch (Exception e) {
			_log.error(e.toString());
		}
	}

	@GET
	@Path("/ping")
	@Produces("application/json")
	public String Ping() {
		_log.info("Ping()");
		return "{ 'Ping':'OK' }";
	}
	
	@POST
	@Path("/publish")
	@Produces("application/json")
	@Consumes("application/json")
	public String Publish() {
		_log.info("Publish()");
		
		// TODO: Need to extract the json published
		Object o = new String("Hello World!");
		_q.add(o);
		_producer.Run();
		
		return "{ 'Result':'OK' }";
	}
}
