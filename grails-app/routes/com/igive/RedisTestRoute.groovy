package com.igive

import org.apache.camel.LoggingLevel
import org.apache.camel.builder.RouteBuilder

class RedisTestRoute  extends RouteBuilder {
	def grailsApplication

	@Override
	void configure() {
		def config = grailsApplication?.config
		errorHandler(loggingErrorHandler("com.igive").level(LoggingLevel.ERROR))
		from("seda:input.queue").to("bean:redisTestService?method=loadList").to("log:com.igive?showAll=true&multiline=true").to("stream:out")
	}
}
