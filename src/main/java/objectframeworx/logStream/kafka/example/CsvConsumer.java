package objectframeworx.logStream.kafka.example;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaConsumerProducerDemo implements com.jingit.export.distributor.spouts.KafkaProperties
{
  public static void main(String[] args)
  {
	final Logger log =  LoggerFactory.getLogger(Consumer.class);
 */

public class CsvConsumer extends Thread
{
  private final ConsumerConnector consumer;
  private final String topic;
  final Logger log =  LoggerFactory.getLogger(CsvConsumer.class);
  private ConsumerIterator<byte[], byte[]> it;
  private KafkaStream<byte[], byte[]> stream;
  public CsvConsumer(String topic)
  {
    consumer = kafka.consumer.Consumer.createJavaConsumerConnector(
            createConsumerConfig());
    this.topic = topic;
  }

  private static ConsumerConfig createConsumerConfig()
  {
    Properties props = new Properties();
    props.put("zookeeper.connect", KafkaProperties.zkConnect);
    props.put("group.id", KafkaProperties.groupId);
    props.put("zooKeeper.sessiontimeout.ms", "400");
    props.put("zooKeeper.synctime.ms", "200");
    props.put("autocommit.interval.ms", "1000");
 

    return new ConsumerConfig(props);

  }
  
  public void init() {
	    Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
	    topicCountMap.put(topic, new Integer(1));
	    Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
	    this.stream =  consumerMap.get(topic).get(0);
	    this.it = stream.iterator();	  
  }
 
  public void run() {
    //this.init();
    
    while(it.hasNext()) {
    	//log.info("length is:"+ 	it.length());
      //log.info("stream count:"+ it.length() +" data items");
      String stormInput = new String(it.next().message());
      log.info("kafka client received:"+stormInput);
      if (it.nonEmpty() == false) {
    	   log.info("kafka client read until done.");
      }
      if (it.hasNext() == false) {
    	  System.out.println("all done folks...");
      }
    }    
    System.out.println("empty spout");
    
  }
}