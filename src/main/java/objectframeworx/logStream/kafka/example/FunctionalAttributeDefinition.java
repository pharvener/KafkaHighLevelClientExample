package objectframeworx.logStream.kafka.example;

import java.io.Serializable;

public abstract class FunctionalAttributeDefinition implements Serializable{
	public abstract Object get(Object anInput);
}
