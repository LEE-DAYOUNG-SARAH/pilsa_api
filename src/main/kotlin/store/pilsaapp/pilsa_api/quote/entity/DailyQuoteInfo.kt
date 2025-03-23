package store.pilsaapp.pilsa_api.quote.entity

import jakarta.persistence.*
import store.pilsaapp.pilsa_api.common.BaseEntity
import java.time.LocalDate

@Entity
@Table(name = "daily_quote_info", schema = "pilsa_db")
class DailyQuoteInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DAILY_QUOTE_SEQ", nullable = false)
    val dailyQuoteSeq: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "QUOTE_SEQ",
        referencedColumnName = "QUOTE_SEQ",
        nullable = false
    )
    var quoteInfo: QuoteInfo,

    @Column(name = "QUOTE_DATE", nullable = false)
    val quoteDate: LocalDate
): BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DailyQuoteInfo

        if (dailyQuoteSeq != other.dailyQuoteSeq) return false
        if (quoteInfo != other.quoteInfo) return false
        if (quoteDate != other.quoteDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = dailyQuoteSeq.hashCode()
        result = 31 * result + quoteInfo.hashCode()
        result = 31 * result + quoteDate.hashCode()
        return result
    }

    override fun toString(): String {
        return "DailyQuoteInfo(dailyQuoteSeq=$dailyQuoteSeq, quoteInfo=$quoteInfo, quoteDate=$quoteDate)"
    }
}
