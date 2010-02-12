/*
 *  Nimble, an extensive application base for Grails
 *  Copyright (C) 2009 Intient Pty Ltd
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
 * Represents a comment made by a user about some current status or links
 * to some current content
 *
 * @author Bradley Beddoes
 */
class Status {
    String status
    SocialUrl url = null

    Date dateCreated
    Date lastUpdated

    static belongsTo = [owner:SocialProfileBase]
    
    static constraints = {
        status(nullable:false, blank:false)
        url(nullable:true)

        dateCreated(nullable: true) // must be true to enable grails
        lastUpdated(nullable: true) // auto-inject to be useful which occurs post validation
    }
}