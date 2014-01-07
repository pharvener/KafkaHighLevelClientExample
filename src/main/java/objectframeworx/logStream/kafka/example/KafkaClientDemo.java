package objectframeworx.logStream.kafka.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaClientDemo implements KafkaProperties
{
  final Logger log =  LoggerFactory.getLogger(KafkaClientDemo.class);
  public static void main(String[] args)
  {
	   final Logger log =  LoggerFactory.getLogger(KafkaClientDemo.class);
	    Consumer consumerThread = new Consumer("VoltExport");
	
	    consumerThread.start();
	    log.info("started VoltExport Kafka client");
  }
} 