package com.gvart.auth.helper

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import javax.persistence.AttributeConverter

class StringJsonConverter: AttributeConverter<Map<String, Any>, String> {
    private val mapper = ObjectMapper()

    override fun convertToDatabaseColumn(attribute: Map<String, Any>): String {
        return mapper.writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String): Map<String, Any> {
        return mapper.readValue<Map<String, Any>>(dbData, object : TypeReference<Map<String, Any>>() {})
    }
}