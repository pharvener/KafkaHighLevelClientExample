package objectframeworx.logStream.kafka.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class MockCsvProducer extends Thread
{
  private final kafka.javaapi.producer.Producer<Integer, String> producer;
  private final String topic;
  private final Properties props = new Properties();
  MockDataGenerator mockDataGenerator = new MockDataGenerator() ;
  
  public static final Logger LOG = LoggerFactory.getLogger(MockCsvProducer.class);
  
  private final List<String[]> valueSource = new ArrayList<String[]>();
  Random _rand = null;


  public MockCsvProducer(String topic)
  {
    props.put("serializer.class", "kafka.serializer.StringEncoder");
    props.put("metadata.broker.list", "localhost:9092");
    // Use random partitioner. Don't need the key type. Just set it to Integer.
    // The message is of type String.
    producer = new kafka.javaapi.producer.Producer<Integer, String>(new ProducerConfig(props));//hacky
    this.topic = topic;
  }
  
  public void run() {
	 System.out.println("producing");
    int messageNo = 0;
    boolean good = true;
    while(good)
    {
      String messageStr = this.mockDataGenerator.getCsvStream();
      producer.send(new KeyedMessage<Integer, String>(topic, messageStr));
      LOG.info("sending :"+messageStr);
      if (messageNo > 5000)
    	  good = false;
      messageNo++;
    }
  }

}