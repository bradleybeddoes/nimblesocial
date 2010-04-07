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

import grails.plugins.nimble.core.*
import grails.plugins.nimble.social.*

/**
 * Provides generic, mostly UI related tags to the Nimble application
 *
 * @author Bradley Beddoes
 */
class NimbleSocialTagLib {
    def pluginContextPath
  
    static namespace = "ns"

    /**
     * Provides markup to render the supplied users profile photo
	 * (Realizing these docs don't show up, yet)
	 *
	 * @param id The ID IMG tag (optional)
     * @param userId The ID of the user profile to load (optional)
	 * @param user The user to display (optional)
	 * @param size The size in pixels to display.  Applies to both width and height.  (A square image)
     */
    def photo = {attrs ->
        if((attrs.userId == null && attrs.user == null) || attrs.size == null)
            throwTagError("Photo tag requires user id and size attributes")

        def id = attrs.id
		def userId = attrs.userId
        def user = attrs.user
        def size = attrs.size

		if(user == null)
        	user = UserBase.get(userId)

		if(id == null)
			id = "nimble-photo-${user.id}"
        if(user == null)
            user = UserBase.get(userId)

        if(id == null)
            id = "nimble-photo-${user.id}"

        if(user) {
            out << render(template: "/templates/nimblesocial/profile/photo", contextPath: pluginContextPath, model: [profile: user.profile, id: id, size: size])
            return
        }
        throwTagError("No user located for supplied ID")
    }

    /**
     * Provides script to allow the user of the classes 'userhighlight' and 'user_X' on elements to provide
     * mini user profile popups on mouse hover.
     */
    def userhighlight = {
        out << render(template: "/templates/nimblesocial/profile/userhighlight", contextPath: pluginContextPath)
    }

    /**
     * Providers markup to render the supplied users current status
     *
     * @param id The ID IMG tag (optional)
     * @param userId The ID of the user profile to load (optional)
	 * @param user The user to display (optional)
     * @param clear True/false, allow the user to clear their status
     */
    def status = {attrs ->
        if((attrs.userId == null && attrs.user == null))
            throwTagError("Status tag requires user id")

        def id = attrs.id
        def userId = attrs.userId
        def user = attrs.user
        def clear = attrs.clear ?: false

        if(user == null)
            user = UserBase.get(userId)

        if(id == null)
            id = "nimble-status-${user.id}"

        if(user) {
            out << render(template: "/templates/nimblesocial/profile/currentstatus", model: [profile: user.profile, clear: clear, id: id])
            return
        }
        throwTagError("No user located for supplied ID")
    }

    /**
     * Allows Nimble core and Host Apps alike to access images provided for social sites
     */
    def socialimg = {attrs ->
        if(attrs.alt == null || attrs.name == null || attrs.size == null)
        throwTagError("Social image tag requires size, name and alt attributes")

        def mkp = new groovy.xml.MarkupBuilder(out)
        mkp.img(src: resource(dir: pluginContextPath, file:"images/social/$attrs.size/${attrs.name}.png"), alt: "$attrs.alt")
    }

	def confirmaction = { attrs, body ->
			if(attrs.action == null || attrs.title == null || attrs.msg == null || attrs.accept == null || attrs.cancel == null)
        		throwTagError("Confirm action tag requires action, title, msg, accept and cancel attributes")

			out << "<a href=\"#\" class=\"${attrs.class}\" onClick=\"confirmAction = function() { ${attrs.action} }; wasConfirmed('${attrs.title}', '${attrs.msg}', '${attrs.accept}', '${attrs.cancel}');\">${body()}</a>"
	}


}

