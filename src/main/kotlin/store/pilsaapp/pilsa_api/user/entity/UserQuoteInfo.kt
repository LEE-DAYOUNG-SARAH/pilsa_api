package store.pilsaapp.pilsa_api.user.entity

import jakarta.persistence.*
import store.pilsaapp.pilsa_api.common.BaseEntity
import store.pilsaapp.pilsa_api.quote.entity.DailyQuoteInfo

@Entity
@Table(name = "user_quote_info", schema = "pilsa_db")
data class UserQuoteInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_QUOTE_SEQ", nullable = false, updatable = false)
    val userQuoteSeq: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "USER_SEQ",
        referencedColumnName = "USER_SEQ",
        nullable = false
    )
    val userInfo: UserInfo,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "DAILY_QUOTE_SEQ",
        referencedColumnName = "DAILY_QUOTE_SEQ",
        nullable = false
    )
    val dailyQuoteInfo: DailyQuoteInfo,

    @Column(name = "TYPING_KOR_QUOTE", columnDefinition = "TEXT", nullable = true)
    var typingKorQuote: String? = null,

    @Column(name = "TYPING_ENG_QUOTE", columnDefinition = "TEXT", nullable = true)
    var typingEngQuote: String? = null,

    @Column(name = "IMG", columnDefinition = "TEXT", nullable = true)
    var img: String? = null,

    @Column(name = "MEMO", columnDefinition = "TEXT", nullable = true)
    var memo: String? = null,

    @Column(name = "LIKE_YN", nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 'N'")
    var likeYn: String = "N"
): BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserQuoteInfo

        if (userQuoteSeq != other.userQuoteSeq) return false
        if (userInfo != other.userInfo) return false
        if (dailyQuoteInfo != other.dailyQuoteInfo) return false
        if (typingKorQuote != other.typingKorQuote) return false
        if (typingEngQuote != other.typingEngQuote) return false
        if (img != other.img) return false
        if (memo != other.memo) return false
        if (likeYn != other.likeYn) return false

        return true
    }

    override fun hashCode(): Int {
        var result = userQuoteSeq.hashCode()
        result = 31 * result + userInfo.hashCode()
        result = 31 * result + dailyQuoteInfo.hashCode()
        result = 31 * result + (typingKorQuote?.hashCode() ?: 0)
        result = 31 * result + (typingEngQuote?.hashCode() ?: 0)
        result = 31 * result + (img?.hashCode() ?: 0)
        result = 31 * result + (memo?.hashCode() ?: 0)
        result = 31 * result + likeYn.hashCode()
        return result
    }

    override fun toString(): String {
        return "UserQuoteInfo(userQuoteSeq=$userQuoteSeq, userInfo=$userInfo, dailyQuoteInfo=$dailyQuoteInfo, typingKorQuote=$typingKorQuote, typingEngQuote=$typingEngQuote, img=$img, memo=$memo, likeYn='$likeYn')"
    }
}