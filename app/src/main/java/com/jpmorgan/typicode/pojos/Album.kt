package com.jpmorgan.typicode.pojos

import com.google.gson.annotations.SerializedName

class Album : Comparable<Album> {

    @SerializedName("userId")
    var userId: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String? = null

    override fun toString(): String {
        return "Album{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\''.toString() +
                '}'.toString()
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val album = o as Album?

        if (userId != album!!.userId) return false
        if (id != album.id) return false
        return if (title != null) title == album.title else album.title == null
    }

    override fun hashCode(): Int {
        var result = userId
        result = 31 * result + id
        result = 31 * result + if (title != null) title!!.hashCode() else 0
        return result
    }

    override fun compareTo(o: Album): Int {
        return this.title!!.compareTo(o.title!!)
    }
}
