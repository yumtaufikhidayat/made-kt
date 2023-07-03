package com.yumtaufikhidayat.made.model.reviews


import com.google.gson.annotations.SerializedName

data class ReviewsResult(
    @SerializedName("author")
    val author: String = "", // ObjectivityGate
    @SerializedName("author_details")
    val authorDetails: AuthorDetails = AuthorDetails(),
    @SerializedName("content")
    val content: String = "", // Even if the story was kind of lackluster, the film itself was incredible.  If you consider the tower as a kind of true main character of the movie.  On first watching this I can instantly imagine the blustering cacophony of outrage about climbing technique from viewers.  From the first, the film is rather jarring but honest about its juvenile depiction of "climbing".  At the start I had to decide NOT to care about how realistic it was because it would be wrong to reduce a film abductio absurdum because it is a story after all.  A creation.  It isn't being judged on its ability to remind one of real life so much as to forget it.  I do this 'forgetting' voluntarily and I seem to enjoy films more. I felt my body constricting away slightly and getting anxious during the gravity yawning scenes, 2000ft above the ground!  The characters were reckless enough to believe they would die at almost any time.  It was unrelenting in the tension.  Even if the writing is kind of silly at times, there are elements in a film, perhaps shown through other mediums besides the writing itself that can raise the score of the film quite a bit. Consider the cinematography.  The deft and skilled work at showing the tension existing in every moment by rattling bolts in close up with uncanny metallic sounds protesting the extra weight.  The drone shots that highlight the mind bending fear of such a radical location.   Honestly!  It seemed like such a labor of love of the filmmakers.  They immediately saw how much could be done with the location.  The story felt like a vehicle for the film which was this awesome gigantic testament to the fear of heights.  The movie poster sold this one for me because I was thinking, well, even if it isn't that good, the idea itself is good enough to be fascinating.  Consider the main character of the movie: the tower itself.  It said nothing the entire time, but it was the star of every scene.   Such as it was, the story was like kind of this extra fluff that you had to deal with, but what a cool film.  There was an amazing number of times I was 'triggered' by how silly and unrealistic the climbing aspects were, and how insanely reckless it became.  However, I don't believe that anyone thinks this a film to be studying climbing from.  It isn't even showing climbing's artistic nature which is the film's biggest pitfall.  I loved how the arc centered around conquering your fears through this metaphorical path of climbing and I'm sure a lot of climbers embraced that, and were reminded of it, but it was a crime to leave out why the characters are pursuing this passion.
    @SerializedName("created_at")
    val createdAt: String = "", // 2022-09-01T23:49:58.044Z
    @SerializedName("id")
    val id: String = "", // 631145261511aa0080d77496
    @SerializedName("updated_at")
    val updatedAt: String = "", // 2022-09-03T15:40:33.434Z
    @SerializedName("url")
    val url: String = "" // https://www.themoviedb.org/review/631145261511aa0080d77496
)