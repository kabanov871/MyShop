package com.example.myshop.data.mapper

import com.example.myshop.utils.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MapperTest {

    @Test
    fun mapLatestToLatestModel() {

        val mapper = Mapper()

        Assertions.assertEquals(
            mapper.mapLatestToLatestModel(createLatest()),
            createLatestModel()
        )
    }

    @Test
    fun mapListLatestToListLatestModel() {

        val mapper = Mapper()

        Assertions.assertEquals(
            mapper.mapListLatestToListLatestModel(createLatestApiModel().latest),
            listOf(createLatestModel())
        )
    }

    @Test
    fun mapFlashSaleToFlashSaleModel() {

        val mapper = Mapper()

        Assertions.assertEquals(
            mapper.mapFlashSaleToFlashSaleModel(createFlashSale()),
            createFlashSaleModel()
        )
    }

    @Test
    fun mapListFlashSaleToListFlashSaleModel() {

        val mapper = Mapper()

        Assertions.assertEquals(
            mapper.mapListFlashSaleToListFlashSaleModel(createFlashSaleApiModel().flash_sale),
            listOf(createFlashSaleModel())
        )
    }

    @Test
    fun mapUserModelToUserDbModel() {

        val mapper = Mapper()

        Assertions.assertEquals(
            mapper.mapUserModelToUserDbModel(createUserModel()),
            createUserDbModel()
        )
    }

    @Test
    fun mapDetailApiModelToDetailModel() {

        val mapper = Mapper()

        Assertions.assertEquals(
            mapper.mapDetailApiModelToDetailModel(createDetailApiModel()),
            createDetailModel()
        )
    }
}