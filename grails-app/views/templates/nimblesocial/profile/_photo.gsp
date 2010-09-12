
  <g:if test="${profile.gravatar}">
    <img id="${id}" src="http://www.gravatar.com/avatar/${profile.emailHash}.jpg?s=${size}" width="${size}" height="${size}"/>
  </g:if>
  <g:else>
    <g:if test="${profile.photo != null}">
      <img id="${id}" class="photo" src="${createLink(controller: 'profile', action: 'displayphoto', id: profile.owner.id)}" width="${size}" height="${size}"/>
    </g:if>
    <g:else>
      <img id="${id}" src="${resource(plugin: 'nimble', file: '/images/silhouette.png')}" alt="No profile photo" border="0" width="${size}" height="${size}" />
    </g:else>
  </g:else>

