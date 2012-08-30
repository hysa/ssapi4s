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
 * Language of slideshows
 * (**:All,
 *  es:Spanish,
 *  pt:Portuguese,
 *  fr:French,
 *  it:Italian,
 *  nl:Dutch,
 *  de:German,
 *  zh:Chinese,
 *  ja:Japanese,
 *  ko:Korean,
 *  ro:Romanian,
 *  !!:Other)
 */
object Lang extends Enumeration {
  type Lang = Value
  val **, es, pt, fr, it, nl, de, zh, ja, ko, ro, !! = Value
}

/**
 * Sort order
 * (relevance, mostviewed,mostdownloaded,latest)
 */
object Sort extends Enumeration {
  type Sort = Value
  val relevance, mostviewed, mostdownloaded, latest = Value
}

/**
 * The time period you want to restrict your search to.
 * week would restrict to the last week.
 * (any, week, month, year)
 */
object UploadDate extends Enumeration {
  type UploadDate = Value
  val any, week, month, year = Value
}

/**
 * File format to search for.
 * (all, pdf:PDF,ppt:PowerPoint,odp:Open Office,pps:PowerPoint Slideshow,pot:PowerPoint template)
 */
object Fileformat extends Enumeration {
  type Fileformat = Value
  val all, pdf, ppt, odp, pps, pot = Value
}

/**
 * File type to search for. (all, presentations, documents, webinars, videos)
 */
object FileType extends Enumeration {
  type FileType = Value
  val all, presentations, documents, webinars, videos = Value
}
