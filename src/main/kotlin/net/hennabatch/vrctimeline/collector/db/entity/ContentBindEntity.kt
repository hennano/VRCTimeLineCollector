package net.hennabatch.vrctimeline.collector.db.entity

import org.komapper.annotation.KomapperAutoIncrement
import org.komapper.annotation.KomapperColumn
import org.komapper.annotation.KomapperEntity
import org.komapper.annotation.KomapperId

@KomapperEntity
data class ContentBindEntity(
    @KomapperId
    @KomapperAutoIncrement
    @KomapperColumn(name = "content_bind_id")
    val id: Int,

    @KomapperColumn(name = "event_type_id")
    val eventTypeId: Int,

    //ContentEntityを検索するために使用
    @KomapperColumn(name = "content_role_id")
    val contentRoleId: Int,

    //どのidを保存するかkeyを指定する
    @KomapperColumn(name = "bind_id_type")
    val bindIdType: String
)
