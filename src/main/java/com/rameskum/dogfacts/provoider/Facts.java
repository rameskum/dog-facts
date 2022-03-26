package com.rameskum.dogfacts.provoider;

import com.rameskum.dogfacts.config.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "facts")
@Getter
@Setter
@PropertySource(value = "classpath:facts.yml", factory = YamlPropertySourceFactory.class)
public class Facts {

	private List<String> dog;
}
