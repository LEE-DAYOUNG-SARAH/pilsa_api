package store.pilsaapp.pilsa_api.notice.enitty

import jakarta.persistence.*
import store.pilsaapp.pilsa_api.common.BaseEntity

@Entity
@Table(name = "notice_info", schema = "pilsa_db")
class NoticeInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_SEQ", nullable = false)
    val noticeSeq: Long = 0,

    @Column(name = "TITLE", columnDefinition = "TEXT", nullable = false)
    var title: String,

    @Column(name = "CONTENT", length = 255, nullable = false)
    var content: String
): BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NoticeInfo

        if (noticeSeq != other.noticeSeq) return false
        if (title != other.title) return false
        if (content != other.content) return false

        return true
    }

    override fun hashCode(): Int {
        var result = noticeSeq.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + content.hashCode()
        return result
    }

    override fun toString(): String {
        return "NoticeInfo(noticeSeq=$noticeSeq, title='$title', content='$content')"
    }

}