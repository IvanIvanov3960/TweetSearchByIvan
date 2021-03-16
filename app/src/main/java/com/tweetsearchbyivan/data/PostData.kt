package com.tweetsearchbyivan.data

data class PostData (
    val data: List<Datum>,
    val meta: Meta
)


data class Datum (
    val authorID: String?,
    val createdAt: String?,
    val entities: Entities? = null,
    val id: String,
    val lang: Lang?,
    val possiblySensitive: Boolean?,
    val referencedTweets: List<ReferencedTweet>? = null,
    val source: Source?,
    val text: String?,
    val inReplyToUserID: String? = null
)

data class Entities (
    val mentions: List<Mention>? = null,
    val hashtags: List<Hashtag>? = null,
    val urls: List<URL>? = null
)

data class Hashtag (
    val start: Long,
    val end: Long,
    val tag: String
)

data class Mention (
    val start: Long,
    val end: Long,
    val username: String
)

data class URL (
    val start: Long,
    val end: Long,
    val url: String,
    val expandedURL: String,
    val displayURL: String,
    val images: List<Image>,
    val status: Long,
    val title: String,
    val description: String,
    val unwoundURL: String
)

data class Image (
    val url: String,
    val width: Long,
    val height: Long
)

enum class Lang {
    De,
    En
}


data class ReferencedTweet (
    val type: String,
    val id: String
)

enum class Source {
    TwitterForAndroid,
    TwitterForIPhone,
    TwitterWebApp
}

data class Meta (
    val newestID: String?,
    val oldestID: String?,
    val resultCount: Long?,
    val nextToken: String?
)
