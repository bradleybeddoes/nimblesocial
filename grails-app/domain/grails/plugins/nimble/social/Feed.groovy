/*
 *  NimbleSocial, A complimentary set of social web functionality for Nimble, an extensive application base for Grails
 *  Copyright (C) 2010 Bradley Beddoes
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package grails.plugins.nimble.social

/**
 * Represents a web based information feed, commonly atom, rss
 *
 * @author Bradley Beddoes
 */
class Feed {

  SocialDetails details
  SocialUrl feedUrl = null

  static constraints = {
    details(nullable: false)
    feedUrl(nullable:false)
  }
}
