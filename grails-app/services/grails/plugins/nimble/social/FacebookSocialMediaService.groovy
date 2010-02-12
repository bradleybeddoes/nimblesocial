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

class FacebookSocialMediaService {

    def grailsApplication

    def facebookMediaService

	/**
     * Integrates with extended Nimble bootstrap process, sets up Facebook Environment
     * once all domain objects etc ave dynamic methods available to them.
     */
    public void nimbleInit() {
        createSocialMediaAccount()
    }
	
	/**
     * Creates all facets of a Facebook social media account for a local user.
     *
     * @param profile A valid profile object.
     * @param userID The ID returned by Facebook to represent this user
     *
     * @return The profile object populated with Facebook scoial account details.
     *
     * @throws RuntimeException If FacebookService could not create a Facebook specific SocialMediaSerivce
     *                          (or open from DB) on application start.
     */
    def create(def profile, def userID) {
        if(facebookMediaService){
            SocialMediaAccount facebookAccount  = new SocialMediaAccount(accountID: userID, username:userID, service: facebookMediaService)

            def location = facebookMediaService.baseProfileUrl.location.replace(/ACCOUNTID/, facebookAccount.accountID)
            facebookAccount.profile = new SocialUrl(location:location, altText: facebookMediaService.baseProfileUrl.altText)
            facebookAccount.owner = profile

            profile.addToSocialAccounts(facebookAccount)
            return profile
        }

        log.error("Unable to locate Facebook social media service when attempting to add Facebook account for [$profile.owner?.id]$profile.owner?.username, invalid configuration?")
        throw new RuntimeException("Unable to locate Facebook social media service, invalid configuration?")
    }

    private createSocialMediaAccount() {
        facebookMediaService = SocialMediaService.findByUid(grailsApplication.config.nimble.facebook.uid)
        if (!facebookMediaService) {
            facebookMediaService = new SocialMediaService()
            facebookMediaService.uid = grailsApplication.config.nimble.facebook.uid

            def details = new SocialDetails()
            details.name = grailsApplication.config.nimble.facebook.name
            details.displayName = grailsApplication.config.nimble.facebook.displayname
            details.description = grailsApplication.config.nimble.facebook.description

            def url = new SocialUrl()
            url.location = grailsApplication.config.nimble.facebook.url
            url.altText = grailsApplication.config.nimble.facebook.alttext

            details.url = url
            facebookMediaService.details = details

            facebookMediaService.baseProfileUrl = new SocialUrl(location: grailsApplication.config.nimble.facebook.profileurl, altText: grailsApplication.config.nimble.facebook.profilealttext)

            facebookMediaService.save()
            if (facebookMediaService.hasErrors()) {
                facebookMediaService.errors.each {
                    log.error(it)
                }
                throw new RuntimeException("Unable to create valid Facebook media service")
            }
            log.info("Created Facebook social media service")
        }
    }
}