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
 * OUT OF OR IN Connector WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package me.hysa.ssapi4s

import java.util.Date
import me.hysa.ssapi4s.util.SlideShareUtils
import dispatch._
import scala.util.logging.Logged
import grizzled.slf4j.Logging

/**
 * Connector.
 *
 */
class Connector(
  val apiKey: String,
  val secret: String,
  val timeoutSec: Int = 5
) extends Connectable with Logging {
  require(apiKey != null && secret != null)
  require(timeoutSec > 0)

  /**
   * Constructor helper.
   */

  /**
   * Build required parameters.
   *
   * @return Map of required parameters
   */
  private def baseParam: Map[String, String] = {
    val ts = new Date().getTime() / 1000
    Map("api_key"   -> apiKey,
        "ts"	    -> ts.toString(),
        "hash"		-> SlideShareUtils.sha1(secret+ts)
        )
  }

  /**
   * Connect to SlideShare Web Service.
   *
   * @param url Url of SlideShare API
   * @param param GET parameters
   * @return String of response
   */
  override def connect(urlStr: String, param: Map[String, String]): String = {
    val h = new Http
    try {
      h(url(urlStr) <<? (baseParam ++ param) as_str)
    } finally {
      h.shutdown()
    }
  }

}
