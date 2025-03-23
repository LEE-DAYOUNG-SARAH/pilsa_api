package store.pilsaapp.pilsa_api.user.entity

import jakarta.persistence.*
import store.pilsaapp.pilsa_api.common.BaseEntity

@Entity
@Table(name = "user_info", schema = "pilsa_db")
class UserInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SEQ", nullable = false)
    val userSeq: Long = 0,

    @Column(name = "OAUTH_PROVIDER", length = 50, nullable = false)
    val oauthProvider: String,

    @Column(name = "OAUTH_ID", length = 100, nullable = false)
    val oauthId: String,

    @Column(name = "EMAIL", length = 255, nullable = true)
    val email: String? = null,

    @Column(name = "NICKNAME", length = 255, nullable = true)
    val nickname: String? = null,

    @Column(name = "PROFILE_IMGAGE_URL", length = 255, nullable = true)
    val profileImgageUrl: String? = null,

    @Column(name = "GENDER", length = 10, nullable = true)
    val gender: String? = null,

    @Column(name = "BIRTH", length = 10, nullable = true)
    val birth: String? = null,

    @Column(name = "LOCALE", length = 10, nullable = true)
    val locale: String? = null,

    @Column(name = "WITHDRAWAL_YN", nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 'N'")
    val withdrawalYn: String = "N"
): BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserInfo

        if (userSeq != other.userSeq) return false
        if (oauthProvider != other.oauthProvider) return false
        if (oauthId != other.oauthId) return false
        if (email != other.email) return false
        if (nickname != other.nickname) return false
        if (profileImgageUrl != other.profileImgageUrl) return false
        if (gender != other.gender) return false
        if (birth != other.birth) return false
        if (locale != other.locale) return false
        if (withdrawalYn != other.withdrawalYn) return false

        return true
    }

    override fun hashCode(): Int {
        var result = userSeq.hashCode()
        result = 31 * result + oauthProvider.hashCode()
        result = 31 * result + oauthId.hashCode()
        result = 31 * result + (email?.hashCode() ?: 0)
        result = 31 * result + (nickname?.hashCode() ?: 0)
        result = 31 * result + (profileImgageUrl?.hashCode() ?: 0)
        result = 31 * result + (gender?.hashCode() ?: 0)
        result = 31 * result + (birth?.hashCode() ?: 0)
        result = 31 * result + (locale?.hashCode() ?: 0)
        result = 31 * result + withdrawalYn.hashCode()
        return result
    }

    override fun toString(): String {
        return "UserInfo(userSeq=$userSeq, oauthProvider='$oauthProvider', oauthId='$oauthId', email=$email, nickname=$nickname, profileImgageUrl=$profileImgageUrl, gender=$gender, birth=$birth, locale=$locale, withdrawalYn='$withdrawalYn')"
    }
}