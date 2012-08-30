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
package me.hysa.ssapi4s

import scala.xml.XML
import me.hysa.ssapi4s.model._
import me.hysa.ssapi4s.util._
import me.hysa.ssapi4s.util.Sort._
import me.hysa.ssapi4s.util.UploadDate._
import me.hysa.ssapi4s.util.FileType._
import me.hysa.ssapi4s.util.Fileformat._

/**
 * SlideShareApi.
 */
class SlideShareApi private (connector: Connectable) {
  val QUERY_SLIDESHOW_ID = "slideshow_id"
  val QUERY_SLIDESHOW_URL = "slideshow_url"
  val QUERY_USERNAME = "username"
  val QUERY_PASSWORD = "password"
  val QUERY_EXCLUDE_TAGS = "exclude_tags"
  val QUERY_DETAILED = "detailed"
  val QUERY_TAG = "tag"
  val QUERY_LIMIT = "limit"
  val QUERY_OFFSET = "offset"
  val QUERY_GROUP_NAME = "group_name"

  val QUERY_Q = "q"
  val QUERY_PAGE = "page"
  val QUERY_ITEMS_PER_PAGE = "items_per_page"
  val QUERY_LANG = "lang"
  val QUERY_SORT = "sort"
  val QUERY_UPLOAD_DATE = "upload_date"
  val QUERY_WHAT = "what"
  val QUERY_DOWNLOAD = "download"
  val QUERY_FILEFORMAT = "fileformat"
  val QUERY_FILE_TYPE = "file_type"
  val QUERY_CC = "cc"
  val QUERY_CC_ADAPT = "cc_adapt"
  val QUERY_CC_COMMERCIAL = "cc_commercial"

//	get_slideshow
  val URL_GET_SLIDESHOW           = "https://www.slideshare.net/api/2/get_slideshow"
//	get_slideshows_by_tag
  val URL_GET_SLIDESHOWS_BY_TAG   = "https://www.slideshare.net/api/2/get_slideshows_by_tag"
//	get_slideshows_by_group
  val URL_GET_SLIDESHOWS_BY_GROUP = "https://www.slideshare.net/api/2/get_slideshows_by_group"
//	get_slideshows_by_user
  val URL_GET_SLIDESHOWS_BY_USER  = "https://www.slideshare.net/api/2/get_slideshows_by_use"
//	search_slideshows
  val URL_SEARCH_SLIDESHOWS       = "https://www.slideshare.net/api/2/search_slideshows"
//	get_user_groups
  val URL_GET_USER_GROUPS         = "https://www.slideshare.net/api/2/get_user_groups"
//	get_user_favorites
  val URL_GET_USER_FAVORITES      = "https://www.slideshare.net/api/2/get_user_favorites"
//	get_user_contacts
  val URL_GET_USER_CONTACTS       = "https://www.slideshare.net/api/2/get_user_contacts"
//	get_user_tags
  val URL_GET_USER_TAGS           = "https://www.slideshare.net/api/2/get_user_tags"
//	edit_slideshow
  val URL_EDIT_SLIDESHOW          = "https://www.slideshare.net/api/2/edit_slideshow"
//	delete_slideshow
  val URL_DELETE_SLIDESHOW        = "https://www.slideshare.net/api/2/delete_slideshow"
//	upload_slideshow
  val URL_UPLOAD_SLIDESHOW        = "https://www.slideshare.net/api/2/upload_slideshow"
//	get_user_campaigns
  val URL_GET_USER_CAMPAIGNS      = "https://www.slideshare.net/api/2/get_user_campaigns"
//	get_user_leads
  val URL_GET_USER_LEADS          = "https://www.slideshare.net/api/2/get_user_leads"
//	get_user_campaign_leads
  val URL_GET_USER_CAMPAIGN_LEADS = "https://www.slideshare.net/api/2/get_user_campaign_leads"

  /**
   * Get slideshow.
   *
   * @see {{https://www.slideshare.net/developers/documentation#get_slideshow}}
   * @return Slideshow if exists
   */
  def getSlideshow(
    slideshowId: String = null,
    slideshowUrl: String = null,
    username: String = null,
    password: String = null,
    excludeTags: String = null,
    detailed: String = null
  ) : SlideShareResponse = {
    require(slideshowId != null || slideshowUrl != null, "Neigher slideshowId or slideshowUrl must be not null.")

    var query = Map[String, String]()
    if (slideshowId != null)  query += QUERY_SLIDESHOW_ID -> slideshowId
    if (slideshowUrl != null) query += QUERY_SLIDESHOW_URL -> slideshowUrl
    if (username != null)	  query += QUERY_USERNAME -> username
    if (password != null) 	  query += QUERY_PASSWORD -> password
    if (excludeTags != null)  query += QUERY_EXCLUDE_TAGS -> excludeTags
    if (detailed != null)	  query += QUERY_DETAILED -> detailed
    
    val response = connector.connect(URL_GET_SLIDESHOW, query)
    Slideshow(XML.load(response))
  }

  /**
   * Get Slideshows by tag.
   *
   * @see {{http://www.slideshare.net/developers/documentation#get_slideshows_by_tag}}
   * @return Tag if exists.
   */
  def getSlideshowsByTag(
    tag: String,
    limit: String = null,
    offset: String = null,
    detailed: String = null 
  ) : SlideShareResponse = {
    require(tag != null, "tag  must be not null.")

    var query = Map[String, String](
        QUERY_TAG -> tag
    )
    if (limit != null)	    query += QUERY_LIMIT -> limit
    if (offset != null)     query += QUERY_OFFSET -> offset
    if (detailed != null)	query += QUERY_DETAILED -> detailed
    
    Tag(XML.load(connector.connect(URL_GET_SLIDESHOWS_BY_TAG, query)))
  }

  /**
   * Get Slideshows by group.
   *
   * @see {{http://www.slideshare.net/developers/documentation#get_slideshows_by_group}}
   * @return Group if exists.
   */
  def getSlideshowsByGroup(
    groupName: String,
    limit: String = null,
    offset: String = null,
    detailed: String = null
  ) : SlideShareResponse = {
    require(groupName != null, "group_name must be not null.")

    var query = Map[String, String](
        QUERY_GROUP_NAME	-> groupName
    )
    if (QUERY_LIMIT != null)	query += QUERY_LIMIT -> limit
    if (QUERY_OFFSET != null)	query += QUERY_OFFSET -> offset
    if (QUERY_DETAILED != null) query += QUERY_DETAILED -> detailed
    
    Group(XML.load(connector.connect(URL_GET_SLIDESHOWS_BY_GROUP, query)))
  }

  /**
   * Search Slideshows
   *
   * @see {{http://www.slideshare.net/developers/documentation#search_slideshows}}
   * @return Slideshows if exists.
   */
  def searchSlideshows(
    q: String,
    page: String = null,
    itemsPerPage: String = null,
    lang: String = null,
    sort: Sort = null,
    uploadDate: UploadDate = null,
    what: String = null,
    download: String = null,
    fileformat: Fileformat = null, 
    fileType: FileType = null,
    cc: String = null,
    ccAdapt: String = null,
    ccCommercial: String = null,
    detailed: String = null
  ) : SlideShareResponse = {
    require(q != null, "q must be not null")

    var query = Map[String, String](
      QUERY_Q -> q
    )
    if (page != null) 			query += (QUERY_PAGE -> page)
    if (itemsPerPage != null)	query += (QUERY_ITEMS_PER_PAGE -> itemsPerPage)
    if (lang != null) 			query += (QUERY_LANG -> lang)
    if (sort != null) 			query += (QUERY_SORT -> sort.toString)
    if (uploadDate != null) 	query += (QUERY_UPLOAD_DATE -> uploadDate.toString)
    if (what != null) 			query += (QUERY_WHAT -> what)
    if (download != null) 		query += (QUERY_DOWNLOAD -> download)
    if (fileformat != null) 	query += (QUERY_FILEFORMAT -> fileformat.toString)
    if (fileType != null) 		query += (QUERY_FILE_TYPE -> fileType.toString)
    if (cc != null) 			query += (QUERY_CC -> cc)
    if (ccAdapt != null) 		query += (QUERY_CC_ADAPT -> ccAdapt.toString)
    if (ccCommercial != null) 	query += (QUERY_CC_COMMERCIAL -> ccCommercial)
    if (detailed != null) 		query += (QUERY_DETAILED -> detailed)

    Slideshows(XML.load(connector.connect(URL_SEARCH_SLIDESHOWS, query)))
  }

  def getSlideshowsByUser() = throw new Error("Not implemented.") // TODO Implement this method.
  def getUserGroups() = throw new Error("Not implemented.") // TODO Implement this method.
  def getUserFavorites() = throw new Error("Not implemented.") // TODO Implement this method.
  def getUserContacts() = throw new Error("Not implemented.") // TODO Implement this method.
  def getUserTags() = throw new Error("Not implemented.") // TODO Implement this method.
  def editSlideshow() = throw new Error("Not implemented.") // TODO Implement this method.
  def deleteSlideshow() = throw new Error("Not implemented.") // TODO Implement this method.
  def uploadSlideshow() = throw new Error("Not implemented.") // TODO Implement this method.
  def getUserCampaigns() = throw new Error("Not implemented.") // TODO Implement this method.
  def getUserLeads() = throw new Error("Not implemented.") // TODO Implement this method.
  def getUserCampaignLeads() = throw new Error("Not implemented.") // TODO Implement this method.

}

/**
 * Factory for SlideShareApi
 *
 */
object SlideShareApi {
  def apply(connector: Connectable): SlideShareApi = {
    new SlideShareApi(connector)
  }

  def apply(apiKey: String, secret: String): SlideShareApi = {
    this(new Connector(apiKey, secret))
  }
}
