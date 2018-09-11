package com.example.firstinsmvc.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

@Primary
@Component
public class WebObjectMapper extends ObjectMapper {

	public WebObjectMapper() {
		registerModule(customJavaTimeModule());
	}

	/**
	 * 使用Jackson本身提供的JavaTimeModule, 並客製部分formatter
	 */
	private JavaTimeModule customJavaTimeModule() {
		final JavaTimeModule module = new JavaTimeModule();

		// LocalDateTime
		module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(CommonConstants.DATE_TIME_FORMATTER));
		module.addSerializer(new LocalDateTimeSerializer(CommonConstants.DATE_TIME_FORMATTER));

		// LocalTime
		module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(CommonConstants.TIME_FORMATTER));
		module.addSerializer(new LocalTimeSerializer(CommonConstants.TIME_FORMATTER));

		// LocalDate
		module.addDeserializer(LocalDate.class, new LocalDateDeserializer(CommonConstants.DATE_FORMATTER));
		module.addSerializer(new LocalDateSerializer(CommonConstants.DATE_FORMATTER));

		return module;
	}

}
