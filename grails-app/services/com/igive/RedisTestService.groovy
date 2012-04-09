package com.igive

import redis.clients.jedis.Jedis


class RedisTestService {
    def redisService
	
    def loadList(String queue) {
		redisService.withRedis { Jedis redis ->
            println redis.ping()
			def data = redis.lrange(queue, -100, 1000)
            println data
			data
		}
	}
	
	def sendMessage() {
		sendMessage("seda:input.queue", "queue|nonp|impressions")
	}
}
