package com.gvart.device

import com.mongodb.MongoClient
import com.mongodb.MongoClientSettings
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.boot.autoconfigure.mongo.ReactiveMongoClientFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.testcontainers.containers.GenericContainer
import java.util.stream.Collectors
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
import kotlin.streams.toList


class KGenericContainer(imageName: String): GenericContainer<KGenericContainer>(imageName)

@Configuration
class TestConfiguration {

    private val container = KGenericContainer("mongo").withExposedPorts(27017)

    @PostConstruct
    fun start() {
        container.start()
    }

    @Bean
    fun mongoClient() = MongoClient(container.containerIpAddress,
        container.getMappedPort(27017))


    @Bean
    fun reactiveStreamsMongoClient(env: Environment,
        builderCustomizers: ObjectProvider<MongoClientSettingsBuilderCustomizer>,
        settings: ObjectProvider<MongoClientSettings>): com.mongodb.reactivestreams.client.MongoClient? {
        val props = MongoProperties()
        props.host = container.containerIpAddress
        props.port = container.getMappedPort(27017)
        return ReactiveMongoClientFactory(props, env, builderCustomizers.orderedStream().toList())
            .createMongoClient(settings.ifAvailable)
    }

    @PreDestroy
    fun stop() {
        container.stop()
    }
}
