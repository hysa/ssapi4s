/*
 * Copyright (c) 2012 hysa
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is furnished
 * to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package me.hysa.ssapi4s.util

/**
 * ResponseTag.
 *
 */
object ResponseTag {
  // for Slideshows
  val TagSlideshows = "Slideshows"
  val TagMeta = "Meta"
  val TagQuery = "Query"
  val TagResultOffset = "ResultOffset"
  val TagNumResults = "NumResults"
  val TagTotalResults = "TotalResults"
  
  // for Slideshow
  val TagSlideshow = "Slideshow"
  val TagID = "ID"
  val TagTitle = "Title"
  val TagDescription = "Description"
  val TagStatus = "Status"
  val TagUsername = "Username"
  val TagURL = "URL"
  val TagThumbnailURL = "ThumbnailURL"
  val TagThumbnailSmallURL = "ThumbnailSmallURL"
  val TagEmbed = "Embed"
  val TagCreated = "Created"
  val TagUpdated = "Updated"
  val TagLanguage = "Language"
  val TagFormat = "Format"
  val TagDownload = "Download"
  val TagDownloadUrl = "DownloadUrl"
  val TagSlideshowType = "SlideshowType"
  val TagInContest = "InContest"

  val TagUserID = "  UserID"
  val TagPPTLcation = "PPTLcation"
  val TagStrippedTitle = "StrippedTitle"
  val TagTags = "Tags"
  val TagTag = "Tag"
  val TagAudio = "Audio"
  val TagNumDownloads = "NumDownloads"
  val TagNumViews = "NumViews"
  val TagNumComments = "NumComments"
  val TagNumFavorites = "NumFavorites"
  val TagNumSlides = "NumSlides"
  val TagRelatedSlideshows = "RelatedSlideshows"
  val TagRelatedSlideshowID = "RelatedSlideshowID"
  val TagPrivacyLevel = "PrivacyLevel"
  val TagFlagVisible = "FlagVisible"
  val TagShowOnSS = "ShowOnSS"
  val TagSecretURL = "SecretURL"
  val TagAllowEmbed = "AllowEmbed"
  val TagShareWithContacts = "ShareWithContacts"

  // for Tag, Group
  val TagGroup = "Group"
  val TagName = "Name"
  val TagCount = "Count"

  // SlideShareServiceError
  val TagSlideShareServiceError = "SlideShareServiceError"
  val TagMessage = "Message"
  val AttributeID = "@ID"
}