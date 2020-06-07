package com.thebotbox.letsmvvm.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thebotbox.letsmvvm.data.db.entity.QuoteEntity
import com.thebotbox.letsmvvm.data.network.model.RandomQuoteResponse

@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuote(quoteEntity: QuoteEntity)
}

fun RandomQuoteResponse.toQuoteEntity(): QuoteEntity {
    return QuoteEntity(this.quote_id, this.quote, this.author)
}