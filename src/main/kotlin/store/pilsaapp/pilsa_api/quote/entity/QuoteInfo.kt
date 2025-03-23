package store.pilsaapp.pilsa_api.quote.entity

import jakarta.persistence.*
import store.pilsaapp.pilsa_api.common.BaseEntity

@Entity
@Table(name = "quote_info", schema = "pilsa_db")
class QuoteInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUOTE_SEQ", nullable = false)
    val quoteSeq: Long = 0,

    @Column(name = "KOR_QUOTE", columnDefinition = "TEXT", nullable = true)
    var korQuote: String? = null,

    @Column(name = "ENG_QUOTE", columnDefinition = "TEXT", nullable = true)
    var engQuote: String? = null,

    @Column(name = "KOR_AUTHOR", length = 255, nullable = true)
    var korAuthor: String? = null,

    @Column(name = "ENG_AUTHOR", length = 255, nullable = true)
    var engAuthor: String? = null,

    @Column(name = "CATEGORY", length = 20, nullable = true)
    var category: String? = null
): BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as QuoteInfo

        if (quoteSeq != other.quoteSeq) return false
        if (korQuote != other.korQuote) return false
        if (engQuote != other.engQuote) return false
        if (korAuthor != other.korAuthor) return false
        if (engAuthor != other.engAuthor) return false
        if (category != other.category) return false

        return true
    }

    override fun hashCode(): Int {
        var result = quoteSeq.hashCode()
        result = 31 * result + (korQuote?.hashCode() ?: 0)
        result = 31 * result + (engQuote?.hashCode() ?: 0)
        result = 31 * result + (korAuthor?.hashCode() ?: 0)
        result = 31 * result + (engAuthor?.hashCode() ?: 0)
        result = 31 * result + (category?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "QuoteInfo(quoteSeq=$quoteSeq, korQuote=$korQuote, engQuote=$engQuote, korAuthor=$korAuthor, engAuthor=$engAuthor, category=$category)"
    }
}
