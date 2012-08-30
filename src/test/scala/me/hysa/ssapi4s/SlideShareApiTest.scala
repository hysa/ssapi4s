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

import org.specs2.mutable._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import me.hysa.ssapi4s.model._

/**
 * SlideShareApiTest.
 *
 */
@RunWith(classOf[JUnitRunner])
class SlideShareApiTest extends Specification {
  val API    = "******"
  val SECRET = "******"

  val USERNAME = "******"
  val PASSWORD = "******"

  "All method of SlideShareApi" should {
    "Return exception if exists error" in {
      val res: SlideShareResponse = SlideShareApi(new ConnectorMock("xml/slideshow_error.xml")).getSlideshow(
          slideshowId = "dummy"
      )
      res match {
        case error: SlideShareServiceError =>
          error.id === "1"
          error.message === "Failed API validation"
        case _ =>
          failure("failure")
      }
    }
  }

  "SlideShareApi#getSlideshow" should {
    "Parse xml and return model instance" in {
      val res: SlideShareResponse = SlideShareApi(new ConnectorMock("xml/get_slideshow.xml")).getSlideshow(
          slideshowId = "dummy"
      )
      res match {
        case ss:Slideshow =>
        ss.id === "414888"
        ss.title === "Groovy And Grails JUG Padova"
        ss.description === "Presentation of Groovy and Grails made at the JUG Padova on 17 May 2008"
        ss.status === "2"
        ss.username === "john.leach"
        ss.url === "http://www.slideshare.net/john.leach/groovy-and-grails-jug-padova"
        ss.thumbnailUrl === "//cdn.slidesharecdn.com/ss_thumbnails/groovyandgrails-1211192948866493-8-thumbnail.jpg?1211187157"
        ss.thumbnailSmallUrl === "//cdn.slidesharecdn.com/ss_thumbnails/groovyandgrails-1211192948866493-8-thumbnail-2.jpg?1211187157"
        ss.created === "Mon May 19 03:29:54 -0500 2008"
        ss.updated === "Mon May 19 03:52:37 -0500 2008"
        ss.language === "en"
        ss.format === "pdf"
        ss.download === "1"
        ss.downloadUrl === ""
        ss.slideshowType === "0"
        ss.inContest === "0"
        // detail
        ss.userId === "123456"
        ss.pptLocation === "abcdef-1234-pptloc"
        ss.strippedTitle === "groovy-and-grails-jug-padova"
        ss.tags.head === "grails"
        ss.tags.reverse.head === "groovy"
        ss.audio ==== "0"
        ss.numDownloads === 65
        ss.numViews === 2773
        ss.numComments === 3
        ss.numFavorites === 190
        ss.numSlides === 37

        case _ => true === false
      }
    }

    "Send optional parameters" in {
      SlideShareApi(new Connector(API, SECRET)).getSlideshow(
        slideshowId = "414888",
        username = USERNAME,
        password = PASSWORD,
        detailed = "1"
      ) === "hoge"
    }
  }

  "SlideShareApi#getSlideshowByTag" should {
    "Parse xml and return model instance" in {
      val res = SlideShareApi(new ConnectorMock("xml/get_slideshow_by_tag.xml")).getSlideshowsByTag(
          tag = "dummy"
      )
      res match {
        case tag: Tag =>
        tag.name === "scala"
        tag.count === 20
        tag.slideshows must have size 20
        tag.slideshows.head.id ===  "414888"
        tag.slideshows.reverse.head.id === "159195"

        case _ =>
          failure("failure")
      }
    }
  }

  "SlideShareApi#getSlideshowByGroup" should {
    "Parse xml and return model instance" in {
      val res = SlideShareApi(new ConnectorMock("xml/get_slideshow_by_group.xml")).getSlideshowsByGroup(
          groupName = "dummy"
      )
      res match {
        case g: Group =>
          g.name === "javaday-italy"
          g.count === 21
          g.slideshows must have size 21
          g.slideshows.head.id ===  "202356"
          g.slideshows.reverse.head.id === "3031113"

        case _ =>
          failure("Failure")
      }
    }
  }
//    "Send message to REST service" in {
//      val res = SlideShareApi(API, SECRET).getSlideshowByGroup(
//        groupName = "javaday-italy"
//      )
//      res match {
//        case  g: Group =>
//          g.name === "javaday-italy"
//
//        case _ =>
//          failure("Failure")
//      }
//    }
  "SlideShareApi#searchSlideshow" should {
    "Parse xml and return model instance" in {
      val res = SlideShareApi(new ConnectorMock("xml/search_slideshows.xml")).searchSlideshows(
          q = "scala"
      )
      res match {
        case s: Slideshows =>
          s.metaQuery === "scala"
          s.metaResultOffset === "3"
          s.metaNumResults === 12
          s.metaTotalResults === 4650
          s.slideshows.size === 12
          s.slideshows.head.id === "966972"
          s.slideshows.reverse.head.id === "2535603"

        case _ =>
          failure("Failure")
      }
    }

//    "Send message to REST service" in {
//      val res = SlideShareApi(API, SECRET).searchSlideshows(
//          q = "scala"
//      )
//      true === false
//    }
  }
}

