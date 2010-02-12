
  <g:if test="${profile.gravatar}">
    <img src="http://www.gravatar.com/avatar/${profile.emailHash}.jpg?s=${size}" width="${size}" height="${size}"/>
  </g:if>
  <g:else>
    <g:if test="${profile.photo != null}">
      <img class="photo" src="${createLink(controller: 'profile', action: 'displayphoto', id: profile.owner.id)}" width="${size}" height="${size}"/>
    </g:if>
    <g:else>
      <img src="${resource(dir: pluginContextPath, file: '/images/silhouette.png')}" alt="No profile photo" border="0"  /> 
    </g:else>
  </g:else>

