/*
 *  Nimble, an extensive application base for Grails
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
 * Represents generic details users may wish to store about themselves within
 * a given application.
 *
 * @author Bradley Beddoes
 */
class SocialProfileBase extends grails.plugins.nimble.core.ProfileBase {

    String bio

    Date dob
    Gender gender

    byte[] photo
    String photoType
    
    boolean gravatar = false
    Status currentStatus

    static hasMany = [
        websites: SocialUrl,
        alternateEmails: String,
        feeds: Feed,
        socialAccounts: SocialMediaAccount,
        addresses: Address,
        phoneNumbers: Phone,
        statuses: Status,
    ]

    static constraints = {
        bio(nullable: true, blank: false)

        photo(nullable: true, maxSize: 4194304)
        photoType(nullable: true, blank:false)
    
        currentStatus(nullable:true)
        gender(nullable: true)
        dob(nullable: true)
    }
}

public enum Gender {
    Male, Female
}
