/*
 * Copyright (c) 2012 hysa
 *
 * Permission is hereby granted = "" free of charge = "" to any person obtaining a copy
 * of this software and associated documentation files (the "Software") = "" to deal
 * in the Software without restriction = "" including without limitation the rights
 * to use = "" copy = "" modify = "" merge = "" publish = "" distribute = "" sublicense = "" and/or sell
 * copies of the Software = "" and to permit persons to whom the Software is furnished
 * to do so = "" subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" = "" WITHOUT WARRANTY OF ANY KIND = "" EXPRESS OR
 * IMPLIED = "" INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY = ""
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM = "" DAMAGES OR OTHER LIABILITY = ""
 * WHETHER IN AN ACTION OF CONTRACT = "" TORT OR OTHERWISE = "" ARISING FROM = ""
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package me.hysa.ssapi4s.model

import scala.xml._
import me.hysa.ssapi4s.util.ResponseTag._

/**
 * Slideshow.
 *
 * Model of Slideshow.
 *
 */
case class Slideshow (id: String) extends SlideShareResponse {
  // Basic information
  var title				: String = ""
  var description		: String = ""
  var status			: String = ""
  var username			: String = ""
  var url				: String = ""
  var thumbnailUrl		: String = ""
  var thumbnailSmallUrl	: String = ""
// TODO var embed				: String = ""
  var created			: String = ""
  var updated			: String = ""
  var language			: String = ""
  var format			: String = ""
  var download			: String = ""
  var downloadUrl		: String = ""
  var slideshowType		: String = ""
  var inContest			: String = ""

  // Detail Informations
  var userId			: String = ""
  var pptLocation		: String = ""
  var strippedTitle		: String = ""
  var tags				: List[String] = Nil // TODO can't explain "Count" and "Owner".
  var audio				: String = ""
  var numDownloads		: Int = 0
  var numViews			: Int = 0
  var numComments		: Int = 0
  var numFavorites		: Int = 0
  var numSlides			: Int = 0
  var relatedSlideshowId: List[String] = Nil
  var privacyLevel		: String = ""
  var flagVisible		: String = ""
  var ShowOnSS			: String = ""
  var secretURL			: String = ""
  var allowEmbed		: String = ""
  var shareWithContacts : String = ""
}

object Slideshow extends SlideShareFactory {
  override def parse(xml: Node): Slideshow = {
    val ss = new Slideshow(
      id 				= (xml \ TagID).text
    )
    ss.title 				= (xml \ TagTitle).text
    ss.description 			= (xml \ TagDescription).text
    ss.status 				= (xml \ TagStatus).text
    ss.username 			= (xml \ TagUsername).text
    ss.url 					= (xml \ TagURL).text
    ss.thumbnailUrl 		= (xml \ TagThumbnailURL).text
    ss.thumbnailSmallUrl 	= (xml \ TagThumbnailSmallURL).text
    ss.created 				= (xml \ TagCreated).text
    ss.updated 				= (xml \ TagUpdated).text
    ss.language				= (xml \ TagLanguage).text
    ss.format 				= (xml \ TagFormat).text
    ss.download 			= (xml \ TagDownload).text
    ss.downloadUrl 			= (xml \ TagDownloadUrl).text
    ss.slideshowType		= (xml \ TagSlideshowType).text
    ss.inContest			= (xml \ TagInContest).text

    // Detail Information
    if (!(xml \ TagUserID isEmpty)) {
      ss.userId				= (xml \ TagUserID).text
      ss.pptLocation		= (xml \ TagPPTLcation).text
      ss.tags				= (xml \ TagTags \ TagTag).map(_.text).toList
      ss.audio				= (xml \ TagAudio).text
      ss.numDownloads		= (xml \ TagNumDownloads).text.toInt
      ss.numViews			= (xml \ TagNumViews).text.toInt
      ss.numComments		= (xml \ TagNumComments).text.toInt
      ss.numFavorites		= (xml \ TagNumFavorites).text.toInt
      ss.numSlides			= (xml \ TagNumSlides).text.toInt
    }
    
    ss
  }
}
