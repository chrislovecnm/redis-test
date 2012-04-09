package com.igive

import redis.clients.jedis.Jedis

class RedisController {

	def redisService

	def redisTestService

	def queue = "queue|nonp|impressions"

	def index() {
		redisTestService.sendMessage()
	}

	def foo() {
		log.info "loading list"
		def data = redisTestService.loadList(queue)
		log.info "${data}"
		[data:data]
	}

	def direct() {
		def data
        def info
        def bind
		redisService.withRedis { Jedis redis ->
			println redis.ping()
			info = redis.info()
			data = redis.lrange(queue, -100, 1000)
			bind = redis.configGet("bind")
			println data
		}
		log.info "${data}"
		log.info "${info}"
		log.info "${bind}"
		[data:data, info:info, bind:bind]
	}
}
