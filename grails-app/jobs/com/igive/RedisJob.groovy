package com.igive

class RedisJob {

	def redisTestService

	static triggers = {
		simple name: 'mySimpleTrigger', startDelay: 600, repeatInterval: 10000
	}


	def execute() {
		println "running nonprofit impression route"
		// why can't we call sendMessage from here??
		redisTestService.sendMessage()
	}
}
