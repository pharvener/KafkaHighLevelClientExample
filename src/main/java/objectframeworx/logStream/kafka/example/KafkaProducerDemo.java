package objectframeworx.logStream.kafka.example;

public class KafkaProducerDemo implements KafkaProperties
{
  public static void main(String[] args)
  {
    MockCsvProducer producerThread = new MockCsvProducer("VoltExport");
    producerThread.start();
    System.out.println("started VoltExport Kafka producer"); 
  }
} 