package objectframeworx.logStream.kafka.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaConsumerProducerDemo implements KafkaProperties
{
  public static void main(String[] args)
  {
	final Logger log =  LoggerFactory.getLogger(KafkaConsumerProducerDemo.class);
	MockCsvProducer producerThread = new MockCsvProducer("VoltExport");
    producerThread.start();
    log.info("started VoltExport Kafka producer");
    Consumer consumerThread = new Consumer("VoltExport");
    consumerThread.start();
    log.info("started VoltExport Kafka client");
  }
} 

/*
 public static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerProducerDemo.class); * 
 */
