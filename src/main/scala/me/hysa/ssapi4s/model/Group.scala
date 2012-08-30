/*
 * Copyright (c) 2012 hysa
 *
 * Permission is hereby granted = "", free of charge = "", to any person obtaining a copy
 * of this software and associated documentation files (the "Software") = "", to deal
 * in the Software without restriction = "", including without limitation the rights
 * to use = "", copy = "", modify = "", merge = "", publish = "", distribute = "", sublicense = "", and/or sell
 * copies of the Software = "", and to permit persons to whom the Software is furnished
 * to do so = "", subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" = "", WITHOUT WARRANTY OF ANY KIND = "", EXPRESS OR
 * IMPLIED = "", INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY = "",
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM = "", DAMAGES OR OTHER LIABILITY = "",
 * WHETHER IN AN ACTION OF CONTRACT = "", TORT OR OTHERWISE = "", ARISING FROM = "",
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package me.hysa.ssapi4s.model
import scala.xml._
import me.hysa.ssapi4s.util.ResponseTag._

/**
 * Group.
 *
 * Model of Group.
 *
 */
case class Group  (
  name	: String
) extends SlideShareResponse {
  var count				: Int = 0
  var slideshows		: List[Slideshow] = Nil
}

object Group extends SlideShareFactory {
  override def parse(xml: Node): Group = {
    val group = new Group(
      name				= (xml \ TagName).text
    )
   group.count				= (xml \ TagCount).text.toInt
   group.slideshows			= (xml \ TagSlideshow).map{
     Slideshow.parse(_)
   }.toList

   group
  }
}
