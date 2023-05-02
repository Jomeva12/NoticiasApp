package com.jomeva.noticiasapi.modelos

data class NoticiasResponse(
    var articles: List<Article>,
    var status: String, // ok
    var totalResults: Int // 14802
) {
    data class Article(
        var author: String, // Sharron Bennet
        var content: String, // According to Elon Musk, Twitter users should soon be able to read subscription-exclusive stories on a per-article basis next month. The Tesla CEO described the plan as a major win-win both for the pu… [+2428 chars]
        var description: String, // According to Elon Musk, Twitter users should soon be able to read subscription-exclusive stories on a per-article basis next month. The Tesla CEO described the plan as “a major win-win” both for the public and media organizations, with the latter being able t…
        var publishedAt: String, // 2023-05-01T04:27:03Z
        var source: Source,
        var title: String, // Twitter to allow users to read subscription news on per-article basis next month
        var url: String, // https://mspoweruser.com/twitter-users-to-read-subscription-news-on-per-article-basis/
        var urlToImage: String // https://mspoweruser.com/wp-content/uploads/2022/03/Twitter-Logo-160322.jpg
    ) {
        data class Source(
            var id: String, // globo
            var name: String // MSPoweruser
        )
    }
}