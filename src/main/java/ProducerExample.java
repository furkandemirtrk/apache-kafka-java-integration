import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ProducerExample {
    public static void main(String[] args) throws InterruptedException {
        String topicName = "search";
        String[] arr = {"phone","laptop","tablet"};
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(config);
        for (int i = 0; i < arr.length; i++){
            ProducerRecord<String,String> rec = new ProducerRecord<String,String>(topicName,arr[i]);
            producer.send(rec);
            TimeUnit.SECONDS.sleep(2);
        }
        producer.close();

    }
}
